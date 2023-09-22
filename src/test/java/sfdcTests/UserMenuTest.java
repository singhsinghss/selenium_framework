package sfdcTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Constants.FileConstants;
import listeners.SFDClisteners;
import sfdcPages.LoginPage;
import sfdcPages.UserMenu;
import sfdcUtils.CommonUtils;
import sfdcUtils.FileUtils;

@Listeners(SFDClisteners.class)
public class UserMenuTest extends CommonTest{
  
	@BeforeMethod
  public void navigateToHomePage() throws IOException {
		WebDriver driver=CommonTest.getDriver();
		LoginPage lp=new LoginPage(driver);
		lp.LoginToSalesForce(driver);
  }
	@Test
	public void userMenuDropDown_TC05() throws IOException
	{
		WebDriver driver=CommonTest.getDriver();
		UserMenu ump=new UserMenu(driver);
		CommonUtils.waitForElementToDisplay(driver, ump.Usermenu);
		ump.Usermenu.click();
		Assert.assertTrue(ump.verifyUserMenuOptions());
		
	}
	@Test
	public void myProfile_TC06(Method name) throws IOException
	{
		WebDriver driver=CommonTest.getDriver();
		UserMenu ump=new UserMenu(driver);
		//logger.info("UserMenuPage : TC06 :"+name.getName()+" The object for UserMenu page is created");
		CommonUtils.waitForElementToDisplay(driver, ump.Usermenu);
		ump.Usermenu.click();
		Assert.assertTrue(ump.verifyUserMenuOptions());
		Assert.assertTrue(ump.selectMyProfile());
		CommonUtils.waitForElementToDisplay(driver, ump.profilePage);
		Assert.assertTrue(ump.isProfilePageVisible());
		ump.EditContact(driver);
		Assert.assertTrue(ump.verifyEditContactPopUp(driver));
		Assert.assertTrue(ump.verifyLastNameChanged(driver, FileUtils.readUserMenuTestDataFile("lastname")));
		Assert.assertTrue(ump.VerifyCreatePost(driver, FileUtils.readUserMenuTestDataFile("Post")));
		CommonUtils.waitForElement(driver, ump.Filelink);
		Assert.assertTrue(ump.VerifyFileUpload(driver, FileConstants.UPLOAD_FILE_PATH));
		ump.uploadProfilePhoto(driver);
		Assert.assertTrue(ump.verifyUploadPhoto(driver, FileConstants.PROFILE_PHOTO_PATH));
	}
	
	@Test
	public void mySetting_TC07(Method name) throws IOException
	{
		WebDriver driver=CommonTest.getDriver();
		SoftAssert softAssert=new SoftAssert();
		UserMenu ump=new UserMenu(driver);
		//logger.info("UserMenuPage : TC07 :"+name.getName()+" The object for UserMenu page is created");
		CommonUtils.waitForElementToDisplay(driver, ump.Usermenu);
		Assert.assertTrue(ump.mySetting(driver));
		ump.DownloadLoginHistory(driver);
		ump.verifyLoginHistoryDownloaded(driver, FileConstants.LOGIN_HISTORY_FILA_PATH,FileUtils.readUserMenuMySettingData("loginhistory_filename"));
		Assert.assertTrue(ump.DispalyandLayout(driver));
		Assert.assertTrue(ump.VerifyCustomeAppSelected(driver, FileUtils.readUserMenuMySettingData("customApp")));
		softAssert.assertTrue(ump.addTabFromAvailableTab(driver, FileUtils.readUserMenuMySettingData("addTab")));
		//Assert.assertTrue(ump.isTextExistsInDropDown(driver, ump.AvailableTab, FileUtils.readUserMenuMySettingData("addTab")));
		Assert.assertTrue(ump.verifyTabAddedtoSelectedTab(driver, FileUtils.readUserMenuMySettingData("addTab")));
		Assert.assertTrue(ump.VerifyTabBar(driver, FileUtils.readUserMenuMySettingData("addTab")));
		Assert.assertTrue(ump.myEmailSetting(driver));
		Assert.assertTrue(ump.isEmailUpdated(driver, FileUtils.readUserMenuMySettingData("emailName"), FileUtils.readUserMenuMySettingData("emailAdd")));
		Assert.assertTrue(ump.VerifyEmailUpdated(driver, FileUtils.readUserMenuMySettingData("emailSaveMessage")));
		Assert.assertTrue(ump.CalAndReminder(driver));
		Assert.assertTrue(ump.OpenTestReminder(driver));
		
	}
	@Test
	
	public void DeveloperConsole_TC08(Method name)
	{
		WebDriver driver=CommonTest.getDriver();
		UserMenu ump=new UserMenu(driver);
		//logger.info("UserMenuPage : TC08 :"+name.getName()+" The object for UserMenu page is created");
		Assert.assertTrue(ump.openDeveloperConsole(driver));
		//logger.info("Open Developer console");
		Assert.assertTrue(ump.verifyDCWindowOpened(driver));
		//logger.info("verify whether developer console window opened");
	}
	
	@Test 
	public void logout_TC09(Method name)
	{
		WebDriver driver=CommonTest.getDriver();
		UserMenu ump=new UserMenu(driver);
		//logger.info("UserMenuPage : TC09 :"+name.getName()+" The object for UserMenu page is created");
		//logger.info("logout from application");
		Assert.assertTrue(ump.logout(driver));
		//Assert.assertTrue(ump.verifyLogout(driver));
	}
}
