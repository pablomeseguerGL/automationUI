package framework.config;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class DriverWait {


    AppiumDriver<?> driver;
    public DriverWait( AppiumDriver<?> driver) {
     this.driver= driver;

    }




    public WebElement waitElementClickable(WebElement element){


        return  (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(element));

    }


    public  WebElement waitElementVisibly(WebElement element){


        try{

        if(getLocatorType(element).contains("xpath")){
            return  (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getLocatorValue(element))));

        }
        if(getLocatorType(element).contains("id")){
            return  (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id(getLocatorValue(element))));

        }
        if(getLocatorType(element).contains("className")){
            return  (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className(getLocatorValue(element))));

        }
        if(getLocatorType(element).contains("name")){
            return  (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.name(getLocatorValue(element))));

        }
        }
        catch (NoSuchElementException ex)
        {
            throw  ex;
        }

        return element;
    }

    public static String getLocatorType(WebElement element){

        return element.toString().split("By")[2].split(":")[0].replace(".","");
    }
    public  static String getLocatorValue(WebElement element){
     return element.toString().split("By")[2].split(":")[1].replace("}","").replace(")","");

    }
}
