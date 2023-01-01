package com.project.config;

import com.project.annotation.CustomAnnotation;
import com.project.pages.HomePage;
import com.project.pages.Loginpage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class HomeTests extends BaseTest{
    @DataProvider
    public Object[][] dataHomePage() throws IOException {
            File file=new File(System.getProperty("user.dir")+"/src/test/resources/testdata/Testdata.xlsx");
            FileInputStream fis=new FileInputStream(file);
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fis);
            XSSFSheet xssfSheet=xssfWorkbook.getSheet("Sheet1");
            int rowNumber=xssfSheet.getLastRowNum();
            int cellNumber=xssfSheet.getRow(0).getLastCellNum();
            Object[][] a=new Object[rowNumber][cellNumber];
            for(int i=1;i<=rowNumber;i++){
                for(int j=0;j<cellNumber;j++){
                    a[i-1][j]=xssfSheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
            return a;
    }
    @CustomAnnotation(author = "madhu",category = "sanity")
    @Test(dataProvider ="dataHomePage")
    public void homePageTitle(String userName,String password,String title){
        Loginpage loginpage=new Loginpage();
        loginpage.loginToApplication(userName,password);
        HomePage homePage=new HomePage();
        String actualTitle=homePage.Title();
        Assert.assertEquals(actualTitle,title,"Title is not matching");
    }
}
