package BasePackage;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseClass {

	public static WebDriver driver;
	static FileInputStream fis;
	public static Properties myProperties;

	@BeforeSuite
	public void setUp() throws IOException {
		ChromeOptions options = new ChromeOptions();

		// will remove chrome driver is controlled by automated software
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		System.setProperty("webdriver.chrome.driver", "J:\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		fis = new FileInputStream("F:\\Project2\\WalmartDotCom\\src\\FilePropertiesFolder\\locators.properties");
		myProperties = new Properties();
		myProperties.load(fis);
	}

	public void navigateUrl(String url) {
		driver.get(url);
	}

	public void sendKeys(By by, String keyValue) {
		driver.findElement(by).sendKeys(keyValue);
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public String getText(By by) {
		return driver.findElement(by).getText();
	}

	@AfterSuite
	public void driverClose() {
		driver.close();
	}

}
