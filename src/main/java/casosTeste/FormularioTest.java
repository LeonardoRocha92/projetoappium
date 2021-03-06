package casosTeste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import apoio.BaseTest;
import apoio.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.FormularioPage;
import pages.MenuPage;

public class FormularioTest extends BaseTest {

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

	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {

		page.escreverNome("Leonardo");

		page.salvarDemorado();
		// esperar(3000);

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=' Name: Leonardo']")));

		assertEquals("Nome: Leonardo", page.obterNomeCadastrado());

	}

	@Test
	public void deveAlterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
	}
	
	@Test
	public void deveAlterarHora(){
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("10:40"));

	}

}
