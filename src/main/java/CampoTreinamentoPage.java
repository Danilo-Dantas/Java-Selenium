import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicaRadio("elementosForm:sexo:0");
	}
	
	public void setComidaCarne() {
		dsl.clicaRadio("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaPizza() {
		dsl.clicaRadio("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegano() {
		dsl.clicaRadio("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}
	
	public void setEsporte(String valor) {
		dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void setSugestao(String texto) {
		dsl.escreve("elementosForm:sugestoes", texto);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultado() {
		return dsl.obterTexto("resultado");
	}
	
	
 }
