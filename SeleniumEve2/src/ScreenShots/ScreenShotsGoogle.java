package ScreenShots;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sun.javafx.util.Utils;

import SeleniumUtils.SeleniumUtils1;

public class ScreenShotsGoogle extends SeleniumUtils1 {

	public static void main(String[] args) {
		WebDriver driver = Utils.setUp("chrome", "https://www.google.com");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./screenshots/googleSearchPage.jpg"));
	}

}
