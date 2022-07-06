package testAppium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class UiAutomatorTest extends base {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("Views")).click();

	}

}
