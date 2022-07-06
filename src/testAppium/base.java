package testAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
		
		public static AndroidDriver capabilities() throws MalformedURLException {
			File appDir = new File("src");
			//File app = new File(appDir, "ApiDemos-debug.apk");
			File app = new File(appDir, "ApiDemos-debug-face.apk");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "RF8N11S8H3A");
			
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			
			//cap.setCapability("newCommandTimeout", 1000);
			
			cap.setCapability("platformName", "Android");
			cap.setCapability("appActivity", ".graphics.FingerPaint");
			
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				
			return driver;
		}


}
