package SeleniumAssignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actiTime_XPath {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FileInputStream data = new FileInputStream(".\\TestData\\actiTime.properties");
		Properties Prop = new Properties();
		Prop.load(data);
		driver.get(Prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Prop.getProperty("UserName"));
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(Prop.getProperty("Pass"));
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();

		WebElement TaskBtn = driver.findElement(By.xpath("//div[@id='container_tasks']"));
		System.out.println(TaskBtn.isDisplayed() + ":" + TaskBtn.isEnabled() + ":" + TaskBtn.isSelected());
		TaskBtn.click();
		WebElement AddNewBtn = driver.findElement(By.xpath("//div[text()='Add New']"));
		AddNewBtn.click();
		System.out.println(AddNewBtn.isSelected() + ":" + AddNewBtn.isEnabled() + ":" + AddNewBtn.isDisplayed());
		WebElement NewTask = driver
				.findElement(By.xpath("//div[@class='item createNewTasks']"));
		NewTask.click();
		System.out.println(NewTask.isDisplayed() + ":" + NewTask.isEnabled() + ":" + NewTask.isSelected());
		driver.findElement(By.cssSelector("div[class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']")).click();
		driver.findElement(By.cssSelector("div[class='scrollableDropdownView']>div>div>div>div:nth-child(4)")).click();
		driver.findElement(By.cssSelector("div[class=\"projectSelector customerOrProjectSelector selectorWithPlaceholderContainer\"]")).click();
		driver.findElement(By.cssSelector("")).click();
		driver.findElement(By.cssSelector("div[class='taskTableContainer']>table>tbody>tr:nth-child(1)>td:nth-child(1)>input")).sendKeys("Testing");
		driver.findElement(By.cssSelector("div[class='taskTableContainer']>table>tbody>tr:nth-child(1)>td:nth-child(5)>div:nth-child(2)>div")).click();
		driver.findElement(By.cssSelector("div[class='taskTableContainer']>table>tbody>tr:nth-child(1)>td:nth-child(5)>div:nth-child(1)>div>div>div:nth-child(1)>div>div:nth-child(11)>div")).click();
        driver.findElement(By.xpath("//div[text()=\"Create Tasks\"]")).click();
        
	}

}
