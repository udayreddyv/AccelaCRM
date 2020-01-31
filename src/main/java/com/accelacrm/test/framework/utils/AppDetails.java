package com.accelacrm.test.framework.utils;


import com.accelacrm.test.framework.selenium.PropertiesLoader;
import com.accelacrm.test.pages.BasePage;
import java.util.Properties;

public class AppDetails {
    String moduleName;
    String browserName;
    public Properties properties;

    public AppDetails()
    {
        moduleName = System.getProperty("module");
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        String fileName = BasePage.environmentDetails_FileLocation + BasePage.environmentDetails_FileName;
        properties = propertiesLoader.loadProperties(fileName);
        browserName = System.getProperty("browser.name");
         }

    public String getBrowserName() {
        return browserName;
    }

    public String getAppUrl()
    {
        return properties.getProperty(String.format("login_url_%s", moduleName));
    }

    public String getLoginUserName()
    {
        return properties.getProperty(String.format("login_userName_%s", moduleName));
    }

    public String getLoginUserPassword()
    {
        return properties.getProperty(String.format("login_password_%s", moduleName));
    }
   public String getAppUrl(String moduleDepartment)
    {
        return properties.getProperty(String.format("login_url_%s", moduleDepartment));
    }
   public String getLoginUserName(String moduleDepartment)
    {
        return properties.getProperty(String.format("login_userName_%s", moduleDepartment));
    }

    public String getLoginUserPassword(String moduleDepartment)
    {
        return properties.getProperty(String.format("login_password_%s",moduleDepartment));
    }

	
}
