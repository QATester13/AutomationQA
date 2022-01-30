package com.pom.openBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiTimeLogin {

	public static void main(String[] args) {

		// Step1: open browser
		System.setProperty("webdriver.chrome.driver", ".\\Executable\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		// Step2: enter required URL
		driver.get("https://demo.actitime.com/login.do");

		// implicit wait: Interface->Interface->Interface->abstract method*/
		/* WebDriver->Manage->Timeouts->implicitlyWait */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		// Step3: login page title
		System.out.println("Page title before login: " + driver.getTitle());
		
		
		//Step4: locate username field, 0-20 sec---> 2secs 
		driver.findElement(By.id("username")).sendKeys("admin");
		
		
		// Step5: locate password field, 0-20 sec ----> 10secs 
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
		
		// Step6: locate login button 0-20sec --->9 sec 
		driver.findElement(By.id("loginButton")).click();

		WebElement logoutLink = driver.findElement(By.linkText("Logout"));
		// explicit wait--> WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
		
		
		// step7:
		System.out.println("Page title after login: " + driver.getTitle());
		
		
		// Step8: identify logout button and click on it, 0-20 seconds
		logoutLink.click();
		
		
		// Step9:
		driver.close();
		
	}

}
