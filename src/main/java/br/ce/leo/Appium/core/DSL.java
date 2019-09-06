package br.ce.leo.Appium.core;

import static br.ce.leo.Appium.core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

public class DSL {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);

	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();

	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
		
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));

	}

	public boolean isCheckMarcado(By by) {

		return getDriver().findElement(by).getAttribute("checked").equals("true");

	}

}
