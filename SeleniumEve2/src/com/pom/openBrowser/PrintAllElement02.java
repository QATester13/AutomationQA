package com.pom.openBrowser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllElement02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\Executable\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();

		cdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cdriver.manage().window().maximize();

		cdriver.get("https://www.flipkart.com/");

		List<WebElement> categories = cdriver.findElements(By.cssSelector("div[class='_37M3Pb'] div:nth-of-type(2)"));

		System.out.println("Count of Categories:" + categories.size());

		for (int i = 0; i < categories.size(); i++) {
			System.out.println(categories.get(i).getText());
		}

	}

}
