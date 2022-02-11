package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
