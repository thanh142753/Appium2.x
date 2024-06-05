package widget.commonWidget;

import factory.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.bs.I;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import widget.elementLocator.BaseWidgetElementLocator;

public class LoginWidget extends BaseWidget implements ILoginWidget {

    BaseClass baseClass = BaseClass.getInstance();

    // String xpath
    String IF_USERNAME = "//android.widget.EditText[@content-desc='test-Username']";
    String IF_PASSWORD = "//android.widget.EditText[@content-desc=\"test-Password\"]";
    String BTN_LOGIN = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]";
    String ICON_CART = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]";

    String BTN_ACCEPT = "//android.widget.Button[@resource-id='com.android.chrome:id/terms_accept']";
    String BTN_CONTINUE = "//android.widget.Button[@text='CONTINUE']";
    String BTN_OkGotIt = "//android.widget.Button[@text='OK, GOT IT']";
    String IF_SearchWeb = "//android.widget.EditText[@resource-id='com.android.chrome:id/search_box_text']";
    String IF_SearchWebOnHeader = "//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']";

    @Override
    public void loginToAppSuccessfully() {
        Assert.assertTrue(getAndroidElementByXpath(ICON_CART).isDisplayed());
    }

    @Override
    public void inputUsername(String username) {
        inputValueToField(IF_USERNAME,username);
    }

    @Override
    public void inputPassword(String password) {
        inputValueToField(IF_PASSWORD,password);
    }

    @Override
    public void clickOnLoginButton() {
        getAndroidElementByXpath(BTN_LOGIN).click();
    }

    @Override
    public void loginToGoogleChrome() {
        getAndroidElementByXpath(BTN_ACCEPT).click();
        getAndroidElementByXpath(BTN_CONTINUE).click();
        getAndroidElementByXpath(BTN_OkGotIt).click();
    }

    @Override
    public void accessLink(String link) {
        baseClass.getDriver().get(link);



//        getAndroidElementByXpath(IF_SearchWeb).click();
//        getAndroidElementByXpath(IF_SearchWebOnHeader).sendKeys(link);
//        baseClass.getDriver().getKeyboard().sendKeys(Keys.ENTER);
//        ((AndroidDriver<MobileElement>) baseClass.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
//        getAndroidElementByXpath(IF_SearchWebOnHeader).sendKeys(new KeyEvent(AndroidKey.ENTER));
    }
}
