package selenium_tfg.funciones;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.TestRunner;


public class Funciones {

    static WebDriver chrome;
    static Properties props = new Properties();
    static String mainTab;
    static String firstTab;
    static String secondTab;

    public static void tearDown() throws InterruptedException {
        uWait(10);
		WebElement logout = chrome.findElement(By.id("logout"));
		logout.click();
		uWait(10);
		chrome.quit();
    }



    public static void login(String locator) {

        WebElement userSelect = chrome.findElement(By.id("userSelect"));
		userSelect.click();

		Funciones.fluentXpath(locator, 3);
		WebElement user = chrome.findElement(By.xpath(locator));
		String username = user.getText();
		user.click();

		WebElement passGenerate = chrome.findElement(By.id("generatePass"));
		passGenerate.click();

		Funciones.fluentId("passGenerated", 3);
		String password = chrome.findElement(By.id("passGenerated")).getText();
		WebElement userInput = chrome.findElement(By.name("username"));
		userInput.sendKeys(username);

		WebElement passInput = chrome.findElement(By.name("password"));
		passInput.sendKeys(password);

		chrome.findElement(By.name("btn-login")).click();
    }

    public static WebDriver setUp(Properties propiedades) throws IOException {
        System.setProperty(propiedades.getProperty("chromeDriver"), propiedades.getProperty("driverPath"));
		chrome = new ChromeDriver();
		chrome.manage().window().maximize();
		chrome.get(propiedades.getProperty("baseUrl"));
        return chrome;
    }

    public static Properties props(String propFileName) throws IOException {    
        InputStream inputStream = TestRunner.class.getClassLoader().getResourceAsStream(propFileName);
        props.load(inputStream);
        return props;
    }
    
    public static void uWait(int time) throws InterruptedException{
        Thread.sleep(time*100);
    }

    public static void fluentXpath(String locator, int time) {
        final String finalLocator = locator;
        Wait<WebDriver> wait = new FluentWait<>(chrome)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        wait.until(new com.google.common.base.Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver chrome) {
                return chrome.findElement(By.xpath(finalLocator));
            }
        }).isDisplayed();
    }

    public static void fluentId(String locator, int time) {
        final String finalLocator = locator;
        Wait<WebDriver> wait = new FluentWait<>(chrome)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(Exception.class);

        wait.until(new com.google.common.base.Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver chrome) {
                return chrome.findElement(By.id(finalLocator));
            }
        }).isDisplayed();
    }

    public void fluentName(String locator, int time) {
        final String finalLocator = locator;
        Wait<WebDriver> wait = new FluentWait<>(chrome)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(Exception.class);

        wait.until(new com.google.common.base.Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver chrome) {
                return chrome.findElement(By.name(finalLocator));
            }
        }).isDisplayed();
    }

    public static void threeTabsLogin(Properties propiedades, String mainUrl, String firstUrl, String secondUrl) throws InterruptedException {

        mainTab = chrome.getWindowHandle();
        firstTab = "";
        secondTab = "";
        Funciones.uWait(20);
        ((JavascriptExecutor)chrome).executeScript("window.open()");
        Funciones.uWait(20);
        ((JavascriptExecutor)chrome).executeScript("window.open()");
        Funciones.uWait(20);
        Set<String> handles = chrome.getWindowHandles();
        //Funciones.login(mainUrl);
        Funciones.uWait(20);

        int i = 1;
        for (String actual : handles) {
            if (!actual.equalsIgnoreCase(mainTab)) {
                if (i==1) {
                    chrome.switchTo().window(actual);
                    firstTab = actual;
                    chrome.get(propiedades.getProperty("baseUrl"));
                    Funciones.uWait(20);
                    Funciones.login(firstUrl);
                    Funciones.uWait(20);
                }
            } else if (i==2) {
                chrome.switchTo().window(actual);
                secondTab = actual;
                chrome.get(propiedades.getProperty("baseUrl"));
                Funciones.uWait(20);
                Funciones.login(secondUrl);
                Funciones.uWait(20);
            }
            i++;
        }
        chrome.switchTo().window(firstTab);
    }
}