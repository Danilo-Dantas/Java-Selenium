import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

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
	public void deveInteragirComAlertSimples() {

		dsl.clicarBotao("alert");
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		dsl.escrever("elementosForm:nome", texto);
	}

	@Test
	public void deveInteragirComAlertConfirmAceitando() throws InterruptedException {

		dsl.clicarBotao("confirm");
		Alert alertConfirm = driver.switchTo().alert();
		alertConfirm.accept();
		String texto = alertConfirm.getText();
		alertConfirm.accept();
		dsl.escrever("elementosForm:nome", texto);
	}

	@Test
	public void deveInteragirComAlertConfirmNegando() throws InterruptedException {
		dsl.clicarBotao("confirm");
		Alert alertConfirm = driver.switchTo().alert();
		alertConfirm.dismiss();
		String texto = alertConfirm.getText();
		alertConfirm.accept();
		dsl.escrever("elementosForm:nome", texto);
	}

	@Test
	public void deveInteragirComAlertPrompt() throws InterruptedException {
		dsl.clicarBotao("prompt");
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("22");
		Thread.sleep(1000);
		alert.accept();
		Assert.assertEquals("Era 22?", alert.getText());
		Thread.sleep(1000);
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		Thread.sleep(1000);
		alert.accept();
	}
}
