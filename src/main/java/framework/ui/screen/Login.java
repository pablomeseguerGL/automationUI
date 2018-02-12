package framework.ui.screen;


import com.sun.tools.javac.code.Attribute;
import framework.config.DriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.util.concurrent.TimeUnit;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;






/**
 * Created by pablomeseguer on 1/30/18.
 */
@Getter(AccessLevel.NONE)
@Setter(AccessLevel.NONE)
public class Login {

    AppiumDriver<?> driver;

    String n;

    public Login(  AppiumDriver<?> driver) {

        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);


    }



    @iOSFindBy( id="username_edit_text")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @AssertFalse(message = "Element not found")
    public WebElement userNameTextBox;


    @AndroidFindBy(id="password_edit_text")
    @iOSFindBy(id="password_edit_text")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    public WebElement passWordTextBox;

    @AndroidFindBy(id="login_button")
    @iOSFindBy(id="login_button")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @AssertTrue(message = "Element found")
    @AssertFalse(message = "Element not found")
    public WebElement loginButon;






}
