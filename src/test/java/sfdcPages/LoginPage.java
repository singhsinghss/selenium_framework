package sfdcPages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;

import Constants.FileConstants;
import Constants.WaitConstants;
import junit.framework.Assert;
import sfdcUtils.CommonUtils;
import sfdcUtils.FileUtils;


public class LoginPage extends CommonPage{

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="username")
	public WebElement Username;
	
	@FindBy (xpath="//input[@id='password'][@name='pw']")
	public WebElement password;
	
	@FindBy (xpath = "//input[@id='Login'][@name='Login']")
	public WebElement loginBtn;
	
	@FindBy (xpath="//div[@class='loginError'][@id='error']")
	public WebElement errorMsg;
	
	@FindBy (xpath = "//a[@id='forgot_password_link' and @ class='fl small']")
	public WebElement forgotPassword;
	
	@FindBy(xpath="(//*[@id='continue'])")
	public WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='message']//following::p[@class='senttext mb12']")
	public WebElement resetMsg;
	
	@FindBy(xpath="//label[text()='Remember me' and @class='fl pr db tn3']/preceding::input[1]")
	public WebElement rememberMeChk;
	
	@FindBy(xpath = "//div[@id='userNav']")
	public WebElement userMenu;
	
	@FindBy (xpath= "//div[@id='userNav-menuItems']//child::a[@title='Logout']")
	public WebElement logOut;
	
	@FindBy(xpath = "(//*[@title='Home Tab'])")
	public WebElement homeTab;
	
	@FindBy(xpath = "//span[@id='idcard-identity']")
	public WebElement postLogotUsername;
	
	@FindBy(xpath = "(//*[@id='un'])")
	public WebElement forgorUserName;
	
	@FindBy(xpath = "(//*[text()='Return to Login'])")
	public WebElement retutnToLogin;
	
	@FindBy(xpath = "//*[@id='error']")
	public WebElement ErrorMsg;
	
	public boolean SelectRememberMe()
	{
		boolean isSelected=false;
		if(!rememberMeChk.isSelected())
		{
			rememberMeChk.click();
			isSelected=true;
		}
		return isSelected;
	}
		
	@FindBy (xpath="//span[@id='idcard-identity']")
	public WebElement validateUserName;
	
	public void LoginToSalesForce(WebDriver driver) throws IOException {
		driver.manage().window().maximize();
		driver.get(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"url"));
		String sUsername=FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"username");
		Username.sendKeys(sUsername);
		password.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"password"));
		loginBtn.click();
	}
	public boolean isHomePageVisible(WebDriver driver) {
		// TODO Auto-generated method stub
		logger.info("LoginPage : isHomePageVisible: is executing");
		CommonUtils.waitForElementToDisplay(driver,homeTab);
		boolean isHomeVisible=false;
		if(homeTab.isDisplayed())
		{
			isHomeVisible=true;
		}
		return isHomeVisible; 
	}
	public boolean verifyForgotPwd(WebDriver driver) {
		// TODO Auto-generated method stub
		logger.info("LoginPage : verifyForgotPWD: is executing");
		boolean isVerify=false;
		CommonUtils.waitForElement(driver, retutnToLogin);
		if(retutnToLogin.isDisplayed())
		{
			isVerify=true;
		}
		return isVerify;
	}
	public boolean isUsernameAutoDisplayed(WebDriver driver) {
		// TODO Auto-generated method stub
		logger.info("LoginPage : isUserNameAutoDisplayed: is executing");
		boolean isUsernameAutoDisplayed=false;
		CommonUtils.waitForElementToDisplay(driver, postLogotUsername);
		if(postLogotUsername.isDisplayed())
		{
			isUsernameAutoDisplayed=true;
		}
		return isUsernameAutoDisplayed;
		
	}
	
	public boolean verifyCredentials_TC4B(WebDriver driver) throws IOException
	{
		logger.info("LoginPage : verifyCredentials : is executing");
		boolean isValid=false;
		driver.manage().window().maximize();
		driver.get(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"url"));
		String sUsername=FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"invalid_username");
		Username.sendKeys(sUsername);
		password.sendKeys(FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH,"invalid_password"));
		loginBtn.click();
		String ExpectedMsg=FileUtils.readLoginTestDataFile(FileConstants.LOGIN_TESTDATA_FILE_PATH, "ErrorMessage");
		Assert.assertEquals(ExpectedMsg, ErrorMsg.getText());
		isValid=true;
		logger.info("LoginPage : result is as expected");
		return isValid;
	}
	
}
