package com.zerobank.pages;


import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Cihan Aslan
 * @project Zerobank_Project
 */

public class LoginPage {
    @FindBy(id = "user_login")
    public WebElement username;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='user_remember_me']")
    public WebElement rememberMe;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement signInBtn;

    public WebElement forgotPassWord = Driver.get().findElement(By.linkText("Forgot your password ?"));

    @FindBy(css = "div.alert-error")
    public WebElement errorMessage;

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void login(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        signInBtn.click();
    }

}
