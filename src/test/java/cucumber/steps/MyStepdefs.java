package cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.config.DriverWeb;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {

    WebDriver driver = null;






    @When("^I go to X page$")
    public void iGoToXPage() throws Throwable {
        driver = DriverWeb.getWebDriver("test");
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
    }

    @Then("^I see that element$")
    public void i_see_that_element() throws Throwable {
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();

    }
}
