package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.config.DriverMobile;
import framework.config.DriverWait;
import framework.ui.screen.Login;
import io.appium.java_client.AppiumDriver;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;


import static org.assertj.core.api.Assertions.*;

public class mobileSteps  {


    DriverMobile driver=new DriverMobile();
    public static AppiumDriver<?> driverObject;
@After
public void INIT() throws Exception {

    Scenario scenario = null;
    if(scenario.getSourceTagNames().contains("iOS")) {
        new Login(driver.getDriver("iOS"));
    }
    else{
        new Login(driver.getDriver("Android"));
    }


}


    @When("^Open Android app$")
    public void openAndroidApp() throws Throwable {
        Scenario scenario = null;
        if(scenario.getSourceTagNames().contains("Android")) {
            driver.getDriver("Android");
        }

    }

    @When("^Open iOS app$")
    public void openIOSApp() throws Throwable {

    }


    @And("^User enters Credentials to LogIn$")
    public void userEntersCredentialsToLogIn() throws Throwable {



    }


    @When("^Add UserName$")
    public void addUserName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^Add PassWord$")
    public void addPassWord() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Login was successfully$")
    public void loginWasSuccessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
