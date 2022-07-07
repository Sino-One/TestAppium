package testAppium;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class swipeDemo extends base {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver driver = capabilities();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("text(\"2. Inline\")")).click();
		WebElement element = driver.findElement(By.xpath("//*[@content-desc='9']"));
		element.click();
				
		WebElement a = driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement b = driver.findElement(By.xpath("//*[@content-desc='45']"));
		
		Sequence sequence = swipe(a.getLocation(), b.getLocation(), Duration.ofMillis(1000));
		
		driver.perform(Arrays.asList(sequence));


	}

}
