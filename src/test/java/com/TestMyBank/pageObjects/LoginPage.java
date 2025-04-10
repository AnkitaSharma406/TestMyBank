package com.TestMyBank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name="uid")
    WebElement userName;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="btnLogin")
    WebElement loginBtn;

    public void setUserName(String uname){
        userName.sendKeys(uname);
    }

    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }

    public void clickSubmit(){
        loginBtn.click();

    }
}
