package com.accelacrm.test.pages.govdepartment;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.accelacrm.test.framework.selenium.DefaultWebDriver;
import com.accelacrm.test.framework.selenium.exception.FrameworkException;
import com.accelacrm.test.pages.BasePage;

public class ContentPage extends BasePage{

	public ContentPage(DefaultWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static final Logger log = LogManager.getLogger(ContentPage.class);
	private static final By firstNameTextBox = By.xpath("//input[@id='first-name']");
	private static final By lastNameTextBox = By.xpath("//input[@id='last-name']");
	private static final By position = By.xpath("//input[@id='title']");
	private static final By department = By.xpath("//input[@id='department']");
	/*private static final By EmailId = By.xpath("");
	private static final By Phone = By.xpath("");
	private static final By Twitter = By.xpath("");
	private static final By FaceBook = By.xpath("");*/
	//private static final By uploadPhotoButton = By.xpath("//button[@id='upload-picture-button']");
	private static final By saveButton = By.xpath("//input[@id='save-publicperson']");
	private static final By statusOfSave= By.xpath("//span[@id='publicperson-success']");
	private static final String editpublicPerson = "//ul[@id='people-sort']/child::li/strong/span[text()='%s']/following::div/button[@title='Edit']";
	private static final By newCategoryButton = By.xpath("//*[contains(text(),'New Category')]");
	private static final By newCategoryTextBox = By.xpath("//div[@class='category-name-editor']/input");
	private static final By newCategorySaveButton = By.xpath("//div[@class='category-name-editor']/descendant::span[@class='confirm']");
	private static final By statusOfSuccessCategory = By.xpath("//*[@class='saved-message']");
	private static final By faqTextBox = By.xpath("//input[@name='question']");
	private static final By answerTextBox = By.xpath("//textarea[@name='answer']");
	private static final By postButton = By.xpath("//input[@class='btn btn-primary']");
	private static final By statusOfFAQ = By.xpath("//span[text()='Post successful!']");
	
	private static final String editFAQ = "//h4/span[text()='%s']/following::a[@title='Edit FAQ']";
	public String frstName ;
	
	
public String goToaddPublicPeople() {
	frstName = "PersonFName_"+RandomStringUtils.randomAlphabetic(4);
	String lastName = "PersonLName_"+RandomStringUtils.randomAlphabetic(4);
	String positionText = "PersonPosition_"+RandomStringUtils.randomAlphabetic(4);
	String deptName = "PersonDeptName_"+RandomStringUtils.randomAlphabetic(4);
	String actualMessage;
	log.info("Start Method For -addPublicPeople ");
	try {
		driver.typeText(firstNameTextBox, frstName);
		driver.typeText(lastNameTextBox, lastName);
		driver.typeText(position, positionText);
		driver.typeText(department, deptName);
		driver.clickOnElement(saveButton);
		actualMessage = driver.getTextFromElement(statusOfSave);
		
	} catch (Exception e) {
		log.error("Failed to go Add public people");
		throw new FrameworkException(e.toString());
		// TODO: handle exception
	}
	log.info("End Method For -addPublicPeople ");
	return actualMessage;
}
public String goToModifyPublicPeople(String firstName) {

	String actualMessage;
	log.info("Start Method For -addPublicPeople ");
	try {
		driver.clickOnElement(By.xpath(String.format(editpublicPerson, firstName)));
		driver.wait(WAIT_SMALL);
		driver.typeText(firstNameTextBox, "_Modify");
		driver.wait(WAIT_SMALL);
		driver.clickOnElement(saveButton);
		actualMessage = driver.getTextFromElement(statusOfSave);
		log.info("*************************** : "+actualMessage);
		
	} catch (Exception e) {
		log.error("Failed to go Add public people");
		throw new FrameworkException(e.toString());
		// TODO: handle exception
	}
	log.info("End Method For -addPublicPeople ");
	return actualMessage;
}
public String goToAddPlaces(){
	String actualStatus;
	String placeText = "PlaceName_"+RandomStringUtils.randomAlphabetic(4);
	log.info("Start Method for - goToAddPlaces");
	try {
		driver.clickOnElement(newCategoryButton);
		driver.clearTextBox(newCategoryTextBox);
		driver.wait(WAIT_SMALL);
		driver.typeText(newCategoryTextBox, placeText);
		driver.clickOnElement(newCategorySaveButton);
		actualStatus = driver.getTextFromElement(statusOfSuccessCategory);
				
	} catch (Exception e) {
		log.error("Failed to go Add place");
		throw new FrameworkException(e.toString());
	}
	log.info("End Method for - goToAddPlaces");
	return actualStatus;
}
 public String questionText;
public String goToAddFAQPost(){
	String actualStatusFAQ;
	questionText = "Question_"+RandomStringUtils.randomAlphabetic(4)+"  ?";
	String answerText = "PlaceName_"+RandomStringUtils.randomAlphabetic(4)+".";
	log.info("Start Method for - goToAddPlaces");
	try {
		driver.typeText(faqTextBox, questionText);
		driver.typeText(answerTextBox, answerText);
		driver.clickOnElement(postButton);
		actualStatusFAQ = driver.getTextFromElement(statusOfFAQ);
		log.info("**************************** :"+actualStatusFAQ);
				
	} catch (Exception e) {
		log.error("Failed to go Add place");
		throw new FrameworkException(e.toString());
	}
	log.info("End Method for - goToAddPlaces");
	return actualStatusFAQ;
}
public String goToModifyExistedFAQPost(String faqQuestion){
	String actualStatusFAQ;
	log.info("Start Method for - goToAddPlaces");
	try {
		driver.clickOnElement(By.xpath(String.format(editFAQ, faqQuestion)));
		driver.wait(WAIT_SMALL);
		driver.typeText(faqTextBox, "_Modified ?");
		driver.typeText(answerTextBox, "_Modified.");
		driver.clickOnElement(postButton);
		actualStatusFAQ = driver.getTextFromElement(statusOfFAQ);
		log.info("**************************** :"+actualStatusFAQ);
				
	} catch (Exception e) {
		log.error("Failed to go Add place");
		throw new FrameworkException(e.toString());
	}
	log.info("End Method for - goToAddPlaces");
	return actualStatusFAQ;
}

}


