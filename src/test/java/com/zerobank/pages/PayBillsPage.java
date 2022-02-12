package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PayBillsPage {

    @FindBy(id = "sp_amount")
    public WebElement amountInput;

    @FindBy(id = "sp_date")
    public WebElement dateInput;

    @FindBy(id = "sp_description")
    public WebElement descriptionInput;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(css = "#alert_content>span")
    public WebElement alertMessage;

    @FindBy(xpath = "//*[contains(@id, 'np_new_payee')]")
    public List<WebElement> inputFields;

    @FindBy(xpath = "//*[contains(@for, 'np_new_payee')]")
    public List<WebElement> labels;

    @FindBy(css = "#add_new_payee")
    public WebElement addButton;

    @FindBy(css = "div#alert_content")
    public WebElement actualMessage;

    @FindBy(css = "#pc_currency")
    public WebElement currencyDropDown;

    @FindBy(css = "#pc_amount")
    public WebElement amountInputCurrency;

    @FindBy(css = "#pc_calculate_costs")
    public WebElement calButton;

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void fillTheInfos(Map<String, String> userTable) {

        BrowserUtils.waitForClickablility(addButton,5);

        for (int i=0; i<labels.size(); i++) {
            inputFields.get(i).sendKeys(userTable.get(labels.get(i).getText()));
        }

        addButton.click();
    }

    public void compareCurrencies(List<String> currincies) {
        Select selectOptions = new Select(currencyDropDown);
        List<WebElement> actualOptions = selectOptions.getOptions();

        Assert.assertTrue(BrowserUtils.getElementsText(actualOptions).containsAll(currincies));
    }

    public void calWithCurr(String amount) {
        BrowserUtils.waitForVisibility(amountInputCurrency,5);
        amountInputCurrency.sendKeys(amount);
        calButton.click();
    }
}
