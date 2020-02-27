package com.accelacrm.test.pages.citizens;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;
import com.accelacrm.test.pages.citizen.login.LoginPage;

public class CitizensHomePage extends BasePage {

	public CitizensHomePage(DefaultWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final Logger log = LogManager.getLogger(CitizensHomePage.class);
	private static final By userLogInImg = By.xpath("//li[@class='dropdown']/descendant::img[@class='navbar-img']");
	private static final By phoneNumber = By.cssSelector("input#phone");
	private static final By saveChanges = By.xpath("//span[text()='Save changes']");
	private static final By closeButton = By.xpath("//button[text()='Close']");
	private static final By statusMessage = By.cssSelector("p.alert");
	private static final By managentAccountButton = By.xpath("//a[text()='Manage account']");
	private static final By logOutButton = By.xpath("//a[text()='Logout']");
	private static final By d = By.xpath("");
	
	
	public String goToModifyUserAccount() {
		String phoneNum = "98"+RandomStringUtils.randomNumeric(8);
		String actualStatus;
		log.info("Start Method for - goToManageAccount");
		try {
			driver.clickOnElement(userLogInImg);
			driver.clickOnElement(managentAccountButton);
			driver.wait(WAIT_SMALL);
			driver.clearTextBox(phoneNumber);
			driver.wait(WAIT_SMALL);
			driver.typeText(phoneNumber, phoneNum);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(saveChanges);
			String actualStatusOriginal = driver.getTextFromElement(statusMessage);
			String actualStatusTrimming = (String) actualStatusOriginal.subSequence(0, 29);
			actualStatus = actualStatusTrimming.trim();
			driver.clickOnElement(closeButton);
			
		} catch (Exception e) {
			log.error("Failed to go ModifyUserAccount");
			throw new FrameworkException(e.toString());
		}
		log.info("End Method for - goToManageAccount");
		return actualStatus;
	}
	
	public void goToLogOutCitizenPage() {
		
		log.info("Start Method for - goToLogOutCitizenPage");
		try {
			driver.clickOnElement(userLogInImg);
			driver.clickOnElement(logOutButton);
					
		} catch (Exception e) {
			log.error("Failed to go ModifyUserAccount");
			throw new FrameworkException(e.toString());
		}
		log.info("End Method for - goToManageAccount");
	
	}
	public void logInToGOVAdminModule()
	{
		log.info("Start Method for - logInToGOVAdminModule");
		driver.navigateToUrl("https://gov-stage.publicstuff.com/dashboard");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logInApplication("admin_neverland@publicstuff.com", "s7EWUbuphATamaH4");
		log.info("End Method for - logInToGOVAdminModule");
		
	}
	
	public void goToPreviusURL() {
		log.info("Start Method for - goToPreviusURL");
		driver.navigateToBack();
		log.info("End Method for - goToPreviusURL");
		
	}
}
