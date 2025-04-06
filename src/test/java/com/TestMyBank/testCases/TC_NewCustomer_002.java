package com.TestMyBank.testCases;

import com.TestMyBank.pageObjects.LoginPage;
import com.TestMyBank.pageObjects.NewCustomer;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NewCustomer_002 extends BaseClass{

    @Test
    public void addCustomer() throws InterruptedException {

        logger.info("URL is opened");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Username is entered");

        lp.setPassword(password);
        logger.info("Password is entered");

        lp.clickSubmit();
        logger.info("Clicked on button");



        String name = "John" + RandomStringUtils.randomAlphabetic(3);      // e.g. JohnXyz
        String dob = "07,06,2001";                                         // can keep static or random
        String address = "Street " + RandomStringUtils.randomNumeric(3);  // e.g. Street 123
        String city = "City" + RandomStringUtils.randomAlphabetic(2);     // e.g. CityAb
        String state = "State" + RandomStringUtils.randomAlphabetic(2);   // e.g. StateXY
        long pin = Long.parseLong(RandomStringUtils.randomNumeric(6));    // e.g. 654321
        long contact = Long.parseLong("9" + RandomStringUtils.randomNumeric(9)); // 10-digit number
        String email = "user" + RandomStringUtils.randomAlphanumeric(4) + "@gmail.com"; // e.g. userXyz1@test.com
        String password = "Pass@" + RandomStringUtils.randomAlphanumeric(3);  // e.g. Pass@abc

        NewCustomer nc = new NewCustomer(driver);
        nc.clickNewCustomer();
        nc.setCustName(name);
        nc.setGender(); // If you want to make it dynamic, pass gender and use if-else
        nc.setDateOfBirth(dob); // Update method to accept String instead of long
        nc.setAddress(address);
        Thread.sleep(3000);
        nc.setCity(city);
        nc.setState(state);
        Thread.sleep(3000);
        nc.setPin(pin);
        nc.setContactNo(contact);
        Thread.sleep(3000);
        nc.setEmailId(email);
        nc.setPassword(password);
        nc.clickSubmitBtn();
        Thread.sleep(5000);

        if(driver.getPageSource().contains("Customer Registered Successfully!!!")){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }

    }



}
