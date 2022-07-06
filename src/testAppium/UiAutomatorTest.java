package testAppium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class UiAutomatorTest extends base {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver driver = capabilities();

		driver.findElement(AppiumBy.androidUIAutomator("text(\"Views\")")).click();
		
		System.out.println(driver.findElement(AppiumBy.androidUIAutomator("newUiSelector().clickable(true)")).getSize());
		

	}

}
