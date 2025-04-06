package com.TestMyBank.testCases;

import com.TestMyBank.pageObjects.DeleteCustomer;
import com.TestMyBank.pageObjects.NewCustomer;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class TC_DeleteCustomer_003 extends BaseClass{

    @Test
    public void deleteCustomer() throws InterruptedException {
        NewCustomer nc = new NewCustomer(driver);
        DeleteCustomer dc = new DeleteCustomer(driver);
        String custId = nc.getCustomerID();
        System.out.println(custId);
        //Thread.sleep(3000);

        dc.clickDeleteCustomer();
        Thread.sleep(3000);
        dc.setInputCustId(custId);
       Thread.sleep(3000);
        dc.deleteId();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(5000);

    }


}
