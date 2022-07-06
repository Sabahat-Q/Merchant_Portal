package com.qisstpay.pageobjects;

import com.qisstpay.setup.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 60);

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);

    }

    //email input field locator on merchant sign in page
    @FindBy(id= "mui-6")
    WebElement emailInput;

    //password input field locator
    @FindBy(id = "outlined-adornment-password")
    WebElement passInput;

    //signin button locator on merchant signin page
    @FindBy(css = "button.MuiButtonBase-root.css-1rpt11a")
    WebElement signinBtn;

    @Step("User will enter email address {0}, ")
    public void enterEmail(String email){
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);

    }

    @Step("User will enter password {1} ")
    public void enterPassword(String password){
        passInput.sendKeys(password);
    }

    @Step("User will click on the signin button ")
    public void clickSigninButton(){
        signinBtn.click();
    }


}
