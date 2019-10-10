package casosTeste;

import org.junit.Assert;
import org.junit.Test;

import apoio.BaseTest;
import pages.AlertaPage;
import pages.MenuPage;

public class AlertTest extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AlertaPage alerta = new AlertaPage();

	@Test

	public void deveConfimarAlerta() {

		// acessar menu alerta

		menu.acessarAlertas();

		// clicar em alerta confirm

		alerta.clicarAlertaConfirm();

		// Verificar os textos

		Assert.assertEquals("Info", alerta.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", alerta.obterMensagemAlerta());

		// confirmar o alerta

		alerta.confimar();

		// verificar nova mensagem

		Assert.assertEquals("Confirmado", alerta.obterMensagemAlerta());

		// sair

		alerta.sair();

	}

}
