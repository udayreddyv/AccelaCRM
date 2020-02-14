package com.accelacrm.test.pages.govdepartment;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;

public class DepartmentPage extends BasePage{

	public DepartmentPage(DefaultWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final Logger log = LogManager.getLogger(DepartmentPage.class);
	private static final By departmentNameTextBox = By.xpath("//form[@id='dept-add']//input[@id='dept-name']");
	private static final By saveButton = By.xpath("//form[@id='dept-add']//input[@name='submitBtn']");
	private static final By successText = By.xpath("//div[@class='alert alert-success success-message dept-added hide']");
	
	public String departmentName;
	
	public String goToCreateDepartmentName() {
		departmentName = "Department "+RandomStringUtils.randomAlphabetic(5);
		String actualMessage;
		log.info("Start Method for - goToCreateDepartmentName");
		try {
			driver.typeText(departmentNameTextBox, departmentName);
			driver.clickOnElement(saveButton);
			actualMessage = driver.getTextFromElement(successText);
			
		} catch (Exception ex) {
			log.error("Failed to Create DepartmentName");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for - goToCreateDepartmentName");
		return actualMessage;
	}

}
