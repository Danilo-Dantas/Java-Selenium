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
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void deveInteragirComAlertSimples() {

		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}

	@Test
	public void deveInteragirComAlertConfirmAceitando() throws InterruptedException {

		driver.findElement(By.id("confirm")).click();
		Alert alertConfirm = driver.switchTo().alert();
		alertConfirm.accept();
		String texto = alertConfirm.getText();
		alertConfirm.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}

	@Test
	public void deveInteragirComAlertConfirmNegando() throws InterruptedException {
		driver.findElement(By.id("confirm")).click();
		Alert alertConfirm = driver.switchTo().alert();
		alertConfirm.dismiss();
		String texto = alertConfirm.getText();
		alertConfirm.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}

	@Test
	public void deveInteragirComAlertPrompt() throws InterruptedException {
		driver.findElement(By.id("prompt")).click();
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















