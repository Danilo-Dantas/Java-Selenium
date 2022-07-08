import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioCadastro {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void cadastroUsuario() throws InterruptedException {
		dsl.escreve("elementosForm:nome", "Danilo");
		dsl.escreve("elementosForm:sobrenome", "Dantas");
		dsl.clicaRadio("elementosForm:sexo:0");
		dsl.clicaRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.escreve("elementosForm:sugestoes", "Criar novas atualizações dessa páginas :P");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Cadastrado!", dsl.obterTexto("resultado").startsWith("Cadastrado!"));
	}
}
