package com.accelacrm.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.accelacrm.test.framework.selenium.TestBaseClass;
import com.accelacrm.test.pages.citizens.CitizensHomePage;

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
}
