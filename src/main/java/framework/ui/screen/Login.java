package framework.ui.screen;


import com.sun.tools.javac.code.Attribute;
import framework.config.DriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.util.concurrent.TimeUnit;

/**
 * Created by pablomeseguer on 1/30/18.
 */
@Getter(AccessLevel.NONE)
@Setter(AccessLevel.NONE)
public class Login extends DriverWait {

    AppiumDriver<?> driver;



    public Login(  AppiumDriver<?> driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);


    }


    private int age = 10;





    public final static String TESTNG_TEST_TIMEOUT = "username_edit_text1";
   // public final static String TESTNG_TEST_TIMEOUT = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/TextInputLayout[1]/android.widget.FrameLayout[1]/android.widget.EditText[1]";

    @AndroidFindBy(id=TESTNG_TEST_TIMEOUT)
    @iOSFindBy( id="username_edit_text")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @AssertFalse(message = "Element not found")
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

        try {
            userNameTextBox.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
        throw  e;
        }





    }

    public void addPassword(){
    waitElementClickable(passWordTextBox).click();

    }




    public void clickButton(){
        loginButon.click();
    }




}
