package com.accelacrm.test.framework.selenium;

import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.framework.utils.AppDetails;
import com.accelacrm.test.framework.utils.FileUpload;
import com.accelacrm.test.pages.citizen.login.LoginPage;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Map;

public class TestBaseClass {
    public DefaultWebDriver defaultWebDriver;
    protected PropertiesLoader propertiesLoader;
    protected static AppDetails appDetails;
    public Map<String, String> classLevelData;
    public Map<String, String> methodLevelData;
   public FileUpload document;
   LoginPage loginPage;
    

    @BeforeSuite
    public void setupTest(ITestContext iTestContext)
    {
    	System.out.println("INSIDE BEFORE SUITE");
        killBrowser();
        appDetails = new AppDetails();
        document = new FileUpload();
    }
	 
    
    @BeforeMethod
    public void setupBeforeMethod(Method method, ITestContext iTestContext)
    {
    	propertiesLoader = new PropertiesLoader();
    	classLevelData = propertiesLoader.loadClassLevelData(method.getDeclaringClass());
    	methodLevelData = propertiesLoader.loadMethodLevelData(method, iTestContext);
    	BrowserSetup browserSetup = new BrowserSetup();
        defaultWebDriver = browserSetup.getWebDriver(appDetails.getBrowserName());
        defaultWebDriver.openURL(appDetails.getAppUrl());
        loginSetup();
    }

    @AfterMethod
    public void tearDownAfterMethod(ITestContext iTestContext)
    {
    	System.out.println("INSIDE After Method");
    	defaultWebDriver.quitDriver();
    	killBrowser();
    }
    public void loginSetup()
    {
        LoginPage loginPage = new LoginPage(defaultWebDriver);
        loginPage.login(appDetails.getLoginUserName(), appDetails.getLoginUserPassword());
        
    }

    public void killBrowser() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            File batScriptFile = new File("./scripts/killBrowsers.bat");
            Process process = Runtime.getRuntime().exec("cmd.exe /c " + batScriptFile);
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine())!= null) {
                stringBuffer.append(line + "\n");
            }
        } catch (Exception ex) {
            throw new FrameworkException("Failed to execute bat script file");
        }
    }
    
    public void loginGovDept(String deptName)
    {
        defaultWebDriver.openURL(appDetails.getAppUrl(deptName));
        LoginPage loginPage = new LoginPage(defaultWebDriver);
        loginPage.logInApplication(appDetails.getLoginUserName("GOVADMIN"), appDetails.getLoginUserPassword("GOVADMIN"));
    

    }
   
}
