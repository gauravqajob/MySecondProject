package myStepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;

public class FirstCode {
	public static WebDriver driver;
	@Given("^user is hitting the url \"([^\"]*)\" for login$")
	public void user_is_hitting_the_url_for_login(String arg1) throws Throwable 
	{
		//System.setProperty("webdriver.gecko.driver","D:\\eclipse-workspace2\\myCucuSelProject\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\eclipse-workspace2\\myCucuSelProject\\drivers\\chromedriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(arg1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
        System.out.println("execution for scenario is done");
        
	    
	}

}
