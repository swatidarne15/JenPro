package Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import net.bytebuddy.utility.RandomString;

public class ExtentReport {

	
	static ExtentReports extent;
	public static ExtentReports getReportObject(){
		String Random = RandomString.make(5);
		DateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy h-m-s");
		Date date= new Date();
		String Name = "ExtentReport -"+dateformat.format(date);
		String path = System.getProperty("user.dir")+"//reports//"+Name+""+""+Random+".html";
		
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		
		reporter.config().setReportName("Employee Management Serice");
		reporter.config().setDocumentTitle("Employee Managaement Execution Report");
		
		extent = new ExtentReports();
	
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Sr Software Engineer", "Arvind");
		return extent;
	}
}	