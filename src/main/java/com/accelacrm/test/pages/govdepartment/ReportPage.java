package com.accelacrm.test.pages.govdepartment;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;

public class ReportPage extends BasePage {

	public ReportPage(DefaultWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static final Logger log = LogManager.getLogger(ReportPage.class);
	private static final By calendarDropdown = By.xpath("//div[@class='daterange']/child::span[contains(text(),'Jan')]");
	private static final By deptDropdown = By.xpath("");
	private static final By keywordDropdown = By.xpath("");
	private static final By requestTypeDropdown = By.xpath("");
	private static final By statusDropdown = By.xpath("");
	private static final By saveAsNewButton = By.xpath("//button[@class='btn btn-default save-as-new']");
	private static final By newReportNameTextBox = By.xpath("//div[@id='save-modal']/descendant::input"); //TextBox
	
	private static final By selectOneTypeFromCalendarList = By.xpath("//div[@class='daterangepicker dropdown-menu opensright']/descendant::ul/li[text()='Today']");
	private static final By saveReportButton = By.xpath("//div[@id='save-modal']/descendant::a[text()='Save Report']");
	private static final By typesOfActionsDropdown = By.xpath("//span[@class='ps-dropdowntriangle']");
	private static final By shareButton = By.xpath("//div[@class='menu report-actions-menu']/child::div[text()='Share']");
	private static final By shareReportName = By.xpath("//div[@id='share-modal']/descendant::input[@class='report-name span9']");
	private static final By recipientTextBox = By.xpath("//div[@class='select2-container select2-container-multi share-with span9']");
	private static final By shareReportRecipients = By.xpath("//div[@id='share-modal']/descendant::ul");
	private static final By shareReportAddNote = By.xpath("//div[@class='row-fluid']/child::textarea");
	private static final By reportShareButton = By.xpath("//div[@class='modal-footer']/child::a[text()='Share']");
	private static final By searchedRecipientName = By.xpath("//div[@class='select2-result-label']");
	private static final By statuSMessageForSReport = By.xpath("//div[contains(text(),'Shared successfully')]");
	
	private static final String requiredReportFromList = "//div[@class='tab my-reports']/descendant::span[text()='%s']";
	private static final String goToSettingOption = "//div[@class='tab my-reports']/descendant::span[text()='%s']/following-sibling::div";
	private static final String deleteReport = "//div[@class='tab my-reports']/descendant::span[text()='%s']/following-sibling::div/descendant::div[text()='Delete Report']";
	private static final By confirmDeleteReport = By.xpath("//a[text()='Delete']");
	private static final By deleteReportStatus = By.xpath("//div[contains(text(),'successfully deleted')]");
	
	public String reportName;
	public void createNewReport() {
		log.info(" Start Method for - createNewReport");
		reportName = "Report_"+RandomStringUtils.randomAlphabetic(8);
		try {
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(calendarDropdown);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(selectOneTypeFromCalendarList);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(saveAsNewButton);
			driver.typeText(newReportNameTextBox, reportName);
			driver.clickOnElement(saveReportButton);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.info(" End Method for - createNewReport");
	}
	
	public String goToShareReports(String recipientName) {
		log.info(" Start Method for - shareReports");
		String actualStatusReport ;
		String reportName = "Report_"+RandomStringUtils.randomAlphabetic(8);
		try {
			driver.clickOnElement(typesOfActionsDropdown);
			driver.clickOnElement(shareButton);
			driver.typeText(shareReportName, reportName);
			driver.clickOnElement(recipientTextBox);
			driver.typeText(shareReportRecipients, recipientName);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(searchedRecipientName);
			driver.typeText(shareReportAddNote, "Report shared  into User");
			driver.clickOnElement(reportShareButton);
			actualStatusReport = driver.getTextFromElement(statuSMessageForSReport);
			log.info("***************** : "+actualStatusReport);
			
		} catch (Exception e) {
			log.error("Failed to goToShareReports ");
			throw new FrameworkException(e.toString());
			// TODO: handle exception
		}
		log.info(" End Method for - shareReports");
		return actualStatusReport;
	}
	
	
	public String goToDeleteReport() {
		String actualReportDeleteStatus;
		log.info(" Start Method for - goToDeleteReport");
		
		try {
			driver.navigateToRefresh();
			driver.mouseMoveToElement(By.xpath(String.format(requiredReportFromList, reportName)));
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(By.xpath(String.format(goToSettingOption, reportName)));
			driver.clickOnElement(By.xpath(String.format(deleteReport, reportName)));
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(confirmDeleteReport);
			String reportDeleteStatus = driver.getTextFromElement(deleteReportStatus);
			actualReportDeleteStatus = (String) reportDeleteStatus.subSequence(16, 36);
			} catch (Exception e) {
			throw new FrameworkException(e.toString());
		}
		log.info(" End Method for - goToDeleteReport");
		return actualReportDeleteStatus;
	}

}
