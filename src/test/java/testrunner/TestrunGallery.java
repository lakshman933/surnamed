package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".//features/"},
glue = "stepdefination",
dryRun = false,
plugin={"pretty", "html:Signin/HtmlReports.html","json:target/cucumber.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome=false,
tags="@G1"

)
 
public class TestrunGallery extends AbstractTestNGCucumberTests {

}
