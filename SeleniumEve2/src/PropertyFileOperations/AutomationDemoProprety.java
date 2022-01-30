package PropertyFileOperations;

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

public class AutomationDemoProprety {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\TestData\\AutomationDemo.properties");

		Properties prop = new Properties();

		prop.load(fis);
		System.out.println(prop.getProperty("chromedriverkey") + "-->" + prop.getProperty("chromedrivervalue"));
		System.setProperty(prop.getProperty("chromedriverkey"), prop.getProperty("chromedrivervalue"));
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      
		driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.cssSelector("div [class='col-md-8 col-xs-8 col-sm-8']>textarea")).sendKeys(prop.getProperty("address"));
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.cssSelector("input[type='tel']")).sendKeys(prop.getProperty("phone"));
		driver.findElement(By.cssSelector("input[value='Male']")).click();
		driver.findElement(By.cssSelector("input[value='Movies']")).click();
		driver.findElement(By.cssSelector("input[id='checkbox3']")).click();
//		driver.findElement(By.cssSelector("ul[class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']']")).sendKeys("English");
		driver.findElement(By.cssSelector("input[id='firstpassword']")).sendKeys("pass");
		driver.findElement(By.cssSelector("input[ng-model='CPassword']")).sendKeys("cpass");
		WebElement dropdown1=driver.findElement(By.id("Skills\""));
		Select selectdrop1=new Select(dropdown1);
		List<WebElement> options1=selectdrop1.getOptions();
		System.out.println("skills Options count:"+ options1.size());
		selectdrop1.selectByValue("Java");
		
		driver.navigate().to("https://www.google.com");

		
		
		
	}

}
