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
import sfdcPages.LeadsPage;
import sfdcPages.LoginPage;
import sfdcUtils.FileUtils;

@Listeners(SFDClisteners.class)
public class LeadsTest extends CommonTest {
  @BeforeClass
  public void navigateToHome() throws IOException {
	  WebDriver driver=CommonTest.getDriver();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
  }
  
 
  @Test (priority=1)
  public void openLeadsPage_TC20(Method name)
  {
	  WebDriver driver=CommonTest.getDriver();
	  LeadsPage lp=new LeadsPage(driver);
	  CommonTest.test.info("Open Leads Tab : TC20 : "+name.getName()+" object created for leads page");
	  Assert.assertTrue(lp.openLeadPage(driver));
	  logger.info("open leads page");
  }
  
  @Test (priority=2)
  public void verifyLeadsViewList_TC21(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  LeadsPage lp=new LeadsPage(driver);
	  SoftAssert soft=new SoftAssert();
	  CommonTest.test.info("verify leads view list : TC21 : "+name.getName()+" object created for leads page");
	  Assert.assertTrue(lp.openLeadPage(driver));
	  logger.info("open leads page");
	  soft.assertTrue(lp.verifyLeadsViewList_TC21(driver,FileUtils.readLeadsTestData("leadsViewlist")));
	  System.out.println("verified leads view list");
  }
  
  @Test (priority=3)
  public void DefaultView_TC22(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  LeadsPage lp=new LeadsPage(driver);
	 // SoftAssert soft=new SoftAssert();
	  CommonTest.test.info("Default view : TC22 : "+name.getName()+" object created for leads page");
	  Assert.assertTrue(lp.openLeadPage(driver));
	  logger.info("open leads page");
	  Assert.assertTrue(lp.DefaultView_TC22(driver, FileUtils.readLeadsTestData("leadViewOption")));
	  System.out.println(FileUtils.readLeadsTestData("leadViewOption")+" has been selected in leads View DropDown");
	  Assert.assertTrue(lp.verifyDefaultView(driver, FileUtils.readLeadsTestData("leadViewText")));
	  System.out.println(FileUtils.readLeadsTestData("leadViewOption")+" was already selected in leads View DropDown");
	  Assert.assertTrue(lp.checkDefaultSelectedView(driver, FileUtils.readLeadsTestData("leadViewText")));
	  System.out.println(FileUtils.readLeadsTestData("leadViewOption")+"  was Default selected in leads View DropDown");
	 
  }
  
  @Test (priority=4)
  public void todaysLeadPage_TC23(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  LeadsPage lp=new LeadsPage(driver);
	 // SoftAssert soft=new SoftAssert();
	  CommonTest.test.info("Todays Lead : TC23 : "+name.getName()+" object created for leads page");
	  Assert.assertTrue(lp.openLeadPage(driver));
	  logger.info("open leads page");
	  Assert.assertTrue(lp.selectTodaysLeadPage_TC23(driver, FileUtils.readLeadsTestData("leadViewOption2")));
	  System.out.println("selected Todays Lead from dropdown");
	  Assert.assertTrue(lp.verifyTodaysLeadPage(driver,FileUtils.readLeadsTestData("leadViewText2")));
	  System.out.println("verified Todays lead has been selected");
  }
  
  @Test (priority=5)
  public void newLead_TC24(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  LeadsPage lp=new LeadsPage(driver);
	 // SoftAssert soft=new SoftAssert();
	  CommonTest.test.info("New lead : TC24 : "+name.getName()+" object created for leads page");
	  Assert.assertTrue(lp.openLeadPage(driver));
	  logger.info("open leads page");
	  lp.createNewLead_TC24(driver, FileUtils.readLeadsTestData("lastname"), FileUtils.readLeadsTestData("companyname"));
	  System.out.println("new lead has been created");
	  Assert.assertTrue(lp.verifyCreatedLead(driver));
	  System.out.println("verified created lead");
	  lp.deleteIfExits(driver);
  }
}
