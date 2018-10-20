package CucumberProject;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber" }, 
				  glue = {"CucumberProject" }, 
				  features = "./scenarios/BDDScenarios.feature", 
				  monochrome = true, 
				  tags = "@Tests",
				  dryRun=false)

public class TestRunnerCucumber {

}
