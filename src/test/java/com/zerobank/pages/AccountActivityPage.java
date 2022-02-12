package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cihan Aslan
 * @project Zerobank_Project
 */

public class AccountActivityPage {

    @FindBy(id = "aa_accountId")
    public WebElement accountDropDown;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> actualColumns;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[2]")
    public WebElement aaTab;

    @FindBy(xpath = "//div[@id='tabs']//a")
    public List<WebElement> subTabs;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = ".btn-primary")
    public WebElement findButton;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tr/td[1]")
    public List<WebElement> dateColumns;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tr/td[2]")
    public List<WebElement> descriptionColumns;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tr/td[3]")
    public List<WebElement> depositColumns;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tr/td[4]")
    public List<WebElement> withdrawalColumns;

    @FindBy(css = "#aa_description")
    public WebElement description;

    @FindBy(css = "#aa_type")
    public WebElement typeDropDown;

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public String getSelectedOption() {
        Select selectOptions = new Select(accountDropDown);
        return selectOptions.getFirstSelectedOption().getText();
    }

    public List<String> actualOptions(){
        Select selectOptions = new Select(accountDropDown);
        List<WebElement> actualWE = selectOptions.getOptions();

        List<String> actualOptions=new ArrayList<>();

        for (WebElement we:actualWE){
            actualOptions.add(we.getText());
        }
        return actualOptions;
    }

    public void clickTab(String tab){
        for (WebElement we:subTabs) {
            if(we.getText().equalsIgnoreCase(tab)){
                we.click();
                return;
            }
        }
    }

    public void typeDate(String date1, String date2){
        fromDate.clear();
        toDate.clear();
        fromDate.sendKeys(date1);
        toDate.sendKeys(date2);
    }

    public void checkDates(String fromDate, String toDate){

        int tempFromDate = Integer.parseInt(fromDate.replace("-",""));
        int tempToDate = Integer.parseInt(toDate.replace("-",""));
        int temp;

        for (WebElement we: dateColumns) {
            temp = Integer.parseInt(we.getText().replace("-",""));
            Assert.assertTrue(tempToDate>=temp||tempFromDate<=temp);
        }
    }

    public void compareDateRecentSort(){

        int tempFirst = Integer.parseInt(dateColumns.get(0).getText().replace("-",""));
        int temp;
        for (WebElement date : dateColumns) {
            temp = Integer.parseInt(date.getText().replace("-",""));

            Assert.assertTrue(tempFirst>=temp);
            tempFirst=temp;
        }
    }

    public Boolean checkTextForExpected(String expected) {
        Boolean flag = false;

        for (WebElement we : descriptionColumns) {
            if(we.getText().contains(expected)){
                flag = true;
            }else{
                flag = false;
            }
        }
        return flag;
    }

    public Boolean verifyData(String columnName) {
        Boolean flag = false;
        if(columnName.equals("Deposit")){
            for (WebElement we : depositColumns) {
                if(!we.getText().isBlank()){
                    flag=true;
                    break;
                }
            }
        }else if(columnName.equals("Withdrawal")){
            for (WebElement we : withdrawalColumns) {
                if(!we.getText().isBlank()){
                    flag=true;
                    break;
                }
            }
        }
        return flag;
    }

    public void selectTypeOption(String type) {
        Select selectedOption = new Select(typeDropDown);

        selectedOption.selectByValue(type.toUpperCase());
    }

    public Boolean verifyNoData(String columnName) {
        Boolean flag = false;
        if(columnName.equals("Deposit")){
            for (WebElement we : withdrawalColumns) {
                if(we.getText().isBlank()){
                    flag=true;
                    break;
                }
            }
        }else if(columnName.equals("Withdrawal")){
            for (WebElement we : depositColumns) {
                if(we.getText().isBlank()){
                    flag=true;
                    break;
                }
            }
        }
        return flag;


    }
}
