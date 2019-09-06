package br.ce.leo.Appium.page;

import br.ce.leo.Appium.core.DSL;

public class MenuPage {
	
	private DSL dsl = new DSL();
	
	public  void acessarFormulario(){
		
		dsl.clicarPorTexto("Formulário");
	}

}
