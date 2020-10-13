package com.testPage;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.experimental.theories.FromDataPoints;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.WrapperClass;

public class RedBusPage1 {

	WebDriver driver;

	public RedBusPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	ExcelPage e = new ExcelPage();

	String sheetName = "Savaari";

	@FindBy(xpath = "//input[@id='src']")
	WebElement FromCity;

	@FindBy(xpath = "//input[@id='dest']")
	WebElement toCity;

	@FindBy(xpath = "//*[contains(text(),'Search Buses')]")
	WebElement searchBtn;

	public void fromStation(int rowNum, int cellNum) throws IOException, InterruptedException {

		String fromValue = e.getCellValue(sheetName, rowNum, cellNum);

		FromCity.clear();
		Thread.sleep(1000);

		FromCity.sendKeys(fromValue);
		Thread.sleep(1000);

		FromCity.sendKeys(Keys.ENTER);
	}

	public void toStation(int rowNum, int cellNum) throws IOException, InterruptedException {

		String toValue = e.getCellValue(sheetName, rowNum, cellNum);

		toCity.clear();
		Thread.sleep(1000);

		toCity.sendKeys(toValue);
		Thread.sleep(1000);
		FromCity.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	public void selectDate(String date) throws InterruptedException {

		driver.findElement(By.xpath(
				"//div[@class='fl search-box date-box gtm-onwardCalendar']/span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[5]/td[5]")).click();

	}

	public void search() throws InterruptedException {
		searchBtn.click();
		Thread.sleep(2000);
	}

	public void nonAC() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='list-chkbox']/li[3]/label[2]")).click();
	}

	public void details() throws InterruptedException {
		Thread.sleep(2000);
		String name1 = driver.findElement(By.xpath("//li/div/div[1]/div[1]/div[1]/div[1]")).getText();
		String name2 = driver.findElement(By.xpath("//li/div/div[1]/div[1]/div[1]/div[2]")).getText();
		String nameOfBus = name1 + " " + name2;
		System.out.println("name of the second nonAC bus :::::::f" + nameOfBus);

		Thread.sleep(2000);
		String cost = driver.findElement(By.xpath("//li/div/div[1]/div[1]/div[6]/div[1]/div[1]/span")).getText();
		System.out.println("cost of the one seat in the bus :" + cost);
		Thread.sleep(2000);
	}

}
