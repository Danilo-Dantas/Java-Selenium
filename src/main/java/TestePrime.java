import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrime {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl = new DSL(driver);
	}

	@After
	public void finaliza() {
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		dsl.clicarRadio(By.xpath("//input[@id=\"j_idt312:console:0\"]/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:0"));
		dsl.clicarRadio(By.xpath("//label[.=\"Option2\"]/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:1"));
	}
	
	@Test
	public void deveInteragirComComboPrime() {
		dsl.selecionarComboPrime("j_idt311:option_label", "Option2");
		Assert.assertEquals(dsl.obterTexto("j_idt311:option_label"), "Option2") ;
		
	}
}
