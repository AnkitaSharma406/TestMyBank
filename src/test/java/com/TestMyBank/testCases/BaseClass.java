package com.TestMyBank.testCases;

import com.TestMyBank.utilities.ReadConfig;
import com.TestMyBank.utilities.XLUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class BaseClass {
    ReadConfig readConfig = new ReadConfig();

    public String baseUrl= readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger = LogManager.getLogger(BaseClass.class);

    @DataProvider(name="loginData")
    public Object[][] getLoginData() {
        String excelPath = "src/test/java/com/TestMyBank/testData/TestDataExcel.xlsx";
        return XLUtils.getExcelData(excelPath, "Data");
    }



    @Parameters("Browser")
    @BeforeSuite
    public void setup(String browser){

        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("No valid Input Browser");
        }
        driver.get(baseUrl);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public void captureScreen(String testName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)"); // Scroll down 500px

        String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+"__"+timestamp+".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);
        try {
            destFile.getParentFile().mkdirs(); // Create folder if it doesn't exist
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
             e.getMessage();
        }
    }


   @AfterSuite
    public void tearDown(){
        driver.quit();
    }


}
