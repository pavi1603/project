package org.testng;

import org.datadriven.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class priority  extends BaseClass{
	WebDriver driver;
	long startTime;
	long endTime;

	@BeforeClass
	private void browser() throws InterruptedException {
			startTime=System.currentTimeMillis();
			Thread.sleep(2000);
			launchChrome();
			WinMax();
			Thread.sleep(2000);
			System.out.println("Chrome Launched");
	}
	@AfterClass
	private void browserClose() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		System.out.println("Chrome Closed");
	}
	@Test(priority= 1)
	public void openGoogle() throws InterruptedException {
		loadUrl("https://www.mandmdirect.com/");
		Thread.sleep(3000);
		System.out.println("Test2 : url Launch");
	}
	@Test(priority= -2)
	private void tc1() {
		System.out.println("Test1");
	}
	@Test(priority= 9)
	private void tc5() {
		System.out.println("Test3");
	}
	@BeforeMethod
	private void start() {
		System.out.println("Test Start");
	}
	@AfterMethod
	private void end() {
		System.out.println("Test End");
	}
}
