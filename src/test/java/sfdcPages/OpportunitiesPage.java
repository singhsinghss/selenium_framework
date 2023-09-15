package sfdcPages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sfdcUtils.CommonUtils;

public class OpportunitiesPage {
 
  public OpportunitiesPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  
  @FindBy(css = "#Opportunity_Tab")
  public WebElement optyTab;
  
  @FindBy (className = "pageType")
  public WebElement optyPage;
  
  @FindBy (css = "select[id='fcf']")
  public WebElement viewOpty;
  
  /******************TC16*********************/
  @FindBy(css = "input[name='new']")
  public WebElement newBtn;
  
  @FindBy (css = "input[id='opp3']")
  public WebElement optyName;
  
  @FindBy (id = "opp4_lkwgt")
  public WebElement searchBtn;
  
  @FindBy (css = "frame[id='resultsFrame']")
  public WebElement iframe;
  
  @FindBy (css = "table[class=list]")
  public WebElement table;
  
  @FindBy (xpath  = "//table[@class='list']//child::tr[5]//a")
  public WebElement row;
  
  @FindBy (css = "input[id='opp9']")
  public WebElement closeDate;
  
  @FindBy (className  = "calToday")
  public WebElement currDate;
  
  @FindBy(css = "select[id='opp11']")
  public WebElement stage;
  
  @FindBy(css = "input[id='opp12']")
  public WebElement probability;
  
  @FindBy(css = "select[id='opp6']")
  public WebElement leadSource;
  
  @FindBy(id = "opp17_lkwgt")
  public WebElement pCampSrc;
  
  @FindBy(xpath  = "//table[@class='list']//th[@scope='row']/a[1]")
  public WebElement campaignTable;
  
  @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save' and  @class='btn']")
  public WebElement saveButton;
  
  @FindBy(className = "pageDescription")
  public WebElement pageName;
  
  @FindBy(xpath = "//*[@id='topButtonRow']//input[@name='del']")
  public WebElement deleteOptyBtn;
  
  @FindBy (className = "pageDescription")
  public WebElement pageDesc;

  
  /****************************TC17*************************/
  
  @FindBy(xpath = "//div[@class='lbBody']//li//a[text()='Opportunity Pipeline']")
  public WebElement pipelineLink;
  
  @FindBy(xpath = "//div[@class='content']//h1[text()='Opportunity Pipeline']")
  public WebElement pipelinedOpty;
  
  /*********************TC18*********************/
  @FindBy(xpath = "//div[@class='lbBody']//a[text()='Stuck Opportunities']")
  public WebElement stuckPipelineOpty;
  
  @FindBy(xpath = "//div[@class='content']//h1[text()='Stuck Opportunities']")
  public WebElement verifyStuckOpty;
  
  /************************TC19**********************/
  @FindBy(css = "select[id='quarter_q']")
  public WebElement intervalDropDwn;
  
  @FindBy(css = "select[id='open']")
  public WebElement includeDropDwn;
  
  @FindBy(css = "input[value='Run Report']")
  public WebElement runReportBtn;
  
  @FindBy(xpath = "//div[@class='content']//h1[starts-with(text(),'Opportunity')]")
  public WebElement verifyReport;
  
  /***********************TC15*********************/
  public boolean verifyOpty(WebDriver driver)
  {
	  boolean isPageDisplayed=false;
	  if(CommonUtils.waitForElement(driver, optyTab))
	  {
		  optyTab.click();
		 if( CommonUtils.waitForElementToDisplay(driver, optyPage))
		 {
			 isPageDisplayed=true;
		 }
	  }
	  return isPageDisplayed;
  }
  
  public boolean verifyList(WebDriver driver,String key) throws IOException
  {
	  boolean isVerified=false;
	  
	  isVerified=CommonUtils.verifyList(driver,viewOpty,key);
	  return isVerified;
	  
  }
  
  /**************************Create New Opty TC16***********************/
  public boolean CreateNewOptyPage(WebDriver driver,String sOptyName,String sStage,String sProbability,String sLeadSrc)
  {
	  boolean isCreated=false;
	  newBtn.click();
	  if(CommonUtils.waitForElementToDisplay(driver, optyName))
	  {
		  optyName.sendKeys(sOptyName);
		  //searchBtn.click();
		  searchBtn.sendKeys(Keys.ENTER);
		  String Parent=driver.getWindowHandle();
		  CommonUtils.switchWindow(driver);
		  if(CommonUtils.waitForElementToDisplay(driver, iframe))
		  {
			  driver.switchTo().frame(iframe);
			  if(table.isDisplayed() && row.isDisplayed())
			  {
				  row.click();
				  System.out.println("Account name has been selected");
			  }
			  else
			  {
				  System.out.println("Could not found the mentioned row");
				  driver.close();
				  driver.switchTo().window(Parent);
			  }
			  driver.switchTo().window(Parent);
			  Actions action=new Actions(driver);
			  action.moveToElement(closeDate).click().build().perform();
			  currDate.sendKeys(Keys.ENTER);
			  CommonUtils.VerifySelectByVisibleText(driver, stage, sStage);
			  probability.clear();
			  probability.sendKeys(sProbability);
			  CommonUtils.VerifySelectByVisibleText(driver, leadSource, sLeadSrc);
			  pCampSrc.click();
			  
			  CommonUtils.switchWindow(driver);
			  driver.switchTo().frame(iframe);
			  if(campaignTable.isDisplayed())
			  {
				  campaignTable.click();
				  System.out.println("campaign source link has been selected");
			  }
			  else
			  {
				  System.out.println("No record found");
				  driver.close();
				  driver.switchTo().window(Parent);
			  }
			  driver.switchTo().window(Parent);
			  saveButton.click();
			  if(pageDesc.getText().contains(sOptyName))
				{
					System.out.println("Opportunity has been created and saved");
					isCreated=true;
				}
		  }
	  }
	  return isCreated;
			  
  }
  
  public boolean deleteOpportunity(WebDriver driver)
  {
	  boolean isdeleted=false;
	  if(CommonUtils.waitForElement(driver, deleteOptyBtn))
	  {
		  deleteOptyBtn.click();
		  driver.switchTo().alert().accept();
		  if(CommonUtils.waitForElementToDisplay(driver, optyPage))
		  {
			  isdeleted=true;
			  System.out.println("created opportunity has been deleted.");
		  }
		  else
		  {
			  System.out.println("opportunity could not be deleted");
		  }
	  }
	  return isdeleted;
  }
  
  /******************************Opty pipeline reportTC17************************/
  public boolean openPipelineLink(WebDriver driver)
  {
	  boolean isClicked=false;
	  if(CommonUtils.waitForElement(driver, pipelineLink))
	  {
		  pipelineLink.click();
		  System.out.println("Opportunity pipeline link clicked");
		  isClicked=true;
	  }
	  return isClicked;
  }
  
  public boolean verifyOptyPipelineDisplayed(WebDriver driver)
  {
	  boolean isDisplayed=false;
	  if(CommonUtils.waitForElementToDisplay(driver, pipelinedOpty))
	  {
		  System.out.println("Report page with the Pipelined opportunities are displayed");
		  isDisplayed=true;
		}
		else
		{
			System.out.println("Unable to locate web element");
		}
	  return isDisplayed;
  }
  
  /*****************************TC18******************************/
  
  public boolean openStuckOpty(WebDriver driver)
  {
	  boolean isClicked=false;
	  if(CommonUtils.waitForElement(driver, stuckPipelineOpty))
	  {
		  stuckPipelineOpty.click();
		  System.out.println("clicked on stuck pipeline opportunity link");
		  isClicked=true;
	  }
	  else
	  {
		  System.out.println("Unable to locate web element");
	  }
	  return isClicked;
  }
  
  public boolean verifyStuckOptyReport(WebDriver driver)
  {
	  boolean isDisplayed=false;
	  if(CommonUtils.waitForElementToDisplay(driver, verifyStuckOpty))
	  {
		  isDisplayed=true;
		  System.out.println("Report page with the Stuck opportunities are displayed");
		}
		else
		{
			System.out.println("Unable to locate web element");
		}
	  return isDisplayed;
  }
  
  /************************Quarterly summary report TC19********************/
  
  public void quarterlySummaryReport_TC19(WebDriver driver,String sIntervalValue,String sIncludeText)
  {
	  if(CommonUtils.waitForElementToDisplay(driver, intervalDropDwn))
	  {
		  CommonUtils.selectByValue(driver, intervalDropDwn, sIntervalValue);
		  CommonUtils.VerifySelectByVisibleText(driver, includeDropDwn, sIncludeText);
		  runReportBtn.click();
		  System.out.println("Run report button clicked");
	  }
  }
  public boolean verifyQSummaryRptPage(WebDriver driver)
  {
	  boolean isDisplayed=false;
	  if(CommonUtils.waitForElementToDisplay(driver, verifyReport))
	  {
		  isDisplayed=true;
		  System.out.println("Quarterly Summary Report page is displayed.");
	  }
	  return isDisplayed;
  }
}
