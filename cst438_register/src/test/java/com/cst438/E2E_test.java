package com.cst438;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class E2E_test {
	public static final String CHROME_DRIVER_FILE_LOCATION 
                          = "C:/Users/Anna/selenium/chromedriver.exe";
	public static final String URL = "http://localhost:3000/admin";
	public static final String NAME = "Test Student";
	public static final String EMAIL = "atestemail9@wwwmail.org";
	
	public static final int SLEEP_DURATION = 1000; // 1 second.


	@Test
	public void addStudent() throws Exception {


		// set the driver location and start driver
		//@formatter:off
		//
		// browser	property name 				Java Driver Class
		// -------  ------------------------    ----------------------
		// Edge 	webdriver.edge.driver 		EdgeDriver
		// FireFox 	webdriver.firefox.driver 	FirefoxDriver
		// IE 		webdriver.ie.driver 		InternetExplorerDriver
		// Chrome   webdriver.chrome.driver     ChromeDriver
		//
		//@formatter:on


		//TODO update the property name for your browser 
		System.setProperty("webdriver.chrome.driver",
                     CHROME_DRIVER_FILE_LOCATION);
		//TODO update the class ChromeDriver()  for your browser
		// For chromedriver 111 need to specify the following options 
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");	


	           WebDriver driver = new ChromeDriver(ops);
	           //////UNUSED//////
		//TODO update the class ChromeDriver()  for your browser
		//WebDriver driver = new ChromeDriver();
	           //////       //////
		try {
			WebElement we;
			
			driver.get(URL);
			// must have a short wait to allow time for the page to download 
			Thread.sleep(SLEEP_DURATION);

			// enter the answer.  
			// find the input tag with name="attempt"
			we = driver.findElement(By.id("AddStudent1"));
			we.click();
			Thread.sleep(SLEEP_DURATION);
			
			we = driver.findElement(By.name("name"));
			we.sendKeys(NAME);
			
			// enter an alias name
			we = driver.findElement(By.name("email"));
			we.sendKeys(EMAIL);
			
			// find and click the submit button
			we = driver.findElement(By.id("Add"));
			we.click();
			Thread.sleep(SLEEP_DURATION);
			
			// verify the correct message
			we = driver.findElement(By.id("message"));
			String message = we.getText();
			assertTrue(message.startsWith("Student id="));
			
			// find and click the submit button
			we = driver.findElement(By.id("Close"));
			we.click();
			Thread.sleep(SLEEP_DURATION);
			

			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
			
		} finally {
			driver.close();
			driver.quit();
		}
	}
		
		@Test
		public void addBadStudent() throws Exception {


			System.setProperty("webdriver.chrome.driver",
                                         CHROME_DRIVER_FILE_LOCATION);
		//TODO update the class ChromeDriver()  for your browser
		// For chromedriver 111 need to specify the following options 
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");	
				
		WebDriver driver = new ChromeDriver(ops);	
			
			//WebDriver driver = new ChromeDriver();
			
			try {
				WebElement we;
				
				driver.get(URL);
				// must have a short wait to allow time
                             //  for the page to download 
				Thread.sleep(SLEEP_DURATION);

			
				we = driver.findElement(By.id("AddStudent1"));
				we.click();
				Thread.sleep(SLEEP_DURATION);
				
				we = driver.findElement(By.name("name"));
				we.sendKeys(NAME);
				
				// enter an alias name
				we = driver.findElement(By.name("email"));
				we.sendKeys(EMAIL);
				
				// find and click the submit button
				we = driver.findElement(By.id("Add"));
				we.click();
				Thread.sleep(SLEEP_DURATION);
				
				// verify the correct message
				 we = driver.findElement(By.id("message"));
				 String message = we.getText();
				 assertEquals("Add failed. Email already exists. rc=400", message);
				
				// find and click the submit button
				we = driver.findElement(By.id("Close"));
				we.click();
				Thread.sleep(SLEEP_DURATION);
				

				
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
				
			} finally {
				driver.close();
				driver.quit();
			}

	}
}