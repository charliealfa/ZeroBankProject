package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
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
}
