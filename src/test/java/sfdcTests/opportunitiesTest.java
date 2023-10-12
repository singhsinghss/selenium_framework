package sfdcTests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import listeners.SFDClisteners;
import sfdcPages.LoginPage;
import sfdcPages.OpportunitiesPage;
import sfdcUtils.FileUtils;

@Listeners(SFDClisteners.class)
public class opportunitiesTest extends CommonTest{
 // @BeforeClass
	/*
	 * public void navigateToHome() throws IOException { WebDriver driver
	 * =CommonTest.getDriver(); LoginPage lp=new LoginPage(driver);
	 * lp.LoginToSalesForce(driver); }
	 */
  
  @Test
  public void verifyOpportunityList_TC15(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  OpportunitiesPage OP=new OpportunitiesPage(driver);
	  SoftAssert soft=new SoftAssert();
	  test.info("OpportunitiesPage :  TC15 : "+name.getName()+" : object created for oppotunityPage");
	  logger.info("OpportunitiesPage :  TC15 : "+name.getName()+" : object created for oppotunityPage");
	  Assert.assertTrue(OP.verifyOpty(driver));
	  logger.info("open Opportunity page");
	  soft.assertTrue(OP.verifyList(driver,FileUtils.readOpportunities("opportunities")));
	  logger.info("verify opportunity list");
	  test.info("OpportunitiesPage :  TC15 : "+name.getName()+" : Executed Successfully");
	  logger.info("OpportunitiesPage :  TC15 : "+name.getName()+" : Executed Successfully");
	  
  }
  @Test
  
  public void createNewOpprtunity_TC16(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  OpportunitiesPage OP=new OpportunitiesPage(driver);
	  test.info("OpportunitiesPage :  TC16 : "+name.getName()+" : object created for oppotunityPage");
	  logger.info("OpportunitiesPage :  TC16 : "+name.getName()+" : object created for oppotunityPage");
	  Assert.assertTrue(OP.verifyOpty(driver));
	  logger.info("open Opportunity page");
	  Assert.assertTrue(OP.CreateNewOptyPage(driver,FileUtils.readOpportunities("optyName"), FileUtils.readOpportunities("stage"), FileUtils.readOpportunities("probability"), FileUtils.readOpportunities("leadSource")));
	  //Assert.assertTrue(OP.deleteOpportunity(driver));
	  test.info("OpportunitiesPage :  TC16 : "+name.getName()+" : Executed Successfully");
	  logger.info("OpportunitiesPage :  TC16 : "+name.getName()+" : Executed Successfully");
  }
  
  @Test
  public void opportunityPipelineRpt_TC17(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  OpportunitiesPage OP=new OpportunitiesPage(driver);
	  test.info("OpportunitiesPage :  TC17 : "+name.getName()+" : object created for oppotunityPage");
	  logger.info("OpportunitiesPage :  TC17 : "+name.getName()+" : object created for oppotunityPage");
	  Assert.assertTrue(OP.verifyOpty(driver));
	  logger.info("open Opportunity page");
	  Assert.assertTrue(OP.openPipelineLink(driver));
	  Assert.assertTrue(OP.verifyOptyPipelineDisplayed(driver));
	  test.info("OpportunitiesPage :  TC17 : "+name.getName()+" : Executed Successfully");
	  logger.info("OpportunitiesPage :  TC17 : "+name.getName()+" : Executed Successfully");
  }
  
  @Test
  public void stuckOpportunityReport_TC18(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  OpportunitiesPage OP=new OpportunitiesPage(driver);
	  test.info("OpportunitiesPage :  TC18 : "+name.getName()+" : object created for oppotunityPage");
	  logger.info("OpportunitiesPage :  TC18 : "+name.getName()+" : object created for oppotunityPage");
	  Assert.assertTrue(OP.verifyOpty(driver));
	  logger.info("open Opportunity page");
	  Assert.assertTrue(OP.openStuckOpty(driver));
	  Assert.assertTrue(OP.verifyStuckOptyReport(driver));
	  test.info("OpportunitiesPage :  TC18 : "+name.getName()+" : Executed Successfully");
	  logger.info("OpportunitiesPage :  TC18 : "+name.getName()+" : Executed Successfully");
  }
  @Test
  public void QuarterlySummaryReport_TC19(Method name) throws IOException
  {
	  WebDriver driver=CommonTest.getDriver();
	  ExtentTest test = CommonTest.threadExtentTest.get();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  OpportunitiesPage OP=new OpportunitiesPage(driver);
	  test.info("OpportunitiesPage :  TC19 : "+name.getName()+" : object created for oppotunityPage");
	  logger.info("OpportunitiesPage :  TC19 : "+name.getName()+" : object created for oppotunityPage");
	  Assert.assertTrue(OP.verifyOpty(driver));
	  logger.info("open Opportunity page");
	  OP.quarterlySummaryReport_TC19(driver, FileUtils.readOpportunities("interval"), FileUtils.readOpportunities("include"));
	  Assert.assertTrue(OP.verifyQSummaryRptPage(driver));
	  test.info("OpportunitiesPage :  TC19 : "+name.getName()+" : Executed Successfully");
	  logger.info("OpportunitiesPage :  TC19 : "+name.getName()+" : Executed Successfully");
  }
}
