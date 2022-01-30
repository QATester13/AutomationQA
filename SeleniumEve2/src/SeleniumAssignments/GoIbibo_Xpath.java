package SeleniumAssignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIbibo_Xpath {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement HotelsBtn = driver.findElement(By.xpath("//a[@href='/hotels/' and @class='nav-link']"));
		System.out.println(HotelsBtn.isDisplayed() + ":" + HotelsBtn.isSelected() + ":" + HotelsBtn.isEnabled());
		HotelsBtn.click();
//follow the same method but if you need to choose drop-down button then follow drop-down method
		driver.navigate().back();
        WebElement StudenrFareBtn=driver.findElement(By.xpath("//span[text()='Student Fare']"));
        StudenrFareBtn.click();
        System.out.println(StudenrFareBtn.isEnabled());
        
        WebElement SeniorCitizenBtn=driver.findElement(By.xpath("//span[text()='Senior Citizen fare']"));
        SeniorCitizenBtn.click();
        System.out.println(SeniorCitizenBtn.isEnabled());
        WebElement ADDSymbol=driver.findElement(By.xpath("//button[@id='adultPaxPlus']"));
        ADDSymbol.click();
        System.out.println(ADDSymbol.isDisplayed());
	}

}
