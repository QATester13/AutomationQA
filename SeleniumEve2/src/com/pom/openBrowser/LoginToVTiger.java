package com.pom.openBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToVTiger {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",".\\Executable\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String loginTitle=driver.getTitle();
		
		
		System.out.println("Page Title before login: " + driver.getTitle());
		WebElement username=driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("admin");
		
		
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("Test@123");
		
		driver.findElement(By.className("button")).click();
		
		
		
		
		
		
	}

}
