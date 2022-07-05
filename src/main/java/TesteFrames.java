import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrames {
	
	@Test
	public void digitaTextoFrame() throws InterruptedException {
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
}
