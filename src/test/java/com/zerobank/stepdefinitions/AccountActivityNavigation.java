package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigation {

    AccountActivityPage accountActivityPage = new AccountActivityPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForPageToLoad(5);
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        Driver.get().navigate().to("http://zero.webappsecurity.com/bank/account-summary.html");
        BrowserUtils.waitFor(2);
        String expectedUrl= "http://zero.webappsecurity.com/bank/account-summary.html";
        String actualUrl= Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String expectedLink) {
        accountSummaryPage.clickLink(expectedLink);
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertEquals(Driver.get().getTitle(),"Zero - Account Activity");
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedOption) {
        BrowserUtils.waitForPageToLoad(5);

        System.out.println(accountActivityPage.getSelectedOption());
        Assert.assertEquals(expectedOption,accountActivityPage.getSelectedOption());
    }
}
