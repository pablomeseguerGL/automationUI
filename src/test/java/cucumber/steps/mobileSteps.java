package cucumber.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.common.Utilities;
import framework.config.DriverMobile;
import framework.config.DriverWeb;
import framework.config.Element;
import framework.config.Selector;
import gherkin.ast.Background;
import io.appium.java_client.AppiumDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

import static framework.config.Selector.generateSelector;
import static org.assertj.core.api.Assertions.*;

public class mobileSteps  {


    DriverMobile driverMobile=new DriverMobile();
    DriverWeb driverWeb=new DriverWeb();
    WebDriver driver=null;
    String featureName;
    @Before
    public void setUp(Scenario scenario) throws Exception {
        this.featureName= scenario.getId().split(";")[0];

        }









    @Given("^Open Android platform$")
    public void openAndroidPlatform() throws Throwable {
        this.driver=driverMobile.getDriver("Android");

    }





    @And("^I click the \"([^\"]*)\" element$")
    public void iClickTheElement(String element) throws Throwable {

       new Selector().getElement(driver,checkLoginSelector(element),element).click();
    }


    @And("^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
    public void iEnterInTheField( String value,String element) throws Throwable {

        new Selector().getElement(driver,checkLoginSelector(element),element).sendKeys(value);

    }

    @And("^I \"([^\"]*)\" see the \"([^\"]*)\" element$")
    public void iSeeTheElement( String value,String element) throws Throwable {

        Assert.assertEquals(new Selector().getElement(driver,checkLoginSelector(element),element).isDisplayed(),true);

    }

    @And("^element \"([^\"]*)\" will have the \"([^\"]*)\" \"([^\"]*)\"$")
    public void elementWillHaveThe(String selector, String attribute, String value) throws Throwable {


    }


    public String  checkLoginSelector(String element){
        if(element.contains("~Login")){
            return "login";
        }
        else
        {
            return this.featureName;
        }
    }

    @And("^I close the keyboard$")
    public void iCloseTheKeyboard() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.driver.navigate().back();
    }


    @Given("^Open iOS platform$")
    public void openIOSPlatform() throws Throwable {
        this.driver=driverMobile.getDriver("iOS");
    }

    @Given("^Open Web platform$")
    public void openWebPlatform() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.driver=driverWeb.getWebDriver("test");
    }

    @When("^I go to \"([^\"]*)\" page$")
    public void iGoToPage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to(arg0);
    }
}

