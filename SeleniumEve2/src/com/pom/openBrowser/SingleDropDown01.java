package com.pom.openBrowser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleDropDown01 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\Executable\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();

		cdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		cdriver.manage().window().maximize();

		cdriver.get("https://www.gsmarena.com/");

		List<WebElement> phoneCategories = cdriver
				.findElements(By.cssSelector("div[class='brandmenu-v2 light l-box clearfix']>ul>li>a"));

		System.out.println("Count of Phone Categories:" + phoneCategories.size());

		for (int i = 0; i < phoneCategories.size(); i++) {
			System.out.println(phoneCategories.get(i).getText());
		}
		System.out.println(
				"************************************************************************************************");
		cdriver.findElement(By.cssSelector("div[class='brandmenu-v2 light l-box clearfix'] li:nth-child(1)>a")).click();
		List<WebElement> samsungBtn = cdriver.findElements(By.cssSelector("div[class='makers']>ul>li>a "));

		System.out.println("Count of Samsung Phones:" + samsungBtn.size());

		for (int i = 0; i < samsungBtn.size(); i++) {
			System.out.println(samsungBtn.get(i).getText());
		}
		
		

	}

}
