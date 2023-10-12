package sfdcTests;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Constants.FileConstants;
import sfdcPages.LoginPage;
import sfdcUtils.FileUtils;
import listeners.*;

@Listeners(SFDClisteners.class)
public class LoginTest extends CommonTest{

	@Test (priority = 1)
	public void LoginFail(Method name) throws IOException {
		//CommonTest.test=extent.createTest("TC_LoginFail");
		WebDriver driver=CommonTest.getDriver();
		ExtentTest test = CommonTest.threadExtentTest.get();
		LoginPage lp=new LoginPage(driver);
		logger.info("LoginPage : TC01 :"+name.getName()+" The object for login page is created");
		test.info("LoginPage : TC01 :"+name.getName()+" The object for login page is created");
		//driver.get(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"url"));
		driver.get("https://login.salesforce.com");
		lp.Username.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"username"));
		lp.password.clear();
		lp.loginBtn.click();
		test.warning(name.getName()+" Password not entered");
		test.info("LoginPage : TC01 :"+name.getName()+" Executed Successfully");
	}


@Test (priority = 2)
	public void LoginSuccess(Method name) throws IOException
	{
		WebDriver driver=CommonTest.getDriver();
		ExtentTest test = CommonTest.threadExtentTest.get();
		driver.get(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"url"));
		LoginPage lp=new LoginPage(driver);		
		logger.info("LoginPage : TC02 :"+name.getName()+" The object for login page is created");
		test.info("LoginPage : TC02 :"+name.getName()+" The object for login page is created");
		lp.Username.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"username"));
		lp.password.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"password"));
		test.info(name.getName()+ " Entered username and password");
		lp.loginBtn.click();
		test.info("Clicked on login button");
		logger.info("LoginPage : TC02 :"+name.getName()+" Executed Successfully");
		test.info("LoginPage : TC02 :"+name.getName()+" Executed Successfully");
		
	}

@Test  (priority = 3)
	public void rememberMeTest3(Method name) throws IOException
	{
		
		WebDriver driver=CommonTest.getDriver();
		ExtentTest test = CommonTest.threadExtentTest.get();
		driver.get(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"url"));
		LoginPage lp=new LoginPage(driver);
		logger.info("LoginPage : TC03 :"+name.getName()+" The object for login page is created");
		test.info("LoginPage : TC03 :"+name.getName()+" The object for login page is created");
		lp.Username.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"username"));
		lp.password.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "password"));
		lp.SelectRememberMe();
		lp.loginBtn.click();
		Assert.assertTrue(lp.isHomePageVisible(driver));		
		test.info(name.getName()+" verified visibility of home page");
		lp.userMenu.click();
		Actions action=new Actions(driver);
		action.moveToElement(lp.logOut).click().build().perform();
		//String sPostLogoutUsername=lp.postLogotUsername.getText();
		lp.isUsernameAutoDisplayed(driver);
		logger.info("LoginPage : TC03 :"+name.getName()+" Executed Successfully");
		test.info("LoginPage : TC03 :"+name.getName()+" Executed Successfully");
				
	}

@Test (priority = 4)
	public void forgotpasswordTest4A(Method name) throws IOException
	{
		WebDriver driver=CommonTest.getDriver();
		ExtentTest test = CommonTest.threadExtentTest.get();
		driver.get(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"url"));
		LoginPage lp=new LoginPage(driver);	
		logger.info("LoginPage : TC04A :"+name.getName()+" The object for login page is created");
		test.info("LoginPage : TC04A :"+name.getName()+" The object for login page is created");
		lp.Username.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "username"));
		lp.password.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "password"));
		//test.info("Entered username and password");
		lp.forgotPassword.click();		
		CommonTest.test.info("Clicked on forgot password");
		lp.forgorUserName.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.
		LOGIN_TESTDATA_FILE_PATH, "username")); lp.btnContinue.click();
		test.info(name.getName()+" Clicked on continue button");
		Assert.assertTrue(lp.verifyForgotPwd(driver));
		test.pass(name.getName()+" TEST PASSED");
		logger.info("LoginPage : TC4A :"+name.getName()+" Executed Successfully");
		test.info("LoginPage : TC4A :"+name.getName()+" Executed Successfully");
		//throw new ArithmeticException(); 
		
				
	}

@Test (priority = 5)
	public void VerifyInvalidCredentials(Method name) throws IOException
	{
		WebDriver driver=CommonTest.getDriver();
		ExtentTest test = CommonTest.threadExtentTest.get();
		LoginPage lp=new LoginPage(driver);
		logger.info("LoginPage : TC4B :"+name.getName()+" The object for login page is created");
		test.info("LoginPage : TC4B :"+name.getName()+" The object for login page is created");
		Assert.assertTrue(lp.verifyCredentials_TC4B(driver));
		test.pass(name.getName()+" TEST PASSED");
		logger.info("LoginPage : TC4B :"+name.getName()+" Executed Successfully");
	}
}
