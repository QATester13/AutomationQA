package MouseAndKeyboard;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DrangAndDrop2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		// Switch to frame
//		driver.switchTo().frame(0);
//		WebElement from = driver
//				.findElement(By.className("ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle"));
//		WebElement To = driver.findElement(By.id("trash"));
//		Actions action = new Actions(driver);
//		action.dragAndDrop(from, To).build().perform();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
//		List<WebElement> from = driver
//				.findElements(By.cssSelector("li>.ui-widget-header"));
//		WebElement To = driver.findElement(By.xpath("//div[@id='trash']")); 
		Actions action = new Actions(driver);
//		action.dragAndDrop(from.get(0), To).build().perform();
//		WebElement from1=driver.findElement(By.xpath("//h5[text()='High Tatras 3']"));
//		WebElement target =driver.findElement(By.xpath("//div[@id='trash']"));
//		action.dragAndDrop(from1, To).build().perform();
//      WebElement from2=driver.findElement(By.xpath("//h5[text()='High Tatras 2']"));
//      WebElement target1=driver.findElement(By.xpath("//div[@id='trash']"));
//      action.dragAndDrop(from2, target1).build().perform();
//      WebElement from3=driver.findElement(By.xpath("//h5[text()='High Tatras 4']"));
//      WebElement target2=driver.findElement(By.xpath("//div[@id='trash']"));
//      action.dragAndDrop(from3, target2).build().perform();
//      WebElement Trash=driver.findElement(By.xpath(""));
//      driver.close();
		WebElement trash=driver.findElement(By.xpath("//div[@id='trash']"));
		List<WebElement> Images=driver.findElements(By.xpath("//ul[@class='gallery ui-helper-reset ui-helper-clearfix ui-droppable']/li"));
		System.out.println(Images.size());
		for(int i=0;i<Images.size();i++) {
			System.out.println(Images.get(i).getText());
			Thread.sleep(2000);
			action.dragAndDrop(Images.get(i),trash).build().perform();
			
			
		}
		driver.close();
	}
}
