package framework.ui.screen;


import com.sun.tools.javac.code.Attribute;
import framework.config.DriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import lombok.Data;
import  lombok.NoArgsConstructor;
import lombok.Generated;
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
import lombok.Getter;
import lombok.Setter;





/**
 * Created by pablomeseguer on 1/30/18.
 */
@Data
@NoArgsConstructor
public class Login {

    AppiumDriver<?> driver;

    String n;

    public Login(  AppiumDriver<?> driver) {

        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);


    }


    @AndroidFindBy(id="landing_already_have_account_button")
    // @iOSFindBy(id="login_button")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @AssertTrue(message = "Element found")
    @AssertFalse(message = "Element not found")
    public WebElement alReadyHaveAccountButton;

    @Getter
    @AndroidFindBy(id="login_username")
    @AssertTrue(message = "Element found")
    @AssertFalse(message = "Element not found")
   // @iOSFindBy( id="username_edit_text")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    public WebElement userNameTextBox;


    @AndroidFindBy(id="login_password")
    @AssertTrue(message = "Element found")
    @AssertFalse(message = "Element not found")
   // @iOSFindBy(id="password_edit_text")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    public WebElement passWordTextBox;

    @AndroidFindBy(id="login_signin_button")
   // @iOSFindBy(id="login_button")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @AssertTrue(message = "Element found")
    @AssertFalse(message = "Element not found")
    public WebElement loginButon;

    @AndroidFindBy(id="toolbar_title")
    // @iOSFindBy(id="login_button")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @AssertTrue(message = "Element found")
    @AssertFalse(message = "Element not found")
    public WebElement homeElement;








}
