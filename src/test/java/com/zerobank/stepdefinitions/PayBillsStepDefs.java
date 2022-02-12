package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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


    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new AccountActivityPage().clickTab("Add New Payee");
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> userTable) {
        new PayBillsPage().fillTheInfos(userTable);
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        BrowserUtils.waitForVisibility(payBillsPage.actualMessage,5);
        Assert.assertEquals(expectedMessage,payBillsPage.actualMessage.getText());
    }


    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currincies) {
        BrowserUtils.waitForClickablility(new PayBillsPage().currencyDropDown,5);
        payBillsPage.compareCurrencies(currincies);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.calWithCurr("123456");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() throws InterruptedException {
        Thread.sleep(500);
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Please, ensure that you have filled all the required fields with valid values."));
        alert.accept();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.calWithCurr("");
    }

}
