package myTestRunner;

	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "D:\\eclipse-workspace2\\myCucuSelProject\\src\\test\\java\\myFeatures\\firstFeatureFile.feature", 
		glue = { "myStepDefinitions" }, 
		tags = "@tag1",
		plugin = {"pretty", "html:test-output", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 	
		dryRun = false, 
		monochrome = true,
		publish=true
		)
	public class MyFirstJunitRunner {

	}

