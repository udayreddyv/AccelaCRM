package com.accelacrm.test.pages.govdepartment;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;
import com.accelacrm.test.pages.citizen.login.LoginPage;

public class WorkflowPage extends BasePage {

	public WorkflowPage(DefaultWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	private static final By workflowNameText = By.xpath("//input[@id='workflow-name']");
	private static final By deptDropdown = By.xpath("//span[@id='select2-chosen-6']");
	private static final String depNameFromDropDown = "//ul[@id='select2-results-6']/descendant::div[text()='%s']";
	//private static final By allDepNames = By.xpath("//ul[@id='select2-results-6']/descendant::div");
	private static final By statusMessageForSave = By.xpath("//div[text()='Workflow successfully created']");
	private static final By statusMessageForEditSave = By.xpath("//div[text()='Workflow successfully updated']");
	private static final By saveButton = By.xpath("//h2[@class='new-header']//a[contains(text(),'Save')]");
	private static final By EditsaveButton = By.xpath("//h2[@class='edit-header hide']//a[contains(text(),'Save')]");
	
	
	private static final String requiredValue = "//div[@class='workflow-list-container']//ul/li[text()='%s']";
	
	public String workflowName;
	
	public String goToCreateWorkflow(String depName) {
		log.info("Start method for goToCreateWorkflow");
		workflowName = "Workflow_" + RandomStringUtils.randomAlphabetic(6);
		String actualStatusForWorkflowCreation;
		try {
			driver.typeText(workflowNameText, workflowName);
			driver.clickOnElement(deptDropdown);
			driver.clickOnElement(By.xpath(String.format(depNameFromDropDown, depName)));
			driver.clickOnElement(saveButton);
			//driver.getTextFromElement(statusMessageForSave);
			actualStatusForWorkflowCreation = driver.getTextFromElement(statusMessageForSave);
			driver.wait(WAIT_MEDIUM);
		} catch (Exception ex) {
			log.error("Failed to go ManageWorkflow Button");
			throw new FrameworkException(ex.toString());
		}
		log.info("End method for goToCreateWorkflow");
		return actualStatusForWorkflowCreation;
	}
	
	public String goToModifyWorkflow(String workflowName) {
		log.info("Start method for goToModifyWorkflow");
				String actualStatusForWorkflowUpdate;
		try {
			
			driver.clickOnElement(By.xpath(String.format(requiredValue, workflowName)));
			driver.wait(WAIT_SMALL);
			driver.typeText(workflowNameText, "_Modify");
						driver.clickOnElement(EditsaveButton);
			driver.getTextFromElement(statusMessageForEditSave);
			actualStatusForWorkflowUpdate = driver.getTextFromElement(statusMessageForSave);
		} catch (Exception ex) {
			log.error("Failed to go ManageWorkflow Button");
			throw new FrameworkException(ex.toString());
		}
		log.info("End method for goToModifyWorkflow");
		return actualStatusForWorkflowUpdate;
	}
}
