package selenium_tfg;

import java.io.IOException;
import java.util.ArrayList;
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

public class Menu {

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
		
		Funciones.login("//option[text()='menu&list']");
	}

	@Test(priority=2)
	public void colors() throws InterruptedException {

		WebElement bgColor = chrome.findElement(By.id("colorSelect"));
		bgColor.click();
		chrome.findElement(By.xpath("(//option[@value='green'])[1]")).click();
		bgColor.click();
		chrome.findElement(By.xpath("(//option[@value='red'])[1]")).click();
		bgColor.click();
		chrome.findElement(By.xpath("(//option[@value='yellow'])[1]")).click();
		bgColor.click();
		chrome.findElement(By.xpath("(//option[@value='white'])")).click();
		bgColor.click();
		chrome.findElement(By.xpath("(//option[@value='green'])[1]")).click();
		bgColor.click();
		chrome.findElement(By.xpath("(//option[@value='red'])[1]")).click();

		WebElement textColor = chrome.findElement(By.id("textColorSelect"));
		textColor.click();
		chrome.findElement(By.xpath("(//option[@value='green'])[2]")).click();
		textColor.click();
		chrome.findElement(By.xpath("(//option[@value='orange'])")).click();
		textColor.click();
		chrome.findElement(By.xpath("(//option[@value='blue'])")).click();
		textColor.click();
		chrome.findElement(By.xpath("(//option[@value='red'])[2]")).click();
		textColor.click();
		chrome.findElement(By.xpath("(//option[@value='yellow'])[2]")).click();
		textColor.click();
		chrome.findElement(By.xpath("(//option[@value='green'])[2]")).click();
	}

	@Test(priority=2)
	public void multiSelect() {

		WebElement multiSelect = chrome.findElement(By.xpath("//i[@class='dropdown icon']"));
		multiSelect.click();
		chrome.findElement(By.xpath("//div[@data-value='5']")).click();
		chrome.findElement(By.xpath("//div[@data-value='2']")).click();
		chrome.findElement(By.xpath("//div[@data-value='8']")).click();
		chrome.findElement(By.xpath("//div[@data-value='4']")).click();
		chrome.findElement(By.xpath("//div[@data-value='6']")).click();
		chrome.findElement(By.xpath("//div[@data-value='9']")).click();
		chrome.findElement(By.xpath("//a[@data-value='5']//i[1]")).click();
		chrome.findElement(By.xpath("//a[@data-value='4']//i[1]")).click();
		chrome.findElement(By.xpath("//a[@data-value='9']//i[1]")).click();
		chrome.findElement(By.xpath("//a[@data-value='8']//i[1]")).click();
		chrome.findElement(By.xpath("//div[@data-value='7']")).click();
		chrome.findElement(By.xpath("//div[@data-value='3']")).click();
		chrome.findElement(By.xpath("//div[@data-value='4']")).click();
		chrome.findElement(By.xpath("//div[@data-value='8']")).click();
		chrome.findElement(By.xpath("//div[@data-value='9']")).click();
		chrome.findElement(By.xpath("//a[@data-value='9']//i[1]")).click();
		chrome.findElement(By.xpath("//a[@data-value='4']//i[1]")).click();
		chrome.findElement(By.xpath("//a[@data-value='3']//i[1]")).click();
		chrome.findElement(By.xpath("//a[@data-value='7']//i[1]")).click();
		chrome.findElement(By.xpath("//div[@data-value='9']")).click();
		chrome.findElement(By.xpath("//div[@data-value='3']")).click();
		multiSelect.click();
	}

	@Test(priority=4)
	public void menu() throws InterruptedException {

		Actions act = new Actions(chrome);

		WebElement documen = chrome.findElement(By.linkText("Documentación"));
		WebElement ides = chrome.findElement(By.linkText("IDEs"));
		WebElement plugin = chrome.findElement(By.linkText("Plugins útiles"));

		act.moveToElement(ides).perform();
		act.moveToElement(plugin).perform();
		act.moveToElement(documen).perform();
		WebElement front = chrome.findElement(By.linkText("Frontend"));
		WebElement back = chrome.findElement(By.linkText("Backend"));
		WebElement db = chrome.findElement(By.linkText("Bases de datos"));
		WebElement testing = chrome.findElement(By.linkText("Testing y automatización"));
		act.moveToElement(testing).perform();
		act.moveToElement(front).perform();
		act.moveToElement(db).perform();
		act.moveToElement(back).perform();
		act.moveToElement(front).perform();
		act.moveToElement(back).perform();
		act.moveToElement(db).perform();
		act.moveToElement(testing).perform();
		act.moveToElement(back).perform();
		act.moveToElement(front).perform();
		act.moveToElement(db).perform();
		act.moveToElement(testing).perform();
		chrome.findElement(By.xpath("//li[text()='Selenium']")).click();

		ArrayList<String> tabs = new ArrayList<String> (chrome.getWindowHandles());
		Funciones.uWait(5);
		chrome.switchTo().window(tabs.get(0));
		Funciones.uWait(5);
		chrome.switchTo().window(tabs.get(1));
		chrome.findElement(By.linkText("Webdriver.chrome")).click();
		Funciones.uWait(5);
		chrome.close();
		chrome.switchTo().window(tabs.get(0));




	}
}