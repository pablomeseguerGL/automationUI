package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import framework.config.DriverWeb;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyStepdefs3{

    public static WebDriver driver = null;
    public static Scenario myScenario;

    @Before
    public void setUp(Scenario scenario){
        myScenario=scenario;
    }


    @When("^I go to home page$")
    public void iGoToXPage() throws Throwable {
        driver = DriverWeb.getWebDriver("test2");
        driver.get("https://www.google.es/");
        Thread.sleep(2000);
    }

    @Then("^I check the title of the page$")
    public void i_see_that_element() throws Throwable {
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
        DriverWeb.setResults(myScenario);
    }

}
