package DropDownList;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown01 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\Executable\\chromedriver.exe");

		WebDriver cdriver = new ChromeDriver();

		cdriver.get("https://omayo.blogspot.com/");

		cdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		cdriver.manage().window().maximize();

		// identify dropdown
		WebElement dropdown = cdriver.findElement(By.id("drop1"));

		// create the instace of select class by pass dropdown to its constructor
		Select skillSelect = new Select(dropdown);

		// isDisplay(),isEnabled()
		System.out.println("Is Dropdown is Selected or Not: " + skillSelect.isMultiple());
		System.out.println("Selected Options:" + skillSelect.getFirstSelectedOption().getText());

		List<WebElement> options = skillSelect.getOptions();
		System.out.println("Options Count:" + options.size());

		// print all the option names
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());

		}
		// or
//		System.out.println("Options Count:" + skillSelect.getOptions().size());
//		for (int i = 0; i < ((List<WebElement>) skillSelect).size(); i++) {
//			System.out.println(skillSelect.getOptions().get(i).getText());
		}

	}


