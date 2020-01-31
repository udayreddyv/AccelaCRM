package com.accelacrm.test.framework.selenium;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


import com.accelacrm.test.framework.selenium.exception.FrameworkException;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class DefaultWebDriver {

    private static final Logger log = LogManager.getLogger(DefaultWebDriver.class);
    private final WebDriver driver;
    private String exceptionMessage;
    String getTextDetails;//name may change
    List<String> elementText;
    

    public DefaultWebDriver(WebDriver driver) {
        this.driver = driver;
    }

	/**
	 * openURL : To open URL
	 * @param url : URL in string format
	 */
	public void openURL(String url) {
		try {
			log.info("Opening url : " + url);
			driver.get(url);
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.info("URL exception : "+exceptionMessage);
			log.error(String.format("Failed to open url %s", url));
		}
	}

	/**
	 * getCurrentUrl : To get current URL
	 * @return returns current URL
	 */
	public String getCurrentUrl() {
		String currentUrl = "";
		try {
			currentUrl = driver.getCurrentUrl();
			log.info("Current url : " + currentUrl);
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Failed to get current url"));
		}
		return currentUrl;
	}

	/**
	 * click : To click on web element
	 * @param element : element as By class object
	 */
	public void clickOnElement(By element) {
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(2));
		try {
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					WebElement webElement = driver.findElement(element);
					if (webElement.isEnabled() && webElement.isDisplayed()) {
						webElement.click();
						return true;
					} else
						return false;

				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			exceptionMessage = ex.getMessage();
			log.error(String.format("Failed to click on element %s", element));
			throw new FrameworkException(ex.toString());
		}
	}

	/**
	 * typeText : To enter text to text field
	 * @param element : element as By class object
	 * @param text    : text in string format
	 */
	public void typeText(By element, String text) {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(2));
		try {
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					WebElement webElement = driver.findElement(element);
					if (webElement.isEnabled() && webElement.isDisplayed()) {
						webElement.sendKeys(text);
						return true;
					} else
						return false;

				}
			});
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Failed to enter text on element %s", element));
		}
	}
    
	/**
	 * selectByVisibleText : To select value from drop down by visible text
	 * @param element : element as By class object
	 * @param option  : option in string format
	 */
	public void selectByVisibleText(By element, String option) {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(2));
		try {
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					Select ulbNameDropdown = new Select(driver.findElement(element));
					ulbNameDropdown.selectByVisibleText(option);
					if (((WebElement) ulbNameDropdown).isEnabled() && ((WebElement) ulbNameDropdown).isDisplayed()) {
						ulbNameDropdown.selectByVisibleText(option);
						return true;
					} else
						return false;

				}
			});
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Failed to enter text on element %s", element));
		}
	}

	/**
	 * selectDate : To select date from date picker
	 * 
	 * @param yearElemenet : element as By class object
	 * @param monthElement : element as By class object
	 * @param dateDiv      : element as By class object
	 * @param year         : year in string format
	 * @param month        : month in string format
	 * @param date         : date in string format
	 */
	public void selectDate(By yearElemenet, By monthElement, By dateDiv, String year, String month, String date) {
		try {
			// Year
			selectByVisibleText(yearElemenet, year);
			// Month
			selectByVisibleText(monthElement, month);
			// Date
			List<WebElement> allDatesCallandor = driver.findElements(dateDiv);
			for (WebElement element : allDatesCallandor) {
				String elementDateText = element.getText();
				if (elementDateText.equalsIgnoreCase(date)) {
					element.click();
					break;
				}
			}
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error("Failed to select date from date picker");
		}

	}

	/**
	 * getTextFromElement : To get Text from element
	 * @param element : element as By class object
	 * @return : returns text as string format
	 */
	public String getTextFromElement(By element) {

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(2));
		try {
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					WebElement webElement = driver.findElement(element);
					if (webElement.isEnabled() && webElement.isDisplayed()) {
						getTextDetails = webElement.getText();
						return true;
					} else
						return false;

				}
			});
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Failed to getText  %s", element));
		}
		return this.getTextDetails;
	}

	/**
	 * getAttribute : get attribute from web element
	 * @param element : element as By class object
	 * @return : returns text as string format
	 */
	String userName;

	public String getAttribute(By element) {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(2));
		try {

			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					WebElement webElement = driver.findElement(element);
					if (webElement.isEnabled() && webElement.isDisplayed()) {
						userName = webElement.getAttribute("value");
						return true;
					} else
						return false;

				}
			});
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Failed to click on element %s", element));
		}
		return userName;
	}

	/**
	 * switchToFrame : switch to frame from default frame
	 * @param frameName : frameName as string format
	 */
	public void switchToFrame(String frameName) {

		try {
			driver.switchTo().frame(frameName);
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Unable to switc to frame  %s", frameName));
		}
	}

	/**
	 * acceptAlert : To switch acceptAlert from popUp
	 */
	public void acceptAlert() {

		try {
			driver.switchTo().alert().accept();
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Unable to switc to alert %s"));
		}
	}
	/**
	 * waitForAlert : To wait for Alert after file upload
	 */
	public void waitForAlert() {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(2));
		try {
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					try 
				    { 
				        driver.switchTo().alert(); 
				        return true; 
				    } 
				    catch (NoAlertPresentException Ex) 
				    { 
				        return false; 
				    }

				}
			});
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
		}
	}

	/**
	 * getTextFromPopupAlert : To get text from popUp alert
	 * @return : returns text as string format
	 */
	public String getTextFromPopupAlert() {
		String uploadStatus;
		try {
			Alert alert = driver.switchTo().alert();
			uploadStatus = alert.getText();
		} catch (Exception ex) {
			uploadStatus = ex.getMessage();
			log.error(String.format("Unable to switc to alert %s"));
		}
		return uploadStatus;
	}
	
	/**
	 * navigateToUrl : To navigate URL from one to other
	 * @param url : URL as string format
	 */

	public void navigateToUrl(String url) {

		try {
			driver.navigate().to(url);
			;
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Unable to switc to alert %s"));
		}
	}

	/**
	 * navigateToBack : navigate To Back
	 */
	public void navigateToBack() {

		try {
			driver.navigate().back();
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Unable to switc to alert %s"));
		}
	}

	/**
	 * isElementPresentAndVisible : To verify whether element is present or not
	 * @param element : element as By object
	 * @return returns present and visible status
	 */
	public boolean isElementPresentAndVisible(By element) {
		log.info("Checking for element visible status");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(2));
		WebElement webElement = null;
		boolean isPresentAndVisible = false;
		try {
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					WebElement webElement = driver.findElement(element);
					if (webElement.isEnabled() && webElement.isDisplayed()) {
						return true;
					} else
						return false;

				}
			});
			webElement = driver.findElement(element);
			isPresentAndVisible = webElement.isEnabled() && webElement.isDisplayed();
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Element %s is not found", element));
		}

		return isPresentAndVisible;
	}

	/**
	 * wait : To Wait until by given time
	 * @param waitTime : waitTime in integer format
	 */
	public void wait(int waitTime) {
		log.info(String.format("Waiting %s seconds", waitTime));
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Failed to wait %s seconds", waitTime));
		}
	}
	/**
	 * takeSnapShot : To take screenshot
	 * @param fileWithPath : file path as String format
	 * @throws Exception
	 */
	public void takeSnapShot(String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }
	
	/**
	 * quitDriver : To quit webBrowser
	 */
	public void quitDriver()
	{
		driver.quit();
	}

	/**
	 * clearTextBox : To clear text box
	 * @param element : element is By class object
	 */
	public void clearTextBox(By element) {

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(2));
		try {
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					WebElement webElement = driver.findElement(element);
					if (webElement.isEnabled() && webElement.isDisplayed()) {
						webElement.clear();
						return true;
					} else
						return false;

				}
			});
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Failed to getText  %s", element));
		}
	}

	/**
	 * getElementsText :To get text from elements
	 * @param element : element is By class object
	 * @return : returns list as string format
	 */

	public List<String> getElementsText(By element) {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))
				.pollingEvery(Duration.ofMillis(2));
		try {
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver webDriver) {
					List<WebElement> webElements = driver.findElements(element);
					elementText = new ArrayList<String>();

					for (WebElement webElement : webElements) {
						if (webElement.isEnabled() && webElement.isDisplayed()) {
							getTextDetails = webElement.getText();
							log.info(String.format("Element text is %s", getTextDetails));
							elementText.add(getTextDetails);
						} else {
							return false;
						}

					}
					return true;

				}
			});
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
			log.error(String.format("Failed to getText  %s", element));
		}
		return this.elementText;
	}

}
