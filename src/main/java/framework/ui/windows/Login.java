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
public class Login   implements Runnable  {


    DesiredCapabilities capabilities;
    ArrayList<DesiredCapabilities> listCapability=new ArrayList<>();


            String platformName;
    public Login(String platformName) {

         this.platformName=platformName;
         listCapability= getCapabilities(platformName);

    }

    @AndroidFindBy(id="username_edit_text")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    private WebElement userNameTextBox;


    @AndroidFindBy(id="password_edit_text")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    private WebElement passWordTextBox;

    @AndroidFindBy(id="login_button")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)

    private WebElement loginButon;



    public void installApp() {
      DesiredCapabilities cap=  listCapability.get(0);


            DriverMobile driver=new DriverMobile();



       // AppiumDriver<?> d=    driver.getDriver();
        try {
         AppiumDriver<?> driver1=driver.getDriver("sd");
            PageFactory.initElements( new AppiumFieldDecorator(driver1),this);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void addUserName(){
        userNameTextBox.sendKeys("hola");
    }

    public void addPassword(){
        passWordTextBox.sendKeys("pop");
    }

    public void clickButton(){
        loginButon.click();
    }

    public static void main() {


        /*
        Runnabler1 = new Login(capabilities);
        List<Runnable> runnables;
      for (DesiredCapabilities capabilities:getCapabilities("Android")){

          runnables.add()
      }

      }
        for(){

        new Thread(r1).start();


   List<Runnable> runnings;
        LinkedList browsers = new LinkedList();
for (DesiredCapabilities capa:getCapabilities("Android")){

    browsers.add( new Login(capa));
}
for (Object n:browsers){
    new Thread((Runnable) n).start();
}
*/
    }

    @Override
    public void run() {

    }



}
