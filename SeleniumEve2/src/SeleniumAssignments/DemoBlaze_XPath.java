package SeleniumAssignments;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoBlaze_XPath {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(
				".\\TestData\\DemoBlaze.properties");
		Properties Prop = new Properties();
		Prop.load(fis);
		driver.get("https://www.demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<WebElement> Categories = driver.findElements(By.xpath("//*[text()='CATEGORIES']//following-sibling::a"));
		System.out.println("Phone Count:" + Categories.size());

		for (int i = 0; i < Categories.size(); i++) {
			System.out.println(Categories.get(i).getText());

			List<WebElement> Phones = driver.findElements(By.xpath("//div[@id='tbodyid']//following::h4//a"));
			// System.out.println("Phone count:"+ Phones.size());

			List<WebElement> Price = driver.findElements(By.xpath("//div[@id='tbodyid']//following::h5"));
			// System.out.println("Price count:"+ Price.size());
			for (int j = 0; j < Phones.size(); j++) {
				for (int k = 0; k < Price.size(); k++) {

				}
				System.out.println(Phones.get(j).getText() + " : " + Price.get(j).getText());
			}
			Thread.sleep(2000);
			WebElement NextBtn = driver.findElement(By.cssSelector("button[id='next2']"));
			NextBtn.click();
			System.out.println("*******************************************************************");
			Thread.sleep(5000);
			List<WebElement> Page2 = driver.findElements(By.xpath("//div[contains(@id,'tbodyid')]//following::h4//a"));
//            System.out.println("Page2 count:" + Page2.size() );
			List<WebElement> Price2 = driver.findElements(By.xpath("//div[contains(@class,'row')]//following::h5"));
//            System.out.println(Price2.size());
			for (int l = 0; l < Page2.size(); l++) {
				for (int m = 0; m < Price2.size(); m++) {

				}

				System.out.println(Page2.get(l).getText() + ":" + Price2.get(l).getText());
			}
		}
	}

}
