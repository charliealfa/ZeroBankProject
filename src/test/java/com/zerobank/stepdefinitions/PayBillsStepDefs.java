package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
  @author Cihan Aslan
  @project Zerobank_Project
*/

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("pay with the infos")
    public void pay_with_the_infos() {
        BrowserUtils.waitForVisibility(payBillsPage.amountInput,5);
        payBillsPage.amountInput.sendKeys("10234");
        payBillsPage.dateInput.sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        payBillsPage.descriptionInput.sendKeys("Test Payment");
        payBillsPage.payButton.click();
    }


    @Then("pay without amount")
    public void pay_without_amount() {
        BrowserUtils.waitForVisibility(payBillsPage.amountInput,5);
        payBillsPage.dateInput.sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        payBillsPage.descriptionInput.sendKeys("Test Payment");
        payBillsPage.payButton.click();
    }


    @Then("pay without date")
    public void pay_without_date() {
        BrowserUtils.waitForVisibility(payBillsPage.amountInput,5);
        payBillsPage.amountInput.sendKeys("10234");
        payBillsPage.descriptionInput.sendKeys("Test Payment");
        payBillsPage.payButton.click();
    }

    @Then("verify alert message {string}")
    public void verify_alert_message(String message) {
        BrowserUtils.waitForVisibility(payBillsPage.alertMessage,5);
        Assert.assertEquals(message,payBillsPage.alertMessage.getText());
    }


    @Then("verify popup message for amount{string}")
    public void verify_popup_message_for_amount(String message) {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertEquals(message,payBillsPage.amountInput.getAttribute("validationMessage"));
    }


    @Then("verify popup message for date {string}")
    public void verify_popup_message_for_date (String message) {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertEquals(message,payBillsPage.dateInput.getAttribute("validationMessage"));
    }


    @Then("pay with alphabetic chars at amount")
    public void pay_with_alphabetic_chars_at_amount() {
        BrowserUtils.waitForVisibility(payBillsPage.amountInput,5);
        payBillsPage.amountInput.sendKeys("asdaferfe");
        payBillsPage.dateInput.sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        payBillsPage.descriptionInput.sendKeys("Test Payment");
        payBillsPage.payButton.click();
    }


    @Then("pay with alphabetic chars at date")
    public void pay_with_alphabetic_chars_at_date() {
        BrowserUtils.waitForVisibility(payBillsPage.amountInput,5);
        payBillsPage.amountInput.sendKeys("12344");
        payBillsPage.dateInput.sendKeys("ghjjkjk");
        payBillsPage.descriptionInput.sendKeys("Test Payment");
        Assert.assertFalse(payBillsPage.dateInput.getText().equals("ghjjkjk"));
    }


    @Then("verify payment not accept")
    public void verify_payment_not_accept() {
        Assert.assertFalse(payBillsPage.alertMessage.isDisplayed());
    }

}
