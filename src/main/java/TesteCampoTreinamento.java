import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

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
	public void testeTextField() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComTextArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\naaaaa");
//		Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}
	
	@Test
	public void testeRadioButtonCheckBox() {
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		System.out.println(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		System.out.println(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}
	
	@Test
	public void testeCombo() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByIndex(2);
//		combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
	}
	
	@Test
	public void testeVerificarValoresCombo() throws InterruptedException {
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
	}
	
	@Test
	public void testeVerificarValoresComboMultiplo() {
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
	}
	
	@Test
	public void deveInterarirComBotoes () {
		
//		Fiz de 2 maneiras diferentes, segue os testes:
		
//		driver.findElement(By.id("buttonSimple")).click();
//		Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("value"));
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	@Ignore
	public void deveInteragirComLinks() {
		String enderecoHtml = System.getProperty("user.dir") + "/src/main/resources/componentes.html";
		driver.get(enderecoHtml);
		
		WebElement btnVoltar = driver.findElement(By.linkText("Voltar"));
		btnVoltar.click();
		Assert.fail();
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		WebElement btnVoltar = driver.findElement(By.linkText("Voltar"));
		btnVoltar.click();
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
//		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}
	
	@Test
	public void testeComErro() {
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de erro", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
}



































