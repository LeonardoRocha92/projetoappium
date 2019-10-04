package br.ce.leo.Appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.leo.Appium.core.BaseTest;
import br.ce.leo.Appium.page.FormularioPage;
import br.ce.leo.Appium.page.MenuPage;

public class Formulario_Caso_Teste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void InicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		page.escreverNome("Leonardo");

		Assert.assertEquals("Leonardo", page.obterNome());

	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		page.selecionarCombo("PS4");

		assertEquals("PS4", page.obterValorCombo());

	}

	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {

		assertFalse(page.isCheckMarcado());
		assertTrue(page.isSwitchMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		assertTrue(page.isCheckMarcado());
		assertFalse(page.isSwitchMarcado());

	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {

		page.escreverNome("Leonardo");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("PS4");

		page.salvar();

		assertEquals("Nome: Leonardo", page.obterNomeCadastrado());
		Assert.assertEquals("Console: ps4", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Off"));
		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Marcado"));
	}

}
