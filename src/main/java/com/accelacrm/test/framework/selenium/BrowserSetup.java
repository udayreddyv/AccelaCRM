package com.accelacrm.test.framework.selenium;


import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

public class BrowserSetup {

    private static final String BROWSERNAME_CHROME = "chrome";

    public DefaultWebDriver getWebDriver(String browserName) {
        WebDriver driver = null;
        DefaultWebDriver defaultWebDriver = null;

        if (browserName.equals(BROWSERNAME_CHROME)) {
            driver = getChromeDriver();
            driver.manage().window().maximize();
        }
        defaultWebDriver = new DefaultWebDriver(driver);
        return defaultWebDriver;
    }

    public WebDriver getChromeDriver() {
        try {
            URL jarUrl = ClassLoader.getSystemClassLoader().getResource(".");
            String jarPath = URLDecoder.decode(jarUrl.getPath(), "UTF-8");
            String driverName = "chromedriver.exe";
            File file = new File(jarPath + BasePage.browserLocation + driverName);
            System.setProperty("webdriver.chrome.driver", file.getPath());
        }
        catch (Exception ex)
        {
            throw new FrameworkException(ex.toString());
        }
        WebDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }
}
