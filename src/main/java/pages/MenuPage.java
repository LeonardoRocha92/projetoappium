package pages;

import apoio.BasePage;

public class MenuPage extends BasePage {

	public void acessarFormulario() {

		clicarPorTexto("Formul�rio");
	}
	
	public void acessarSplash(){
		
		clicarPorTexto("Splash");
	}
	
	public void acessarAlertas(){
		
		clicarPorTexto("Alertas");
	}

	public void acessarAbas() {
		clicarPorTexto("Abas");

	}

}