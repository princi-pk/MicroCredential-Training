
package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "features" }, plugin = { "json:target/Destination/CucumberReportJSON.json",
		"junit:target/Destination/CucumberReportXML.xml", "html:target/DestinationCucumberReport" }, glue = { "steps" })
public class TestRunner {

}
