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
	private static final By editdepNameTextBox = By.xpath("//form[@id='dept-edit']//input[@id='dept-name']");
	private static final By saveButton = By.xpath("//form[@id='dept-add']//input[@name='submitBtn']");
	private static final By afterModifySaveButton = By.xpath("//a[@id='dept-delete-modal-btn']/preceding-sibling::input");
	private static final By successText = By.xpath("//div[@class='alert alert-success success-message dept-added hide']");
	private static final By afterModifySuccessText = By.xpath("//div[@class='alert alert-success success-message dept-edited hide']");
	private static final By DeleteButtonAtAlert = By.cssSelector("a#dept-delete-btn");
	private static final String deptList = "//ul[@id='dept-list']/descendant::a[text()='%s']";
	private static final By deleteButton = By.cssSelector("a#dept-delete-modal-btn");
	
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
	public String goToModifyDepartmentName(String deptName) {
		String actualMessage;
		log.info("Start Method for - goToModifyDepartmentName");
		try {
			driver.clickOnElement(By.xpath(String.format(deptList, deptName)));
			driver.wait(WAIT_SMALL);
			driver.typeText(editdepNameTextBox, "_Modified");
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(afterModifySaveButton);
			actualMessage = driver.getTextFromElement(afterModifySuccessText);
			
		} catch (Exception ex) {
			log.error("Failed  go To ModifyDepartmentName");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for - goToModifyDepartmentName");
		return actualMessage;
	}

	public boolean goToDeleteDepartmentName(String deptName) {
		boolean isVisible ;
		log.info("Start Method for - goToDeleteDepartmentName");
		try {
			driver.clickOnElement(By.xpath(String.format(deptList, deptName)));
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(deleteButton);
			driver.clickOnElement(DeleteButtonAtAlert);
			driver.wait(WAIT_SMALL);
			driver.navigateToRefresh();
			isVisible =driver.isElementPresentAndVisible(By.xpath(String.format(deptList, deptName)));
			log.info("*********************** : "+isVisible);
				
		} catch (Exception ex) {
			log.error("Failed go To DeleteDepartmentName");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for - goToDeleteDepartmentName");
		return isVisible;
		
	}


}
