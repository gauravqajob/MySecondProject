package myStepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import myHelper.Base;

public class FirstCode {
	WebDriver driver;
	Base base;
	public FirstCode(Base base) 
	{
		this.base=base;
	}
	//public static WebDriver driver;
	@Given("^user is hitting the url \"([^\"]*)\" for login$")
	public void user_is_hitting_the_url_for_login(String arg1) throws Throwable 
	{
		/*System.setProperty("webdriver.chrome.driver","D:\\git_Project\\MySecondProject\\myCucuSelProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(arg1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();*/
        //driver.quit();
        System.out.println("execution for scenario is started from here onwards:-----");
        base.getDriver().get(arg1);
        base.getDriver().manage().window().maximize();
	    
	}
	@Then("go to homepage")
	public void go_to_homepage() throws Throwable
	{
		base.getDriver().findElement(By.xpath("//input[@id='origin']")).sendKeys("patna");
		//driver.findElement(By.xpath("//input[@id='origin']")).sendKeys("patna");
		Thread.sleep(2000);
		//Creating object of an Actions class
		Actions action = new Actions(base.getDriver());
		WebElement ele1 = base.getDriver().findElement(By.xpath("//form[@id='Search_Flights']//following::li[2]/div"));
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele1).perform();
		action.click().build().perform();
		Thread.sleep(2000);
		base.getDriver().findElement(By.xpath("//input[@id='destination']")).sendKeys("del");
		Thread.sleep(2000);
		WebElement ele2 = base.getDriver().findElement(By.xpath("//input[@id='destination']//following::li[1]"));
		action.moveToElement(ele2).perform();
		action.click().build().perform();
		Thread.sleep(2000);
		
		
		//handling Calendar 
		WebDriverWait wait=new WebDriverWait(base.getDriver(),3000);
		WebElement waitElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dateNew']")));
		waitElement.click();
		//driver.findElement(By.xpath("//input[@id='dateNew']")).click();
		Thread.sleep(2000);
		while(!base.getDriver().findElement(By.xpath("//div[@id='dateNew_root']//div[@class='picker__header']")).getText().contains("May")) 
		{
			base.getDriver().findElement(By.xpath("//div[@id='dateNew_root']//div[@class='picker__nav--next']")).click();
		}
		List<WebElement> data= base.getDriver().findElements(By.xpath("//table[@id='dateNew_table']//div[@role='gridcell']"));
		int count=data.size();
		for(int i=0;i<count;i++)
		{
			String text=data.get(i).getText();
			System.out.println("list of date as text are:"+text);
			if(text.contains("23")) 
			{
				Thread.sleep(1000);
				base.getDriver().findElements(By.xpath("//table[@id='dateNew_table']//div[@role='gridcell']")).get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		WebElement ele = base.getDriver().findElement(By.xpath("//button[@type='submit']"));
		action.doubleClick(ele).perform();
		base.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



	    
	

}
