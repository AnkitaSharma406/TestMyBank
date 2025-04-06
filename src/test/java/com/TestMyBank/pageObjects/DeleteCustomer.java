package com.TestMyBank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {

    WebDriver ldriver;

    public DeleteCustomer(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(xpath = "//*[@href='DeleteCustomerInput.php']")
    WebElement clickDeleteCustomer;

    @FindBy(name = "cusid")
    WebElement inputCustId;

    @FindBy(name="AccSubmit")
    WebElement clickSubmitBtn;



    public void clickDeleteCustomer(){
        clickDeleteCustomer.click();
    }

    public void setInputCustId(String custID){
        inputCustId.sendKeys(custID);
    }

    public void deleteId(){
        clickSubmitBtn.click();
    }



}
