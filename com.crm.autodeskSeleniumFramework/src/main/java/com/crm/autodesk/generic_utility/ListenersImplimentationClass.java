package com.crm.autodesk.generic_utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class is used for Executing the listeners 
 * @author Prathith Acchu
 *
 */
public class ListenersImplimentationClass implements  ITestListener {

	ExtentTest test;
	ExtentReports report;
	public void onTestStart(ITestResult result) {
		test =report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		String path=null;
		try {
			path = new WebdriverUtility().toTakeScreenshot(BaseClass.monitorDriver, result.getMethod().getMethodName());
			System.out.println(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
		}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		/* Step 1:Extent report configuration*/
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./extentReport"+new JavaUtility().getsystemDateandTimeFormat());
		htmlReporter.config().setReportName("Regression execution report");
		htmlReporter.config().setDocumentTitle("Comcast Automation execution Report");
		htmlReporter.config().setTheme(Theme.DARK);

		/*Step 2: Attach the physical report and do the system configuration*/
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name"," Prathith");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}





}
