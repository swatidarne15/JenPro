package com.EmployeManagementService.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.EmployeManagementService.base.BaseClass;
import com.EmployeManagementService.pages.AdminPage;

import Utility.Parametarization;

public class AdminPageTest extends BaseClass{
	AdminPage ap;
	@Parameters({"browser"})
	@BeforeMethod
	public void BeforeMethod(String browser) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		initialisation(browser);
		ap= LoadLoginPage().Login(Parametarization.getData("Sheet1", 3, 0), prop.getProperty("password")).admintab();
	}
	
//	@Test
//	public void ConfigurationDropTest() throws InterruptedException{
//	ap.configurationDrop();
//	}
	@Test(groups = {"a"})
	public void emailConfigurationTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		ap.configurationDrop();
		for(int i=6;i<8;i++) {
		ap.emailConfiguration(Parametarization.getData("Sheet1", i, 0));
		Thread.sleep(4000);
	    }
	}
}
