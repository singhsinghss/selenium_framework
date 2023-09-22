package sfdcTests;


import java.io.IOException;
import java.lang.reflect.Method;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Constants.FileConstants;
import listeners.SFDClisteners;
import sfdcPages.LoginPage;
import sfdcUtils.FileUtils;



/**
 * @author seema
 *
 */
@Listeners(SFDClisteners.class)
public class LoginTest extends CommonTest{
	
	/**
	 * Login without entering password.Login should fail.
	 * @author seema
	 * @throws ParseException 
	 * @throws IOException 
	 * @category Login
	 * 
	 */
	
	
	@Test (priority=1)
	public void LoginFail(Method name) throws IOException {
		WebDriver driver=CommonTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		driver.get("https://login.salesforce.com");
		lp.Username.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"username"));
		lp.password.clear();
		lp.loginBtn.click();
		CommonTest.test.warning("Password not entered");
		
	}
	/**
	 * Login with correct username and password. login should be successful.
	 * @category Login 
	 * @param URL
	 * @param username is passed as param
	 * @param password 
	 * @throws IOException 
	 */
	@Test (priority=2)
	public void LoginSuccess(Method name) throws IOException
	{
		WebDriver driver=CommonTest.getDriver();
		driver.get("https://login.salesforce.com");
		LoginPage lp=new LoginPage(driver);		
		lp.Username.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"username"));
		lp.password.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"password"));
		CommonTest.test.info("Entered username and password");
		lp.loginBtn.click();
		CommonTest.test.info("Clicked on login button");
		
	}
	
	/**
	 * checks if username is auto displayed after clicking on rememberMe checkbox
	 * @throws IOException
	 */
	@Test (priority=3) 
	public void rememberMeTest3(Method name) throws IOException
	{
		
		WebDriver driver=CommonTest.getDriver();
		driver.get("https://login.salesforce.com");
		LoginPage lp=new LoginPage(driver);
		lp.Username.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"username"));
		lp.password.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "password"));
		lp.SelectRememberMe();
		lp.loginBtn.click();
		Assert.assertTrue(lp.isHomePageVisible());		
		CommonTest.test.info("verified visibility of home page");
		lp.userMenu.click();
		Actions action=new Actions(driver);
		action.moveToElement(lp.logOut).click().build().perform();
		//String sPostLogoutUsername=lp.postLogotUsername.getText();
		lp.isUsernameAutoDisplayed(driver);
				
	}
	
	
	@Test (priority=4)
	public void forgotpasswordTest4A(Method name) throws IOException
	{
		WebDriver driver=CommonTest.getDriver();
		driver.get("https://login.salesforce.com");
		LoginPage lp=new LoginPage(driver);		
		lp.Username.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "username"));
		lp.password.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "password"));
		CommonTest.test.info("Entered username and password");
		lp.forgotPassword.click();		
		CommonTest.test.info("Clicked on forgot password");
		lp.forgorUserName.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.
		LOGIN_TESTDATA_FILE_PATH, "username")); lp.btnContinue.click();
		CommonTest.test.info("Clicked on continue button");
		Assert.assertTrue(lp.verifyForgotPwd(driver));
		CommonTest.test.pass(name.getName()+" TEST PASSED");
		
		//throw new ArithmeticException(); 
		
				
	}
	
	@Test (priority=5)
	public void VerifyInvalidCredentials(Method name) throws IOException
	{
		WebDriver driver=CommonTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.verifyCredentials_TC4B(driver));
		CommonTest.test.pass(name.getName()+" TEST PASSED");
	}
	
	
  
}
