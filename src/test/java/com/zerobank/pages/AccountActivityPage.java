package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Cihan Aslan
 * @project Zerobank_Project
 */

public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
