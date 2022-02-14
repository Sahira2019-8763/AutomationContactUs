package Ejercicio2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PageContactUs {
	private WebDriver driver;
	By linkLocator = By.linkText("Contact us");
	By dropDownList =By.id("id_contact");
	By userLocator = By.id("email");
	By oderLocator = By.name("id_order");
	By messageLocator = By.id("message");
	By btnSubmit= By.name("submitMessage");


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	

	@Test
	public void testFillForm() throws InterruptedException {
		driver.findElement(linkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(userLocator).isDisplayed()) {
			equals(Ddlist("Webmaster"));
			driver.findElement(userLocator).sendKeys("Sahirareyesmedina@gmail.com");
			driver.findElement(oderLocator).sendKeys("Ninguna");
			driver.findElement(messageLocator).sendKeys("Esta en una prueba");
			Thread.sleep(2000);
			driver.findElement(btnSubmit).click();
			
			
		} else {
			
			System.out.println("The page not was found");
		}

		
	}
	

	public String Ddlist(String string) {
		Select selecList = new Select(driver.findElement(dropDownList));
		selecList.selectByVisibleText("Webmaster");
		return getText(selecList.getFirstSelectedOption());
	}
	

	private String getText(WebElement firstSelectedOption) {
		// TODO Auto-generated method stub
		return null;
	}
}
