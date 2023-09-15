package sfdcPages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sfdcUtils.CommonUtils;
import sfdcUtils.FileUtils;

public class CreateAccountPage extends CommonPage{
 public CreateAccountPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 
 //@FindBy (css = "a[title='Accounts Tab']")
 @FindBy(css = "#Account_Tab")
 public WebElement AccTab;
 
 @FindBy(className = "pageType")
 public WebElement AccountHome;
 
 @FindBy (xpath = "//td[@class='pbButton']/input[@name='new']")
 public WebElement NewAccountButton;
 
 @FindBy (xpath = "//div[@class='content']//child::h2[text()=' New Account']")
 public WebElement NewAccountLabel;
 
 @FindBy (css = "input[id='acc2']")
 public WebElement NewAccountInput;
 
 @FindBy(css = "Select[id='acc6']")
 public WebElement TechPartnerDropDwn;
 
 @FindBy (css = "Select[id='00NHu00000PEX5G']")
 public WebElement CustPriorityDropDwn;
 
 @FindBy (xpath = "//td[@id='topButtonRow']/input[@type='submit' and @name='save']")
 public WebElement saveButton;
 
 @FindBy(className = "topName")
 public WebElement newAccName;
 
 @FindBy (css = "table[class='list']")
 public WebElement tableAccount;
 
  
 @FindBy (xpath = "//td[@id='topButtonRow']//input[@title='Delete']")
 public WebElement deleteAcc;
 
 /****************Create New view*****************/
 @FindBy (xpath = "//div[@class='pbHeader']//input[@name='delID']")
 public WebElement deleteView;
 
 @FindBy(className = "pageDescription")
 public WebElement Acc_Home;
 
 @FindBy (xpath = "//a[text()='Create New View']")
 public WebElement CreateNewView;
 
 @FindBy (xpath = "//input[@id='fname']")
 public WebElement viewName;
 
 @FindBy (xpath = "//input[@id='devname']")
 public WebElement uniqueViewName;
 
 @FindBy (xpath = "//div[@class='pbHeader']//child::input[1]")
 public WebElement saveViewButton;
 
 @FindBy (className = "title")
 public WebElement viewDropDown;
 
 /***************edit view********************/
 @FindBy(xpath = "//a[text()='Accounts']")
 public WebElement Accounts;
 
 @FindBy (css = "select[title='View:']")
 public WebElement editViewDropDown;

 @FindBy (xpath = "//span[@class='fFooter' ]//child::a[1]")
 public WebElement editLink;
 
 @FindBy (className = "pageDescription")
 public WebElement EditViewPage;
 
 @FindBy(css = "input[id='fname']")
 public WebElement newViewName;
 
 @FindBy (css = "select[id='fcol1']")
 public WebElement fieldDropDown;
 
 @FindBy (css = "select[id='fop1']")
 public WebElement operatorDropDwn;
 
 @FindBy (id = "fval1")
 public WebElement valueInput;
 
 @FindBy (xpath = "//div[@class='pbHeader']//child::input[1]")
 public WebElement saveViewChangesButton;
 
 /******************Merge accounts****************************/
 @FindBy (xpath = "//div[@class='toolsContentRight']//div[@class='lbBody']//li[4]//a[text()='Merge Accounts']")
 public WebElement mergeAccLink;
 
 @FindBy (css = "input[id='srch']")
 public WebElement searchInput;
 
 @FindBy (css = "input[name='srchbutton']")
 public WebElement searchButton;
 
 @FindBy (xpath = "//input[@name='srchbutton']//following::div[@class='bRelatedList']")
 public WebElement accTable;
 
 @FindBy (css = "table[class='list'] tbody")
 public WebElement tableBody;
 
 @FindBy (css = "input[id='cid0']")
 public WebElement checkBox1;
 
 @FindBy (css = "input[id='cid1']")
 public WebElement checkBox2;
 
 @FindBy (css = "div[class='pbBottomButtons'] input")
 public WebElement nextButton;
 
 @FindBy (xpath = "//div[@class='pbTopButtons']//child::input[@value=' Merge ' and @name='save']")
 public WebElement mergeButton;
 
 @FindBy(xpath = "//div[@class='pbTopButtons']//input[@title='Cancel']")
 public WebElement cancelButton;
 
 @FindBy (xpath = "//h1[text()='Merge My Accounts']")
 public WebElement verifyMergeAccPage;
 
 /*******************last30 days activity*******************/
 
 @FindBy(xpath = "//div[@class='toolsContentLeft']//li[2]//a[contains(text(),'30 days')]")
 public WebElement last30DaysActivity;
 
 @FindBy (id = "ext-gen148")
 public WebElement dateField;
 
 @FindBy (className  = "pageDescription")
 public WebElement unsavedReportPage;
 
 @FindBy (xpath = "//div[@id='ext-gen265']/div[text()='Created Date']")
 public WebElement selectCreateDate; 
 
 @FindBy (css = "input[id='ext-comp-1042']")
 public WebElement fromDate;
 
 @FindBy (css = "input[id='ext-comp-1045']")
 public WebElement toDate;
 
 @FindBy (css = "button[id='ext-gen49']")
 public WebElement saveRptButton;
 
 @FindBy (xpath = "//*[@id='saveReportDlg']")
 public WebElement SaveReportDialog;
 
 @FindBy(css = "input[id='saveReportDlg_reportNameField']")
 public WebElement reportName;
 
 @FindBy (css = "input[id='saveReportDlg_DeveloperName']")
 public WebElement uniqueRptName;
 
 @FindBy (xpath = "//button[text()='Save']//following::button[text()='Save and Run Report']")
 public WebElement saveAndRunRpt;
 
 @FindBy(className = "x-form-invalid-msg")
 public WebElement errorMsg;
 
 @FindBy(xpath = "//div[@class='progressIndicator']/h2")
 public WebElement reportPageHeader;
 
 @FindBy (css = "#report_Tab")
 public WebElement ReportTab;
 
// @FindBy(name = "delrep")
// public WebElement delRptButton;
 
 @FindBy (xpath  = "//*[@class='nameFieldContainer descrContainer']")
 public WebElement reportNamelink;
 
 @FindBy (xpath = "//div[@id='00OHu00000AySKI_ACTION_COLUMN']//child::img[@title='Action']")
 public WebElement delDropDwn;
 
 @FindBy (xpath = "//*[@class='x-menu-item-text' and text()='Delete']//parent::a")
 public WebElement deleteLink;
 
 @FindBy (xpath = "//button[text()='Cancel']")
 public WebElement CancelRptButton;
 
 @FindBy(xpath = "//*[text()='Report Properties']//preceding::button[text()='Close']")
 public WebElement closeButton;
 
 @FindBy (xpath = "//*[text()='Save & Close']//following::button[text()='Close']")
 public WebElement cancelCloseRptBtn;
 
 public boolean openAccountPage(WebDriver driver,WebElement element)
 {
	 boolean isAccountTabclicked=false;
	 
	 if(CommonUtils.waitForElement(driver, element))
	 {
		 element.click();
		 isAccountTabclicked=true;
	 }
	 return isAccountTabclicked;
 }
 
 public boolean verifyAccPageDisplayed(WebDriver driver) throws IOException {
	 
	 boolean isPageDisplayed=false;	 
	 if(CommonUtils.waitForElementToDisplay(driver, AccountHome))
	 {
		 String ActualText=AccountHome.getText();
		 Assert.assertEquals(FileUtils.readCreateAccount("AccountHome"), ActualText);
		 isPageDisplayed=true;
	 }
	 return isPageDisplayed;
 }
 
 public boolean deleteIfExists(WebDriver driver,String sNewAccName)
 {
	 boolean isExist=false;
	 try
	 {
	 
	 List<WebElement> rowlist=tableAccount.findElements(By.tagName("tr"));
	 List<WebElement>colList;
	 
	 for (WebElement row:rowlist)
	 {
		colList=row.findElements(By.tagName("th"));
		for(WebElement column:colList)
		{
			String ExistingAccName=column.getText();
			if(ExistingAccName.equals(sNewAccName))
			{
				WebElement acc_name=driver.findElement(By.xpath("//th/a[text()='"+ExistingAccName+"']"));
				acc_name.click();
				if(CommonUtils.waitForElement(driver, deleteAcc))
				{
					deleteAcc.click();
					driver.switchTo().alert().accept();
				}
				isExist=true;
				
				//driver.navigate().refresh();
				//rowlist=tableAccount.findElements(By.tagName("tr")
				new WebDriverWait(driver, Duration.ofSeconds(20)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(tableAccount));
				rowlist=tableAccount.findElements(By.tagName("tr"));
				row.findElements(By.tagName("th"));
				
				
			}			
		}//break;
	 }
	 }
	 catch(StaleElementReferenceException e)
	 {
		 System.out.println("Handle stale element exception "+e.getMessage());
	 }
	 return isExist;
 }
 
 public boolean isCreateNewAccDisplayed(WebDriver driver) throws IOException {
	 boolean isPageDisplayed=false;
	 if(CommonUtils.waitForElement(driver, NewAccountButton))
	 {
		 NewAccountButton.click();
		 if(CommonUtils.waitForElementToDisplay(driver, NewAccountLabel))
		 {
			 String ActualText=NewAccountLabel.getText();
			 Assert.assertEquals(FileUtils.readCreateAccount("pagename"), ActualText);
			 isPageDisplayed=true;
		 }
		
	 }
	 return isPageDisplayed;
 }
 
 public boolean enterNewAccDetails(WebDriver driver,String sNewAcc,String sTechPartnerValue,String sCustPriority)
 {
	 boolean isAccCreated=false;
	 if(NewAccountInput.isEnabled())
	 {
		 NewAccountInput.sendKeys(sNewAcc);
		CommonUtils.selectByValue(driver, TechPartnerDropDwn, sTechPartnerValue);
		CommonUtils.VerifySelectByVisibleText(driver, CustPriorityDropDwn, sCustPriority);
		if(saveButton.isDisplayed())
		{
			saveButton.click();
			
			if(CommonUtils.waitForElementToDisplay(driver, newAccName))
			{
				Assert.assertEquals(sNewAcc, newAccName.getText());
				isAccCreated=true;
			}
		}
	 }
	 return isAccCreated;
	 
 }
 
 
 /***************Create New View TC11************************/
 public boolean DeleteDuplicateView(WebDriver driver,String sViewName)
 {
	 //boolean isExists=false;
	 boolean isDeleted=false;
	 try
	 {
	 //isExists=verifyNewView(driver, sViewName);
	 Select select=new Select(editViewDropDown);
	 List<WebElement>viewNames=select.getOptions();
	 for(int i=0;i<viewNames.size();i++)
	 {
		 if(viewNames.get(i).getText().equals(sViewName))
		 {
			 select.selectByVisibleText(sViewName);
			 editLink.click();
			 if(CommonUtils.waitForElement(driver, deleteView))
			 {
				 deleteView.click();
				 driver.switchTo().alert().accept();
				 if(CommonUtils.waitForElementToDisplay(driver, Acc_Home))
				 {
					 isDeleted=true;
				 }
				 driver.navigate().refresh();
				 //select=new Select(driver.findElement(By.cssSelector("select[title='View:']")));
			 }
		 }
		 
	 }
	 }
	 catch(StaleElementReferenceException s)
	 {
		 System.out.println("stale element exception "+s.getMessage());
	 }
	 return isDeleted;
	
 }
 
 public void createNewView(WebDriver driver,String sViewName,String sUniqueViewName)
 {
	 
	 if(CommonUtils.waitForElement(driver, CreateNewView))
	 {
		 CreateNewView.click();
		 if(CommonUtils.waitForElementToDisplay(driver, viewName))
		 {
			 viewName.sendKeys(sViewName);
			 uniqueViewName.sendKeys(sUniqueViewName);
			 saveViewButton.click();
		 }
	 }
 }
 public boolean verifyNewView(WebDriver driver,String sViewName)
 {
	 boolean isViewCreated=false;
	 Select select=new Select(viewDropDown);
	 String ActualText=select.getFirstSelectedOption().getText();
	 Assert.assertEquals(sViewName, ActualText);
	 isViewCreated=true;	 
	 return isViewCreated;
 }
 
 
 /********************Edit View TC12 ***************************/
 public boolean editView(WebDriver driver,String sViewName) throws IOException
 {
	 boolean isViewSelected=false;
	 isViewSelected=CommonUtils.VerifySelectByVisibleText(driver, editViewDropDown, FileUtils.readCreateAccount("viewname"));
	 if(isViewSelected)
	 {
		 if(CommonUtils.waitForElement(driver, editLink))
		 {
			 editLink.click();
			 isViewSelected=true;
		 }
	 }
	 return isViewSelected;
 }
 
 public boolean verifyEditViewPageDisplayed(WebDriver driver)
 {
	 boolean isPageDisplayed=false;
	 if(CommonUtils.waitForElementToDisplay(driver, EditViewPage))
	 {
		 isPageDisplayed=true;		 
	 }
	 return isPageDisplayed;
 }
 
 public void updateViewName(WebDriver driver,String sNewViewName,String sField,String sOperator,String sValue) throws IOException
 {
	if(CommonUtils.waitForElementToDisplay(driver, viewName))
	{
		viewName.clear();
		viewName.sendKeys(sNewViewName);
		if(fieldDropDown.isDisplayed() && operatorDropDwn.isDisplayed() && valueInput.isDisplayed())
		{
			
			CommonUtils.VerifySelectByVisibleText(driver,fieldDropDown,sField );
			CommonUtils.VerifySelectByVisibleText(driver, operatorDropDwn, sOperator);
			valueInput.sendKeys(sValue);
			saveViewChangesButton.click();
		}
		else
		{
			System.out.println("Field, operator and value fields are not displayed");
		}
	}
	
 }
 public boolean verifyViewNameChanged(WebDriver driver,String sNewViewName)
 {
	 boolean isViewNameChanged=false;
	 Select select =new Select(editViewDropDown);
	 if(select.getFirstSelectedOption().getText().equals(sNewViewName))
	 {
		 isViewNameChanged=true;
		 System.out.println("View name has been changed successfully");
	 }
	 return isViewNameChanged;
 }
 
 /******************Merge accounts****************************/
 public boolean mergeAccountPage(WebDriver driver)
 {
	 boolean isMergeAccClicked=false;
	 if(CommonUtils.waitForElement(driver, mergeAccLink))
	 {
		 mergeAccLink.click();
		 if(CommonUtils.waitForElementToDisplay(driver, verifyMergeAccPage))
		 {
			 isMergeAccClicked=true;
		 }
	 }
	 return isMergeAccClicked;
 }
 
 public void SearchAccount(WebDriver driver,String sAccName)
 {
	 if(searchInput.isDisplayed())
	 {
		 searchInput.sendKeys(sAccName);
		 searchButton.click();
	 }
 }
 public boolean verifySearchData(WebDriver driver)
 {
	 boolean isRecordDisplayed=false;
	 if(CommonUtils.waitForElementToDisplay(driver, accTable))
	 {
		 isRecordDisplayed=true;
	 }
	 return isRecordDisplayed;
 }
 
 public boolean mergeDuplicates(WebDriver driver)
 {
	 boolean isMerged=false;
	 if(tableAccount.isDisplayed())
		{
			//WebElement TogetRows = driver.findElement(By.cssSelector("table[class='list'] tbody"));
			java.util.List<WebElement>TotalRowsList = tableBody.findElements(By.tagName("tr"));
			if(TotalRowsList.size()>=3)
			{				
				
				if(!checkBox1.isSelected())
				{
					checkBox1.click();
				}
				if(!checkBox2.isSelected())
				{
					
					checkBox2.click();
				}
				if(nextButton.isEnabled())
				{
					nextButton.click();
				}
				if(CommonUtils.waitForElement(driver, mergeButton))
				{
					mergeButton.click();
				}
				Alert alert=driver.switchTo().alert();
				alert.accept();
				isMerged=true;
				System.out.println("Accounts have been merged");
			}
			else
			{
				System.out.println("No account found for merging or not enough record found to merge.");
				CommonUtils.waitForElement(driver, cancelButton);
				cancelButton.click();
				if(AccTab.isDisplayed())
				{
					AccTab.click();
				}
			}
		}
	 return isMerged;
	 
 }
 public boolean verifyMerge(WebDriver driver)
 {
	 boolean isHomeDisplayed=false;
	 if(CommonUtils.waitForElementToDisplay(driver, Acc_Home))
	 {
		 isHomeDisplayed=true;
	 }
	 return isHomeDisplayed;
 }
 
 
 /*****************************Create Account report TC_14****************************/
 public boolean last30DaysActivity(WebDriver driver)
 {
	 boolean isPagedisplayed=false;
	 CommonUtils.waitForElement(driver, last30DaysActivity);
	 last30DaysActivity.click();
	 CommonUtils.waitForElementToDisplay(driver, unsavedReportPage);
	 if(unsavedReportPage.isDisplayed())
		 {isPagedisplayed=true;}
	 return isPagedisplayed;
 }
 public boolean saveReport(WebDriver driver)
 {
	 boolean isSaved=false;
	 CommonUtils.waitForElementToDisplay(driver, dateField);
	 dateField.click();
	 Actions action=new Actions(driver);
	 if(CommonUtils.waitForElementToDisplay(driver, selectCreateDate))
	 {
		 //action.moveToElement(selectCreateDate).click().build().perform();
		 selectCreateDate.click();
	 }
	 //action.moveToElement(fromDate).click().build().perform();
	 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
	 Date date = new Date();  
	 String FormattedDate=formatter.format(date).toString().substring(0,10);
	 fromDate.sendKeys(FormattedDate);
	 //action.moveToElement(toDate).click().build().perform();
	 toDate.clear();
	 toDate.sendKeys(FormattedDate);
	 saveRptButton.click();
	 CommonUtils.waitForElementToDisplay(driver, SaveReportDialog);
	 if(SaveReportDialog.isDisplayed())
	 {
		 isSaved=true;
	 }
	 return isSaved;
 }
 
 public boolean saveAndRunReport(WebDriver driver,String sReportName,String sUniqueRptName)
 {
	 boolean isRunandSaved=false;
	 CommonUtils.waitForElementToDisplay(driver, reportName);
	 if(reportName.isDisplayed() && uniqueRptName.isDisplayed())
		 {
		 	reportName.sendKeys(sReportName);
		 	uniqueRptName.sendKeys(sUniqueRptName);
		 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 	CommonUtils.waitForElementToDisplay(driver, saveAndRunRpt);
		 	if(saveAndRunRpt.isEnabled())
		 	{
		 		
		 			saveAndRunRpt.sendKeys(Keys.ENTER);
		 			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveAndRunRpt);
		 			saveAndRunRpt.click();
		 	
		 		//if(CommonUtils.waitForElementToDisplay(driver, errorMsg))
		 		if(errorMsg.isDisplayed())
		 		{
		 			System.out.println(sUniqueRptName +" already exists");
		 			CancelRptButton.click();
		 			closeButton.click();
		 			cancelCloseRptBtn.click();
		 			
		 		}
		 		//saveAndRunRpt.click();
		 		else
		 		{
		 			driver.switchTo().activeElement();
				 	CommonUtils.waitForElementToDisplay(driver,reportPageHeader);
				 	if(reportPageHeader.isDisplayed())
				 	{
				 		isRunandSaved=true;
				 		System.out.println("Report has been run and saved");
				 	}
		 		}
		 	}
		 	
		 	else
		 	{
		 		System.out.println("could not save and run report");
		 	}
		 }
	 return isRunandSaved;
 }
 
 public boolean deleteReport(WebDriver driver,String sRptName)
 {
	 boolean isDeleted=false;
	 /*WebElement delRpt=driver.findElement(By.xpath("//*[(text()='"+sRptName+"')]"));
	 if(delRpt.isDisplayed())
	 {
		// delRpt.click();
		 
		 if(CommonUtils.waitForElement(driver, delRptButton))
		 {
			 delRptButton.click();
			 driver.switchTo().alert().accept();
			 isDeleted=true;
		 }
	}*/
	if(CommonUtils.waitForElementToDisplay(driver, ReportTab))
	{
		ReportTab.click();
		if(CommonUtils.waitForElementToDisplay(driver, reportNamelink))
		{
			//Assert.assertEquals(reportNamelink.getText(), sRptName);
			if(reportNamelink.getText().equals(sRptName))
			{
				delDropDwn.click();
				CommonUtils.waitForElement(driver, deleteLink);
				if(deleteLink.isDisplayed())
				{
					deleteLink.click();
				}
			driver.switchTo().alert().accept();
			if(!reportNamelink.getText().equals(sRptName))
			{
				isDeleted=true;
				System.out.println(sRptName+ " has been deleted");
			}
		}
		}
		else
		 {
			 System.out.println(sRptName +"not found");
		 }		
		
	}
	else
	{
		System.out.println("Report tab was not displayed");
	}
	 
	 return isDeleted;
 }
 
}
