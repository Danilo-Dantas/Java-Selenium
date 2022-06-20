import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\driver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200,765));
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.chrome.driver", "C://driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\naaaaa");
//		Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void testeRadioButtonCheckBox() {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir") + ("/src/main/resources/componentes.html"));
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		System.out.println(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		System.out.println(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
	}
	
	@Test
	public void testeCombo() {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + ("/src/main/resources/componentes.html"));
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByIndex(2);
//		combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
	
	@Test
	public void testeVerificarValoresCombo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + ("/src/main/resources/componentes.html"));
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
		driver.quit();
	}
	
	@Test
	public void testeVerificarValoresComboMultiplo() {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + ("/src/main/resources/componentes.html"));
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		driver.quit();
	}
	
	@Test
	public void deveInterarirComBotoes () {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String caminhoHtml = System.getProperty("user.dir") + "/src/main/resources/componentes.html";
		driver.get(caminhoHtml);
		
//		Fiz de 2 maneiras diferentes, segue os testes:
		
//		driver.findElement(By.id("buttonSimple")).click();
//		Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado", botao.getAttribute("value"));
		driver.quit();
	}
}



































