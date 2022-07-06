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
				
		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 0);
		
		//PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
	    //Sequence circle = new Sequence(finger, 0);
		
		// element.click();
		
		System.out.println(Origin.viewport());
		System.out.println(element.getLocation().x);
		System.out.println(element.getLocation().y);
		
		//sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), element.getLocation().x, element.getLocation().y));
		
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), element.getLocation().x, element.getLocation().y));
		sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		sequence.addAction(new Pause(finger, Duration.ofMillis(1000)));
		sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), element.getLocation().x, element.getLocation().y));
		sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
		sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
		
		element = driver.findElement(By.xpath("//android.widget.TextView[@text='Fish Names']"));
		
		System.out.println(Origin.viewport());
		System.out.println(element.getLocation().x);
		System.out.println(element.getLocation().y);
		
		
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), element.getLocation().x, element.getLocation().y));
		sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.RIGHT.asArg()));
		sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.RIGHT.asArg()));


		driver.perform(Arrays.asList(sequence));
		
		
		
	}
}
