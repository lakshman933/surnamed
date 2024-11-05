package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {".//Features/"},
glue="stepdefination",

dryRun=false,
plugin={"pretty", "html:Signin/HtmlReports.html","json:target/cucumber.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome=false,
tags="@LG1"
)
public class Testrunlogin  extends AbstractTestNGCucumberTests{

}
