package com.accelacrm.test.pages.govdepartment;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;

public class RequestTypePage extends BasePage {

	public RequestTypePage(DefaultWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final Logger log = LogManager.getLogger(RequestTypePage.class);
	private static final By reuestTypeNameText = By.id("request_type_name");
	private static final By workflowNameDropdownButtton = By.id("s2id_autogen25");
	private static final String selectWorkflowName = "//ul[@id='select2-results-26']//div[@class='select2-result-label'][text()='%s']";
	private static final By saveButton = By.xpath("//h2[@class='new']/descendant::button[contains(text(),'Save')]");
	private static final By saveButtonAfterModify = By.xpath("//div[@class='pull-right']//child::a/following-sibling::button");
	private static final By statusOfReuestType = By.xpath("//div[@data-attribute='messages']");//gettext
	private static final By statusModifyMessage = By.xpath("//div[@id='messages']/child::div[contains(text(),'Success')]");
	private static final By dropdownScroll = By.xpath("//ul[@id='select2-results-26']");
	
	private static final String requestTypeList = "//div[@id='deptServicesBox']/descendant::ul/li/a[text()='%s']";
	private static final By addCustomField = By.xpath("//button[contains(text(),'Add Custom Field')]");
	private static final By customFieldName = By.xpath("//form[@id='add-object-field']/descendant::input[@id='manage-of-name']");
	private static final By customFieldDescription = By.xpath("//form[@id='add-object-field']/descendant::textarea[@id='manage-of-description']");
	private static final By submitcustomFieldAddButton = By.xpath("//button[@type='submit'][text()='Add']");
	private static final By customFieldMakeFieldOptional = By.xpath("//*[@id=\"add-object-field\"]/div[1]/div[4]/div[1]/div[2]/div[2]/div/div/div/label");
	
	private static final By deleteButton = By.xpath("//a[text()='Delete']");
	private static final By requestMovigDropdown = By.xpath("//span[text()='Select Request Type']");
	private static final By selectForMoveRequestType = By.xpath("//ul[@role='listbox']/descendant::div[text()='Fire']");
	private static final By moveButton = By.xpath("//button[text()='Move']");
	
	public String requestTypeName;
	public String goToCreateNewRequestType(String workflowName) {
		log.info("Start method for - goToCreateNewRequestType");
		String actualStatusOfReuestType;
		requestTypeName = "ReuestType_" +RandomStringUtils.randomAlphabetic(5);
		try {
			driver.typeText(reuestTypeNameText, requestTypeName);
			driver.clickOnElement(workflowNameDropdownButtton);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(By.xpath(String.format(selectWorkflowName, workflowName)));
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(saveButton);
			String  actualStatusOfReuestTypeOriginal = driver.getTextFromElement(statusOfReuestType);	
			actualStatusOfReuestType = (String) actualStatusOfReuestTypeOriginal.subSequence(17, 46);
			} catch (Exception ex) {
			log.error("Failed to create New Request Type");
			throw new FrameworkException(ex.toString());			
		}
		log.info("End method for - goToCreateNewRequestType");
		return actualStatusOfReuestType;
	}
	public String goToEditExistedRequestType(String newRequestTypeName) {
		log.info("Start method for - goToEditExistedRequestType");
		String actualStatusOfReuestTypeUpdated;
		try {
			driver.clickOnElement(By.xpath(String.format(requestTypeList, newRequestTypeName)));
			driver.wait(WAIT_SMALL);
			driver.typeText(reuestTypeNameText, "_Modified");
			driver.clickOnElement(saveButtonAfterModify);
			actualStatusOfReuestTypeUpdated = driver.getTextFromElement(statusModifyMessage);
			} catch (Exception ex) {
			log.error("Failed to modify Request Type");
			throw new FrameworkException(ex.toString());			
		}
		log.info("End method for - goToEditExistedRequestType");
		return actualStatusOfReuestTypeUpdated;
	}
	
	public void goToAddRequestTypeCustomField(String workflowName) {
		log.info("Start method for - goToRequestTypeCustomField");
		String requestTypeName = "ReuestType_" +RandomStringUtils.randomAlphabetic(5);
		String customName = "CustomName_"+RandomStringUtils.randomAlphabetic(4);
		String customDescription = "CustomDesc_"+RandomStringUtils.randomAlphabetic(4);
		
		try {
			driver.typeText(reuestTypeNameText, requestTypeName);
			driver.clickOnElement(workflowNameDropdownButtton);
			driver.clickOnElement(By.xpath(String.format(selectWorkflowName, workflowName)));
			driver.clickOnElement(addCustomField);
			driver.typeText(customFieldName, customName);
			driver.typeText(customFieldDescription, customDescription);
			driver.clickOnElement(customFieldMakeFieldOptional);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(submitcustomFieldAddButton);
			
			} catch (Exception ex) {
			log.error("Failed to Add custom field for Request Type");
			throw new FrameworkException(ex.toString());			
		}
		log.info("End method for - goToRequestTypeCustomField");
		
	}
	
	public void goToDeleteRequestType(String newRequestTypeName) {
		log.info("Start method for - goToDeleteRequestType");
		
		try {
			driver.navigateToRefresh();
			driver.clickOnElement(By.xpath(String.format(requestTypeList, newRequestTypeName)));
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(deleteButton);
			driver.clickOnElement(requestMovigDropdown);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(selectForMoveRequestType);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(moveButton);				
			
			} catch (Exception ex) {
			log.error("Failed go To DeleteRequestType");
			throw new FrameworkException(ex.toString());			
		}
		log.info("End method for - goToDeleteRequestType");
	}	
	
}
