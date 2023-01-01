package com.project.listeners;

import com.project.annotation.CustomAnnotation;
import com.project.reports.ExtentLogger;
import com.project.reports.ExtentManager;
import com.project.reports.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListner implements ITestListener{

    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    public void onFinish(ITestContext context) {
        ExtentReport.teardown();
    }
    public void onTestStart(ITestResult result) {
        ExtentReport.setExtentTest(result.getName());
        ExtentLogger.info("Test started"+result.getName());
        ExtentManager.setAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).author());
        ExtentManager.setCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).category());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail("Test is failed : "+result.getName());
        ExtentLogger.fail(result.getThrowable().getMessage());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass("passed :"+result.getName());
    }
}
