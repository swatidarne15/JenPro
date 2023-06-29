package com.EmployeManagementService.testcases;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.EmployeManagementService.base.BaseClass;
import com.EmployeManagementService.pages.LoginPage;

import Utility.ExcelDataProvider;


public class LoginPageTest extends BaseClass {
	LoginPage lp;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void BeforeMethod(String browser) throws EncryptedDocumentException, InvalidFormatException, IOException{
		initialisation(browser);
		lp=LoadLoginPage();	
	}
	
	  @Test(groups = {"c"})
	  public void validateLogo() throws InterruptedException, IOException{
	  Thread.sleep(3000); 
	  lp.Logo();
	  }
	  @Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class , groups = {"c"})
	  public void verifyLogin(String userID, String password) throws InterruptedException, IOException  {
			lp.Login(userID, password);
			
	  }
}