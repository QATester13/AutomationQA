package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiTimeTask {
	WebDriver driver;
	Properties prop;

	@Test(priority = 0)
	public void propertyfile() throws IOException {
		FileInputStream fis = new FileInputStream(".\\TestData\\actiTime2.properties");
		prop = new Properties();
		prop.load(fis);
	}

	@Test(priority = 1)
	public void openBrowserAndLogin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		String pagetitle = driver.getTitle();

		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.cssSelector("input[type='password'][placeholder='Password']"))
				.sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector("a[id='loginButton']")).click();
		String expectedTitle = "actiTIME - Login";
		Assert.assertEquals(pagetitle, expectedTitle);
	}

	@Test(priority = 2)
	public void createAndVerifyTask() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[id='container_tasks']")).click();
		driver.findElement(By.className("addNewContainer")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='dropdownContainer addNewMenu']//div[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(
				"div[class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']>div>div:nth-child(1)>div:first-child"))
				.click();
		Thread.sleep(2000);
		// select galaxy
		driver.findElement(By.xpath(
				"//div[@class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[2]/div/div[1]/div/div[text()='Galaxy Corporation']"))
				.click();
		// proj selector
		driver.findElement(
				By.xpath("//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']"))
				.click();
		Thread.sleep(2000);
		// select android
		driver.findElement(By.xpath(
				"//div[@class='projectSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div[2]/div/div[1]/div/div[text()='Android testing']"))
				.click();

		Thread.sleep(2000);// enter task name
		driver.findElement(By.xpath("//div[@class='taskTableContainer']/table/tbody/tr[1]/td[1]/input"))
				.sendKeys("Testing Cases");
		Thread.sleep(2000);// click engg
		driver.findElement(By.xpath("//div[@class='taskTableContainer']/table/tbody/tr[1]/td[5]/div[2]/div")).click();
		Thread.sleep(2000);// select testing
		driver.findElement(By.xpath(
				"//div[@class='taskTableContainer']/table/tbody/tr[1]/td[5]/div[1]/div/div/div[1]/div/div[11]/div"))
				.click();
		Thread.sleep(2000);// click checkbox
		driver.findElement(By.xpath("//div[@class='taskTableContainer']/table/tbody/tr[1]/td[6]/label")).click();
		Thread.sleep(2000);// click create task
		driver.findElement(By.xpath("//div[@class='commitButtonPlaceHolder']/div/div[1]")).click();
		Thread.sleep(2000);// tttt
		WebElement taskname = driver
				.findElement(By.xpath("//tr[@class='taskRow noLastTrackingDate']/td[2]/div/div/div[1]/div[2]"));
		Assert.assertTrue(taskname.isDisplayed());
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void deleteAndVerifyTask() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='tasksTablesWrapper']/div[1]/table/tbody/tr/td[1]/div/div")).click();
		Thread.sleep(2000);// click delete
		driver.findElement(By.xpath("//div[@class='delete button'][text()='Delete']")).click();
		Thread.sleep(2000);// delete permanently
		driver.findElement(By.xpath(
				"//div[@class='dialogWithPointerWrapper deleteDialog']/div[1]/div[1]/div/div[5]/div[1]/div/span"))
				.click();
	}

	@Test(priority = 4)
	public void logoutAndClose() throws InterruptedException {
		driver.findElement(By.id("logoutLink")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
