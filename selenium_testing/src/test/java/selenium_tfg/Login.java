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

public class Login {

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
	public void selectUser() throws InterruptedException {

		chrome.findElement(By.id("generatePass")).click();;
		generar("9");
		generar("6");
		generar("4");
		generar("3");
		generar("2");
		generar("5");
		generar("7");
		generar("8");
		generar("6");
		generar("2");
		generar("8");
		generar("4");
	}

	@Test(priority=2)
	public void wrongLogin() throws InterruptedException {

		WebElement login = chrome.findElement(By.name("btn-login"));
		login.click();
		Funciones.uWait(5);
		chrome.findElement(By.name("username")).sendKeys("ACCEDER");
		login.click();
		Funciones.uWait(5);
		chrome.findElement(By.name("password")).sendKeys("aaaaaa");
		login.click();
		Funciones.uWait(5);

		chrome.switchTo().alert().accept();

	}

	@Test(priority=3)
	public void correctLogin() throws InterruptedException {

		generar("4");
		Funciones.login("(//select[@id='userSelect']//option)[8]");
	}

	public void generar(String locator) {
		WebElement select = chrome.findElement(By.id("userSelect"));
		select.click();
		chrome.findElement(By.xpath("(//select[@id='userSelect']//option)["+locator+"]")).click();
		WebElement generar = chrome.findElement(By.id("generatePass"));
		generar.click();
	}
}