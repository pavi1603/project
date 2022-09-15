package org.testng;

import org.datadriven.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrowserLaunch extends BaseClass {
	WebDriver driver;
	long startTime;
	long endTime;
	
	@BeforeSuite
	public void launchBrowser() throws InterruptedException {
		startTime=System.currentTimeMillis();
		Thread.sleep(2000);
		launchChrome();
		WinMax();
		Thread.sleep(2000);
	}
	@AfterSuite
	public void closebrowser() {
		driver.quit();
		endTime=System.currentTimeMillis();
		long totalTime= endTime-startTime;
		System.out.println("Total time taken" + totalTime);
	}
		@Test
	public void openGoogle() throws InterruptedException {
		//System.out.println("driver :"+ driver);
		loadUrl("https://www.mandmdirect.com/");
		Thread.sleep(3000);
	}
}
