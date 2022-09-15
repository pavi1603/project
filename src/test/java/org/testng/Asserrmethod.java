package org.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Asserrmethod {
	@BeforeClass
	private void browser() {
		System.out.println("Chrome");
	}
	@AfterClass
	private void browserClose() {
		System.out.println("Close");
	}
	@Test(priority= -5)
	private void tc3() {
		System.out.println("Test3");
	}
	//ENABLED=FALSE - used to skip the test case
	@Test(priority= 2, enabled=false)
	private void tc2() {
		System.out.println("Test2");
	}
	@Test(priority= -2)
	private void tc1() {
		System.out.println("Test1");
	}
	//INVOCATIONCOUNT - used to test case in no.of times
	@Test(priority= 2, invocationCount =3)
	private void tc4() {
		System.out.println("Test4");
	}
	@BeforeMethod
	private void start() {
		System.out.println("Start");
	}
	@AfterMethod
	private void end() {
		System.out.println("End");
	}
	String name="Thor";
	@Test
	private void tc5() {
		System.out.println("Test5");
		Assert.assertEquals(name, "thor");
	}

}
