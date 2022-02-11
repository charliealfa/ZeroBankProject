package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountActivityStepDefs {
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    @Then("verify drop down default {string}")
    public void verify_drop_down_default(String selectedOption) {
        BrowserUtils.waitForPageToLoad(5);

        System.out.println(accountActivityPage.getSelectedOption());
        Assert.assertEquals(selectedOption,accountActivityPage.getSelectedOption());
    }

    @Then("verify drop down options")
    public void verify_drop_down_options(List<String> expectedOptions) {
        BrowserUtils.waitForPageToLoad(5);

        new AccountActivityPage().accountDropDown.click();

        Assert.assertEquals(expectedOptions,accountActivityPage.actualOptions());
    }

    @Then("verify transactions table columns")
    public void verify_transactions_table_columns(List<String> expectedColumns) {
        BrowserUtils.waitForVisibility(Driver.get().findElement(By.id("all_transactions_for_account")),5);

        Assert.assertEquals(expectedColumns,BrowserUtils.getElementsText(accountActivityPage.actualColumns));
    }
}
