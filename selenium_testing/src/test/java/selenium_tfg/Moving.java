package selenium_tfg;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium_tfg.funciones.Funciones;

public class Moving {

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
		
		Funciones.login("//option[text()='movingElements']");
	}

	@Test(priority=2)
	public void dragAndDrop() throws InterruptedException, MoveTargetOutOfBoundsException {

		Actions act = new Actions(chrome);					

		WebElement dragable = chrome.findElement(By.id("movingDiv"));
		int screenWidth = chrome.manage().window().getSize().getWidth();
		int screenHeight = chrome.manage().window().getSize().getHeight();
		float ejeX = (float) (screenWidth*0.64);
		float ejeY = (float) (0-(screenHeight*0.12));

		Funciones.uWait(10);
		act.dragAndDropBy(dragable, Math.round(ejeX), Math.round(ejeY)).build().perform();
		act.dragAndDropBy(dragable, -70, -10).build().perform();

		Funciones.uWait(10);
		
	}
}