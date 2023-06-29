package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.EmployeManagementService.base.BaseClass;

import net.bytebuddy.utility.RandomString;

public class ScreenShots extends BaseClass{

	public  String screenshot(String testcaseaname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String random= RandomString.make(5);
		String target= System.getProperty("user.dir")+"\\screenshots\\"+testcaseaname+"\\"+random+".png";
		File dest = new File(target);
		FileUtils.copyFile(source, dest);
		return target ;	
	}
}
