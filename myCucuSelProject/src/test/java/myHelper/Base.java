package myHelper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;

public class Base
{
	private WebDriver driver;
	private Scenario scenario;

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}

	
}
