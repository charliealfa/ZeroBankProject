package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * @author Cihan Aslan
 * @project Zerobank_Project
 */

public class LoginStepDef {

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user type {string} {string}")
    public void user_type(String username, String password) {
        BrowserUtils.waitForPageToLoad(5);
        new LoginPage().login(ConfigurationReader.get(username),ConfigurationReader.get(password));
        Driver.get().navigate().to("http://zero.webappsecurity.com/bank/account-summary.html");
                BrowserUtils.waitFor(2);
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        String expectedUrl= "http://zero.webappsecurity.com/bank/account-summary.html";
        String actualUrl= Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Then("verify Account Summary page opened")
    public void verify_Account_Summary_page_opened() {
        BrowserUtils.waitForPageToLoad(5);
        new AccountSummaryPage().accountSumTab.isSelected();
    }

    @When("user type wrong {string} valid {string}")
    public void user_type_wrong_valid(String wrusername, String password) {
        BrowserUtils.waitForPageToLoad(5);
        new LoginPage().login(ConfigurationReader.get(wrusername),ConfigurationReader.get(password));
    }

    @Then("user should not be logged in")
    public void user_should_not_be_logged_in() {
        String expectedUrl = "http://zero.webappsecurity.com/login.html?login_error=true";
        String actualUrl = Driver.get().getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @When("user type valid {string} wrong {string}")
    public void user_type_valid_wrong(String username, String wrpassword) {
        BrowserUtils.waitForPageToLoad(5);
        new LoginPage().login(ConfigurationReader.get(username),ConfigurationReader.get(wrpassword));
    }


    @When("user click login without inputs")
    public void user_click_login_without_inputs() {
        BrowserUtils.waitForPageToLoad(5);
        new LoginPage().login("","");
    }

    @Then("error message displayed")
    public void error_message_displayed() {
        Assert.assertTrue(new LoginPage().errorMessage.isDisplayed());
    }



}
