package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import sfdcTests.CommonTest;
import sfdcUtils.CommonUtils;

public class SFDClisteners extends CommonTest implements ITestListener{
	@Override
	public void onTestSuccess(ITestResult result)
	{
		CommonTest.test.pass(MarkupHelper.createLabel(result.getName()+" PASS", ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		CommonTest.test.fail(MarkupHelper.createLabel(result.getName()+" FAIL", ExtentColor.RED));
		try {
			CommonTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(CommonTest.getDriver()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



}
