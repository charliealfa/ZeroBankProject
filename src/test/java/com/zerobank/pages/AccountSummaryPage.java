package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author Cihan Aslan
 * @project Zerobank_Project
 */

public class AccountSummaryPage {

    @FindBy(id="account_summary_tab")
    public WebElement accountSumTab;

    @FindBy(xpath = "//div/h2")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//div[@class='board'])[3]//table//th")
    public List<WebElement> columnNames;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li")
    public List<WebElement> navTabs;

    @FindBy(xpath = "//div[@class='board-content']//td//a")
    public List<WebElement> actualLinks;

    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void navigateTab(String tabName){
         for(WebElement we:navTabs){
            if(we.getText().equals(tabName)){
                we.click();
                return;
            }
        }
    }


    public void clickLink(String linkText){
        for (WebElement we: actualLinks) {
            if(we.getText().equalsIgnoreCase(linkText)){
                we.click();
                return;
            }
        }
    }


}
