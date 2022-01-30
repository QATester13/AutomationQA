package SeleniumAssignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class FlipKart {
	WebDriver driver;
	Properties prop;

	@Test(priority = 0)
	public void LoginAndVerify() {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
	}

	@Test(priority = 1)
	public void PrintAllElements() {
		List<WebElement> Categories = driver.findElements(By.cssSelector("div[class='_37M3Pb'] div:nth-of-type(2)"));
		System.out.println("Categories count:" + Categories.size());
		for (int i = 0; i < Categories.size(); i++) {
			System.out.println(Categories.get(i).getText());
		}

	}

	@BeforeClass
	public void PropertyFiles() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream(".\\TestData\\FlipKart.proprties");
		prop = new Properties();
		prop.load(fis);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void CleanUp() {
		driver.findElement(By.className("exehdJ")).click();

	}

}
