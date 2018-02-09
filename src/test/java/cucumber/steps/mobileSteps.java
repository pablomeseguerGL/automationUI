package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.config.DriverMobile;
import framework.ui.windows.Login;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static framework.config.MobileCapabilities.getCapabiltiiesJson;
import static org.assertj.core.api.Assertions.*;

public class mobileSteps {


    DriverMobile driver=new DriverMobile();
    public static AppiumDriver<?> driverObject;
    @When("^Open Android app$")
    public void openAndroidApp() throws Throwable {



        try {

            //   driver.androidDriverRun("Android");
            driverObject=driver.getDriver("Android");
            Login login;
            login =new Login(driverObject);
            login.addUserName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^Open iOS app$")
    public void openIOSApp() throws Throwable {
        try {
            //   driver.androidDriverRun("Android");
            driver.getDriver("iOS");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^Add user name$")
    public void addUserName() throws Throwable {

    }
}
