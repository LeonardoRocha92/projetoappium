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

@SuppressWarnings("deprecation")
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

		org.junit.Assert.assertEquals("Leonardo", text);

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

		// clicar no combo

		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// Selecionar a opção desejada

		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();

		// Verificar opção selecionada

		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		org.junit.Assert.assertEquals("PS4", text);

		driver.quit();
	}

	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {

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

		driver.findElement(By.xpath("//*[@text='Formulário']")).click();

		// verificar status dos elementos

		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		org.junit.Assert.assertTrue(check.getAttribute("checked").equals("false"));
		org.junit.Assert.assertTrue(switc.getAttribute("checked").equals("true"));

		// clicar nos elementos

		check.click();
		switc.click();

		// verificar estados alterados

		org.junit.Assert.assertFalse(check.getAttribute("checked").equals("false"));
		org.junit.Assert.assertFalse(switc.getAttribute("checked").equals("true"));

		driver.quit();
	}

	@Test
	public void preecherCampos() throws MalformedURLException {

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

		driver.findElement(By.xpath("//*[@text='Formulário']")).click();

		// preencher campos

		driver.findElement(By.className("android.widget.EditText")).sendKeys("Leonardo");
		driver.findElement(MobileBy.AccessibilityId("check")).click();
		driver.findElement(MobileBy.AccessibilityId("switch")).click();
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();

		// salvar

		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();

		// verificações

		MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Leonardo']"));
		org.junit.Assert.assertEquals("Nome: Leonardo", nome.getText());

		MobileElement combo = driver
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
		org.junit.Assert.assertEquals("Console: ps4", combo.getText());
		
		MobileElement switc = driver
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
		org.junit.Assert.assertTrue(switc.getText().endsWith("Off"));
		
		MobileElement checkBox = driver
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		org.junit.Assert.assertTrue(checkBox.getText().endsWith("Marcado"));

		driver.quit();
	}

}
