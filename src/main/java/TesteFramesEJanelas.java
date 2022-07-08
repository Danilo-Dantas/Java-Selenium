import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFramesEJanelas {
	
	@Test
	public void deveInteragirComJanelas() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.switchTo().frame("frame1");
		Thread.sleep(2000);
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String textoAlert = alert.getText();
		Assert.assertEquals("Frame OK!", textoAlert);
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(textoAlert);
		
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
		
		Thread.sleep(2000);
		driver.quit();
	}
}
