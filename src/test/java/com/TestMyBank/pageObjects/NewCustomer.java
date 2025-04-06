package com.TestMyBank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

    WebDriver ldriver;

    public NewCustomer(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }


    @FindBy(xpath = "//*[@href='addcustomerpage.php']")
    WebElement clickNewCustomer;

    @FindBy(name="name")
    WebElement custName;

    @FindBy(xpath="//*[@value='f']")
    WebElement gender;

    @FindBy(name="dob")
    WebElement dateOfBirth;

    @FindBy(name="addr")
    WebElement address;

    @FindBy(name="city")
    WebElement city;

    @FindBy(name="state")
    WebElement state;

    @FindBy(name="pinno")
    WebElement pinCode;

    @FindBy(name="telephoneno")
    WebElement contactNo;

    @FindBy(name="emailid")
    WebElement emailId;

    @FindBy(name="password")
    WebElement pswd;

    @FindBy(name="sub")
    WebElement submitBtn;

    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    WebElement getCustomerID;

    public void clickNewCustomer(){
        clickNewCustomer.click();
    }

    public void setCustName(String customerName){
       custName.sendKeys(customerName);
    }

    public void setGender(){
        gender.click();
    }

    public void setDateOfBirth(String dob){
        dateOfBirth.sendKeys(dob);
    }

    public void setAddress(String add){
        address.sendKeys(add);
    }

    public void setCity(String myCity){
        city.sendKeys(myCity);
    }

    public void setState(String myState){
        state.sendKeys(myState);
    }

    public void setPin(long myPin){
        pinCode.sendKeys(String.valueOf(myPin));
    }
    public void setContactNo(long myContact){
        contactNo.sendKeys(String.valueOf(myContact));
    }
    public void setEmailId(String myEmail){
        emailId.sendKeys(myEmail);
    }
    public void setPassword(String myPswd){
        pswd.sendKeys(myPswd);
    }
    public void clickSubmitBtn(){
        submitBtn.click();
    }

    public String getCustomerID(){
        return getCustomerID.getText();
    }



}
