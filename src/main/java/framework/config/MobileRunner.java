package framework.config;

import java.util.List;

import cucumber.api.java.gl.E;
import framework.ui.windows.Login;
import org.openqa.selenium.remote.DesiredCapabilities;

import static framework.config.DriverMobile.getJsonProperties;
import static framework.config.MobileCapabilities.searchCapability;

/**
 * Created by pablomeseguer on 2/1/18.
 */
public class MobileRunner  implements Runnable{

    Object object;
    public MobileRunner(Object object) {
        this.object=object;
    }



    public static void test(Object object){
Login login = null;
        List<Runnable> object1=null;
        object1.add((Runnable) login);
        new Thread((Runnable) object1).start();

    }
    @Override
    public void run() {


        test(object);

    }


}
