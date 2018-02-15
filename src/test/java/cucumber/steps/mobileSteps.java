package cucumber.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.common.Utilities;
import framework.config.DriverMobile;
import framework.config.Element;
import framework.config.Selector;
import gherkin.ast.Background;
import io.appium.java_client.AppiumDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static framework.config.Selector.generateSelector;
import static org.assertj.core.api.Assertions.*;

public class mobileSteps  {


    DriverMobile driverMobile=new DriverMobile();
    WebDriver driver=null;
    String featureName;
    @Before
    public void setUp(Scenario scenario) throws Exception {
        this.featureName= scenario.getId().split(";")[0];

        }





    @When("^I submit username$")
    public void
    iSubmitUsername() throws Throwable {


    }

    @When("^I submit password$")
    public void iSubmitPassword() throws Throwable {


    }



    @Given("^Open Android platform$")
    public void openAndroidPlatform() throws Throwable {
        this.driver=driverMobile.getDriver("Android");

    }

    @Given("^Open iOS platform$")
    public void openIOSPlatform() throws Throwable {

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
}

