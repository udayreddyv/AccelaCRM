package com.accelacrm.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accelacrm.test.framework.selenium.TestBaseClass;
import com.accelacrm.test.pages.govdepartment.ContentPage;
import com.accelacrm.test.pages.govdepartment.DepartmentPage;
import com.accelacrm.test.pages.govdepartment.HomePage;
import com.accelacrm.test.pages.govdepartment.ReportPage;
import com.accelacrm.test.pages.govdepartment.ReuestPage;
import com.accelacrm.test.pages.govdepartment.RequestTypePage;
import com.accelacrm.test.pages.govdepartment.UsersPage;
import com.accelacrm.test.pages.govdepartment.WorkflowPage;


public class GovDepartmentTest extends TestBaseClass {

	@Test
	public void createToDepartmentName() {
		String expectedSuccessMessage = classLevelData.get("expectedSuccessMessage");
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertAll();
	}

	@Test
	public void createToManageWorkflow() {
		String expectedSuccessMessage = classLevelData.get("expectedSuccessMessage");
		String expectedSuccessMessageForWorkflow = classLevelData.get("expectedSuccessMessageForWorkflow");
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		WorkflowPage workflowPage = homePage.goToManageWorkflow();
		String actualSuccessMessageForWorkflow = workflowPage.goToCreateWorkflow(deptName);
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertAll();
	}
	@Test
	public void modifyToeWorkflow() {
		String expectedSuccessMessage = classLevelData.get("expectedSuccessMessage");
		String expectedSuccessMessageForWorkflow = classLevelData.get("expectedSuccessMessageForWorkflow");
		String expectedSuccessMessageForWorkflowUpdation = "Workflow successfully updated";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		WorkflowPage workflowPage = homePage.goToManageWorkflow();
		String actualSuccessMessageForWorkflow = workflowPage.goToCreateWorkflow(deptName);
		String wrokflowName =workflowPage.workflowName;
		String atualSuccessMessageForWorkflowUpdation = workflowPage.goToModifyWorkflow(wrokflowName);
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertEquals(atualSuccessMessageForWorkflowUpdation, expectedSuccessMessageForWorkflowUpdation);
		softAssert.assertAll();
	}
	@Test
	public void createToManageReuestType() {
		String expectedSuccessMessage = classLevelData.get("expectedSuccessMessage");
		String expectedSuccessMessageForWorkflow = classLevelData.get("expectedSuccessMessageForWorkflow");
		String expectedSuccessMessageForReuestType = classLevelData.get("expectedSuccessMessageForReuestType");
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		WorkflowPage workflowPage = homePage.goToManageWorkflow();
		String actualSuccessMessageForWorkflow = workflowPage.goToCreateWorkflow(deptName);
		String wrkflwName = workflowPage.workflowName;
		RequestTypePage reuestTypePage = homePage.goToManageReuestTypes();
		String actualSuccessMessageForReuestType= reuestTypePage.goToCreateNewRequestType("0 Test 0");
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertEquals(actualSuccessMessageForReuestType, expectedSuccessMessageForReuestType);
		softAssert.assertAll();
	}
	@Test
	public void goToModifyManageRequestType() {
		String expectedSuccessMessage = classLevelData.get("expectedSuccessMessage");
		String expectedSuccessMessageForWorkflow = classLevelData.get("expectedSuccessMessageForWorkflow");
		String expectedSuccessMessageForReuestType = classLevelData.get("expectedSuccessMessageForReuestType");
		String expectedSuccessfullMessageForModifyRequestType = "Successfully Updated";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		WorkflowPage workflowPage = homePage.goToManageWorkflow();
		String actualSuccessMessageForWorkflow = workflowPage.goToCreateWorkflow(deptName);
		String wrkflwName = workflowPage.workflowName;
		RequestTypePage reuestTypePage = homePage.goToManageReuestTypes();
		String actualSuccessMessageForReuestType= reuestTypePage.goToCreateNewRequestType("0 Test 0");
		String acutalSuccessfullMessageForModifyRequestType = reuestTypePage.goToEditExistedRequestType(reuestTypePage.requestTypeName);
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertEquals(actualSuccessMessageForReuestType, expectedSuccessMessageForReuestType);
		softAssert.assertEquals(acutalSuccessfullMessageForModifyRequestType, expectedSuccessfullMessageForModifyRequestType);
		softAssert.assertAll();
	}
	@Test
	public void goToAddCustomFieldForRequestType() {
		String expectedSuccessMessage = classLevelData.get("expectedSuccessMessage");
		String expectedSuccessMessageForWorkflow = classLevelData.get("expectedSuccessMessageForWorkflow");
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		WorkflowPage workflowPage = homePage.goToManageWorkflow();
		String actualSuccessMessageForWorkflow = workflowPage.goToCreateWorkflow(deptName);
		String wrkflwName = workflowPage.workflowName;
		RequestTypePage reuestTypePage = homePage.goToManageReuestTypes();
		reuestTypePage.goToAddRequestTypeCustomField("0 Test 0");
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertAll();
	}
	
	
	@Test
	public void createToNewReuest() {
		String expectedSuccessMessage = "has been submitted successfully, click here to view it.";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		WorkflowPage workflowPage = homePage.goToManageWorkflow();
		String actualSuccessMessageForWorkflow = workflowPage.goToCreateWorkflow(deptName);
		String wrkflwName = workflowPage.workflowName;
		RequestTypePage reuestTypePage = homePage.goToManageReuestTypes();
		String actualSuccessMessageForReuestType= reuestTypePage.goToCreateNewRequestType("0 Test 0");
		String requestTypeName = reuestTypePage.requestTypeName;
		ReuestPage reuestPage = homePage.goToRequestTab();
		String actualSuccessMessageForNR = reuestPage.goToCreateNewReuest(requestTypeName);
		softAssert.assertEquals(actualSuccessMessageForNR, expectedSuccessMessage, "Not Matched");
		softAssert.assertAll();
				
	}
	@Test
	public void createNewReport() {
		HomePage homePage = new HomePage(defaultWebDriver);
		ReportPage reportPage = homePage.goToReportTab();
		reportPage.createNewReport();
		homePage.goToLogOut();		
	}
	@Test
	public void createToUsers() {
		String expectedStatusMessage = "Action Successful";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		UsersPage usersPage = homePage.goToManageUsers();
		String actualStatusMessage =usersPage.createUser();
		homePage.goToLogOut();	
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessage,"Not Matched");
		softAssert.assertAll();		
	}
	@Test
	public void shareReportsToUser() {
		String expectedStatusMessage = "Action Successful";
		String expectedStatusMessageSReport = "Shared successfully with 1 person";
		
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		UsersPage usersPage = homePage.goToManageUsers();
		String actualStatusMessage =usersPage.createUser();
		String recipient = usersPage.details;
		System.out.println("$$$$$$$$$$$$$$$$$$$$ : "+recipient);
		
		
		ReportPage reportPage = homePage.goToReportTab();
		String actualStatusMessageSReport =reportPage.goToShareReports(recipient);
		//homePage.goToLogOut();	
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessage,"Not Matched");
		softAssert.assertEquals(actualStatusMessageSReport, expectedStatusMessageSReport, "Not Matched");
		softAssert.assertAll();		
	}
	@Test
	public void CreateToPublicPeople() {
		String expectedStatusMessage = "Save successful!";
		SoftAssert softAssert =  new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenPublicPeople();
		String actualStatusMessage = contentPage.goToaddPublicPeople();
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessage);
		softAssert.assertAll();		
	}
	@Test
	public void modifyToPublicPeople() {
		String expectedStatusMessageUpdate = "Save successful!";
		SoftAssert softAssert =  new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenPublicPeople();
		String actualStatusMessage = contentPage.goToaddPublicPeople();
		String firstNameText = contentPage.frstName;
		String actualStatusMessageUpdate  = contentPage.goToModifyPublicPeople(firstNameText);
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessageUpdate);
		softAssert.assertEquals(actualStatusMessageUpdate, expectedStatusMessageUpdate);
		softAssert.assertAll();		
		
	}
	@Test
	public void createToPlaces() {
		String expectedStatusMessage = "saved";
		SoftAssert softAssert =  new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenPlace();
		String actualStatusMessage = contentPage.goToAddPlaces();
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessage);
		softAssert.assertAll();		
	}
	@Test
	public void createToFAQ() {
		String expectedStatusMessageFAQ = "Post successful!";
		SoftAssert softAssert =  new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenFAQ();
		String actualStatusMessageFAQ = contentPage.goToAddFAQPost();
		softAssert.assertEquals(actualStatusMessageFAQ, expectedStatusMessageFAQ);
		softAssert.assertAll();		
	}
	@Test
	public void modifyToFAQ() {
		String expectedStatusMessageFAQ = "Post successful!";
		SoftAssert softAssert =  new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenFAQ();
		String actualStatusMessageFAQ = contentPage.goToAddFAQPost();
		String actualMessage = contentPage.goToModifyExistedFAQPost(contentPage.questionText);
		System.out.println("******************************* : "+actualMessage);
		softAssert.assertEquals(actualStatusMessageFAQ, expectedStatusMessageFAQ);
		softAssert.assertAll();		
	}
	@Test
	public void goToSearchGlobal() {
		SoftAssert softAssert =  new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		homePage.goToEnterTextInSearchBox(appDetails.getLoginUserName());
		
	}
	
	@Test
	public void goToNewUser(){
		String expectedUrl = "https://gov-stage.publicstuff.com/dashboard";
		SoftAssert softAssert =  new SoftAssert();
		defaultWebDriver.wait(5000);
		String actualUrl = defaultWebDriver.getCurrentUrl();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@  NewUser Successfull: "+actualUrl);
		softAssert.assertEquals(actualUrl, expectedUrl);
		softAssert.assertAll();
		
	}
	
}
