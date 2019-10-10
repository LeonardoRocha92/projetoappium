package casosTeste;

import org.junit.Assert;
import org.junit.Test;

import apoio.BaseTest;
import pages.AbaPage;
import pages.MenuPage;

public class AbasTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AbaPage page = new AbaPage();

	@Test
	public void deveInteragirComAbas() {

		// acessar menu abas

		menu.acessarAbas();

		// verificar se est� na aba 1

		Assert.assertTrue(page.isAba1());

		// acessar aba 2

		page.selecionarAba2();

		// verificar que est� na aba2

		Assert.assertTrue(page.isAba2());

	}

}
