package sfdcTests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sfdcPages.LoginPage;
import sfdcUtils.FileUtils;

public class ContactsTest extends CommonTest{
  @BeforeClass
  public void navigateToHome() throws IOException {
	  WebDriver driver=CommonTest.getDriver();
	  LoginPage lp=new LoginPage(driver);
	  lp.LoginToSalesForce(driver);
  }
  
  @Test
  public void CreateNewContact_TC25(Method name)
  {
	  
  }
}
