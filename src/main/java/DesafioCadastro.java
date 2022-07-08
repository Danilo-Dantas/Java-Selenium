import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioCadastro {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void cadastroUsuario() throws InterruptedException {
		page.setNome("Danilo");
		page.setSobrenome("Dantas");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Superior");
		page.setEscolaridade("Natacao");
		page.setSugestao("Criar novas atualizações dessa páginas :P");
		page.cadastrar();
		Assert.assertEquals("Cadastrado!", page.obterResultado().startsWith("Cadastrado!"));
	}
}
