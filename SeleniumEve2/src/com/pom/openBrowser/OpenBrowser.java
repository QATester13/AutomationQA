package com.pom.openBrowser;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenBrowser {

	public static void main(String[] args) {
		// opening chrome browser

		System.setProperty("webdriver.chrome.driver",
				"E:\\Setup\\Automation\\SeleniumEve2\\Executable\\chromedriver.exe");

		ChromeDriver cdriver = new ChromeDriver();

		// opening Internet Explorer browser

		// System.setProperty("webdriver.ie.driver",
		// ".\\Executable\\IEDriverServer.exe");

		// create an object of InternetExplorerDriver class to open IE browser

		// InternetExplorerDriver idriver=new InternetExplorerDriver();

		// Enter required URL
		cdriver.get("https://www.google.com");

		// print source code
		System.out.println("Page source: " + cdriver.getPageSource());

		// current page title
		System.out.println("Current Page Title: " + cdriver.getTitle());

		// current page URL
		System.out.println("Current Page URL:" + cdriver.getCurrentUrl());

		// closing the physical Instance
		cdriver.close();
		

	}

}
