package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindTransactionsStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {
        accountActivityPage.clickTab(tab);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtils.waitForVisibility(accountActivityPage.fromDate,5);
        accountActivityPage.typeDate(fromDate,toDate);
    }

    @And("clicks search")
    public void clicks_search() {
        BrowserUtils.waitForClickablility(accountActivityPage.findButton,5);
        accountActivityPage.findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to  {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitForVisibility(Driver.get().findElement(By.id("filtered_transactions_for_account")),5);
        accountActivityPage.checkDates(fromDate, toDate);
    }

    @And("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        accountActivityPage.compareDateRecentSort();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        Assert.assertFalse(accountActivityPage.dateColumns.contains(date));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String word) {
        BrowserUtils.waitForVisibility(accountActivityPage.description,5);
        accountActivityPage.description.clear();
        accountActivityPage.description.sendKeys(word);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String word) throws InterruptedException {
        Thread.sleep(500);
        //BrowserUtils.waitForVisibility(Driver.get().findElement(By.cssSelector("#filtered_transactions_for_account")), 5);
        Assert.assertTrue(accountActivityPage.checkTextForExpected(word));
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String word) {
        Assert.assertFalse(accountActivityPage.checkTextForExpected(word));
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String columnName) throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(accountActivityPage.verifyData(columnName));
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        accountActivityPage.selectTypeOption(type);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String columnName) {
        Assert.assertTrue(accountActivityPage.verifyNoData(columnName));
    }


}
