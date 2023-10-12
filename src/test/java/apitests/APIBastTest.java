package apitests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.jayway.jsonpath.JsonPath;
import api.constants.FileConstants;
import api.listener.Listener;
import api.utils.commonUtilities;
import apireusableutils.RestUtils;
import org.apache.logging.log4j.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import sfdcTests.CommonTest;
 


public class APIBastTest {

	public static String token;
	static ExtentReports extent=new ExtentReports();
	static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	public static Logger logger=LogManager.getLogger("APIBASETEST");
	public static void setToken() throws IOException
	{	//CommonTest.test=extent.createTest("setToken");	
		String uri=commonUtilities.readFileAndReturnString(FileConstants.URI_FILE_PATH);		
		RestAssured.baseURI=JsonPath.read(uri, "$.login.prod");	
		System.out.println(RestAssured.baseURI);
		//test.info("setToken: read the baseURI detail");
		String creds=commonUtilities.readFileAndReturnString(FileConstants.USER_CONFIG_FILE_PATH);
		String un=JsonPath.read(creds, "$.prod.username");
		String pwd=JsonPath.read(creds, "$.prod.password");
		HashMap<String, String>payload=new HashMap<>();
		
		payload.put("username", un);
		payload.put("password", pwd);
		//test.info("setToken: username and password has been passed");
		//logger.info("setToken: username and password has been passed");
		HashMap<String, String>headers=new HashMap<>();
		headers.put("Content-Type", "application/json");
		//test.info("setToken: header has been passed");
		Response res=RestUtils.postReq(payload, headers, "/login");		
		//System.out.println(res.prettyPrint());
		//test.info("setToken: request has been posted for getting token");
		token=JsonPath.read(res.asString(), "$.[0].token");
		System.out.println("token from BaseTest: "+ token);
		//logger.info("APIBaseTest: token from BaseTest has been received ");
	}
	@BeforeMethod
	public void setUp(Method name) throws IOException
	{
		//extent=new ExtentReports();
		APIBastTest.test=extent.createTest(name.getName());
		//APIBastTest.setToken();
	}

	/*
	 * @BeforeMethod public void setupReport(Method name) {
	 * CommonTest.test=extent.createTest(name.getName()); }
	 */
	@BeforeSuite
	public void configureReport()
	{
		//extent=new ExtentReports();
		spark=new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
		extent.attachReporter(spark);
	}
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}
}
