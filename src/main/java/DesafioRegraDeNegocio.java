import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioRegraDeNegocio {

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
	public void testaNome() throws InterruptedException {
		page.cadastrar();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
	}
	
	@Test
	public void testaSobrenome() throws InterruptedException {
		page.setNome("Danilo");
		page.cadastrar();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
		
	}
	
	@Test
	public void testaSexo() throws InterruptedException {
		page.setNome("Danilo");
		page.setSobrenome("Dantas");
		page.cadastrar();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
	}
	
	@Test
	public void testaComida() throws InterruptedException {		
		page.setNome("Danilo");
		page.setSobrenome("Dantas");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaVegano();
		page.cadastrar();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		Thread.sleep(1000);
		alert.accept();

	}
	
	@Test
	public void testaEsporte() throws InterruptedException {
		page.setNome("Danilo");
		page.setSobrenome("Dantas");
		page.setSexoMasculino();
		page.setEsporte("Natacao");
		page.setEsporte("O que eh esporte?");
		page.cadastrar();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		Thread.sleep(1000);
		alert.accept();

	}
}
