package selenium_tfg;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_tfg.funciones.Funciones;

public class Form {

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
		
		Funciones.login("//option[text()='form&radio']");
	}

	@Test(priority=2)
	public void inputs() throws InterruptedException {

		WebElement nombre = chrome.findElement(By.xpath("//input[@placeholder='Nombre']"));
		nombre.sendKeys("Facundo");
		Funciones.uWait(2);
		WebElement apellidos = chrome.findElement(By.xpath("//input[@placeholder='Apellidos']"));
		apellidos.sendKeys("Tamborini");
		Funciones.uWait(2);
		WebElement fecha = chrome.findElement(By.xpath("//input[@type='date']"));
		fecha.sendKeys("05101990");
		Funciones.uWait(2);
		WebElement observaciones = chrome.findElement(By.xpath("//div[@id='form']//textarea[1]"));
		observaciones.sendKeys("Quiero recibir información adicional sobre la página.");
		Funciones.uWait(2);
	}

	@Test(priority=3)
	public void radio() throws InterruptedException {
		
		chrome.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		Funciones.uWait(2);
		chrome.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		Funciones.uWait(2);
		chrome.findElement(By.xpath("(//input[@type='radio'])[3]")).click();
		Funciones.uWait(2);
		chrome.findElement(By.xpath("(//input[@type='radio'])[4]")).click();
		Funciones.uWait(2);
		chrome.findElement(By.xpath("//input[@type='number']")).sendKeys("4");
		Funciones.uWait(2);
		chrome.findElement(By.xpath("//button[text()='Validar']")).click();
	}
}