package framework.ui.windows;

import framework.config.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by pablomeseguer on 1/30/18.
 */
public class Login  extends Driver {





    @AndroidFindBy(id="username_edit_text")
    private WebElement userNameTextBox;


    @AndroidFindBy(id="password_edit_text")
    private WebElement passWordTextBox;

    @AndroidFindBy(id="login_button")
    private WebElement loginButon;

    public void AbstractScreen() {


        PageFactory.initElements(new AppiumFieldDecorator(Driver.setDriver("Android")), this);
        userNameTextBox.sendKeys("hola");
        passWordTextBox.sendKeys("pop");
        loginButon.click();


    }





}
