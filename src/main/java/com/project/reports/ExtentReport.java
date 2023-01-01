package com.project.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.project.constants.FrameworkConstants;

public final class ExtentReport {
    private static ExtentReports reports;
    private static ExtentTest extentTest;
    private ExtentReport(){

    }
    public static void initReports(){
        reports=new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getReportPath());
        reports.attachReporter(spark);
    }
    public static void teardown(){
        reports.flush();
    }
    public static void setExtentTest(String testcaseNo){
       extentTest=reports.createTest(testcaseNo);
       ExtentManager.setExtentTest(extentTest);
    }
}
