package com.crm.Listeners;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClas.BaseClassDWS;
import com.crm.JavaUtility.RandomClass;

public class ListenersDWS extends BaseClassDWS implements ITestListener
{

	 ExtentReports report;
	 ExtentSparkReporter spark;
	 ExtentTest test;
	 
		@Override
		public void onTestStart(ITestResult result) 
		{
			String t_name = result.getMethod().getMethodName();
			Reporter.log(t_name+" is executed");
			test = report.createTest(t_name);
		}

		@Override
		public void onTestSuccess(ITestResult result) 
		{
			String t_name = result.getMethod().getMethodName();
			test.log(Status.PASS, t_name+" is executed");
		}

		@Override
		public void onTestFailure(ITestResult result) 
		{
			String t_name = result.getMethod().getMethodName();
			test.log(Status.FAIL,t_name+" is Failure");
			TakesScreenshot ts = (TakesScreenshot)driver;
			String screenshot = ts.getScreenshotAs(OutputType.BASE64);
			test.addScreenCaptureFromBase64String(screenshot);
		}

		@Override
		public void onTestSkipped(ITestResult result) 
		{
			String t_name = result.getMethod().getMethodName();
			test.log(Status.SKIP, t_name+" is skipped");
		}

		@Override
		public void onStart(ITestContext context) 
		{
			//create spark reporter
			try {
				spark = new ExtentSparkReporter("./Reports/failedTestcase"+RandomClass.randomNum()+".html");
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//configure the spark reporter
			spark.config().setDocumentTitle("sampleReport");
			spark.config().setReportName("kajal");
			spark.config().setTheme(Theme.DARK);
			//create the extent report
			report = new ExtentReports();
			//configure extent report
			report.setSystemInfo("Os", "Window-11");
			report.setSystemInfo("Browser", "Chrome-100");
			
			//Attach the spark reporter to the extent report
			report.attachReporter(spark);
			
		}

		@Override
		public void onFinish(ITestContext context) 
		{
			report.flush();
		}
}
