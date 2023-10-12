package sfdcPages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.WaitConstants;
import sfdcUtils.CommonUtils;
import sfdcUtils.FileUtils;


public class UserMenu extends CommonPage{
  
  public UserMenu(WebDriver driver)  {
	  
	  PageFactory.initElements(driver, this);
  }
  
  @FindBy (xpath="//span[@id='userNavLabel']")
  public WebElement Usermenu;
  
  @FindBy (xpath = "//div[@id='userNav-menuItems']/a")
  public List<WebElement> SubMenus;
  
  @FindBy (xpath = "//div[@id='userNav-menuItems']//child::a[1]")
  public WebElement myProfile;
  
  @FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
  public WebElement profilePage;
  
  @FindBy (xpath="//a[@class='contactInfoLaunch editLink']")
  public WebElement EditContactButton;
  
  @FindBy(id="contactInfoContentId")
  public WebElement iFrameAboutTab;
  
  @FindBy (xpath = "//div/h2[@id='contactInfoTitle']")
  public WebElement EditContactPopUpWindow;
  
  @FindBy (id = "aboutTab")
  public WebElement AboutTab;
  
  @FindBy(id = "contactTab")
  public WebElement contactTab;
  
  @FindBy (xpath = "//input[@id='lastName' and @type='text']")
  public WebElement lastName;
  
  @FindBy (xpath = "//div[@class='net-buttons zen-mtl']//following::input[@value='Save All']")
  public WebElement savelAllBtn;
  
  @FindBy (xpath = "//*[@id='tailBreadcrumbNode']")
  public WebElement UserProfilePageName;
  
  //post link
  @FindBy (xpath = "//a[@id='publisherAttachTextPost' and @title='Post']")
  public WebElement postLink;
  
  @FindBy(css = "iframe[class='cke_wysiwyg_frame cke_reset']")
  public WebElement PostLinkIframe;
  
  @FindBy (xpath = "//body[text()='Share an update, @mention someone...']")
  public WebElement PostTextArea;
  
  @FindBy (xpath = "//input[@id='publishersharebutton']")
  public WebElement sharePostButton;
  
  @FindBy (id="cke_304_bottom")
  public WebElement verifyPost;
  
  //File link
  @FindBy (xpath = "//*[@id='publisherAttachContentPost']")
  public WebElement Filelink;
  
  @FindBy(css="#chatterUploadFileAction")
  public WebElement uploadFileFromYourComputer;
  
  @FindBy(xpath = "//input[@id='chatterFile']")
  public WebElement chooseFile;
  
  @FindBy(css = "input[id='publishersharebutton']")
  public WebElement shareFile;
  
  //upload profile photo
  @FindBy(id = "displayBadge")
  public WebElement mouseHoverAddPhoto;
  
  @FindBy (xpath = "//a[@id='uploadLink']")
  public WebElement AddOrUpdateProfilePhoto;
  
  @FindBy (xpath = "//iframe[@id='uploadPhotoContentId']")
  public WebElement uploadPhotoIframe;
  
  @FindBy (id = "j_id0:uploadFileForm:uploadInputFile")
 // @FindBy(xpath = "//input[@id='chatterFile']")
  public WebElement choosePhoto;
  
  @FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;
  
  @FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;
  
//  @FindBy(id = "j_id0:uploadFileForm:uploadBtn")
//  public WebElement uploadPhotoButton;
  
  @FindBy (css = "input[name='j_id0:waitingForm']")
  public WebElement spinnerIcon;
  
  @FindBy (xpath = "/html/body/span/div[1]/div/div/div/div[5]/div[9]")
  public WebElement cropPhoto;
  
  @FindBy (css="input[id='j_id0:uploadFileForm:uploadBtn']")
  public WebElement savePhotoButton;
  
  @FindBy (id="j_id0:j_id7:save")
  public WebElement savePhotoButton2;
  
  @FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;
	
  
  //mysettings
  @FindBy (xpath = "//div[@id='userNav-menuItems']//child::a[2]")
  public WebElement mySetting;
  
  @FindBy(css = "#PersonalSetup_font")
  public WebElement verifyMySetting;
  
  @FindBy (xpath = "//div[@id='PersonalInfo']")
  public WebElement personalLink;
    
  @FindBy (xpath = "//div[@id='PersonalInfo']//child::div[@class='setupLeaf']/following::a[@id='LoginHistory_font']")
  public WebElement loginHistory;
  
  @FindBy (xpath = "//div[@class='pShowMore']//child::a")
  public WebElement downloadLoginHistory;
  
  @FindBy (linkText = "Display & Layout")
  public WebElement displayandLayout;
  
  @FindBy (xpath="//a[@id='CustomizeTabs_font']")
  public WebElement customizeTabs;
  
  @FindBy (xpath = "//*[@id='p4']")
  public WebElement customApp;
  
  //@FindBy (xpath = "//select[@id='duel_select_0']/child::option[@value='report']")
  @FindBy(css="#duel_select_0")
  public WebElement AvailableTab;
  
  @FindBy (xpath = "//*[@id='duel_select_0_right']/img")
  public WebElement addButton;
  
  @FindBy(css="#duel_select_1")
  public WebElement SelectedTab;
  
  @FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
  public WebElement saveTab;

  //@FindBy(id = "tabBar")
  @FindBy(xpath = "//*[@id='tabBar']//a")
  public List<WebElement> tabList;
  
  @FindBy(xpath = "//input[@class='btn primary' and @title='Save']")
  public WebElement saveButton;
  
  //Email link
  @FindBy (xpath = "//div[@id='EmailSetup']/child::a[@class='header setupFolder']")
  public WebElement emailLink;
  
  @FindBy (xpath = "//a[@id='EmailSettings_font']")
  public WebElement emailSettingLink;
  
  @FindBy (id="sender_name")
  public WebElement myEmailName;
  
  @FindBy (id = "sender_email")
  public WebElement emailAddress;
  
  @FindBy (xpath = "//label[text()='Yes']")
  public WebElement yesRadioButton;
  
  @FindBy (xpath = "//input[@value=' Save ' and @class='btn primary']")
  public WebElement saveEmail;
  
  @FindBy(className = "messageText")
  public WebElement emailSaveMessage;
  
  //Calendar and Reminder
  @FindBy (xpath = "//div[@id='CalendarAndReminders']/child::a[@class='header setupFolder']")
  public WebElement CalendarAndReminder;
  
  @FindBy (xpath = "//a[@id='Reminders_font']")
  public WebElement ActivityReminder;
  
  @FindBy (id="testbtn")
  public WebElement openATestReminder;
  
  @FindBy (xpath = "//div[@id='userNav-menuItems']//child::a[3]")
  public WebElement developerConsole;
  
  @FindBy (xpath = "//div[@id='userNav-menuItems']//child::a[@title='Logout']")
  public WebElement logOut;
  
  @FindBy (css="#Login")
  public WebElement loginButton;
  
  /********************************TC06***********************/
  public boolean selectOptionFromUserMenuOptions(WebDriver driver, String sOption) {
		boolean isOptionSelected = false;
		if (Usermenu.isDisplayed()) {
			Usermenu.click();
		}
		WebElement userMenuItem = driver.findElement(By.xpath("//*[text()='" + sOption + "']"));
		if (userMenuItem.isDisplayed()) {
			userMenuItem.click();
			isOptionSelected = true;
		}
		return isOptionSelected;
	}
  
  public boolean verifyUserMenuOptions() throws IOException
  {
	  boolean isOptionsVerified=true;
	  String ExpectedUserMenuItems [] =FileUtils.readUserMenuTestDataFile("UserMenu.items").split(",");
	  
	  for(int i=0;i<ExpectedUserMenuItems.length;i++)
	  {
		  String actualUserMenuItems=SubMenus.get(i).getText();
		  if(ExpectedUserMenuItems[i].equals(actualUserMenuItems))
		  {
			  System.out.println("Expected Options "+ExpectedUserMenuItems[i]+ " Actual Options "+actualUserMenuItems);
		  }
		  else
		  {
			  logger.warn("UserMenuPage : verifyUserMenu : failed to match the order of UserMenu options");
			  System.out.println("Expected options "+ExpectedUserMenuItems[i]+ " failed to match actual options");
			  isOptionsVerified=false;
		  }
		  
	  }
	  
	  return isOptionsVerified;
  }
  
  public boolean selectMyProfile()
  {
	  boolean isMyProfileSelected=false;
	  if(myProfile.isDisplayed())
	  {
		  isMyProfileSelected=true;
		  myProfile.click();
	  }
	  return isMyProfileSelected;
  }
   public boolean isProfilePageVisible()
   {
	 return profilePage.isDisplayed();
   }
   
   public void EditContact(WebDriver driver)
   {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,300)", "");
	   if(CommonUtils.waitForElement(driver, EditContactButton)) {
	   EditContactButton.click();
	   }
	   	   
   }
   public boolean verifyEditContactPopUp(WebDriver driver)
   {
	   boolean isPopUpDisplayed=false;
	   if(CommonUtils.waitForElementToDisplay(driver, iFrameAboutTab))
	   {
		   driver.switchTo().frame(iFrameAboutTab);
		   if(AboutTab.isDisplayed() && contactTab.isDisplayed())
		   {
			   isPopUpDisplayed=true;
		   }
	   }
	   return isPopUpDisplayed;
   }
  
  public boolean verifyLastNameChanged(WebDriver driver,String sLastname)
  {
	  boolean isLastnameVerified=false;
	  AboutTab.click();
	  if(lastName.isDisplayed())
	  {
		  lastName.clear();
		  lastName.sendKeys(sLastname);
		  savelAllBtn.click();
	  }
	  driver.switchTo().defaultContent();
	  if(UserProfilePageName.isDisplayed())
	  {
		  if(UserProfilePageName.getText().contains(sLastname))
		  {
			  System.out.println(sLastname+" has been updated");
			  isLastnameVerified=true;
		  }
	  }
	  return isLastnameVerified;
  }
  
  public boolean VerifyCreatePost(WebDriver driver,String sPost)
  {
	  boolean isPostCreated=false;
	  if(CommonUtils.waitForElementToDisplay(driver, postLink))
	  {
		  postLink.click();
		  driver.switchTo().frame(PostLinkIframe);
		  PostTextArea.sendKeys(sPost);
		  driver.switchTo().parentFrame();
		  if(sharePostButton.isDisplayed())
		  {
			  sharePostButton.click();
			  CommonUtils.waitForElementToDisappear(driver, verifyPost);
			  isPostCreated=true;
		  }
	  }
	  
	  return isPostCreated;
  }
  
  public boolean VerifyFileUpload(WebDriver driver,String sFile) throws InterruptedException
  {
	  boolean isFileUploadSuccess=false;
	  Thread.sleep(3000);
	  if(CommonUtils.waitForElement(driver, Filelink))
	  {		  		  
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  //js.executeScript("window.scrollBy(300,0)", "");
		  js.executeScript("arguments[0].click();", Filelink);
		 // Filelink.click();
		  if(CommonUtils.waitForElement(driver, uploadFileFromYourComputer))
		  {
			  uploadFileFromYourComputer.click();
			  CommonUtils.waitForElement(driver, chooseFile);
			  chooseFile.sendKeys(sFile);
			  CommonUtils.waitForElement(driver, shareFile);
			  shareFile.click();
			  if(CommonUtils.waitForElementToDisappear(driver, cancelUpload))
			  {
				  CommonUtils.waitForElement(driver, verifyFilePostElement);
				  if(verifyFilePostElement.isDisplayed())
					  isFileUploadSuccess=true;
				  
			  }
		  }
	  }
	  
	  return isFileUploadSuccess;
  }
  public void uploadProfilePhoto(WebDriver driver)
  {
	  
	  if(CommonUtils.waitForElement(driver, mouseHoverAddPhoto))
	  {
		CommonUtils.moveToElement(driver, mouseHoverAddPhoto);
		if(AddOrUpdateProfilePhoto.isDisplayed())
		{
			AddOrUpdateProfilePhoto.click();
		}
	  }
	 }
  
  public boolean verifyUploadPhoto(WebDriver driver,String sPhotoPath)
  {
	  boolean isPhotoUploaded=false;
	  //uploadProfilePhoto(driver);
	  driver.switchTo().frame(uploadPhotoIframe);
	  if(CommonUtils.waitForElement(driver, choosePhoto))
	  {
		  choosePhoto.sendKeys(sPhotoPath);
		  savePhotoButton.click();
		  if(CommonUtils.waitForElementToDisappear(driver,spinnerIcon) && CommonUtils.waitForElement(driver,savePhotoButton2) )
		  {
			  CommonUtils.CropPhoto(driver,cropPhoto);
			  savePhotoButton2.click();
			  driver.switchTo().defaultContent();
			  isPhotoUploaded=true;
		  }
	  }
	  return isPhotoUploaded;
  }
  /*******************mySetting_TC07*********************/
  public boolean mySetting(WebDriver driver)
  {
	  boolean isPageDisplayed=false;
	  Usermenu.click();
	  if(CommonUtils.waitForElementToDisplay(driver, mySetting))
	  {
		  mySetting.click();
		  if(CommonUtils.waitForElement(driver,verifyMySetting))
		  {
			  isPageDisplayed=true;
		  }
		  
	  }
	  return isPageDisplayed;
  }
  public void DownloadLoginHistory(WebDriver driver)
  {
	  if(CommonUtils.waitForElement(driver, personalLink))
	  {
		  personalLink.click();
		  if(loginHistory.isDisplayed())
		  {
			  loginHistory.click();
			  CommonUtils.waitForElement(driver, downloadLoginHistory);
			  if(downloadLoginHistory.isDisplayed())
			  {
				  downloadLoginHistory.click();
				  System.out.println("Downloading login history file");
		          logger.info("Downloading login history file");
				  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			  }
		  }
	  }
  }
  
  public boolean verifyLoginHistoryDownloaded(WebDriver driver,String sDownloadedFileDir,String sFileName)
  {
	  boolean isFileDownloaded=false;
	  
	  File dir = new File(sDownloadedFileDir);
	  File[] dirContents = dir.listFiles();

	  for (int i = 0; i < dirContents.length; i++) {
		 String sFile= dirContents[i].getName();
	      if (sFile.contains(sFileName)) {
	          // File has been found, it can now be deleted:
	          dirContents[i].delete();
	          isFileDownloaded =true;
	          System.out.println("login history file has been downloaded");
	          logger.info("login history file has been downloaded");
	      }
	    }
	      return isFileDownloaded;
  }
  
  public boolean DispalyandLayout(WebDriver driver) throws InterruptedException
  {
	  boolean isPageDisplayed=false;
	  Thread.sleep(2000);
	  if(CommonUtils.waitForElement(driver, displayandLayout))
	  {
		  displayandLayout.click();
		  if(customizeTabs.isDisplayed())
		  {
			  customizeTabs.click();
			  isPageDisplayed=true;
		  }
	  }
	  return isPageDisplayed;
  }
  public boolean VerifyCustomeAppSelected(WebDriver driver,String sText)
  {
	  boolean isSelected=CommonUtils.VerifySelectByVisibleText(driver, customApp, sText);
	  return isSelected;
	  	  
  }
  public boolean addTabFromAvailableTab(WebDriver driver,String sText)
  {	 
	 boolean isExist=isTextExistsInDropDown(driver,AvailableTab,sText);
	 if(isExist)
	 {
		 addButton.click();
	 }
	 else
	 {
		System.out.println(sText +" not present in dropdown");
		isExist=false;
	 }
	 return isExist;
  }
  
  public boolean isTextExistsInDropDown(WebDriver driver, WebElement availableTab, String sText) {
	// TODO Auto-generated method stub
	  boolean isExist=false;
	  Select selectTab=new Select(availableTab);
	  List<WebElement>allOptions=selectTab.getOptions();
		 for(int i=0;i<allOptions.size();i++)
		 {
			 if(allOptions.get(i).getText().equals(sText))
			 { 
				 selectTab.selectByVisibleText(sText);
				 isExist=true;
			 }
		 }
		 return isExist;
}

public boolean verifyTabAddedtoSelectedTab(WebDriver driver,String sText)
  {
	  boolean isTabAdded=isTextExistsInDropDown(driver, SelectedTab, sText);
	  if(isTabAdded)
	  {
		  saveTab.click();
	  }
	  return isTabAdded;			  
  }
  
	public boolean VerifyTabBar(WebDriver driver,String sTabname) {
		boolean isTabPresent=false;
		for(int i=0;i<tabList.size();i++)
		{
			if(tabList.get(i).getText().equals(sTabname))
			{
				isTabPresent=true;
			}
		}
		return isTabPresent;
	}
 
	public boolean myEmailSetting(WebDriver driver)
	{
		boolean isEmailSelected=false;
		if(CommonUtils.waitForElement(driver,emailLink))
		{
			emailLink.click();
			if(emailSettingLink.isDisplayed())
			{
				emailSettingLink.click();
				isEmailSelected=true;
			}
		}
		return isEmailSelected;
	}
	
	public boolean isEmailUpdated(WebDriver driver,String emailName,String EmailAdd) {
		boolean isUpdated=false;
		if(myEmailName.isDisplayed() && emailAddress.isDisplayed())
		{
			myEmailName.clear();
			myEmailName.sendKeys(emailName);
			emailAddress.clear();
			emailAddress.sendKeys(EmailAdd);
			yesRadioButton.click();
			saveEmail.click();			
			driver.switchTo().alert().accept();
			isUpdated=true;
		}
		return isUpdated;
	}
	public boolean VerifyEmailUpdated(WebDriver driver,String sMsg)
	{
		boolean isSaved=false;
		if(emailSaveMessage.isDisplayed())
		{
			if(emailSaveMessage.getText().equalsIgnoreCase(sMsg))
				
			{
				isSaved=true;
			}
		}
		return isSaved;
	}
	public boolean CalAndReminder(WebDriver driver)
	{
		boolean isCalenderSelected=false;
		if(CommonUtils.waitForElement(driver, CalendarAndReminder))
		{
			CalendarAndReminder.click();
			if(ActivityReminder.isDisplayed())
			{
				ActivityReminder.click();
				isCalenderSelected=true;
			}
		}
		return isCalenderSelected;
	}
	
	public boolean OpenTestReminder(WebDriver driver) throws InterruptedException
	{
		boolean isReminderWinDisplayed=false;
		if(CommonUtils.waitForElement(driver, openATestReminder))
		{
			openATestReminder.click();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(2000);
			String Parent=driver.getWindowHandle();
			Set<String> windows=driver.getWindowHandles();
			String [] childWindows=windows.toArray(new String[windows.size()]);
			
			if(childWindows.length>1)
			{
				System.out.println("Open Test Reminder window is displayed");
				isReminderWinDisplayed=true;
				
				  for (int i=1;i<childWindows.length;i++) {
				  driver.switchTo().window(childWindows[i]).close(); 
				  //driver.close(); 
				  }
				 
				
			}
			driver.switchTo().window(Parent);
			
		}
		return isReminderWinDisplayed;
	}
	
	/****************Developer console*****************/
	
	public boolean openDeveloperConsole(WebDriver driver)
	{
		boolean isDCPageDisplayed=false;
		if(CommonUtils.waitForElementToDisplay(driver, Usermenu))
		{
			Usermenu.click();
			if(developerConsole.isDisplayed())
			{
				developerConsole.click();
				isDCPageDisplayed=true;
			}
		}
		return isDCPageDisplayed;
	}
	public boolean verifyDCWindowOpened(WebDriver driver)
	{
		boolean isWindowOpen=false;
		String ParentWindow=driver.getWindowHandle();
		Set<String> getAllWindow=driver.getWindowHandles();
		String [] childWindows=getAllWindow.toArray(new String[getAllWindow.size()]);
		if(childWindows.length>1)
		{
			isWindowOpen=true;
			for(int i=1;i<childWindows.length;i++)
			{
				driver.switchTo().window(childWindows[i]).close();
			}
			driver.switchTo().window(ParentWindow);
		}
		return isWindowOpen;
				
	}
	public boolean logout(WebDriver driver)
	{
		boolean isLogOut=false;
		if(CommonUtils.waitForElement(driver, Usermenu))
		{
			Usermenu.click();
			if(logOut.isDisplayed())
			{
				logOut.click();
				isLogOut=true;
			}
		}
		return isLogOut;
	}
	public boolean verifyLogout(WebDriver driver)
	{
		boolean isLogoutSuccessful=false;
		if(CommonUtils.waitForElementToDisplay(driver,loginButton))
		{
			isLogoutSuccessful=true;
			System.out.println("Successfully loggedout");
		}
		return isLogoutSuccessful;
	}
}
