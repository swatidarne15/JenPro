package com.EmployeManagementService.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.EmployeManagementService.base.BaseClass;

import Utility.Log4j;

public class DashboardPage extends BaseClass {

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
	private WebElement admintab ;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")
	private WebElement pimtab ;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span")
	private WebElement leavetab ;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")
	private WebElement myinfotab;
	
	public DashboardPage() {
		PageFactory.initElements(driver,this);
	}
	
	public AdminPage  admintab() throws InterruptedException, IOException {
		Thread.sleep(3000);
		admintab.click();
		Thread.sleep(3000);
		String title=driver.getCurrentUrl();
		Assert.assertEquals(title, "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
		Log4j.loggerr().info("admin tab validated successfully");
		return new AdminPage();
	}
	public void pimtab() throws InterruptedException, IOException {
		Thread.sleep(2000);
		pimtab.click();
		Thread.sleep(2000);
		String title=driver.getCurrentUrl();
		Assert.assertEquals(title, "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
		Log4j.loggerr().info("pim tab validated successfully");
	}

	
}
