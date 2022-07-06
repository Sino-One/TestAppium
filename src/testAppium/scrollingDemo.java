package testAppium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class scrollingDemo extends base {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver driver = capabilities();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")).click();



	}

}
