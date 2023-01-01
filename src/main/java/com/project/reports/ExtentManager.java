package com.project.reports;

import com.aventstack.extentreports.ExtentTest;

public  final class ExtentManager {
    private ExtentManager(){}
    private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
    static ExtentTest getExtentTest(){
        return extentTest.get();
    }
    static void setExtentTest(ExtentTest methodName){
        extentTest.set(methodName);
    }
    public static void setAuthor(String author){
        getExtentTest().assignAuthor(author);
    }
    public static void setCategory(String caategory){
        getExtentTest().assignCategory(caategory);
    }
}
