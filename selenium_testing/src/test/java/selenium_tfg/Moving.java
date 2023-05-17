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
		WebElement list = chrome.findElement(By.className("list"));
		WebElement firstList = chrome.findElement(By.xpath("//div[text()[normalize-space()='Primer elemento']]"));
		WebElement secondList = chrome.findElement(By.xpath("//div[text()[normalize-space()='Segundo elemento']]"));
		WebElement thirdList = chrome.findElement(By.xpath("//div[text()[normalize-space()='Tercer elemento']]"));
		WebElement fourthList = chrome.findElement(By.xpath("//div[text()[normalize-space()='Cuarto elemento']]"));
		WebElement fifthList = chrome.findElement(By.xpath("//div[text()[normalize-space()='Quinto elemento']]"));
		act.dragAndDrop(fourthList, thirdList).build().perform();
		int screenWidth = chrome.manage().window().getSize().getWidth();
		int screenHeight = chrome.manage().window().getSize().getHeight();
		float ejeX = (float) (screenWidth*0.64);
		float ejeY = (float) (0-(screenHeight*0.12));

		act.dragAndDrop(dragable, thirdList);
		Funciones.uWait(10);
		act.dragAndDropBy(dragable, Math.round(ejeX), Math.round(ejeY)).build().perform();

		Funciones.uWait(10);
		//act.dragAndDrop(fourthList, thirdList).build().perform();
		//act.clickAndHold(fourthList).moveByOffset(fourthList.getLocation().getX(), thirdList.getLocation().getY()).release().build().perform(); 

		
	}
}