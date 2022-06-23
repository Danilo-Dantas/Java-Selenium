import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

	@Test
	public void deveInteragirComAlertSimples() {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		driver.quit();
	}

	@Test
	public void deveInteragirComAlertConfirmAceitando() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alertConfirm = driver.switchTo().alert();
		alertConfirm.accept();
		String texto = alertConfirm.getText();
		alertConfirm.accept();

		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);

		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void deveInteragirComAlertConfirmNegando() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alertConfirm = driver.switchTo().alert();
		alertConfirm.dismiss();
		String texto = alertConfirm.getText();
		alertConfirm.accept();

		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);

		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void deveInteragirComAlertPrompt() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
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
		
		Thread.sleep(2000);
		driver.quit();
	}
}















