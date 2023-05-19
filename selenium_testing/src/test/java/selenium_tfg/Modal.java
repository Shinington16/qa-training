package selenium_tfg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_tfg.funciones.Funciones;

public class Modal {

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
		
		Funciones.login("//option[text()='modalWindow']");
	}

	@Test(priority=2)
	public void modalWindow() throws InterruptedException {

		chrome.findElement(By.xpath("//button[text()='Mensaje emergente']")).click();

		ArrayList<String> windows = new ArrayList<String> (chrome.getWindowHandles());
		chrome.switchTo().window(windows.get(0));
		chrome.switchTo().window(windows.get(1));
		chrome.close();
		chrome.switchTo().window(windows.get(0));

		WebElement modal = chrome.findElement(By.id("modalButton"));
		modal.click();
		chrome.findElement(By.id("modalClose")).click();
		modal.click();
		chrome.findElement(By.id("secondModalButton")).click();
		chrome.findElement(By.id("secondModalClose")).click();
		chrome.findElement(By.id("modalClose")).click();
	}

	@Test(priority=3)
	public void windowTab() throws InterruptedException {

		chrome.findElement(By.xpath("//button[text()='Nueva ventana']")).click();
		chrome.findElement(By.xpath("//button[text()='Nueva pestaña']")).click();

		ArrayList<String> windows = new ArrayList<String> (chrome.getWindowHandles());
		chrome.switchTo().window(windows.get(0));
		chrome.switchTo().window(windows.get(1));
		chrome.get("http://localhost/proyecto_tfg/html_files/log_in.html");
		chrome.switchTo().window(windows.get(2));
		chrome.get("http://localhost/proyecto_tfg/html_files/log_in.html");
		chrome.switchTo().window(windows.get(0));
		chrome.switchTo().window(windows.get(1));
		chrome.navigate().back();
		chrome.close();
		chrome.switchTo().window(windows.get(2));
		chrome.close();
		chrome.switchTo().window(windows.get(0));
	}

}