package com.TestMyBank.utilities;
import com.TestMyBank.testCases.BaseClass;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.TestMyBank.testCases.BaseClass.driver;
import static java.sql.DriverManager.getDriver;

public class TestngReports implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;
    BaseClass b = new BaseClass();


    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Ankita");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        b.captureScreen(result.getName());
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try{
        b.captureScreen(result.getName());
        test.fail("Test failed: " + result.getThrowable());
        } catch (Exception e) {
            test.fail("Failed to attach screenshot: " + e.getMessage());
        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Generates the report
    }

}
