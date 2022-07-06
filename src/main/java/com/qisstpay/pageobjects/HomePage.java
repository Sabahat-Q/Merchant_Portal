package com.qisstpay.pageobjects;

import io.qameta.allure.Step;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qisstpay.setup.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage extends TestBase {
    WebDriverWait wait = new WebDriverWait(driver, 60);
    Actions act = new Actions(driver);


    public HomePage() {
        super();
        PageFactory.initElements(driver, this);

    }

    //drop down locator of items sorting on the shop products page
    @FindBy(css = "select.orderby")
    WebElement defaultSortingDropDown;

    //Country drop down selection locator
    @FindBy(css = "div.selected-flag")
    WebElement selectCountry;

    //Select pakistan As A Country locator
    @FindBy(css = "li.country.preferred[data-country-code='pk']")
    WebElement countryPak;

    //Enter phone number input field locator on the 1 click checkout screen
    @FindBy(css = "input.single-input-card2.outline-color-base2.w-100.h-50.text-16")
    WebElement enterPhoneNo;





    /************************* One click checkout Flow ************************************/


    @Step("User will hit the Shop link :{0}, When user will land on the shop page then user will sort the item by low to high price :{1}")
    public void sortItems(){
        Select objSelect = new Select(defaultSortingDropDown);
        objSelect.selectByIndex(5);
    }



    @Step("User will select the country pakistan :{0}, User will enter the phone number :{1}")
    public void selectCountryToGetPasscode(){
        selectCountry.click();
        wait.until(ExpectedConditions.elementToBeClickable(countryPak));
        countryPak.click();

    }

    @Step("User will Enter his/her phone number to get passcode :{0}")
    public String enterUserPhoneNumber(){
        wait.until(ExpectedConditions.elementToBeClickable(enterPhoneNo));
        enterPhoneNo.click();
        enterPhoneNo.sendKeys("03117755668");
        String phoneNo=enterPhoneNo.getText();
        return phoneNo;

    }



}
