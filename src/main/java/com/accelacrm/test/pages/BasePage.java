package com.accelacrm.test.pages;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;

import java.util.Properties;

public class BasePage {
    protected DefaultWebDriver driver;
    protected String module;
    public static Properties properties;
    public static String environmentDetails_FileName = "environmentDetails.properties";
    public static String environmentDetails_FileLocation = "/config/";
    public static String browserLocation = "/drivers/";
    public static String documentLocation = "/documents/";
    public static final int WAIT_LONG = 15000;
    public static final int WAIT_MEDIUM = 10000;
    public static final int WAIT_SMALL = 5000;
    

    public BasePage(DefaultWebDriver driver) {
        this.driver = driver;
        module = System.getProperty("module");

    }
}
