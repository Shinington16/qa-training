package selenium_tfg;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_tfg.funciones.Funciones;

public class ThreeTabs {

	static WebDriver chrome;
	static Properties props;

	@BeforeClass
	public static void setUp() throws IOException {
		props = Funciones.props("config.properties");
		chrome = Funciones.setUp(props);
	}
	//@AfterClass
	public void tearDown() throws InterruptedException {
		
		Funciones.tearDown();
	}
	
	@Test(priority=1)
	public void log_in() throws InterruptedException {
		
		Funciones.threeTabsLogin(props, "//option[text()='button']", "//option[text()='alertWindow']", "//option[text()='form&radio']");
	}

	@Test(priority=2)
	public void buttons() throws InterruptedException {

		Funciones.fluentXpath("//button[text()='Botón con id dinámico']", 3);
		WebElement buttonId = chrome.findElement(By.xpath("//button[text()='Botón con id dinámico']"));
		buttonId.click();
		String textoDinamico = chrome.findElement(By.id("clickDinamico")).getText();
		Assert.assertTrue(textoDinamico.contains(buttonId.getAttribute("id")), buttonId.getAttribute("id"));

		Actions dbclick = new Actions(chrome);
		WebElement doubleClick = chrome.findElement(By.xpath("//button[text()='Botón de doble click']"));
		dbclick.doubleClick(doubleClick).perform();

		Funciones.uWait(50);
		chrome.findElement(By.id("delayedButton")).click();

		Actions context = new Actions(chrome);
		WebElement contextClick = chrome.findElement(By.id("rightButton"));
		context.contextClick(contextClick).perform();

		String contextText = chrome.findElement(By.id("clickDerecho")).getText();
		Assert.assertEquals(contextText.contains("derecho"), contextClick.getText().contains("derecho"));
	}
}
