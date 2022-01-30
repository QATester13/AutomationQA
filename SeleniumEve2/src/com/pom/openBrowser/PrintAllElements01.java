package com.pom.openBrowser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllElements01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\Executable\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();

		cdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cdriver.manage().window().maximize();

		cdriver.get("http://demo.automationtesting.in/Register.html");

		List<WebElement> categories = cdriver
				.findElements(By.cssSelector("div[class='navbar-collapse collapse navbar-right']>ul>li>a"));

		System.out.println("Category count:" + categories.size());

		for (int i = 0; i < categories.size(); i++) {
			System.out.println(categories.get(i).getText());
		}

	}

}
