package br.ce.leo.Appium.test;

import org.junit.Test;

import br.ce.leo.Appium.core.BaseTest;
import br.ce.leo.Appium.page.MenuPage;
import br.ce.leo.Appium.page.SplashPage;

public class SplashTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();

	@Test

	public void deveAguardarSplashSumir() {

		// acessar menu splash

		menu.acessarSplash();

		// verificar que o splash está sendo exibido

		page.isTelaSplashVisivel();

		// aguardar saída do splash

		page.aguardarSplashSumir();

		// verificar que o formulário está aparecendo
		
		org.junit.Assert.assertTrue(page.existeElementoPorTexto("Formulario"));

	}

}
