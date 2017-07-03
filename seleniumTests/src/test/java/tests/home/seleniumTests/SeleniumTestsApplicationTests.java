package tests.home.seleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class SeleniumTestsApplicationTests {

	private WebDriver driver;

	@BeforeClass
	public static void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "/home/snekky/chromedriver");
	}

	@Before
	public void createDriver() {

		driver = new ChromeDriver();
	}

	@Test
	public void contextLoads() {
	}

	/*
	Перед тестом нужно поднять сервер. По-другому нз как
	 */
	@Test
	public void CheckCorrectInput() {
		driver.get("http://localhost:8080");
		driver.findElement(By.id("input")).sendKeys("Angular");

		String name = driver.findElement(By.className("contact-name")).getText();
		assertEquals(name, "Angular");
	}

	@Test(expected = org.openqa.selenium.NoSuchElementException.class)
	public void CheckIncorrectInput() {
		driver.get("http://localhost:8080");
		driver.findElement(By.id("input")).sendKeys("React1");
		String name = driver.findElement(By.className("contact-name")).getText();
		assertEquals(name, "React1");
	}

//	@Test
//	public void checkCorrectSearch() {
//		driver.get("http://localhost:8080");
//		driver.findElement(By.className("contact-name")).getText() ==
//
//
//	}

	@After
	public void quitDriver() {

		driver.quit();
	}
}
