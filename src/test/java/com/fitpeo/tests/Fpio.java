package com.fitpeo.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Fpio {
	@Test
	public static void main(String[] args) throws Exception {
		ScreenRecorderUtil.startRecord("main"); // This is for Screen recording
		Thread.sleep(2000);
		WebDriver driver = new ChromeDriver();
		
		// Navigate to the FitPeo Home page:
		/*Here i'm using Thread.sleep for observing the flow of test script while running */
		
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		// Navigate to the Revenue Calculator Page:
		
		driver.findElement(By.linkText("Revenue Calculator")).click();
		Thread.sleep(2000);
		
		// Scroll Down to the Slider section:	
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,450);");
		Thread.sleep(1000);
		
		// Moving the slider to 823 Value

		/* NOTE - "I'm trying to move the slider position to 820,but it doesn't
		 adjust to the specific value. There, i'm using 823 as an alternative.*/

		Actions actions = new Actions(driver);
		WebElement sliderTxtField = driver.findElement(By.cssSelector(".MuiInputBase-root input"));
		WebElement slider = driver.findElement(By.xpath("//span[@data-index=\"0\"]"));
		jse.executeScript("window.scrollTo(0,450);");
		actions.clickAndHold(slider).moveByOffset(94, 0).release().perform();
		Thread.sleep(1000);

		// Checking slider Text Filed is updated or Not: 

		String finalValue = sliderTxtField.getAttribute("value");
		//System.out.println(finalValue);
		String initialValue ="200";
		if (finalValue != initialValue) {
			System.out.println("Text filed is updated corresponding to the slider position: ");

		} else {
			System.out.println("Text filed is not updated: ");
		}

		Thread.sleep(3000);

		// Updating the Text Field:

		actions.click(sliderTxtField).perform();
		sliderTxtField.sendKeys(Keys.CONTROL + "a"); // Select all text
		sliderTxtField.sendKeys(Keys.BACK_SPACE); // Delete the selected text
		Thread.sleep(3000);
		String value = "560";
		actions.sendKeys(sliderTxtField, value).perform();

		// Validating Slider Value:

		String sBoxActual = driver.findElement(By.xpath("//input[@type=\"range\"]")).getAttribute("aria-valuenow");
		System.out.println("Your entered 560 in the Slider text filed: "+sBoxActual);
		String sBoxExpected = "560";
		Assert.assertEquals(sBoxActual, sBoxExpected);

		Thread.sleep(1000);
		actions.click(sliderTxtField).perform();
		sliderTxtField.sendKeys(Keys.CONTROL + "a"); // Select all text
		sliderTxtField.sendKeys(Keys.BACK_SPACE); // Delete the selected text
		Thread.sleep(3000);

		actions.sendKeys(sliderTxtField,"820").perform();
		jse.executeScript("window.scrollTo(0,850);");

		// Selecting CPT Codes:

		String[]cptCodes = {"CPT-99091","CPT-99453","CPT-99454","CPT-99474"};
		for (String cptCode : cptCodes) {
			String locater = "//p[text()='"+cptCode+"']/parent::div/descendant::input";

			driver.findElement(By.xpath(locater)).click();
		} 

		// Validating Total Recurring Reimbursement:

		String expectedValue = "$110700";
		String actualValue = driver.findElement(By.xpath("//p[text()=\"Total Recurring Reimbursement for all Patients Per Month:\"]/p")).getText();
		System.out.println("Total Recurring Reimbursement based on the CPT codes your selected: "+actualValue);
		Assert.assertEquals(expectedValue, actualValue);
		Thread.sleep(5000);
		driver.close();
		ScreenRecorderUtil.stopRecord();
	}


}