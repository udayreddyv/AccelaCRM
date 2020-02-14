package com.accelacrm.test.pages.govdepartment;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.KeyDownAction;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;
import com.accelacrm.test.pages.citizen.login.LoginPage;

public class HomePage extends BasePage {
	
	public HomePage(DefaultWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	private static final By settingsDropdownButton = By.xpath("//ul[@class='nav pull-right']/child::li[@class='dropdown']/descendant::i[@class='icon-cog icon-white']");
	private static final By peopleUserDropdown = By.xpath("//ul[@class='nav pull-right']//descendant::span[@class='caret'][2]");
	private static final By manageDepartments = By.xpath("//a[contains(text(),'Manage Departments')]");
	private static final By manageWorkflow = By.xpath("//a[contains(text(),'Manage Workflow')]");
	private static final By manageReuestType = By.xpath("//a[contains(text(),'Manage Re')]");
	private static final By manageUsers = By.xpath("//a[contains(text(),'Manage Users')]");
	private static final By requestButton = By.xpath("//a[@class='btn'][contains(text(),'Request')]");
	private static final By reportButton = By.xpath("//li[@class='dropdown']/child::a[text()='Reports']");
	private static final By logOutButton = By.xpath("//a[text()='Log Out']");
	
	private static final By contentDropDown = By.xpath("//a[contains(text(),'Content')]");
	private static final By publicPeopleLink = By.xpath("//a[contains(text(),'Public People')]");
	private static final By plcaeLink = By.xpath("//a[contains(text(),'Places')]");
	private static final By faqLink = By.xpath("//a[contains(text(),'FAQ')]");
	private static final By searchBox = By.xpath("//div[@class='container']/div/descendant::input[@class='search-query']");
	private static final By getRequestId = By.xpath("//table[@id='reported-requests']/tbody/tr[1]/td[4]/a");
	
	private static final String emailID = "//strong[text()='%s']";
	private static final String requestID = "//strong[text()='%s']";
	private static final By getRequestDetails = By.xpath("//span[@id='request_id']");
	
	
	public DepartmentPage goToManageDepartment() {
		log.info("Start Method for goToManageDepartment");
		try {
			driver.clickOnElement(settingsDropdownButton);
			driver.clickOnElement(manageDepartments);

		} catch (Exception ex) {
			log.error("Failed to go ManageDepartment Button");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToManageDepartment");
		return new DepartmentPage(driver);
	}
	
	public WorkflowPage goToManageWorkflow() {
		log.info("Start Method for goToManageWorkflow");
		try {
			driver.clickOnElement(settingsDropdownButton);
			driver.clickOnElement(manageWorkflow);

		} catch (Exception ex) {
			log.error("Failed to go ManageWorkflow Button");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToManageWorkflow");
		return new WorkflowPage(driver);
	}
	public RequestTypePage goToManageReuestTypes() {
		log.info("Start Method for goToManageReuestTypes");
		try {
			driver.clickOnElement(settingsDropdownButton);
			driver.clickOnElement(manageReuestType);

		} catch (Exception ex) {
			log.error("Failed to go Manage ReuestTypes Button");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToManageReuestTypes");
		return new RequestTypePage(driver);
	}
	public ReuestPage goToRequestTab() {
		log.info("Start Method for goToRequestTab");
		try {
			driver.clickOnElement(requestButton);
			
		} catch (Exception ex) {
			log.error("Failed to go goToRequestTab Button");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToRequestTab");
		return new ReuestPage(driver);
	}
	public ReportPage goToReportTab() {
		log.info("Start Method for goToReportTab");
		try {
			driver.clickOnElement(reportButton);
			
		} catch (Exception ex) {
			log.error("Failed to go goToReportTab Button");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToReportTab");
		return new ReportPage(driver);
	}
	public ContentPage goToContentTabThenPublicPeople() {
		log.info("Start Method for goToContentTabThenPublicPeople");
		try {
			driver.clickOnElement(contentDropDown);
			driver.clickOnElement(publicPeopleLink);
			
		} catch (Exception ex) {
			log.error("Failed to go ContentTabThenPublicPeople");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToContentTabThenPublicPeople");
		return new ContentPage(driver);
	}
	public ContentPage goToContentTabThenPlace() {
		log.info("Start Method for goToContentTabThenPlace");
		try {
			driver.clickOnElement(contentDropDown);
			driver.clickOnElement(plcaeLink);
			
		} catch (Exception ex) {
			log.error("Failed to go ContentTabThenPlace");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToContentTabThenPlace");
		return new ContentPage(driver);
	}
	public ContentPage goToContentTabThenFAQ() {
		log.info("Start Method for goToContentTabThenFAQ");
		try {
			driver.clickOnElement(contentDropDown);
			driver.clickOnElement(faqLink);
			
		} catch (Exception ex) {
			log.error("Failed to go ContentTabThenFAQ");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToContentTabThenFAQ");
		return new ContentPage(driver);
	}
	public UsersPage goToManageUsers() {
		log.info("Start Method for goToManageUsers");
		try {
			driver.clickOnElement(settingsDropdownButton);
			driver.clickOnElement(manageUsers);

		} catch (Exception ex) {
			log.error("Failed to  goToManageUsers Button");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToManageUsers");
		return new UsersPage(driver);
	}
	
	
	public void goToEnterTextInSearchBox(String emailId) {
		log.info("Start Method for goToEnterTextInSearchBox");
		try {
			log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ : "+emailId);
			driver.wait(WAIT_SMALL);
			driver.typeText(searchBox,emailId);
			driver.clickOnElement(By.xpath(String.format(emailID, emailId)));
            String requestId = driver.getTextFromElement(getRequestId);
			log.info("********************  requestId :"+requestId);
			driver.wait(WAIT_SMALL);
			driver.typeText(searchBox, requestId);
			driver.clickOnElement(By.xpath(String.format(requestID, requestId)));
			driver.wait(WAIT_SMALL);
			String requestDetails = driver.getTextFromElement(getRequestDetails);
			driver.wait(WAIT_SMALL);
			log.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&   requestDetails : "+requestDetails);
			
			
		} catch (Exception ex) {
			log.error("Failed to  go EnterTextInSearchBox");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToEnterTextInSearchBox");
	
	}
	
	public void goToLogOut() {
		log.info("Start Method for goToLogOut");
		try {
			driver.clickOnElement(peopleUserDropdown);
			driver.wait(WAIT_SMALL);
			driver.clickOnElement(logOutButton);
			driver.wait(WAIT_MEDIUM);

		} catch (Exception ex) {
			log.error("Failed to go goToLogOut Button");
			throw new FrameworkException(ex.toString());
		}
		log.info("End Method for goToLogOut");
		
	}

}
