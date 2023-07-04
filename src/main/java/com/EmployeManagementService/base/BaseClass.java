package com.EmployeManagementService.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.EmployeManagementService.pages.LoginPage;
import Utility.Parametarization;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public  BaseClass() {
	
		try {
			prop= new Properties();
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		   prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public  void initialisation() throws EncryptedDocumentException, InvalidFormatException, IOException {
		//if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
		//	chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(chromeOptions);
	//	}
//		else if(browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions firefoxOptions = new FirefoxOptions();
//			firefoxOptions.addArguments("--start-maximized");
//			firefoxOptions.addArguments("--remote-allow-origin=*");
//			driver = new FirefoxDriver();
//		}
//		else if(browser.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver= new EdgeDriver();
//		}
//		else {
//			System.out.println("please select valid browswe");
	//	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Parametarization.getData("sheet1", 0, 1));
		
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	public LoginPage LoadLoginPage() {
		LoginPage lp= new LoginPage();
		return lp;
	}

}
