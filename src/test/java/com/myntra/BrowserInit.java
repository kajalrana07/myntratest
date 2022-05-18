package com.myntra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInit {

	public static WebDriver driver = null;

	@BeforeSuite
	public static void initbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}

	@AfterSuite
	public static void closebrowser() throws InterruptedException {

		Thread.sleep(4000);
		driver.quit();

	}

}
