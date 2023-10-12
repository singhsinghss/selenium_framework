package sfdcTests;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listeners.SFDClisteners;
import sfdcPages.LoginPage;
import sfdcPages.RandomScenariosPage;
import sfdcUtils.FileUtils;

@Listeners(SFDClisteners.class)
public class RandomScenariosTest extends CommonTest {
	/*
	 * @BeforeClass public void navigateToHome() throws IOException { WebDriver
	 * driver=CommonTest.getDriver(); LoginPage lp=new LoginPage(driver);
	 * lp.LoginToSalesForce(driver); }
	 */
  @Test (priority = 1)
  public void openHomeTab_TC33(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  RandomScenariosPage rcp=new RandomScenariosPage(driver);
	  test.info("Open Home Page: TC33 : "+name.getName()+" :object created for RandomScenarios Page");
	  logger.info("Open Home Page: TC33 : "+name.getName()+" :object created for RandomScenarios Page");
	  rcp.openHomeTab_TC33(driver);
	  Assert.assertTrue(rcp.verifyHomaPage(driver, FileUtils.readRandomTestData("fullName")));
	  logger.info("Home page is opened and user name has been checked");
	  Assert.assertTrue(rcp.openMyProfilePage(driver));
	  logger.info("my profile page is displayed");
	  test.info("Open Home Page: TC33 : "+name.getName()+" : Executed Successfully");
	  logger.info("Open Home Page: TC33 : "+name.getName()+" : Executed Successfully");
	  
  }
  
  @Test(priority=2)
  public void editProfile_TC34(Method name) throws IOException, InterruptedException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  RandomScenariosPage RCP=new RandomScenariosPage(driver);
	  test.info("Edit profile Page: TC34 : "+name.getName()+" :object created for RandomScenarios Page");
	  logger.info("Edit profile Page: TC34 : "+name.getName()+" :object created for RandomScenarios Page");
	  RCP.openHomeTab_TC33(driver);
	  Assert.assertTrue(RCP.editProfile_TC34(driver, FileUtils.readRandomTestData("NewLastName")));
	  Assert.assertTrue(RCP.verifyUpdatedName(driver, FileUtils.readRandomTestData("ExpectedFullName")));
	  test.info("Edit profile Page: TC34 : "+name.getName()+" : Executed Successfully");
	  logger.info("Edit profile Page: TC34 : "+name.getName()+" : Executed Successfully");
  }
  @Test(priority = 3)
  public void removeTab_TC35(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  RandomScenariosPage RCP=new RandomScenariosPage(driver);
	  test.info("Remove tab : TC35 : "+name.getName()+" :object created for RandomScenarios Page");
	  logger.info("Remove tab : TC35 : "+name.getName()+" :object created for RandomScenarios Page");
	  RCP.openHomeTab_TC33(driver);
	  Assert.assertTrue(RCP.customizeTab_TC35(driver));
	  Assert.assertTrue(RCP.removeIfExists(driver, FileUtils.readRandomTestData("removeTab")));
	  Assert.assertTrue(RCP.logoutAndVerifyTab(driver));
	  test.info("Remove tab : TC35 : "+name.getName()+" : Executed Successfully");
	  logger.info("Remove tab : TC35 : "+name.getName()+" : Executed Successfully");
  }
}
