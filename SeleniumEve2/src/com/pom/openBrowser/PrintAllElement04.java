package com.pom.openBrowser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllElement04 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\Executable\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();
		
		cdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		cdriver.manage().window().maximize();
		
		cdriver.get("https://www.espncricinfo.com/");
		
		List<WebElement> mainMenuOptions= cdriver.findElements(By.cssSelector("ul[class='navbar-nav mr-auto']>li>a"));
		System.out.println("Main Menu Options Count:" + mainMenuOptions.size());
		
		for(int i=0; i<mainMenuOptions.size();i++) {
			System.out.println(mainMenuOptions.get(i).getText());
		}
		
		
	}

}
