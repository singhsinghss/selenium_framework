package sfdcTests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.SFDClisteners;
import sfdcPages.CreateAccountPage;
import sfdcPages.LoginPage;
import sfdcUtils.FileUtils;

@Listeners(SFDClisteners.class)
public class CreateAccountTest extends CommonTest{
  @BeforeClass
  public void navigateToHomePage() throws IOException {
	  WebDriver driver= CommonTest.getDriver();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
  }
  
  @Test
  public void CreateNewAccount_TC10(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  CreateAccountPage CAP=new CreateAccountPage(driver);
	  SoftAssert softassert=new SoftAssert();
	  CommonTest.test.info("CreateAccountPage : TC10 :"+name.getName()+" object for CreateAccount page is created");
	  //Assert.assertTrue(CAP.openAccountPage(driver));
	  CAP.openAccountPage(driver, CAP.AccTab);
	  logger.info("Open Account tab");
	  Assert.assertTrue(CAP.verifyAccPageDisplayed(driver));
	  logger.info("verify account tab is opened");
	  
	  softassert.assertTrue(CAP.deleteIfExists(driver, FileUtils.readCreateAccount("AccName")));
	  logger.info("Entered account name already exists so deleting...");
	  
	  Assert.assertTrue(CAP.isCreateNewAccDisplayed(driver));
	  CommonTest.test.pass("Create new account page is displayed");
	  logger.info("Create new account page is displayed");
	  Assert.assertTrue(CAP.enterNewAccDetails(driver, FileUtils.readCreateAccount("AccName"), FileUtils.readCreateAccount("type"),FileUtils.readCreateAccount("custPriority")));
	  
  }
  
  @Test
  public void CreateNewView_TC11(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  CreateAccountPage CAP=new CreateAccountPage(driver);
	  SoftAssert softassert=new SoftAssert();
	  CommonTest.test.info("CreateAccountPage : TC11 :"+name.getName()+" object for CreateAccount page is created");
	  //Assert.assertTrue(CAP.openAccountPage(driver));
	  CAP.openAccountPage(driver, CAP.AccTab);
	  logger.info("Open Account tab");
	  Assert.assertTrue(CAP.verifyAccPageDisplayed(driver));
	  logger.info("verify account tab is opened");
	  softassert.assertTrue(CAP.DeleteDuplicateView(driver, FileUtils.readCreateAccount("newViewName")));
	  CAP.createNewView(driver, FileUtils.readCreateAccount("viewname"), FileUtils.readCreateAccount("uniqueviewname"));
	  Assert.assertTrue(CAP.verifyNewView(driver, FileUtils.readCreateAccount("viewname")));
  }
  
  @Test
  public void EditView_TC12(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  CreateAccountPage CAP=new CreateAccountPage(driver);
	  CommonTest.test.info("CreateAccountPage : TC12 : "+name.getName()+" Object for Create Account page is created.");
	  CAP.openAccountPage(driver, CAP.AccTab);
	  logger.info("Open AccountTab");
	  Assert.assertTrue(CAP.verifyAccPageDisplayed(driver));
	  logger.info("verify account tab is opened");
	  Assert.assertTrue(CAP.editView(driver, FileUtils.readCreateAccount("viewname")));
	  Assert.assertTrue(CAP.verifyEditViewPageDisplayed(driver));
	  logger.info("editview page is displayed");
	  //CAP.isUniqueViewExists(driver,FileUtils.readCreateAccount("uniqueviewname"));
	  CAP.updateViewName(driver, FileUtils.readCreateAccount("newViewName"), FileUtils.readCreateAccount("field"), FileUtils.readCreateAccount("operator"), FileUtils.readCreateAccount("value"));
	  Assert.assertTrue(CAP.verifyViewNameChanged(driver, FileUtils.readCreateAccount("newViewName")));
	  logger.info("View name has been changed.");
  }
  
  @Test
  public void MergeAccounts_TC13(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  CreateAccountPage CAP=new CreateAccountPage(driver);
	  CommonTest.test.info("CreateAccountPage : TC13 : "+name.getName()+" Object for Create Account page is created.");
	  CAP.openAccountPage(driver, CAP.AccTab);
	  logger.info("Open AccountTab");
	  Assert.assertTrue(CAP.verifyAccPageDisplayed(driver));
	  logger.info("verify account tab is opened");
	  Assert.assertTrue(CAP.mergeAccountPage(driver));
	 CAP.SearchAccount(driver, FileUtils.readCreateAccount("searchByAcc"));
	 Assert.assertTrue(CAP.verifySearchData(driver));
	 Assert.assertTrue(CAP.mergeDuplicates(driver));
	 Assert.assertTrue(CAP.verifyMerge(driver));
	 	  
  }
  @Test
  public void saveAndRunAccReport_TC14(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  SoftAssert soft=new SoftAssert();
	  CreateAccountPage CAP=new CreateAccountPage(driver);
	  CommonTest.test.info("CreateAccountPage : TC14 : "+name.getName()+" Object for Create Account page is created.");
	  CAP.openAccountPage(driver, CAP.AccTab);
	  logger.info("Open AccountTab");
	  Assert.assertTrue(CAP.verifyAccPageDisplayed(driver));
	  logger.info("verify account tab is opened");
	  Assert.assertTrue(CAP.last30DaysActivity(driver));
	  Assert.assertTrue(CAP.saveReport(driver));
	  //CommonUtils.waitForElement(driver, CAP.saveAndRunRpt);
	  soft.assertTrue(CAP.saveAndRunReport(driver, FileUtils.readCreateAccount("reportName"), FileUtils.readCreateAccount("uniqueReportName")));	  
	  //soft.assertTrue(CAP.deleteReport(driver, FileUtils.readCreateAccount("reportName")));
	  
  }
}
