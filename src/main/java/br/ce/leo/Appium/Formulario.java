package br.ce.leo.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class Formulario {

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\leo\\eclipse-workspace\\AutomacaoMobileAppium\\src\\test\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Selecionar o Formulario
		
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));

		for (MobileElement elemento : elementosEncontrados) {

			System.out.println(elemento.getText());
		}

		elementosEncontrados.get(1).click();

		// Escrever o Nome

		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Leonardo");

		// Verificar o Nome escrito

		String text = campoNome.getText();

		Assert.assertEquals("Leonardo", text);

		driver.quit();
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\leo\\eclipse-workspace\\AutomacaoMobileAppium\\src\\test\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Selecionar o Formulario
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//clicar no combo
		
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//Selecionar a opção desejada
		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();

		// Verificar opção selecionada

		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("PS4", text);
		
		driver.quit();
	}

}
