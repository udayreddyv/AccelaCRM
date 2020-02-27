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

	// Verify To Create Department Name
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
	// Verify To Modify Department Name
	@Test
	public void modifyTheDepartmentName() {
		String expectedSuccessMessage = classLevelData.get("expectedSuccessMessage");
		String expectedSuccessMessageForModify = "Success! Department Updated.";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		String actualSuccessMessageForModify = departmentPage.goToModifyDepartmentName(deptName);
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForModify, expectedSuccessMessageForModify);
		softAssert.assertAll();
	}
	
	// Verify To Delete Department Name
	@Test
	public void deleteTheDepartmentName() {
		String expectedSuccessMessage = classLevelData.get("expectedSuccessMessage");
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		boolean isVisible = departmentPage.goToDeleteDepartmentName(deptName);
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertFalse(isVisible);
		softAssert.assertAll();
	}
	
	// Verify The Create WorkFlow
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

	// Verify The Edit Workflow
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
		String wrokflowName = workflowPage.workflowName;
		String atualSuccessMessageForWorkflowUpdation = workflowPage.goToModifyWorkflow(wrokflowName);
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertEquals(atualSuccessMessageForWorkflowUpdation, expectedSuccessMessageForWorkflowUpdation);
		softAssert.assertAll();
	}
	// Verify The Delete Workflow
	
	@Test
	public void deleteTheManageWorkflow() {
		String expectedSuccessMessage = classLevelData.get("expectedSuccessMessage");
		String expectedSuccessMessageForWorkflow = classLevelData.get("expectedSuccessMessageForWorkflow");
		String expectedStatusForWrkfDelete = "Workflow successfully deleted";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		String actualSuccessMessage = departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		WorkflowPage workflowPage = homePage.goToManageWorkflow();
		String actualSuccessMessageForWorkflow = workflowPage.goToCreateWorkflow(deptName);
		String wrkflowName = workflowPage.workflowName;
		String actualStatusForWrkfDelete = workflowPage.goToDeleteWorkflow(wrkflowName);
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertEquals(actualStatusForWrkfDelete, expectedStatusForWrkfDelete);
		softAssert.assertAll();
	}

	// Verify The Create Request Type
	@Test
	public void createToManageRequestType() {
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
		String actualSuccessMessageForReuestType = reuestTypePage.goToCreateNewRequestType("Default Workflow");
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertEquals(actualSuccessMessageForReuestType, expectedSuccessMessageForReuestType);
		softAssert.assertAll();
	}

	// Verify The Edit Request Type
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
		String actualSuccessMessageForReuestType = reuestTypePage.goToCreateNewRequestType("Default Workflow");
		String acutalSuccessfullMessageForModifyRequestType = reuestTypePage
				.goToEditExistedRequestType(reuestTypePage.requestTypeName);
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertEquals(actualSuccessMessageForReuestType, expectedSuccessMessageForReuestType);
		softAssert.assertEquals(acutalSuccessfullMessageForModifyRequestType,
				expectedSuccessfullMessageForModifyRequestType);
		softAssert.assertAll();
	}
	// Verify The delete Request Type
		@Test
		public void deleteTheRequestType() {
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
			String actualSuccessMessageForReuestType = reuestTypePage.goToCreateNewRequestType("Default Workflow");
			reuestTypePage.goToDeleteRequestType(reuestTypePage.requestTypeName);
			softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
			softAssert.assertEquals(actualSuccessMessageForReuestType, expectedSuccessMessageForReuestType);
			softAssert.assertAll();
		}

	// Verify The Add Custom Field in Request Type
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
		reuestTypePage.goToAddRequestTypeCustomField("Default Workflow");
		softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
		softAssert.assertEquals(actualSuccessMessageForWorkflow, expectedSuccessMessageForWorkflow);
		softAssert.assertAll();
	}
	
	// Verify The Create New Request from Department
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
		String actualSuccessMessageForReuestType = reuestTypePage.goToCreateNewRequestType("Default Workflow");
		String requestTypeName = reuestTypePage.requestTypeName;
		ReuestPage reuestPage = homePage.goToRequestTab();
		String actualSuccessMessageForNR = reuestPage.goToCreateNewReuest(requestTypeName);
		softAssert.assertEquals(actualSuccessMessageForNR, expectedSuccessMessage, "Not Matched");
		softAssert.assertAll();

	}

	// Verify The Create New Report
	@Test
	public void createNewReport() {
		HomePage homePage = new HomePage(defaultWebDriver);
		ReportPage reportPage = homePage.goToReportTab();
		reportPage.createNewReport();
		homePage.goToLogOut();
	}
	

	// Verify The Delete Report
	@Test
	public void deleteReport() {
		String expectedReportDeleteStatus ="successfully deleted";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ReportPage reportPage = homePage.goToReportTab();
		reportPage.createNewReport();
	    String actualReportDeleteStatus = reportPage.goToDeleteReport();
	   	homePage.goToLogOut();
	    softAssert.assertEquals(actualReportDeleteStatus, expectedReportDeleteStatus);
	    softAssert.assertAll();
	}
	

	// Verify The Create New User
	@Test
	public void createToUsers() {
		String expectedStatusMessage = "Action Successful";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		UsersPage usersPage = homePage.goToManageUsers();
		String actualStatusMessage = usersPage.createUser();
		homePage.goToLogOut();
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessage, "Not Matched");
		softAssert.assertAll();
	}
	
	

	// Verify The Share Reports to User
	@Test
	public void shareReportsToUser() {
		String expectedStatusMessage = "Action Successful";
		String expectedStatusMessageSReport = "Shared successfully with 1 person";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		UsersPage usersPage = homePage.goToManageUsers();
		String actualStatusMessage = usersPage.createUser();
		String recipient = usersPage.details;
		ReportPage reportPage = homePage.goToReportTab();
		String actualStatusMessageSReport = reportPage.goToShareReports(recipient);
		// homePage.goToLogOut();
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessage, "Not Matched");
		softAssert.assertEquals(actualStatusMessageSReport, expectedStatusMessageSReport, "Not Matched");
		softAssert.assertAll();
	}

	// Verify The Create Public People
	@Test
	public void CreateToPublicPeople() {
		String expectedStatusMessage = "Save successful!";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenPublicPeople();
		String actualStatusMessage = contentPage.goToaddPublicPeople();
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessage);
		softAssert.assertAll();
	}

	// Verify The Edit Public People
	@Test
	public void modifyToPublicPeople() {
		String expectedStatusMessageUpdate = "Save successful!";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenPublicPeople();
		String actualStatusMessage = contentPage.goToaddPublicPeople();
		String firstNameText = contentPage.frstName;
		String actualStatusMessageUpdate = contentPage.goToModifyPublicPeople(firstNameText);
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessageUpdate);
		softAssert.assertEquals(actualStatusMessageUpdate, expectedStatusMessageUpdate);
		softAssert.assertAll();

	}

	// Verify The Create Places
	@Test
	public void createToPlaces() {
		String expectedStatusMessage = "saved";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenPlace();
		String actualStatusMessage = contentPage.goToAddPlaces();
		softAssert.assertEquals(actualStatusMessage, expectedStatusMessage);
		softAssert.assertAll();
	}

	// Verify The Create FAQ
	@Test
	public void createToFAQ() {
		String expectedStatusMessageFAQ = "Post successful!";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenFAQ();
		String actualStatusMessageFAQ = contentPage.goToAddFAQPost();
		softAssert.assertEquals(actualStatusMessageFAQ, expectedStatusMessageFAQ);
		softAssert.assertAll();
	}

	// Verify The Edit FAQ
	@Test
	public void modifyToFAQ() {
		String expectedStatusMessageFAQ = "Post successful!";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		ContentPage contentPage = homePage.goToContentTabThenFAQ();
		String actualStatusMessageFAQ = contentPage.goToAddFAQPost();
		String actualMessage = contentPage.goToModifyExistedFAQPost(contentPage.questionText);
		softAssert.assertEquals(actualStatusMessageFAQ, expectedStatusMessageFAQ);
		softAssert.assertAll();
	}

	// Verify The Global Search
	@Test
	public void goToSearchGlobal() {
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		homePage.goToEnterTextInSearchBox(appDetails.getLoginUserName());

	}
	// Verify The New User(individual)

	@Test
	public void goToNewUser() {
		String expectedUrl = "https://gov-stage.publicstuff.com/dashboard";
		SoftAssert softAssert = new SoftAssert();
		defaultWebDriver.wait(5000);
		String actualUrl = defaultWebDriver.getCurrentUrl();
		softAssert.assertEquals(actualUrl, expectedUrl);
		softAssert.assertAll();

	}
	
	//Verify User Profile Page
	@Test
	public void verifyUserProfile()
	{
		String expectedStatus = "Manage my account";
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		String actualStatus = homePage.goToUserProfileEditPage();
		softAssert.assertEquals(actualStatus, expectedStatus);
		softAssert.assertAll();
	}

}
