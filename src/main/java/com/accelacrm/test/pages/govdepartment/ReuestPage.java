package com.accelacrm.test.pages.govdepartment;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;

public class ReuestPage extends BasePage {

	public ReuestPage(DefaultWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final Logger log = LogManager.getLogger(ReuestPage.class);
	private static final By ReuestTypeDropDownButton = By.xpath("//input[@placeholder='Select Request Type']");
	private static final By mapImage = By.xpath("//div[@id='map']//*[@id='OpenLayers_Geometry_Point_185']");
	private static final String reuiedReuestType = "//*[@class='dropdown-section']//descendant::li[text()='%s']";
	private static final By addressRequest = By.xpath("//input[@id='address']");
	private static final By selectAdress = By.xpath("//li[contains(text(),'Berkeley, CA, USA')]");
	private static final By descriptionOfRequest = By.xpath("//*[@id='description']");
	private static final By submitButton = By.id("submit-request");
	private static final By getStatusMessage = By.xpath("//div[@data-attribute='messages']");

	public String goToCreateNewReuest(String reuestTypeText) {
		log.info("Start method for - goToCreateNewReuest");
		String description;
		String actualStatusMessage;
		try {
			description = "Description " + RandomStringUtils.randomAlphabetic(8);
			driver.clickOnElement(ReuestTypeDropDownButton);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(By.xpath(String.format(reuiedReuestType, reuestTypeText)));
			driver.typeText(descriptionOfRequest, description);
			driver.typeText(addressRequest, "Berkeley");
			driver.clickOnElement(selectAdress);
			driver.wait(WAIT_SMALL);
			// driver.switchToFrame();
			// driver.dragAndDropBypixcels(mapImage);
			driver.clickOnElement(submitButton);
			String actualStatusMessageFullTxt = driver.getTextFromElement(getStatusMessage);
			log.info("**************************** : " + actualStatusMessageFullTxt);
			actualStatusMessage = (String) actualStatusMessageFullTxt.subSequence(26, 81);
			log.info("**********After Modify****************** : " + actualStatusMessage);

		} catch (Exception ex) {
			log.error("Failed to create New Reuest Type");
			throw new FrameworkException(ex.toString());	
		}
		log.info("End method for - goToCreateNewReuest");
		return actualStatusMessage;
	}
}
