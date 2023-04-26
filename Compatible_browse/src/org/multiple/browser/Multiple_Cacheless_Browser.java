package org.multiple.browser;

import java.util.Scanner;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Multiple_Cacheless_Browser {

	public static WebDriver driver;

	public static void main(String[] args) {

		try {

			System.out.println("Enter any one of the below mentioned Browser Commands:\r\n" + "\r\n" + "Chrome - C\r\n"
					+ "\r\n" + "Edge - E\r\n" + "\r\n" + "Firefox - F");

			Scanner s = new Scanner(System.in);

			String browserName = s.next(); 

			if (browserName.equalsIgnoreCase("C")) {

				System.out.println("Chrome is launching");

				System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

				driver = new ChromeDriver();

				driver.manage().window().maximize();

				driver.get("chrome://settings/clearBrowserData");

				WebElement findElement = driver.findElement(By.xpath("//settings-ui"));

				WebDriverWait wait = new WebDriverWait(driver, 10);

				WebElement until = wait.until(ExpectedConditions.visibilityOf(findElement));

				until.sendKeys(Keys.ENTER);

				driver.get("data:,");

			} else if (browserName.equalsIgnoreCase("F")) {

				System.out.println("Firefox is launching");

				System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");

				FirefoxProfile profile = new FirefoxProfile();

				profile.setPreference("browser.cache.disk.enable", false);

				profile.setPreference("browser.cache.memory.enable", false);

				profile.setPreference("browser.cache.offline.enable", false);

				profile.setPreference("network.http.use-cache", false);

				FirefoxOptions options = new FirefoxOptions().setProfile(profile);

				driver = new FirefoxDriver(options);

				driver.manage().window().maximize();

			} else if (browserName.equalsIgnoreCase("E")) {

				System.out.println("Edge is launching");

				System.setProperty("webdriver.edge.driver", "/usr/bin/msedgedriver");

				driver = new EdgeDriver();

				driver.manage().window().maximize();

				driver.get("edge://settings/clearBrowserData");

				WebElement findElement = driver.findElement(By.id("clear-now"));

				WebDriverWait wait = new WebDriverWait(driver, 25);

				WebElement until = wait.until(ExpectedConditions.visibilityOf(findElement));

				until.sendKeys(Keys.ENTER);

				driver.get("data:,");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

}