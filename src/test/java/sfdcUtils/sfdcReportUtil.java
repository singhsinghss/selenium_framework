package sfdcUtils;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Constants.FileConstants;
public class sfdcReportUtil {
	
	public static void main(String[]args) {
	ExtentReports extent=new ExtentReports();
	ExtentSparkReporter spark=new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
	extent.attachReporter(spark);
	
	ExtentTest test;
	test=extent.createTest("TC01");
	test.log(Status.PASS, "");
	test.info("password is entered");
	test.info("Clicked on login button");
	extent.flush();
	
	}
}
