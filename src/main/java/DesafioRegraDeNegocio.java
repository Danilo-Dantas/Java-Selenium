import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioRegraDeNegocio {

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
	public void testaNome() throws InterruptedException {
		dsl.clicarBotao("elementosForm:cadastrar");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
	}
	
	@Test
	public void testaSobrenome() throws InterruptedException {
		dsl.escreve("elementosForm:nome", "Danilo");
		dsl.clicarBotao("elementosForm:cadastrar");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
		
	}
	
	@Test
	public void testaSexo() throws InterruptedException {
		dsl.escreve("elementosForm:nome", "Danilo");
		dsl.escreve("elementosForm:sobrenome", "Danilo");
		dsl.clicarBotao("elementosForm:cadastrar");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
	}
	
	@Test
	public void testaComida() throws InterruptedException {		
		dsl.escreve("elementosForm:nome", "Danilo");
		dsl.escreve("elementosForm:sobrenome", "Danilo");
		dsl.clicaRadio("elementosForm:sexo:0");
		dsl.clicaRadio("elementosForm:comidaFavorita:0");
		dsl.clicaRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		Thread.sleep(1000);
		alert.accept();

	}
	
	@Test
	public void testaEsporte() throws InterruptedException {
		dsl.escreve("elementosForm:nome", "Danilo");
		dsl.escreve("elementosForm:sobrenome", "Danilo");
		dsl.clicaRadio("elementosForm:sexo:0");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.clicarBotao("elementosForm:cadastrar");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		Thread.sleep(1000);
		alert.accept();

	}
}