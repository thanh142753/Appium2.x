package widget.commonWidget;

import factory.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebElement;

public class BaseWidget implements IBaseWidget {

    BaseClass baseClass = BaseClass.getInstance();

    String TextElement = "//*[text()='%s']";

    WebDriverWait wait = new WebDriverWait(baseClass.getDriver(), Duration.ofSeconds(10));

    JavascriptExecutor javascriptExecutor=(JavascriptExecutor)baseClass.getDriver();

    //private function

//    private void changeDriverContextTo (String driverContext){
//        Set<String> allContext = baseClass.getDriver().ge();
//        System.out.println(allContext);
//        for (String context : allContext) {
//            if (context.contains(driverContext)) baseClass.getDriver().context(context); //WEBVIEW || NATIVE
//        }
//    }

    public void clickToElementByText(String text) {
        try {
//            Thread.sleep(2000);
            waitForElementIsDisplayed(String.format(TextElement, text));
            waitForElementIsClickable(String.format(TextElement, text));
            getAndroidElementByXpath(String.format(TextElement, text)).click();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void clickToElementByJs(String xpath) {
        WebElement webElement = getAndroidElementByXpath(xpath);
        javascriptExecutor.executeScript("document.evaluate(\""+xpath+"\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();");
//        javascriptExecutor.executeScript("arguments[0].click()", webElement);
    }

    public void waitForElementIsDisplayed(String elementXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
    }

    public void waitForElementIsClickable(String elementXpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }

    @Override
    public WebElement getAndroidElementByXpath(String xpath) {
        return baseClass.getDriver().findElement(By.xpath(xpath));
    }

    @Override
    public void inputValueToField(String xpath, String value) {
        getAndroidElementByXpath(xpath).clear();
        getAndroidElementByXpath(xpath).sendKeys(value);
    }

//    @Override
//    public void switchToNativeApp() {
//        changeDriverContextTo("NATIVE");
//    }
//
//    @Override
//    public void switchToWebViewApp() {
//        changeDriverContextTo("WEBVIEW");
//    }





}
