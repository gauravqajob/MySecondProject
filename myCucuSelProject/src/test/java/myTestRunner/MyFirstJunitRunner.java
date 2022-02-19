package myTestRunner;

	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "D:\\git_Project\\MySecondProject\\myCucuSelProject\\src\\test\\java\\myFeatures\\firstFeatureFile.feature", 
		glue = { "myStepDefinitions" }, 
		tags = "@smoketest1",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 	
		dryRun = false,
		monochrome = true,
		publish=false
		)
	public class MyFirstJunitRunner {

	}

