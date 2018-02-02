package framework.ui.windows;

import framework.config.DriverMobile;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pablomeseguer on 1/30/18.
 */
public class Login  extends DriverMobile  implements Runnable  {


    DesiredCapabilities capabilities;

    public Login(DesiredCapabilities capabilities) {
        this.capabilities=capabilities;
    }

    public Login() {
    }

    @AndroidFindBy(id="username_edit_text")
    private WebElement userNameTextBox;


    @AndroidFindBy(id="password_edit_text")
    private WebElement passWordTextBox;

    @AndroidFindBy(id="login_button")
    private WebElement loginButon;



    public void AbstractScreen() {



        PageFactory.initElements( new AppiumFieldDecorator(DriverMobile.returnDriver(capabilities)),this);
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
*/

   List<Runnable> runnings;
        LinkedList browsers = new LinkedList();
for (DesiredCapabilities capa:getCapabilities("Android")){

    browsers.add( new Login(capa));
}
for (Object n:browsers){
    new Thread((Runnable) n).start();
}

    }

    @Override
    public void run() {
        AbstractScreen();
    }



}
