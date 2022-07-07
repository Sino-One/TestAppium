package testAppium;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;

import io.appium.java_client.android.AndroidDriver;

public class DragDropDemo extends base {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver driver = capabilities();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		
		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 0);
				
		WebElement source = driver.findElement(By.className("android.view.View"));
		WebElement destination = driver.findElement(By.className("android.view.View"));
		System.out.println(source);
		
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), source.getLocation().x, source.getLocation().y));
		sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), destination.getLocation().x, destination.getLocation().y));
		sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(sequence));

	}

}
