package com.qisstpay.testcases;

import com.qisstpay.listeners.TestListener;
import com.qisstpay.pageobjects.SignUpPage;
import com.qisstpay.setup.TestBase;
import com.qisstpay.pageobjects.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class SignupTestCases extends TestBase {

    HomePage homepage;
    SignUpPage signupObj;

    public SignupTestCases(){
        super();
    }

    @BeforeTest
    public void setUp() {
        homepage = new HomePage();
        signupObj= new SignUpPage();
    }

      @Test(priority = 1)
      @Description("Test Description : User will hit the url and then user will click on the signup button")
      @Feature("Signup")
      @Story("As a user I can signup on the merchant portal")
      public void SignUp(){
            signupObj.clickSignupButton();
      }

    @Test(priority = 2)
    @Description("Test Description : User will enter Name, email, and user will select country and then will enter phone number")
    @Feature("Signup")
    @Story("As a user I need to signup on merchant portal")
    public void enterMerchantDetails(){
        signupObj.enterName();
        signupObj.enterEmail();
        signupObj.selectCountryToGetPasscode();
        signupObj.enterUserPhoneNumber();
    }

    @Test(priority = 3)
    @Description("Test Description : User will accept terms and conditions and then merchant will click on the signup button")
    @Feature("Signup")
    @Story("As a user I need to accept terms and conditions and then click on signup button")
    public void clickSignUpButton(){
        signupObj.acceptTerms();
        signupObj.clickSignupButton();
    }


}
