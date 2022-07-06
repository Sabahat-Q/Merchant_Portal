package com.qisstpay.setup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.qisstpay.utalities.WaitUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestBase {
    public static WebDriver driver;
    public static Properties prop;


    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qisstpay/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @BeforeTest
    public void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chrome/chromedriver");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability("applicationCacheEnabled", false);
            driver = new ChromeDriver(cap);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(WaitUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WaitUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    public static WebDriver getDriver() {

        return driver;
    }
//    @AfterTest
//    public void tearDown(){
//        driver.close();
//    }


}

