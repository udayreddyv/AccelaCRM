package com.accelacrm.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accelacrm.test.framework.selenium.TestBaseClass;
import com.accelacrm.test.pages.citizens.CitizensHomePage;
import com.accelacrm.test.pages.govdepartment.DepartmentPage;
import com.accelacrm.test.pages.govdepartment.HomePage;
import com.accelacrm.test.pages.govdepartment.RequestTypePage;
import com.accelacrm.test.pages.govdepartment.WorkflowPage;

public class CitizenTest extends TestBaseClass {
	
	
	@Test
	public void verifyToManageAccount() {
		String expectedMessage = "Your changes have been saved";
		SoftAssert softAssert = new SoftAssert();
		CitizensHomePage citizensHomePage = new CitizensHomePage(defaultWebDriver);
		String actualMessage = citizensHomePage.goToModifyUserAccount();
		softAssert.assertEquals(actualMessage, expectedMessage);
		softAssert.assertAll();
	}
	
	@Test
	public void verifyToCreateNewIssue() {
		CitizensHomePage citizensHomePage = new CitizensHomePage(defaultWebDriver);
		//citizensHomePage.goToLogOutCitizenPage();
		citizensHomePage.logInToGOVAdminModule();
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(defaultWebDriver);
		DepartmentPage departmentPage = homePage.goToManageDepartment();
		departmentPage.goToCreateDepartmentName();
		String deptName = departmentPage.departmentName;
		WorkflowPage workflowPage = homePage.goToManageWorkflow();
		workflowPage.goToCreateWorkflow(deptName);
		String wrkflwName = workflowPage.workflowName;
		RequestTypePage reuestTypePage = homePage.goToManageReuestTypes();
		reuestTypePage.goToCreateNewRequestType("Default Workflow");
		String requestName = reuestTypePage.requestTypeName;
		System.out.println("@@@@@@@@@@@@@@ : "+requestName);
		
		citizensHomePage.goToPreviusURL();
		
	}
}
