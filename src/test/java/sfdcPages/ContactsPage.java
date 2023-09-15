package sfdcPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
  
  public ContactsPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  /*******************Create New Contact TC25***********************/
  @FindBy(css = "#Contact_Tab")
  public WebElement contactTab;
  
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
  
  @FindBy(xpath = "//table[@class='list']//child::tr[@class='dataRow even last']//a")
  public WebElement row;
  
  @FindBy(xpath = "//td[@id='topButtonRow']/input[@name='save']")
  public WebElement saveContactBtn;
  
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
  
  /*************************selectRecentContacts_TC27********************/
  @FindBy(id = "hotlist_mode")
  public WebElement recentDropDwn;
  
  /******************MyContactView_TC28**********************/
  @FindBy(css = "select[id='fcf']")
  public WebElement contactDropDwn;
  
  @FindBy(xpath = "//input[@title='Go!']")
  public WebElement goButton;
  
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
}
