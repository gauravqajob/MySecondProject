package myStepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import myHelper.Base;
import myHelper.GenericFunctions;

public class Hooks 
{
	WebDriver driver;
	Scenario scenario;
	Base base;
	GenericFunctions GenericFunction;
	public Hooks(Base base ,GenericFunctions GenericFunction) 
	{
		this.base=base;
		this.GenericFunction=GenericFunction;
	}
	@Before
	public void beforeHooks() 
	{
		base.setDriver();
		base.setScenario(scenario);
	}
	@AfterStep
	public void as(Scenario scenario) throws IOException, InterruptedException
	{
	    scenario.attach(GenericFunction.getByteScreenshot(), "image/png", "screenshot name");		
	}
	@After
	public void afterHooks(Scenario scenario) throws IOException 
	{
		if(scenario.isFailed())
	    {			
	        scenario.attach(GenericFunction.getByteScreenshot(), "image/png", scenario.getName());
	    }
		//base.getDriver().close();
	}
	

}
