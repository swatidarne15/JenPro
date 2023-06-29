package com.EmployeManagementService.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EmployeManagementService.base.BaseClass;

public class AdminPage extends BaseClass {

	@FindBy (xpath="//span[normalize-space()='Configuration']")
	private WebElement config;
	
	
	@FindBy (xpath="//a[normalize-space()='Email Configuration']")
	private WebElement emailconfig;
	
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/input")
	private WebElement emailconfiguration;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement save;
	
	public AdminPage() {
	PageFactory.initElements(driver,this);
	}
	
	public void configurationDrop() throws InterruptedException {
		config.click();
		Thread.sleep(2000);
		emailconfig.click();
		
	
	}
	public void emailConfiguration(String email) throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].value ='';", emailconfiguration);
		emailconfiguration.clear();
		Thread.sleep(2000);
		emailconfiguration.sendKeys(email);
		save.click();
	
	}

}
