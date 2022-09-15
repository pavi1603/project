package org.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	@Test
	@Parameters({"Input"})
	private void tc1(String name) {
		System.out.println("Test1 " + name);
	}
	@Test
	private void tc2() {
		System.out.println("Test2");
	}
	@Test
	private void tc3() {
		System.out.println("Test3");
	}
	@Test
	private void tc4() {
		System.out.println("Test4");
	}
	@Test
	private void tc5() {
		System.out.println("Test5");
	}
	@Test
	private void tc6() {
		System.out.println("Test6");
	}
}
