package com.framework;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listeners implements ITestListener {
	ExtentReports extent = null;
	ExtentTest test = null;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getInstance().toString());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.toString());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.toString());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.toString());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		extent = new ExtentReports();
		ExtentHtmlReporter ehr = new ExtentHtmlReporter(new File("test-output/testreport.html"));
		extent.attachReporter(ehr);

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
