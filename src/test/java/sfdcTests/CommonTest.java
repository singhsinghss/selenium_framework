package sfdcTests;

import java.io.File;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Constants.FileConstants;


public class CommonTest {

	private static ThreadLocal<WebDriver> LocalDriver=new ThreadLocal<>();
	static ExtentReports extent=new ExtentReports();
	static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	public static org.apache.logging.log4j.Logger logger=org.apache.logging.log4j.LogManager.getLogger("COMMONTEST");
	
	@BeforeSuite
	public void configureReport()
	{
		extent=new ExtentReports();
		spark=new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
		extent.attachReporter(spark);
	}
	
	/*
	 * public void setup(Method name) {
	 * CommonTest.test=extent.createTest(name.getName());
	 * logger.info("CommonTest : setup :"+name.getName()
	 * +" The object for reporting is created");
	 * //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); }
	 */
	
	@AfterTest
	public void teardown()
	{
		//logger.info("CommonTest : setup :"+name.getName()+" teardown called");
		extent.flush();
	}
	
	@BeforeTest
	public static void setDriver()
	{				
		logger.info("CommonTest : setDriver :  Spark report configured");
		WebDriver driver=OpenBrowser("chrome", true);
		logger.info("CommonTest : setDriver : driver object assigned");
		LocalDriver.set(driver);
		//logger.info("CommonTest : setup : "+ name.getName()+" Test Object for reporting is created");
		
	}
	@BeforeClass
	public static WebDriver getDriver()
	{
		return LocalDriver.get();
	}
	@AfterMethod
	public static void remove()
	{
		CommonTest.getDriver().close();
		LocalDriver.remove();
		//logger.info("CommonTest : removeDriver : removed driver");
		//extent.flush();
	}
	
	public static WebDriver OpenBrowser(String browser,boolean headless)
	{
		WebDriver driver;
		String Type=browser.toLowerCase();
		switch (Type)
		{
			case "chrome":
				if(headless) {
					ChromeOptions co=new ChromeOptions();
					//logger.info("BaseTest : getBrowserType : Headless chrome configured");
					co.addArguments("--headless");
					driver=new ChromeDriver(co);
				//	driver=new ChromeDriver();
					
				}
				else
				{
					driver=new ChromeDriver();
					logger.info("BaseTest : getBrowserType : Chrome configured");
				}
				break;
			case "firefox":
				driver=new FirefoxDriver();
				logger.info("BaseTest : getBrowserType : Firefix configured");
				break;
			case "safari":
				driver=new SafariDriver();
				logger.info("BaseTest : getBrowserType : Safari configured");
				break;
			case "edge":
				driver=new EdgeDriver();
				logger.info("BaseTest : getBrowserType : EdgeDriver configured");
				break;
			default:
				driver=null;
				logger.fatal("BaseTest : getBrowserType : Incorrect browser name supplied");
				break;
		}
		return driver;
	}
	
}
