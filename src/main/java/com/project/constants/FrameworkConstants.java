package com.project.constants;

public class FrameworkConstants {
    private static final String REPORT_PATH=System.getProperty("user.dir")+"/report/index.html";

    public static String getReportPath(){
        return REPORT_PATH;
    }
}
