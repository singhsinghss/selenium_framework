package sfdcTests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;
import listeners.SFDClisteners;
import sfdcPages.ContactsPage;
import sfdcPages.LoginPage;
import sfdcUtils.FileUtils;

@Listeners(SFDClisteners.class)
public class ContactsTest extends CommonTest{
	/*
	 * @BeforeClass public void navigateToHome() throws IOException { WebDriver
	 * driver=CommonTest.getDriver(); LoginPage lp=new LoginPage(driver);
	 * lp.LoginToSalesForce(driver); }
	 */
  
  @Test (priority=1)
  public void CreateNewContact_TC25(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  ContactsPage CP=new ContactsPage(driver);
	  test.info("ContactsPage : TC25 :"+name.getName()+ " object created for Contact Page");
	  logger.info("ContactsPage : TC25 :"+name.getName()+ " object created for Contact Page");
	  Assert.assertTrue(CP.openContactsTab(driver));
	  Assert.assertTrue(CP.verifyContactPageOpened(driver));
	  logger.info("contact page opened");
	  CP.CreateNewContacts_TC25(driver, FileUtils.readContactsTestData("lastName"));
	  Assert.assertTrue(CP.verifyNewContact(driver, FileUtils.readContactsTestData("lastName")));
	  test.info("ContactsPage : TC25 :"+name.getName()+ " Executed Successfully");
	  logger.info("ContactsPage : TC25 :"+name.getName()+ " Executed Successfully");
	  Assert.assertTrue(CP.DeleteCreatedContact(driver));
  }
  @Test (priority=2)
  public void CreateNewView_TC26(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  ContactsPage CP=new ContactsPage(driver);
	  SoftAssert soft=new SoftAssert();
	  test.info("ContactsPage : TC26 :"+name.getName()+ " object created for Contact Page");
	  logger.info("ContactsPage : TC26 :"+name.getName()+ " object created for Contact Page");
	  Assert.assertTrue(CP.openContactsTab(driver));
	  Assert.assertTrue(CP.verifyContactPageOpened(driver));
	  logger.info("contact page opened");
	  soft.assertTrue(CP.CreateNewView_TC26(driver, FileUtils.readContactsTestData("viewName"), FileUtils.readContactsTestData("uViewName")));
	  //soft.assertTrue(CP.deleteView(driver));
	  test.info("ContactsPage : TC26 :"+name.getName()+ " Executed Successfully");
	  logger.info("ContactsPage : TC26 :"+name.getName()+ " Executed Successfully");
  }
  @Test(priority=3)
  public void recentlyCreatedContact_TC27(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  ContactsPage CP=new ContactsPage(driver);
	  test.info("ContactsPage : TC27 :"+name.getName()+ " object created for Contact Page");
	  logger.info("ContactsPage : TC27 :"+name.getName()+ " object created for Contact Page");
	  Assert.assertTrue(CP.openContactsTab(driver));
	  Assert.assertTrue(CP.verifyContactPageOpened(driver));
	  logger.info("contact page opened");
	  Assert.assertTrue(CP.recentlyCreatedContact_TC27(driver, FileUtils.readContactsTestData("displaySelection")));
	  test.info("ContactsPage : TC27 :"+name.getName()+ " Executed Successfully");
	  logger.info("ContactsPage : TC27 :"+name.getName()+ " Executed Successfully");
  }
  @Test(priority=4)
  public void myContactView_TC28(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  ContactsPage CP=new ContactsPage(driver);
	  test.info("ContactsPage : TC28 :"+name.getName()+ " object created for Contact Page");
	  logger.info("ContactsPage : TC28 :"+name.getName()+ " object created for Contact Page");
	  Assert.assertTrue(CP.openContactsTab(driver));
	  Assert.assertTrue(CP.verifyContactPageOpened(driver));
	  logger.info("contact page opened");
	  Assert.assertTrue(CP.myContactView_TC28(driver, FileUtils.readContactsTestData("viewContactValue")));
	  test.info("ContactsPage : TC28 :"+name.getName()+ " Executed Successfully");
	  logger.info("ContactsPage : TC28 :"+name.getName()+ " Executed Successfully");
  }
  @Test(priority=5)
  public void ViewContactName_TC29(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  ContactsPage CP=new ContactsPage(driver);
	  test.info("ContactsPage : TC29 :"+name.getName()+ " object created for Contact Page");
	  logger.info("ContactsPage : TC29 :"+name.getName()+ " object created for Contact Page");
	  Assert.assertTrue(CP.openContactsTab(driver));
	  Assert.assertTrue(CP.verifyContactPageOpened(driver));
	  logger.info("contact page opened");
	  Assert.assertTrue(CP.viewContactName_TC29(driver));
	  test.info("ContactsPage : TC29 :"+name.getName()+ " Executed Successfully");
	  logger.info("ContactsPage : TC29 :"+name.getName()+ " Executed Successfully");
  }
  @Test(priority=6)
  public void createNewViewError_TC30(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  ContactsPage CP=new ContactsPage(driver);
	  test.info("ContactsPage : TC30 :"+name.getName()+ " object created for Contact Page");
	  logger.info("ContactsPage : TC30 :"+name.getName()+ " object created for Contact Page");
	  Assert.assertTrue(CP.openContactsTab(driver));
	  Assert.assertTrue(CP.verifyContactPageOpened(driver));
	  logger.info("contact page opened");
	  Assert.assertTrue(CP.createNewViewError_TC30(driver, FileUtils.readContactsTestData("cancelUniqueViewName"), FileUtils.readContactsTestData("expectedError")));
	  test.info("ContactsPage : TC30 :"+name.getName()+ " Executed Successfully");
	  logger.info("ContactsPage : TC30 :"+name.getName()+ " Executed Successfully");
  }
  @Test(priority=7)
  public void cancelNewContact_TC31(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  ContactsPage CP=new ContactsPage(driver);
	  test.info("ContactsPage : TC31 :"+name.getName()+ " object created for Contact Page");
	  logger.info("ContactsPage : TC31 :"+name.getName()+ " object created for Contact Page");
	  Assert.assertTrue(CP.openContactsTab(driver));
	  Assert.assertTrue(CP.verifyContactPageOpened(driver));
	  logger.info("contact page opened");
	  Assert.assertTrue(CP.CancelNewContact_TC31(driver, FileUtils.readContactsTestData("cancelViewName"), FileUtils.readContactsTestData("cancelUniqueViewName")));
	  test.info("ContactsPage : TC31 :"+name.getName()+ " Executed Successfully");
	  logger.info("ContactsPage : TC31 :"+name.getName()+ " Executed Successfully");
  }
  @Test(priority = 8)
  public void saveAndNewContact_TC32(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  ContactsPage CP=new ContactsPage(driver);
	  test.info("ContactsPage : TC32 :"+name.getName()+ " object created for Contact Page");
	  logger.info("ContactsPage : TC32 :"+name.getName()+ " object created for Contact Page");
	  Assert.assertTrue(CP.openContactsTab(driver));
	  Assert.assertTrue(CP.verifyContactPageOpened(driver));
	  logger.info("contact page opened");
	  Assert.assertTrue(CP.SaveNewContact_TC32(driver, FileUtils.readContactsTestData("newLastName"), FileUtils.readContactsTestData("newAccName")));
	  test.info("ContactsPage : TC32 :"+name.getName()+ " Executed Successfully");
	  logger.info("ContactsPage : TC32 :"+name.getName()+ " Executed Successfully");
  }
}
