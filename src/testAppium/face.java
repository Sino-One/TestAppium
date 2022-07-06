package testAppium;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class face extends base {
	
	static Duration STEP_DURATION = Duration.ofMillis(20);
	static Duration NO_TIME = Duration.ofMillis(0);
	static Origin VIEW = Origin.viewport();

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver driver = capabilities();
		
		drawFace(driver);

	}
	
	static Point getPointOnCircle (int step, int totalSteps, Point origin, double radius) {
	    double theta = 2 * Math.PI * ((double)step / totalSteps);
	    int x = (int)Math.floor(Math.cos(theta) * radius);
	    int y = (int)Math.floor(Math.sin(theta) * radius);
	    return new Point(origin.x + x, origin.y + y);
	}
	
	static void drawCircle (AppiumDriver driver, Point origin, double radius, int steps) {
	    Point firstPoint = getPointOnCircle(0, steps, origin, radius);

	    // Set Finger
	    PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
	    Sequence circle = new Sequence(finger, 0);
	    // Set initial position and click
	    circle.addAction(finger.createPointerMove(NO_TIME, VIEW, firstPoint.x, firstPoint.y));
	    circle.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()));

	    // Build form with finger click
	    for (int i = 1; i < steps + 1; i++) {
	        Point point = getPointOnCircle(i, steps, origin, radius);
	        circle.addAction(finger.createPointerMove(STEP_DURATION, VIEW, point.x, point.y));
	    }

	    // Stop click
	    circle.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
	    driver.perform(Arrays.asList(circle));
	}
	
	static void drawFace(AndroidDriver driver) throws InterruptedException {
		
		int deviceHeight = driver.manage().window().getSize().height;
		int deviceWidth = driver.manage().window().getSize().width;
		
	    Point head = new Point(deviceWidth/2, deviceHeight/2);
	    Point leftEye = head.moveBy(-50, -50);
	    Point rightEye = head.moveBy(50, -50);
	    Point mouth = head.moveBy(0, 50);
	    
	    Thread.sleep(5000);

	    drawCircle(driver, leftEye, 20, 20);
	    drawCircle(driver, rightEye, 20, 20);
	    drawCircle(driver, mouth, 40, 20);
	    drawCircle(driver, head, 150, 30);
	}

}
