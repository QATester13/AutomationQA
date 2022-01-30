package com.pom.openBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenFirefoxBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", ".\\Executable\\geckodriver.exe");
		FirefoxDriver Fdriver = new FirefoxDriver();
		Fdriver.get("https://www.facebook.com");
		Fdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Fdriver.manage().window().maximize();

		System.out.println(Fdriver.getTitle());
		System.out.println(Fdriver.getPageSource());
		System.out.println(Fdriver.getCurrentUrl());
		Fdriver.findElement(By.id("email")).sendKeys("ak56bundele@gmail.com");
		Fdriver.findElement(By.id("pass")).sendKeys("Rudra@@54321");
		
		Fdriver.findElement(By.name("login")).click();
		
		Fdriver.navigate().back();
		
		Fdriver.navigate().forward();
		
		Fdriver.navigate().refresh();

		Fdriver.navigate().to("https://www.google.com");
		
		Fdriver.navigate().back();
		
		WebElement logoutBtn=Fdriver.findElement(By.className("oajrlxb2"));
		Fdriver.findElement(By.className("d2edcug0"));
		logoutBtn.click();
		System.out.println("logout button is Enabled: "+ logoutBtn.isEnabled());
//		WebElement logoutlink = Fdriver.findElement(By.linkText("LogOut"));
//		WebDriverWait wait = new WebDriverWait(Fdriver, 20);
//		wait.until(ExpectedConditions.elementToBeClickable(logoutlink));
//		System.out.println("PageTitle After Login " + Fdriver.getTitle());
//		Fdriver.close();
		

	}

}
