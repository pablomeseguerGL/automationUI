package framework.config;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public  class Element implements WebElement, WrapsDriver, WrapsElement {

    protected By by;
    private Element root;

    private Select select;
    private WaitUntil wait;
    protected WebDriver driver;
    private WebElement webElement;
    protected boolean needsReload = false;

    public Element(By by, WebDriver driver) {
        this.by = by;
        this.driver = driver;
    }







    @Override
    public void click() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(by));

        element.click();
    }



    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(by));

        element.sendKeys(keysToSend);
    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public <T extends WebElement> List<T> findElements(By by) {
        return null;
    }

    @Override
    public <T extends WebElement> T findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(by));

      return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }

    @Override
    public WebDriver getWrappedDriver() {
        return null;
    }

    @Override
    public WebElement getWrappedElement() {
        return null;
    }

    public enum WaitUntil {

        VISIBLE("visible"), PRESENT("present"), CLICKABLE("clickable"), NOTREQUIRED("notrequired");

        private String waitType;

        WaitUntil(String waitType) {
            this.waitType = waitType;
        }

        public String getWaitType() {
            return waitType;
        }
    }

}
