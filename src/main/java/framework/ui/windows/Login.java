package framework.ui.windows;

import framework.config.DriverMobile;
import framework.config.MobileCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static framework.config.DriverMobile.driver;
import static framework.config.MobileCapabilities.getCapabilities;

/**
 * Created by pablomeseguer on 1/30/18.
 */
public class Login {

    AppiumDriver<?> driver;


    public Login(  AppiumDriver<?> driver) {
        this.driver=driver;
        PageFactory.initElements( new AppiumFieldDecorator(driver),this);

    }

    @AndroidFindBy(id="username_edit_text")
    @iOSFindBy( id="username_edit_text")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    private WebElement userNameTextBox;


    @AndroidFindBy(id="password_edit_text")
    @iOSFindBy(id="password_edit_text")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    private WebElement passWordTextBox;

    @AndroidFindBy(id="login_button")
    @iOSFindBy(id="login_button")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @AssertTrue(message = "Element found")
    @AssertFalse(message = "Element not found")
    private WebElement loginButon;





    public void addUserName(){
        userNameTextBox.sendKeys("hola");
    }

    public void addPassword(){
        passWordTextBox.sendKeys("pop");
    }

    public void clickButton(){
        loginButon.click();
    }




}
