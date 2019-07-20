package br.ce.leo.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.text.Element;

import org.junit.Assert;
import org.junit.Test;
import org.junit.validator.ValidateWith;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraMi9Se {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "c8e39120");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.miui.calculator");
		desiredCapabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);

		boolean alerta = driver.findElementsById("com.miui.calculator:id/alertTitle") != null;

		if (alerta == true) {

			MobileElement aceitar = driver.findElementById("android:id/button1");

			aceitar.click();

		}

		MobileElement el1 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("adição");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("igual a");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/com.miui.support.view.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.HorizontalScrollView[3]/android.widget.LinearLayout/android.widget.TextView[2]");

		Assert.assertEquals("4", el5.getText());
		driver.quit(); // encerra a sessão
	}

}
