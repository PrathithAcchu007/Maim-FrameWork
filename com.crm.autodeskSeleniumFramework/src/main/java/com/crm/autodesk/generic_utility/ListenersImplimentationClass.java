package com.crm.autodesk.generic_utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * this class is used for Executing the listeners 
 * @author Prathith Acchu
 *
 */
public class ListenersImplimentationClass implements  ITestListener {

	public void onTestStart(ITestResult result) {
		String Name = result.getMethod().getMethodName();
		System.out.println(Name+"=========>Test scripts starts");
	}

	public void onTestSuccess(ITestResult result) {
		String Name = result.getMethod().getMethodName();
		System.out.println(Name+"============>Test scripts execution is successfull");
	}

	public void onTestFailure(ITestResult result) {
		String Name = result.getMethod().getMethodName();
		try {
			String path = new WebdriverUtility().toTakeScreenshot(BaseClass.monitorDriver, Name);
			System.out.println(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String Name = result.getMethod().getMethodName();
		System.out.println(Name+"===>test scripts skipped");
		System.out.println(result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("suit starts ");
	}

	public void onFinish(ITestContext context) {
		System.out.println("suit finished ");
	}





}
