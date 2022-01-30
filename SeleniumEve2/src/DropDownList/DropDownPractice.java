package DropDownList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Executable\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();
		cdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cdriver.manage().window().maximize();

		cdriver.get("https://courses.letskodeit.com/practice");

		WebElement c1 = cdriver.findElement(By.id("carselect"));
		Select Skillselect = new Select(c1);

		System.out.println("Dropdown is multiSelect or not:" + Skillselect.isMultiple());
		System.out.println("Selected options:" + Skillselect.getFirstSelectedOption().getText());

		List<WebElement> Options = Skillselect.getOptions();

		System.out.println("Options count: " + Options.size());

		for (int i = 0; i < Options.size(); i++) {
			System.out.println(Options.get(i).getText());
		}
		Skillselect.selectByIndex(2);
		System.out.println("Selected option:" + Skillselect.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		Skillselect.selectByValue("benz");
		System.out.println("Selected OPtions:" + Skillselect.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		Skillselect.selectByVisibleText("BMW");
		System.out.println("Selected OPtions:" + Skillselect.getFirstSelectedOption().getText());
		System.out.println("**********************************************************************");

		WebElement multiSelect = cdriver.findElement(By.id("multiple-select-example"));
		Select Mselect = new Select(multiSelect);
		System.out.println("MultiSelect:" + Mselect.isMultiple());
		for (int i = 0; i < Mselect.getOptions().size(); i++) {
			System.out.println(Mselect.getOptions().get(i).getText());
		}
		Thread.sleep(2000);
		Mselect.selectByIndex(1);

		Thread.sleep(2000);
		Mselect.selectByVisibleText("peach");
		System.out.println("SelectOptions:" + Mselect.getAllSelectedOptions().size());
		for (int i = 0; i < Mselect.getAllSelectedOptions().size(); i++) {
			System.out.println(Mselect.getAllSelectedOptions().get(i).getText());
		}
		Thread.sleep(2000);
		Mselect.deselectAll();

	}

}
