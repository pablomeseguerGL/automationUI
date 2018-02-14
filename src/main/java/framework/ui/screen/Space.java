package framework.ui.screen;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.util.concurrent.TimeUnit;


/**
 * Created by pablomeseguer on 1/30/18.
 */
@Data
@NoArgsConstructor
public class Space {

    AppiumDriver<?> driver;

    String n;

    public Space(AppiumDriver<?> driver) {

        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);


    }
    @AndroidFindBy(id="bottom_nav_spaces")
    // @iOSFindBy(id="login_button")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @AssertTrue(message = "Element found")
    @AssertFalse(message = "Element not found")
    public WebElement spaceIcon;


    @AndroidFindBy(id="action_create_space")
    // @iOSFindBy(id="login_button")
    @WithTimeout(time = 15, unit = TimeUnit.SECONDS)
    @AssertTrue(message = "Element found")
    @AssertFalse(message = "Element not found")
    public WebElement newSpaceButton;










}
