package sfdcTests;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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
	
	@BeforeTest
	public static void setDriver()
	{
		spark=new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
		extent.attachReporter(spark);
		WebDriver driver=OpenBrowser("chrome");
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
		extent.flush();
	}
	
	public static WebDriver OpenBrowser(String browser)
	{
		WebDriver driver;
		String Type=browser.toLowerCase();
		switch (Type)
		{
			case "chrome":
				driver=new ChromeDriver();
				break;
			case "firefox":
				driver=new FirefoxDriver();
				break;
			case "safari":
				driver=new SafariDriver();
				break;
			case "edge":
				driver=new EdgeDriver();
				break;
			default:
				driver=null;
				break;
		}
		return driver;
	}
	
}
