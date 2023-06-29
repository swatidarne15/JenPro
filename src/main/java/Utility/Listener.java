package Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.EmployeManagementService.base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends BaseClass implements ITestListener {
	ExtentTest test;
	ExtentReports extent =ExtentReport.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		//Extent Report 
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	
	}
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
		String testmethodname =result.getMethod().getMethodName();
	//	ScreenShots sc= new ScreenShots();
		try {
		//	sc.screenshot(testmethodname);
			if(testmethodname.contentEquals("verifyLogin"))
			ExcelDataProvider.putData("PASS",2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void onTestFailure(ITestResult result) {
		//Screenshot
		ScreenShots sc= new ScreenShots();
		extentTest.get().fail(result.getThrowable());
		String testmethodname =result.getMethod().getMethodName();
		
		try {
		//	driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			if(testmethodname.contentEquals("verifyLogin"))
			ExcelDataProvider.putData("FAIL",2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(sc.screenshot(testmethodname), result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	public void onTestSkipped(ITestResult result) {
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	public void onStart(ITestContext context) {
	}
}