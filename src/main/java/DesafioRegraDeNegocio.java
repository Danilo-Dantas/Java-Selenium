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
	public void testaNome() throws InterruptedException {
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
	}
	
	@Test
	public void testaSobrenome() throws InterruptedException {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Danilo");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
		
	}
	
	@Test
	public void testaSexo() throws InterruptedException {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Danilo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dantas");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
		
	}
	
	@Test
	public void testaComida() throws InterruptedException {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Danilo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dantas");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		Thread.sleep(1000);
		alert.accept();

	}
	
	@Test
	public void testaEsporte() throws InterruptedException {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Danilo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dantas");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select multi = new Select(element);
		multi.selectByIndex(0);
		multi.selectByIndex(4);
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		Thread.sleep(1000);
		alert.accept();

	}
}
