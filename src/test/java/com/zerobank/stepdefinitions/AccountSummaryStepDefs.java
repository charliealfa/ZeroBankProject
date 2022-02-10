package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {

    @Then("verify page title {string}")
    public void verify_page_title(String title) {
        String expectedTitle = title;
        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("verify account types")
    public void verify_account_types(List<String> accounts) {
        Assert.assertEquals(BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes),accounts);
    }

    @Then("verify table columns")
    public void verify_table_columns(List<String> columns) {
        Assert.assertEquals(BrowserUtils.getElementsText(new AccountSummaryPage().columnNames),columns);
    }

    @Then("navigate to {string} page")
    public void navigate_to_page(String tab) {
        new AccountSummaryPage().navigateTab(tab);
    }
}
