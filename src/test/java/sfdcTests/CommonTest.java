package sfdcTests;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

import Constants.FileConstants;


public class CommonTest {

	private static ThreadLocal<WebDriver> LocalDriver=new ThreadLocal<>();
	static ExtentReports extent=new ExtentReports();
	static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	public static org.apache.logging.log4j.Logger logger=org.apache.logging.log4j.LogManager.getLogger("COMMONTEST");
	
	@BeforeMethod
	public void setup(Method name)
	{
		CommonTest.test=extent.createTest(name.getName());
		logger.info("CommonTest : setup :"+name.getName()+" The object for reporting is created");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterMethod
	public void teardown(Method name)
	{
		logger.info("CommonTest : setup :"+name.getName()+" teardown called");
	}
	@Parameters({"broserName","isHeadless"})
	@BeforeTest
	public static void setDriver(String browserName,boolean isHeadless)
	{
		spark=new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
		extent.attachReporter(spark);
		logger.info("BaseTest : setDriver :  Spark report configured");
		WebDriver driver=OpenBrowser(browserName,isHeadless);
		logger.info("BaseTest : setDriver : driver object assigned");
		LocalDriver.set(driver);
		
	}
	public static WebDriver getDriver()
	{
		return LocalDriver.get();
	}
	@AfterTest
	public static void remove()
	{
		getDriver().close();
		LocalDriver.remove();
		logger.info("BaseTest : removeDriver : removed driver");
		extent.flush();
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
					logger.info("BaseTest : getBrowserType : Headless chrome configured");
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
