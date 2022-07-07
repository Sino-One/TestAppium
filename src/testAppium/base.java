package testAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	
	static PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
	static Sequence sequence = new Sequence(finger, 0);
	
		public static AndroidDriver capabilities() throws MalformedURLException {
			File appDir = new File("src");
			File app = new File(appDir, "ApiDemos-debug.apk");
			//File app = new File(appDir, "ApiDemos-debug-face.apk");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "RF8N11S8H3A");
			
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			
			//cap.setCapability("newCommandTimeout", 1000);
			
			cap.setCapability("platformName", "Android");
			//cap.setCapability("appActivity", ".graphics.FingerPaint");
			
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				
			return driver;
		}
		
		public static Sequence longPress(int x, int y, Duration delay) {
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), x, y));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			sequence.addAction(new Pause(finger, delay));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			return sequence;
		}
		
		public static Sequence swipe(Point a, Point b, Duration delay) {
			sequence.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), a.x, a.y));
			sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			sequence.addAction(finger.createPointerMove(delay, Origin.viewport(), b.x, b.y));
			sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			return sequence;
		}


}
