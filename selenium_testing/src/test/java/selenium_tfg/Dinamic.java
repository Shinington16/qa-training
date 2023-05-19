package selenium_tfg;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_tfg.funciones.Funciones;

public class Dinamic {

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
		
		Funciones.login("//option[text()='dinamicElements']");
	}

	@Test(priority=2)
	public void load_bar() throws InterruptedException {

		WebElement load = chrome.findElement(By.id("cargar"));
		load.click();

		WebElement slider = chrome.findElement(By.id("slider"));
		for (int i = 0; i < 43; i++) {
			slider.sendKeys(Keys.ARROW_RIGHT);
		}
		Funciones.uWait(5);

		Actions act = new Actions(chrome);

		WebElement sliderInfo = chrome.findElement(By.id("output"));
		act.moveToElement(sliderInfo).perform();
		Funciones.uWait(10);
		act.moveToElement(slider).perform();

		for (int i = 0; i < 57; i++) {
			slider.sendKeys(Keys.ARROW_RIGHT);
		}
		Funciones.uWait(5);
		act.moveToElement(sliderInfo).perform();
		Funciones.uWait(20);

		WebElement loadInfo = chrome.findElement(By.id("carga"));
		act.moveToElement(loadInfo).perform();
		Funciones.uWait(10);

	
		
	}
}