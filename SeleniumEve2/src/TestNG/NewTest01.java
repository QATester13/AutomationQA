package TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest01 {
	WebDriver driver;
	Properties prop;

	@Test(priority = 0)
	public void startUp() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@BeforeTest
	public void propertyfile() throws IOException {
		FileInputStream fis = new FileInputStream(".\\TestData\\actiTime2.properties");
		prop = new Properties();
		prop.load(fis);

	}

	@Test(priority = 1)
	public void LoginBrowser() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//a[@id='loginButton' ]")).click();
		String pagetitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		Assert.assertEquals(pagetitle, expectedTitle);
	}

	@Test(priority = 2)
	public void createandverifytask() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
		driver.findElement(By.xpath("//div[@class='addNewButton']")).click();
		driver.findElement(By.xpath("//div[@class='item createNewTasks']")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[2]/div/div[1]/div/div[text()='Galaxy Corporation']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[2]/div/div[1]/div/div[text()='Android testing']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='taskTableContainer']/table/tbody/tr[1]/td/input"))
				.sendKeys("TestNG");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='taskTableContainer']/table/tbody/tr[1]/td[5]/div[2]/div")).click();

		driver.findElement(By.xpath(
				"//div[@class='taskTableContainer']/table/tbody/tr[1]/td[5]/div[1]/div/div/div[1]/div/div[11]/div"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='taskTableContainer']/table/tbody/tr[1]/td[6]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Create Tasks']")).click();
		WebElement TaskName = driver
				.findElement(By.xpath("//tr[@class='taskRow noLastTrackingDate']/td[2]/div/div/div[1]/div[2]"));
		Assert.assertTrue(TaskName.isDisplayed());
	}

	@Test(priority = 3)
	public void deleteAndVerifyTask() {
		driver.findElement(By.xpath("//div[@class='tasksTablesWrapper']/div[1]/table/tbody/tr/td[1]/div/div")).click();
		driver.findElement(By.xpath("//div[@class='delete button'] [text()='Delete']")).click();
		driver.findElement(By.xpath("//span[@class='submitTitle buttonTitle'] [text()='Delete permanently']")).click();

	}

	@AfterTest
	public void logOutBrowserAndClose() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='logoutLink' and @class='logout']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
