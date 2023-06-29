package com.EmployeManagementService.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.EmployeManagementService.base.BaseClass;
import com.EmployeManagementService.pages.AdminPage;
import com.EmployeManagementService.pages.DashboardPage;

import Utility.Parametarization;

public class DashboardPageTest extends BaseClass {
	
	DashboardPage dp;
	@Parameters({"browser"})
	@BeforeMethod
	public void BeforeMethod(String browser) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		initialisation(browser);
		dp=LoadLoginPage().Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(groups = {"b"})
	public void validateAdminTab() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
		dp.admintab();
	}
	@Test(groups = {"b"})
	public void validatePimTab() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException {
		
		dp.pimtab();
	}
}