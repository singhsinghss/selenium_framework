package sfdcPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdcUtils.CommonUtils;

public class LeadsPage {
  
  public LeadsPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  /************************OPen Lead page TC20**********************/
  @FindBy (css = "#Lead_Tab")
  public WebElement leadsTab;
  
  @FindBy (xpath = "//div[@class='content']//h1[text()='Leads']")
  public WebElement leadHomePage;
  
  /*********************leads view list TC21***********************/
  @FindBy (css = "select[id='fcf']")
  public WebElement leadsViewdropDwn;
  
  /**********************TC22*********************/
  @FindBy (xpath = "//div[@id='userNav-menuItems']//child::a[@title='Logout']")
  public WebElement logout;
  
  @FindBy (xpath = "//span[@class='fBody']//input[@class='btn' and @name='go']")
  public WebElement goBtn;
  
  @FindBy (id = "00BHu00000GsSjC_listSelect")
  public WebElement viewDropDwn;
  
  /***************TC23************************/
  @FindBy(id = "00BHu00000GsSjQ_listSelect")
  public WebElement todaysLeadDropDwn;
  
  /********************TC24*************************/
  @FindBy(xpath = "//select[@id='hotlist_mode']//preceding::td[@class='pbButton']//input[@name='new']")
  public WebElement newBtn;
  
  @FindBy (css = "input[id='name_lastlea2']")
  public WebElement lastName;
  
  @FindBy(css = "input[id='lea3']")
  public WebElement companyName;
  
  @FindBy (xpath = "//td[@id='topButtonRow']//input[@name='save']")
  public WebElement saveBtn;
  
  @FindBy(xpath = "//div[@class='textBlock']/h2")
  public WebElement newLeadPage;
  
  @FindBy(xpath = "//td[@id='topButtonRow']//input[@value='Delete']")
  public WebElement deleteButton;
  
  public boolean openLeadPage(WebDriver driver)
  {
	boolean isDisplayed=false;
	if(CommonUtils.waitForElement(driver, leadsTab))
	{
		leadsTab.click();
		if(CommonUtils.waitForElementToDisplay(driver, leadHomePage))
		{
			isDisplayed=true;
			System.out.println("lead home page is displayed");
		}
	}
	return isDisplayed;
  }
  
  /********************verify leadview list TC21
 * @throws IOException *******************/
  public boolean verifyLeadsViewList_TC21(WebDriver driver,String sKey) throws IOException
  {
	  boolean isListVerified=false;
	  if(CommonUtils.waitForElementToDisplay(driver, leadsViewdropDwn))
	  {		  
		  isListVerified=CommonUtils.verifyList(driver, leadsViewdropDwn, sKey);
		  
	  }
	  return isListVerified;
  }
  
  /**********************************Default View TC22*************************/
  public boolean DefaultView_TC22(WebDriver driver,String sText)
  {
	  boolean isDisplayed=false;
	  if(CommonUtils.waitForElementToDisplay(driver, leadsViewdropDwn))
	  {
		  CommonUtils.selectByValue(driver, leadsViewdropDwn, sText);
		  UserMenu ump=new UserMenu(driver);
		  
		  ump.logout(driver);
		  ump.verifyLogout(driver);
		  isDisplayed=true;
	  }
	  return isDisplayed;
  }
  public boolean verifyDefaultView(WebDriver driver,String sDefault) throws IOException
  {
	  boolean isVerify=false;
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  openLeadPage(driver);
	  if(CommonUtils.waitForElementToDisplay(driver, leadsViewdropDwn))
	  {
		  isVerify=CommonUtils.verifyDropDownDefault(driver,leadsViewdropDwn,sDefault);	
		  if(isVerify)
		  {
			  goBtn.click();
		  }
	  }
	  return isVerify;
  }
  
  public boolean checkDefaultSelectedView(WebDriver driver,String sDefault)
  {
	  boolean isDefaultSelected=false;
	  if(CommonUtils.waitForElementToDisplay(driver, viewDropDwn))
	  {
		 isDefaultSelected= CommonUtils.verifyDropDownDefault(driver,viewDropDwn,sDefault);
		 
		 //isDefaultSelected=true;
	  }
	  return isDefaultSelected;
  }
  
  /****************************Today's Lead page TC23*************************/
  public boolean selectTodaysLeadPage_TC23(WebDriver driver,String sText)
  {
	  boolean isSelected=false;
	  if(CommonUtils.waitForElementToDisplay(driver, leadsViewdropDwn))
	  {
		  CommonUtils.selectByValue(driver, leadsViewdropDwn, sText);
		  isSelected=true;
			/*
			 * if(goBtn.isDisplayed()) { goBtn.click(); } else {
			 */
			  //System.out.println("could not find Go button.Page already redirected.");
		  //}
	  }
	  return isSelected;
  }
  public boolean verifyTodaysLeadPage(WebDriver driver,String sDefault)
  {
	  boolean isVerify=false;
	  if(CommonUtils.waitForElementToDisplay(driver, todaysLeadDropDwn))
	  {
		  isVerify=CommonUtils.verifyDropDownDefault(driver, todaysLeadDropDwn, sDefault);
	  }
	  return isVerify;
  }
  
  /*************************TC24******************/
  public void createNewLead_TC24(WebDriver driver,String sLastName,String sCompanyName)
  {
	 // boolean isCreated=false;
	  if(CommonUtils.waitForElement(driver, newBtn))
	  {
		  newBtn.click();
		  lastName.clear();
		  lastName.sendKeys(sLastName);
		  companyName.clear();
		  companyName.sendKeys(sCompanyName);
		  saveBtn.click();
		  System.out.println("New lead has been created");
	  }
  }
  public boolean verifyCreatedLead(WebDriver driver)
  {
	  boolean isVerify=false;
	  if(CommonUtils.waitForElementToDisplay(driver, newLeadPage))
	  {
		  isVerify=true;
		  System.out.println("created lead page has been displayed");
	  }
	  return isVerify;
  }
  public void deleteIfExits(WebDriver driver)
  {
	  if(CommonUtils.waitForElement(driver, deleteButton))
	  {
		  deleteButton.click();
		  driver.switchTo().alert().accept();
		  if(leadHomePage.isDisplayed())
		  {
			  System.out.println("New created lead has been deleted.");
		  }
	  }
  }
}
