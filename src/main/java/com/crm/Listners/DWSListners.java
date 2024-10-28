package com.crm.Listners;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.DWSBaseClass;

public class DWSListners extends DWSBaseClass implements ITestListener
{
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String name =result.getMethod().getMethodName();
		test= report.createTest(name+" OntestStart");
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String name =result.getMethod().getMethodName();
		test.log(Status.PASS, "assertion is Succes");
		test.log(Status.INFO,name+"is Succes..");		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name =result.getMethod().getMethodName();
		WebDriver dr = DWSBaseClass.driver;
		TakesScreenshot ts =(TakesScreenshot)dr;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
		test.log(Status.FAIL, " assertion is failed");
		test.log(Status.INFO,name+" is failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name =result.getMethod().getMethodName();
		test.log(Status.SKIP, " assertion is Skipped");
		test.log(Status.INFO,name+" is Skipped");		
		

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		
		 spark = new ExtentSparkReporter("..\\src\\test\\resources\\ExtentReport\\DWSReport.html");
		spark.config().setDocumentTitle("DWS testing");
		spark.config().setReportName("Kajol");
		spark.config().setTheme(Theme.DARK);
		
		//create new extent report
		 report = new ExtentReports();
		report.setSystemInfo("os", "window-10");
		report.setSystemInfo("browser", "chrome-100"); 
		report.attachReporter(spark);
		

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		

	}
	

}
