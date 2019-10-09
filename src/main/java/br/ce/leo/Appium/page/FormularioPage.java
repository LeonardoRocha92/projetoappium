package br.ce.leo.Appium.page;

import org.openqa.selenium.By;

import br.ce.leo.Appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage{


	public void escreverNome(String nome) {

			escrever(MobileBy.AccessibilityId("nome"), nome);

	}

	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));

	}

	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);

	}

	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));

	}

	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));

	}

	public boolean isCheckMarcado() {

		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}

	public boolean isSwitchMarcado() {

		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}

	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void salvarDemorado(){
		clicarPorTexto("SALVAR DEMORADO");
	}

	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}

	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));

	}

	public String obterCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));

	}

	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}

}
