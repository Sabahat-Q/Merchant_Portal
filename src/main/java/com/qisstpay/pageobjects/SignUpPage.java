package com.qisstpay.pageobjects;

import com.qisstpay.setup.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 60);
    Actions act = new Actions(driver);


    public SignUpPage() {
        super();
        PageFactory.initElements(driver, this);

    }

    //signup link locator on merchant sign in page
    @FindBy(css= ".css-rt4i6")
    WebElement signUpBtn;

    //Name input field locator
    @FindBy(css = "#mui-7")
    WebElement nameInput;

    //email input field locator
    @FindBy(css = "#mui-8")
    WebElement emailInput;

    //Country drop down selection locator
    @FindBy(css = ".arrow.down")
    WebElement selectCountry;

    //Select pakistan As A Country locator
    @FindBy(css = "li.country.highlight.preferred > div > div")
    WebElement countryPak;

    //Enter phone number input field locator on the 1 click checkout screen
    @FindBy(css = "outlined-basic")
    WebElement enterPhoneNo;

    //accept terms and conditions checkbox
    @FindBy(css = ".css-1m9pwf3")
    WebElement acceptTerms;

    //signup button locator
    @FindBy(css = "button.css-fhz6t4")
    WebElement signupBtn;


    @Step("User will click on the signup button : {0}")
    public void clickSignupButton(){

        wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
    }

    @Step("User will enter his/her name : {0}")
    public void enterName(){
        wait.until(ExpectedConditions.elementToBeClickable(nameInput)).sendKeys("Muhammad Sabahat");

    }

    @Step("User will enter the email : {0}")
    public void enterEmail(){
        emailInput.sendKeys("sabahatch786@gmail.com");

    }

    @Step("User will select the country pakistan :{0}, User will enter the phone number :{1}")
    public void selectCountryToGetPasscode(){
        selectCountry.click();
        wait.until(ExpectedConditions.elementToBeClickable(countryPak));
        countryPak.click();

    }

    @Step("User will Enter his/her phone number to get passcode :{0}")
    public void enterUserPhoneNumber(){

        enterPhoneNo.click();
        enterPhoneNo.sendKeys("03117755668");

    }

    @Step("Merchant will accept terms and conditions {0}")
    public void acceptTerms(){
        acceptTerms.click();
    }

    @Step("Merchant will click on the Signup button {0}")
    public void clickSignUp(){
        signUpBtn.click();
    }


}
