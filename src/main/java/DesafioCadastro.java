import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DesafioCadastro {

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
	public void cadastroUsuario() throws InterruptedException {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Danilo");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Abreu");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByIndex(4);
		WebElement esportes = driver.findElement(By.id("elementosForm:esportes"));
		Select comboEsportes = new Select(esportes);
		comboEsportes.selectByIndex(0);
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Criar novas atualizações dessa páginas :P");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		WebElement res = driver.findElement(By.xpath("/html/body/center/div[2]/span"));
		Assert.assertEquals("Cadastrado!", res.getText()); 
	}
}
