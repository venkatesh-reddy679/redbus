package com.testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testPage.RedBusPage1;
import com.utilities.WrapperClass;

public class RedBusTest extends WrapperClass {

	@Test
	public void f() throws IOException, InterruptedException {
		launchBrowser("chrome", "https://www.redbus.in/");
		RedBusPage1 rbp = new RedBusPage1(driver);
		rbp.fromStation(0, 0);
		rbp.toStation(0, 1);
		rbp.selectDate("Oct-16-2020");
		rbp.search();
		rbp.nonAC();
		screenshot();
		rbp.details();
		driver.close();
	}
}
