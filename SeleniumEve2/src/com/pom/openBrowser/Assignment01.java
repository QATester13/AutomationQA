package com.pom.openBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment01 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Executable\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();
		cdriver.get(" https://demoqa.com/automation-practice-form");

		cdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		cdriver.manage().window().maximize();

		WebElement Name = cdriver.findElement(By.id("userName-label"));
		cdriver.findElement(By.id("firstName")).sendKeys("Akshay");
		cdriver.findElement(By.id("lastName")).sendKeys("Bundele");

		WebElement Email = cdriver.findElement(By.id("userEmail-label"));
		cdriver.findElement(By.id("userEmail")).sendKeys("ak56bundele@gmail.com");

		WebElement Gender = cdriver.findElement(By.className("col-md-3"));
		System.out.println("Gender is Displayed:" + Gender.isDisplayed());

		WebElement Male = cdriver.findElement(By.className("custom-control-label"));
		System.out.println("Male Radio button :" + Male.isDisplayed());
		Male.click();
		System.out.println("Male radio button is Enabled:" + Male.isEnabled());

		WebElement MobNumber = cdriver.findElement(By.id("userNumber-label"));
		cdriver.findElement(By.id("userNumber")).sendKeys("54654654126");
		System.out.println("MOBILE NUMBER IS DISPLAYED:" + MobNumber.isDisplayed());

		WebElement Subjects = cdriver.findElement(By.id("subjects-label"));
		cdriver.findElement(By.id("subjects-label"));
		cdriver.findElement(By.id("subjectsInput")).sendKeys("Hide & Seek");
		
		Thread.sleep(2000);

		WebElement Hobbies = cdriver.findElement(By.id("subjects-label"));
		WebElement checkbox3=cdriver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
		System.out.println("Hobbies:" + Hobbies.isDisplayed());
		System.out.println("Using input for only selected: "+Hobbies.isSelected()+":  "+Hobbies.isDisplayed()+": "+checkbox3.isEnabled());
		checkbox3.click();

		WebElement Music = cdriver.findElement(By.className("custom-control-label"));
		System.out.println("Music radio Button: " + Music.isDisplayed());
		Music.click();
		System.out.println("Music Radio Buton is ENabled: " + Music.isEnabled());

		WebElement CurrentAddress = cdriver.findElement(By.id("currentAddress-label"));
		cdriver.findElement(By.id("currentAddress-label"));
		cdriver.findElement(By.id("currentAddress")).sendKeys("Hi I'm Tom let's Catch Jerry");
		
		Thread.sleep(2000);
		
		//scrolling
		cdriver.findElement(By.xpath("//body")) .sendKeys(Keys.chord(Keys.CONTROL,Keys.END));

		WebElement SubmitBtn = cdriver.findElement(By.id("submit"));
//		cdriver.findElement(By.className("btn btn-primary"));
		
		System.out.println("Submit button is Enabled: " + SubmitBtn.isEnabled());
		SubmitBtn.click();

		cdriver.navigate().to("https://www.google.com");

	}

}
