package com.TestMyBank.testCases;


import com.TestMyBank.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() {

        logger.info("URL is opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Username is entered");


        lp.setPassword(password);
        logger.info("Password is entered");

        lp.clickSubmit();
        logger.info("Clicked on button");


        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Logged In Pass");
        } else {
            Assert.assertTrue(false);
            logger.info("Logged In Fail");
        }

    }

    @Test(dataProvider = "loginData", dataProviderClass = BaseClass.class)
    public void loginTestdd(String username, String password) {
        System.out.println("Username: " + username + ", Password: " + password);
        logger.info("Username and Password is printed ");

    }


}



