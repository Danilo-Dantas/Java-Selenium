import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioCadastro {

	@Test
	public void cadastroUsuario() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Danilo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Abreu");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		Thread.sleep(2000);
		driver.quit();
	}
}
