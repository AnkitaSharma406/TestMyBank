package com.TestMyBank.testCases;

import com.TestMyBank.pageObjects.DeleteCustomer;
import com.TestMyBank.pageObjects.NewCustomer;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class TC_DeleteCustomer_003 extends BaseClass {

    @Test
    public void deleteCustomer() throws InterruptedException {
        NewCustomer nc = new NewCustomer(driver);
        DeleteCustomer dc = new DeleteCustomer(driver);
        String custId = nc.getCustomerID();
        System.out.println(custId);

        dc.clickDeleteCustomer();
        logger.info("You are on Delete Customer Page");
        dc.setInputCustId(custId);
        Thread.sleep(5000);
        logger.info("Entered the customer id");
        dc.deleteId();
        logger.info("Customer deleted");

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }


}
