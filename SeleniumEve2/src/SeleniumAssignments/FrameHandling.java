package SeleniumAssignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class FrameHandling {
	WebDriver driver;
	Properties prop;

	@Test(priority = 0)
	public void LoginAndVerify() {
		driver.get(prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String Actual = "STORE";
		String Expected = Actual;
		Assert.assertEquals(Actual, "STORE");

	}

	@Test(priority = 1)
	public void Task1() throws InterruptedException {
		List<WebElement> Categories = driver.findElements(By.xpath("//div[@id='tbodyid']//div/div//div/h4/a"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@id='tbodyid']//following::h5"));
		System.out.println("category count:" + Categories.size());

		for (int i = 0; i < Categories.size(); i++) {
			for (int j = 0; j < price.size(); j++) {

			}
			System.out.println(Categories.get(i).getText() + ":" + price.get(i).getText());
		}
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void Task2() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='page-link' and @id='next2']")).click();
		Thread.sleep(5000);

		List<WebElement> Page2 = driver.findElements(By.xpath("//div[@id='tbodyid']//following::h4//a"));
		List<WebElement> price2 = driver.findElements(By.xpath("//div[@id='tbodyid']//following::h5"));
		System.out.println("Page2 count:"+Page2.size());
		for (int k = 0; k < Page2.size(); k++) {
			for (int l = 0; l < price2.size(); l++) {

			}
			System.out.println(Page2.get(k).getText() + ":" + price2.get(k).getText());
		}
		Thread.sleep(5000);
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\TestData\\DemoBlaze.properties");
		prop.load(fis);
	}

}
