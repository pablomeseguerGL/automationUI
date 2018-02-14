package framework.config;

import framework.common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selector {

    public static Element generateSelector( String selector,String selectorTypeValue, String platform ,WebDriver driver) {

        String appPackage = "com.gloo.polymerandroid";
        String[] selectorAndInstance = selector.split(":");
        String selectorType =getTypeSelector(platform ,selectorTypeValue);

        String trimmedSelector = selectorType.equals("@resource-id") ? appPackage + ":id/" + selector : selector;
        String selectorPath = selectorType.equals("native-ios") ? "(//"+trimmedSelector+")" :
                "(//*[contains(concat(' ', normalize-space(" + selectorType + "), ' '), ' " + trimmedSelector + " ')])";
        String instance = selectorAndInstance.length == 2 ? "[" + selectorAndInstance[1] + "]" : "";
        String xPath = selectorPath + instance;
       WebElement element= driver.findElement(By.xpath(xPath));
        return new Element(element,driver);

    }


    private static String getTypeSelector(String platform,String selectorType){

        switch (platform.toLowerCase()) {
            case "android":

                switch (selectorType.toLowerCase()) {
                    case "id":
                        selectorType = "@resource-id";
                        break;
                    case "classname":
                        selectorType = "@class";
                        break;
                    case "text":
                        selectorType = "@text";
                        break;
                    case "native-ios":

                }
            case "iOS":
                switch (selectorType.toLowerCase()) {
                    case "id":
                        selectorType = "@id";
                        break;
                    case "classname":
                        selectorType = "@name";
                        break;
                    case "text":
                        selectorType = "text()";
                        break;
                    case "native-ios":
                        selectorType = "native-ios";
                        break;
                }


        }
        return selectorType;
    }

    public Element getElement(WebDriver driver,String featureName,String property) {
        String[] value=  new Utilities().getSelectors(featureName,property).split("~");
       return generateSelector(value[0],value[1],value[2],driver);
    }
}
