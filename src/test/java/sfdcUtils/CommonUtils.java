package sfdcUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constants.FileConstants;
import Constants.WaitConstants;
import sfdcTests.CommonTest;

public class CommonUtils {
  
	public static boolean waitForElement(WebDriver driver,WebElement element)
	{
		boolean isElementClickable=false;
		WebDriverWait wait=new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isElementClickable;
		
	}
	
	public static boolean waitForElementToDisplay(WebDriver driver,WebElement element)
	{
		boolean isElementVisible=false;
		WebDriverWait wait=new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENT);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementVisible=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isElementVisible;
	}
	
	public static boolean waitForElementToDisappear(WebDriver driver,WebElement element)
	{
		boolean isElementDisappear=false;
		WebDriverWait wait=new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
		try
		{
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementDisappear=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isElementDisappear;
	}
	public static String getStringDateTimeStamp()
	{
		String value=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return value;
	}
	public static void moveToElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void CropPhoto(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.clickAndHold(element).moveByOffset(30, 50).release().build().perform();
		
	}
	public static String getScreenshot(WebDriver driver) throws IOException {
		String path=FileConstants.SCREENSHOT_PATH;
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		File dst=new File(path);
		FileUtils.copyFile(src, dst);
		return path;
	}
	public static boolean VerifySelectByVisibleText(WebDriver driver, WebElement viewDrpDwn, String Text) {
		// TODO Auto-generated method stub
		boolean isOptionSelected=false;
		if(waitForElementToDisplay(driver, viewDrpDwn))		
		{
			Select selectByText=new Select(viewDrpDwn);
			selectByText.selectByVisibleText(Text);						   
			String selectedOption=selectByText.getFirstSelectedOption().getText();
			  if(selectedOption.equals(Text))
			  {
				  isOptionSelected=true;
			  }
			 
			System.out.println(Text +" has been selected from dropdown");
		}
		else
		{
			System.out.println("DropDown was not visible");
		}
		 return isOptionSelected;
		
	}
	public static void selectByValue(WebDriver driver, WebElement DropDown, String sValue)
	{
		//boolean isValueSelected=false;
		if(waitForElementToDisplay(driver, DropDown))
		{
			Select selectValue=new Select(DropDown);
			selectValue.selectByValue(sValue);
		}
		else
		{
			System.out.println("DropDown was not displayed");
		}	
			
	}
	public static void selectByIndex(WebDriver driver,WebElement dropDown,int index)
	{
		//boolean isIndexSelected=false;
		if(waitForElementToDisplay(driver, dropDown))
		{
			Select selectIndex=new Select(dropDown);
			selectIndex.selectByIndex(index);
			
		}
		else
		{
			System.out.println("DropDown was not displayed");
		}
	}

	public static boolean verifyList(WebDriver driver, WebElement viewOpty,String key) throws IOException {
		// TODO Auto-generated method stub
		boolean isVerified=true;
		Select select =new Select(viewOpty);
		List<WebElement>list=select.getOptions();
		//String [] toBeVerified=sfdcUtils.FileUtils.readOpportunities(key).split(",");
		String [] toBeVerified=key.split(",");
		try
		{
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				String actual=list.get(i).getText();
				if(toBeVerified[i].equalsIgnoreCase(actual))
				{
					System.out.println("Expected Options "+toBeVerified[i]+ " Actual Options "+actual);
				}
				else
				{
					 //logger.warn("UserMenuPage : verifyUserMenu : failed to match the order of UserMenu options");
					  System.out.println("Expected options "+toBeVerified[i]+ " failed to match actual options");
					  isVerified=false;
				}
			}
		}
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("opportunity list mismatch "+e.getMessage());
			CommonTest.test.warning("indexOutOfBoundsException for "+ key +" " +e.getMessage());
		}
		return isVerified;
	}
	
	public static void switchWindow(WebDriver driver)
	{
		String ParentWin=driver.getWindowHandle();
		Set<String> childWindows=driver.getWindowHandles();
		String [] childWin=childWindows.toArray(new String[childWindows.size()]);
		if(childWin.length>1)
		{
			for(int i=1;i<childWin.length;i++)
			{
			driver.switchTo().window(childWin[i]);
			//System.out.println("Switched to Child Window");
			}
		}
		else
		{
			System.out.println("pop up window not found");
		}
	}

	public static boolean verifyDropDownDefault(WebDriver driver, WebElement leadsViewdropDwn, String sDefault) {
		// TODO Auto-generated method stub
		
		boolean isSelected=false;
		if(CommonUtils.waitForElementToDisplay(driver, leadsViewdropDwn))
		{
			Select selected=new Select(leadsViewdropDwn);
			String actual=selected.getFirstSelectedOption().getText();
			if(sDefault.equals(actual))
			{
				isSelected=true;
			}
		}
		return isSelected;
	}

}
