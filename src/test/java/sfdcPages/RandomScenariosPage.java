package sfdcPages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import sfdcUtils.CommonUtils;

public class RandomScenariosPage extends CommonPage{
  
  public RandomScenariosPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	  PageFactory.initElements(driver, this);
}
  /*****************verify Full nameTC33*********************/
  @FindBy(css = "#home_Tab")
  public WebElement HomeTab;
  
  @FindBy(xpath = "//div[@class='content']//h1[@class='currentStatusUserName']//a")
  public WebElement fullName;
  
  @FindBy(id="publisherAttachTextPost")
  public WebElement myProfilePost;
  /**************************Edit profile TC34*****************/
  @FindBy(xpath = "//div[@class='userBlock']//child::a[@class='userMru']")
  public WebElement userNameLink;
  
  //@FindBy(xpath = "//div[@class='vfButtonBar']//child::a[@class='contactInfoLaunch editLink']")
  @FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
  public WebElement editContact;
  
  @FindBy(id = "contactInfoContentId")
  public WebElement iframe;
  
  @FindBy (css = "#aboutTab")
  public WebElement aboutTab;
  
  @FindBy(xpath = "//input[@id='lastName' and @type='text']")
  public WebElement lastName;
  
  @FindBy (css = "input[value='Save All']")
  public WebElement saveAllBtn;
  
  @FindBy(xpath = "//div[@id='userNavButton']//span[@id='userNavLabel']")
  public WebElement userNamelbl;
  
  /***********************Remove Tab TC35************************/
  @FindBy(id = "AllTab_Tab")
  public WebElement allTabs;
  
  @FindBy(xpath = "//input[@title='Customize My Tabs']")
  public WebElement customizeTab;
  
  @FindBy(css="#duel_select_1")
  public WebElement SelectedTab;
  
  @FindBy(xpath = "//option[@value='ContentSubscriptions']")
  public WebElement subscriptions;
  
  @FindBy(xpath = "//img[@class='leftArrowIcon' and @title='Remove']")
  public WebElement removeBtn;
  
  @FindBy(xpath = "//input[@title='Save']")
  public WebElement saveBtn;
  
  @FindBy(id = "ContentSubscriptions_Tab")
  public WebElement subscriptionTab;
  /********************TC36************************/
  @FindBy(name = "whats_new")
  public WebElement currentDateBtn;
  
  
  
  /************************check last name TC33******************/
  public void openHomeTab_TC33(WebDriver driver)
  {
	 // boolean isOpened=false;
	  if(CommonUtils.waitForElement(driver, HomeTab))
	  {
		  HomeTab.click();
		  System.out.println("clicked on Home Tab");
		// isOpened=true;
	  }
  }
  public boolean verifyHomaPage(WebDriver driver,String sUserFullName)
  {
	  boolean isPageDisplayed=false;
	  if(CommonUtils.waitForElementToDisplay(driver, fullName))
	  {
		  if(fullName.getText().startsWith(sUserFullName))
		  {
			  isPageDisplayed=true;
			  System.out.println("Home page with username was displayed");
		  }
	  }
	  return isPageDisplayed;
  }
  public boolean openMyProfilePage(WebDriver driver)
  {
	  boolean myProfileDisplayed=false;
	  fullName.click();
	  if(CommonUtils.waitForElementToDisplay(driver, myProfilePost))
	  {
		  myProfileDisplayed=true;
		  System.out.println("my profile page is displayed");
	  }
	  return myProfileDisplayed;
  }
  
  /*********************Edit profile TC34
 * @throws InterruptedException ****************/
  public boolean editProfile_TC34(WebDriver driver,String sLastName) throws InterruptedException
  {
	  boolean isEdited=false;
	  if(CommonUtils.waitForElement(driver, userNameLink))
	  {
		  userNameLink.click();
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,400)", "");
			 
		  CommonUtils.waitForElementToDisplay(driver, editContact);
		  if(editContact.isDisplayed())
		  {	
			  //System.out.println("clicking edit contact");	
			  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			  //JavascriptExecutor js = (JavascriptExecutor) driver;
			 // js.executeScript("arguments[0].click();", editContact);
			  Thread.sleep(3000);
			  editContact.click();
			  
			  if(CommonUtils.waitForElementToDisplay(driver,iframe))
			  {
				  if(iframe.isDisplayed())
				  {
				  driver.switchTo().frame(iframe);
				  if(aboutTab.isDisplayed())
				  {
					  aboutTab.click();
					  lastName.clear();
					  lastName.sendKeys(sLastName);
					  saveAllBtn.click();
					  System.out.println("Clicked on save all button and last name has been updated");
					  isEdited=true;
				  }
				  }
			  }
		  }
	  }
	  return isEdited;
  }
  public boolean verifyUpdatedName(WebDriver driver,String sFullName)
  {
	  boolean isUpdated=false;
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(400,0)", "");
		 
	  CommonUtils.waitForElementToDisplay(driver, userNamelbl);
	  
	  if(userNamelbl.isDisplayed())
	  {
		  if(userNamelbl.getText().equals(sFullName))
		  {
			  isUpdated=true;
			  System.out.println("Updated last name is diplayed in usermenu");
		  }
	  }
	  return isUpdated;
  }
  /*****************Remove tab TC35******************/
  public boolean customizeTab_TC35(WebDriver driver)
  {
	  boolean allTabClicked=false;
	  if(CommonUtils.waitForElement(driver, allTabs))
	  {
		 allTabs.click();
		 if(CommonUtils.waitForElement(driver, customizeTab))
		 {
			 customizeTab.click();
			 allTabClicked=true;
			 System.out.println("Clicked on customize Tab button");
		 }
	  }
	  return allTabClicked;
  }
  public boolean removeIfExists(WebDriver driver,String sText)
  {
	  boolean isExist=isTextExistsInDropDown(driver,sText);
		 if(isExist)
		 {
			 //subscriptions.click();
			 removeBtn.click();
			 saveBtn.click();
			 System.out.println(sText+" Tab has been removed");
		 }
		 else
		 {
			System.out.println(sText +" tab is already been removed from tab bar");
			isExist=true;
		 }
		 return isExist;
  }
  public boolean isTextExistsInDropDown(WebDriver driver, String sText) {
		// TODO Auto-generated method stub
		  boolean isExist=false;
		  CommonUtils.waitForElementToDisplay(driver, SelectedTab);
		  Select selectTab=new Select(SelectedTab);
		  List<WebElement>allOptions=selectTab.getOptions();
			 for(int i=0;i<allOptions.size();i++)
			 {
				 if(allOptions.get(i).getText().equals(sText))
				 { 
					 selectTab.selectByVisibleText(sText);
					 System.out.println(sText+ " exists in Selected Tab");
					 isExist=true;
				 }
				 else
				 {
					 System.out.println(sText+" not available in seletcted list for removing");
				 }
			 }
			 return isExist;
	}
  public boolean logoutAndVerifyTab(WebDriver driver) throws IOException
  {
	  boolean isRemoved=false;
	  UserMenu UMP=new UserMenu(driver);
	  UMP.logout(driver);
	  UMP.verifyLogout(driver);
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
	  System.out.println("relogged in succesfully");
	  if(CommonUtils.waitForElementToDisappear(driver, subscriptionTab))
	  {
		  
			  System.out.println("subscription tab was removed successfully");
			  isRemoved=true;
		  
		  
	  }
	  return isRemoved;
  }
}
