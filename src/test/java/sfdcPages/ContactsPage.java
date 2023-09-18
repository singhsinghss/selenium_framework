package sfdcPages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;

import io.netty.handler.timeout.TimeoutException;
import sfdcUtils.CommonUtils;

public class ContactsPage {
  
  public ContactsPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  /*******************Create New Contact TC25***********************/
  @FindBy(css = "#Contact_Tab")
  public WebElement contactTab;
  
  @FindBy(className = "pageType")
  public WebElement contactPage;
  
  @FindBy(xpath = "//td[@class='pbHelp']//preceding::td[@class='pbButton']//input[@name='new']")
  public WebElement newBtn;
  
  @FindBy (css = "input[id='name_lastcon2']")
  public WebElement lastNameInput;
  
  @FindBy(css = "a[id='con4_lkwgt']")
  public WebElement AccNameSearch;
  
  @FindBy(css = "frame[id='resultsFrame']")
  public WebElement iframe;
  
  @FindBy (css = "table[class=list]")
  public WebElement table;
  
  @FindBy(xpath = "//table[@class='list']//child::tr[@class='dataRow even first']//a")
  public WebElement row;
  
  @FindBy(xpath = "//td[@id='topButtonRow']/input[@name='save']")
  public WebElement saveContactBtn;
  
  @FindBy(className = "topName")
  public WebElement savedContactPage;
  
  @FindBy(xpath = "//*[@id='topButtonRow']//input[@value='Delete']")
  public WebElement deleteNewContactBtn;
  
  /***************************CreateNewView_TC26********************/
  @FindBy(linkText = "Create New View")
  public WebElement newViewLink;
  
  @FindBy(css = "input[id='fname']")
  public WebElement viewName;
  
  @FindBy(css = "input[id='devname']")
  public WebElement uniqueViewName;
  
  @FindBy(xpath = "//div[@class='pbHeader']//input[@class='btn primary']")
  public WebElement saveViewBtn;
  
  @FindBy(css = "select[class='title']")
  public WebElement viewPageTitle;
  
  @FindBy(xpath = "//*[@class='filterLinks']//a[text()='Delete']")
  public WebElement deleteViewBtn;
  
  /*************************selectRecentContacts_TC27********************/
  @FindBy(id = "hotlist_mode")
  public WebElement recentDropDwn;
  
  /******************MyContactView_TC28**********************/
  @FindBy(css = "select[id='fcf']")
  public WebElement contactDropDwn;
  
  @FindBy(xpath = "//input[@title='Go!']")
  public WebElement goButton;
  
  @FindBy(className = "x-grid3-viewport")
  public WebElement myContactViewRpt;
  /***********************ViewContactName_TC29********************/
  @FindBy(xpath = "//div[@class='mruItem']/a[@class='contactMru']")
  public WebElement recentContactLink;
  
  /******************VerifyCreateNewViewError_TC30******************/
  @FindBy (xpath = "//input[@id='fname']//following::div[@class='errorMsg']")
  public WebElement errorMsglbl;
  
  /*********************CancelNewContact_TC31*****************/
  @FindBy(xpath = "//div[@class='pbHeader']//td[@class='pbButtonb']//input[@name='cancel']")
  public WebElement cancelButton;
  
  /*******************clickSaveAndNewContact_TC32******************/
  @FindBy(css = "input[id='con4']")
  public WebElement AccNameInput;
  
  @FindBy(xpath = "//div[@id='ep']//td[@id='topButtonRow']//input[@value='Save & New']")
  public WebElement saveAndNewBtn;
  
  @FindBy(className = "mainTitle")
  public WebElement contactEditPage;
  public boolean openContactsTab(WebDriver driver)
  {
	  boolean isOpened=false;
	  if(CommonUtils.waitForElement(driver, contactTab))
	  {
		  contactTab.click();
		  isOpened=true;
	  }
	  return isOpened;
  }
  public boolean verifyContactPageOpened(WebDriver driver)
  {
	  boolean isPageDisplayed=false;
	  if(CommonUtils.waitForElementToDisplay(driver, contactPage))
	  {
		  isPageDisplayed=true;
		  System.out.println("Contact home page is opened");
	  }
	  return isPageDisplayed;
  }
  public void CreateNewContacts_TC25(WebDriver driver,String sLastName)
  {
	  //boolean isCreated=false;
	  if(CommonUtils.waitForElement(driver, newBtn))
	  {
		  newBtn.click();
		  if(CommonUtils.waitForElementToDisplay(driver, lastNameInput))
		  {
			  lastNameInput.sendKeys(sLastName);
			  AccNameSearch.click();
			  String Parent=driver.getWindowHandle();
			  CommonUtils.switchWindow(driver);
			  if(CommonUtils.waitForElementToDisplay(driver, iframe))
			  {
				  //CommonUtils.switchWindow(driver);
				  driver.switchTo().frame(iframe);
				  if(table.isDisplayed())
				  {
					  row.click();
					  driver.switchTo().window(Parent);
					  if(CommonUtils.waitForElement(driver, saveContactBtn))
					  saveContactBtn.click();
					 
				  }
			  }
		  }
	  }
	
  }
  
  public boolean verifyNewContact(WebDriver driver,String sLastName)
  {
	  boolean isSaved=false;
	  if(savedContactPage.isDisplayed())
	  {
		  String actual=savedContactPage.getText();
		  if(sLastName.equals(actual))
		  {
			  isSaved=true;
			  System.out.println("new contact has been saved.");
		  }
		  
	  }
	  return isSaved;
	  
	  
	  
  }
  public boolean DeleteCreatedContact(WebDriver driver)
  {
	  boolean isDeleted=false;
	  if(CommonUtils.waitForElement(driver, deleteNewContactBtn))
	  {
		  deleteNewContactBtn.click();
		  if(CommonUtils.waitForAlertToAppear(driver))
		  {
			  driver.switchTo().alert().accept();
		  }
		  if(contactPage.isDisplayed())
			  isDeleted=true;
		 		  
	  }
	  return isDeleted;
  }
  /**********************create New View TC26*******************/
  public boolean CreateNewView_TC26(WebDriver driver,String sViewName,String sUniqueViewName)
  {
	  boolean isCreated=false;
	  if(newViewLink.isDisplayed())
	  {
		  newViewLink.click();
		  if(CommonUtils.waitForElementToDisplay(driver, viewName))
		  {
			  viewName.sendKeys(sViewName);
			  uniqueViewName.sendKeys(sUniqueViewName);
			  saveViewBtn.click();
			  if(CommonUtils.waitForElementToDisplay(driver, viewPageTitle))
			  {
				  isCreated=true;
				  System.out.println("New View has been created");
			  }
		  }
	  }
	  return isCreated;
  }
  public boolean deleteView(WebDriver driver)
  {
	  boolean isDeleted=false;
	  if(deleteViewBtn.isDisplayed())
	  {
		  deleteViewBtn.click();
		  if(CommonUtils.waitForAlertToAppear(driver))
		  {
			  driver.switchTo().alert().accept();
			  isDeleted=true;
			  System.out.println("view has been deleted");
		  }
	  }
	  return isDeleted;
  }
  
  /********************recently created contact TC27*******************/
  
  public boolean recentlyCreatedContact_TC27(WebDriver driver,String sText)
  {
	  boolean isDisplayed=false;
	  if(CommonUtils.waitForElementToDisplay(driver, recentDropDwn))
	  {
		  isDisplayed=CommonUtils.VerifySelectByVisibleText(driver, recentDropDwn, sText);
		  System.out.println("Recently added contact was displayed");
	  }
	  return isDisplayed;
  }
  
  /**********************My Contact View TC28***************/
  
  public boolean myContactView_TC28(WebDriver driver,String sText)
  {
	  
	  boolean isSelected=false;
	  try
	  {
	  if(CommonUtils.waitForElementToDisplay(driver, contactDropDwn))
	  {
		  CommonUtils.selectByValue(driver, contactDropDwn, sText);
		  
		  if(!CommonUtils.waitForElementToDisplay(driver, goButton))
		  {
			  System.out.println("go button not displayed");			  
			 
		  }
		  else
		  {
			  if(goButton.isDisplayed())
			  {	  
				  goButton.click();
			  }
		  }
		  if(CommonUtils.waitForElementToDisplay(driver, myContactViewRpt))
		  {
			  isSelected=true;
			  System.out.println("My contacvt view is displayed");
			  
		  }
		  
	  }
	  }
	  catch(Exception e)
	  {
		  System.out.println("Element not found exception: "+e.getMessage());
	  }
	 
	  return isSelected;
  }
  
  /**********************View Contact Name TC29******************/
  public boolean viewContactName_TC29(WebDriver driver)
  {
	  boolean isDisplayed=false;
	  if(CommonUtils.waitForElement(driver, recentContactLink))
	  {
		  recentContactLink.click();
		  if(savedContactPage.isDisplayed())
		  {
			  isDisplayed=true;
			  System.out.println("recent contact page is displayed");
		  }
	  }
	  return isDisplayed;
  }
  
  /*********************createNewViewError TC30********************/
  public boolean createNewViewError_TC30(WebDriver driver,String sUniqueViewName,String sErrorMsg)
  {
	  boolean isErrorDisplayed=false;
	  if(newViewLink.isDisplayed())
	  {
		  newViewLink.click();
		  if(uniqueViewName.isDisplayed())
		  {
			  uniqueViewName.sendKeys(sUniqueViewName);
			  saveViewBtn.click();
			  if(errorMsglbl.isDisplayed())
			  {
				  if(errorMsglbl.getText().equals(sErrorMsg))
				  {
					  System.out.println("Error message is displayed as expectd.");
					  isErrorDisplayed=true;
				  }
			  }
		  }
	  }
	  return isErrorDisplayed;
  }
  /********************Cancel New Contact TC31*******************/
  public boolean CancelNewContact_TC31(WebDriver driver,String sViewName,String sUViewName)
  {
	  boolean isCancelled=false;
	  if(newViewLink.isDisplayed())
	  {
		  newViewLink.click();
		  if(CommonUtils.waitForElementToDisplay(driver, viewName))
		  {
			  viewName.sendKeys(sViewName);
			  uniqueViewName.sendKeys(sUViewName);
			  cancelButton.click();
			  if(contactPage.isDisplayed())
			  {
				  System.out.println("New view creation has been canceled");
				  isCancelled=true;
			  }
		  }
	  }
	  return isCancelled;
  }
  /******************SaveNewContact TC32***************/
  public boolean SaveNewContact_TC32(WebDriver driver,String sNewLastName,String snewAccName)
  {
	  boolean isSaved=false;
	  if(CommonUtils.waitForElement(driver, newBtn))
	  {
		  newBtn.click();
		  if(lastNameInput.isDisplayed())
		  {
			  lastNameInput.sendKeys(sNewLastName);
			  AccNameInput.sendKeys(snewAccName);
			  saveAndNewBtn.click();
			  if(contactEditPage.isDisplayed())
			  {
				  isSaved=true;
				  System.out.println("New Contact has been created and Edit contact page is displayed");
			  }
		  }
	  }
	  return isSaved;
  }
}
