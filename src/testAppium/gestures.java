package testAppium;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.android.AndroidDriver;


public class gestures extends base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver driver = capabilities();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		System.out.println(Origin.viewport());
		System.out.println(element.getLocation().x);
		System.out.println(element.getLocation().y);
		
		
		Sequence sequence = longPress(element.getLocation().x, element.getLocation().y, Duration.ofMillis(1000));
		
		driver.perform(Arrays.asList(sequence));
	}

}
