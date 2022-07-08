import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioRegraDeNegocio {

	@Test
	public void testaNome() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testaSobrenome() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Danilo");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testaSexo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Danilo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Dantas");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		Thread.sleep(1000);
		alert.accept();
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testaComida() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
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
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testaEsporte() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
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
		
		Thread.sleep(2000);
		driver.quit();
	}
}
