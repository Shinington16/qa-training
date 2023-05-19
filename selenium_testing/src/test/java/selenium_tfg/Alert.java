package selenium_tfg;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_tfg.funciones.Funciones;

public class Alert {

	static WebDriver chrome;
	static Properties props;

	@BeforeClass
	public static void setUp() throws IOException {
		props = Funciones.props("config.properties");
		chrome = Funciones.setUp(props);
	}
	@AfterClass
	public void tearDown() throws InterruptedException {

		Funciones.tearDown();
	}
	
	@Test(priority=1)
	public void log_in() throws InterruptedException {
		
		Funciones.login("//option[text()='alertWindow']");
	}

	@Test(priority=2)
	public void alerts() throws InterruptedException {

		String firstAlert = chrome.switchTo().alert().getText();
		chrome.switchTo().alert().accept();
		Funciones.fluentXpath("//button[text()='Alert con retardo']", 3);
		WebElement delayAlert = chrome.findElement(By.xpath("//button[text()='Alert con retardo']"));
		delayAlert.click();

		String waitMessage = chrome.findElement(By.id("waitingMessage")).getText();
		Assert.assertTrue(waitMessage.contains("3 segundos"));

		Funciones.uWait(28);
		String openMessage = chrome.findElement(By.id("waitingMessage")).getText();
		Assert.assertTrue(openMessage.contains("Esperando"));
		Funciones.uWait(5);
		String secondAlert = chrome.switchTo().alert().getText();
		chrome.switchTo().alert().accept();
		String closeMessage = chrome.findElement(By.id("waitingMessage")).getText();
		Assert.assertTrue(closeMessage.contains("cerrado"));

		WebElement confirmAlert = chrome.findElement(By.xpath("//button[text()='Alert tipo confirm']"));
		confirmAlert.click();
		String thirdAlert = chrome.switchTo().alert().getText();
		chrome.switchTo().alert().dismiss();

		String cancelMessage = chrome.findElement(By.id("confirmMessage")).getText();
		Assert.assertTrue(cancelMessage.contains("Cancelar"));


		confirmAlert.click();
		chrome.switchTo().alert().accept();
		String confirmMessage = chrome.findElement(By.id("confirmMessage")).getText();
		Assert.assertTrue(confirmMessage.contains("Aceptar"));

		chrome.findElement(By.id("firstAlert")).sendKeys(firstAlert);
		chrome.findElement(By.id("delayAlert")).sendKeys(secondAlert);
		chrome.findElement(By.id("confirmAlert")).sendKeys(thirdAlert);

	}

	@Test(priority=3)
	public void prompt() throws InterruptedException {

		String mensaje = "Este es mi mensaje personalizado.";

		WebElement prompt = chrome.findElement(By.xpath("//button[text()='Prompt de texto']"));
		prompt.click();
		chrome.switchTo().alert().accept();

		WebElement promptMessage = chrome.findElement(By.id("promptMessage"));
		Assert.assertEquals("Quiero decir que...", promptMessage.getText());

		prompt.click();
		chrome.switchTo().alert().dismiss();
		WebElement promptBefore = chrome.findElement(By.id("promptBefore"));
		Assert.assertTrue(promptBefore.getText().contains("Qué lástima"));

		prompt.click();
		chrome.switchTo().alert().sendKeys(mensaje);
		chrome.switchTo().alert().accept();

		WebElement promptMessage2 = chrome.findElement(By.id("promptMessage"));
		WebElement promptBefore2 = chrome.findElement(By.id("promptBefore"));
		Assert.assertTrue(promptBefore2.getText().contains("su mensaje:"));
		Assert.assertEquals(mensaje, promptMessage2.getText());

		Funciones.uWait(5);
	}
}