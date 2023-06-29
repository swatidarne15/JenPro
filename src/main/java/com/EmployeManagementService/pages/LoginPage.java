package com.EmployeManagementService.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.EmployeManagementService.base.BaseClass;

import Utility.Log4j;



public class LoginPage extends BaseClass{
	
	@FindBy( name = "username")
	private WebElement username;
	
	@FindBy( xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy( xpath = "//button[@type='submit']")
	private WebElement loginbutton;
	
	@FindBy( xpath = "//img[@alt='company-branding']")
	private WebElement logo;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}

	public DashboardPage Login(String uname , String pass) throws InterruptedException, IOException {
	
		
	    username.sendKeys(uname);
	    password.sendKeys(pass);
		loginbutton.click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Log4j.loggerr().info("Logged in successfully with "+uname+" and "+ pass+" credentials");
		return new DashboardPage();
	}
		
	

	public void Logo() throws InterruptedException, IOException{
		Thread.sleep(3000);
		Assert.assertTrue(logo.isDisplayed());
		Assert.assertEquals(false, false);
		Log4j.loggerr().info("logo is verified successfully");
		
	}
}
