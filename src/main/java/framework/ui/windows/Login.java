package framework.ui.windows;

import framework.config.DriverMobile;
import framework.config.MobileCapabilities;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pablomeseguer on 1/30/18.
 */
public class Login  extends DriverMobile  implements Runnable  {


    DesiredCapabilities capabilities;
    ArrayList<DesiredCapabilities> listCapability=new ArrayList<>();

            String platformName;
    public Login(String platformName) {
        super();
        this.platformName=platformName;
         listCapability= getCapabilities(platformName);

    }

    @AndroidFindBy(id="username_edit_text")
    private WebElement userNameTextBox;


    @AndroidFindBy(id="password_edit_text")
    private WebElement passWordTextBox;

    @AndroidFindBy(id="login_button")
    private WebElement loginButon;



    public void AbstractScreen() {
      DesiredCapabilities cap=  listCapability.get(0);
      AppiumDriver<?> d=  DriverMobile.returnDriver(platformName,cap );

        PageFactory.initElements( new AppiumFieldDecorator(DriverMobile.returnDriver(platformName, listCapabilities.get(0))),this);
        userNameTextBox.sendKeys("hola");
        passWordTextBox.sendKeys("pop");
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
        AbstractScreen();
    }



}
