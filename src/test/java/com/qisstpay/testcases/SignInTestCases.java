package com.qisstpay.testcases;

import com.qisstpay.listeners.TestListener;
import com.qisstpay.pageobjects.HomePage;
import com.qisstpay.pageobjects.LoginPage;
import com.qisstpay.setup.TestBase;
import com.qisstpay.utalities.DataUtalities;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class SignInTestCases extends TestBase {

    HomePage homepage;
    LoginPage loginObj;

    public SignInTestCases(){
        super();
    }

    @BeforeTest
    public void setUp() {

        homepage = new HomePage();
        loginObj= new LoginPage();
    }

  @Test(priority = 1, dataProviderClass = DataUtalities.class, dataProvider = "adminCredentials")
  @Description("Test Description : User will hit the url and then user will land on the signin page")
  @Feature("SignIn Test")
  @Story("As a merchant I can Signin to the merchant portal")
  public void clickOnShopButton(String data){
        String [] adminInfo=data.split( ",");
        loginObj.enterEmail(adminInfo[0]);
        loginObj.enterPassword(adminInfo[1]);
        loginObj.clickSigninButton();

  }

    @Test(priority = 2)
    @Description("Test Description : User will hit the Shop link and then user will click on the default sorting drop down")
    @Feature("Select Shops")
    @Story("As a user I need to click on the default sorting so that I can sort item by the given criteria ")
    public void sortItemsByIndexing(){
        homepage.sortItems();
    }



}
