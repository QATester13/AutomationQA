package com.pom.openBrowser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllElements03 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\Executable\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();

		cdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cdriver.manage().window().maximize();

		cdriver.get("https://www.amazon.in/");

		List<WebElement> categories = cdriver.findElements(By.cssSelector("#nav-xshop>a"));

		System.out.println("Count of Categories:" + categories.size());
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).isDisplayed()) {
				System.out.println(categories.get(i).getText());
			} else {
				System.out.println("With InnerHTML attribute :" + categories.get(i).getAttribute("innerHTML"));
			}
		}

	}

}
