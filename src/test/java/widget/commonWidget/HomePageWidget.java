package widget.commonWidget;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;

public class HomePageWidget extends BaseWidget implements IHomePageWidget {

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

    String BTN_CloseAdvertisement = "//div[@class='badge-custom']//*[text()=\"X\"]";
    String ModuleName = "//*[text()='%s']";
    String BTN_AddProductByName = "//*[text()='%s']/ancestor::*[contains(@class, 'product-card')]//*[text()='Thêm vào giỏ']";
    String BTN_MyCart = "//*[@class='menu-item product-cart']";
    String ProductInCart = "//*[text()='%s']/ancestor::*[contains(@class, 'cart-itemstyle__ItemBox')]//*[contains(@class, 'CounterValue') and text()='%s']";

    @Override
    public void closeTheWebAdvertisement() {
        getAndroidElementByXpath(BTN_CloseAdvertisement).click();
    }

    @Override
    public void addProductToCart(String productName) {
        waitForElementIsDisplayed(String.format(BTN_AddProductByName, productName));
        getAndroidElementByXpath(String.format(BTN_AddProductByName, productName)).click();
        clickToElementByText("TP. Hà Nội");
        clickToElementByText("H. Đan Phượng");
        clickToElementByText("TT. Phùng");
        clickToElementByText("Xác nhận");
//        Thread.sleep(4000);
        clickToElementByJs(String.format(BTN_AddProductByName, productName));
//        getAndroidElementByXpath(String.format(BTN_AddProductByName, productName)).click();
//        Thread.sleep(4000);
    }

    @Override
    public void clickOnMyCart() {
        waitForElementIsDisplayed(BTN_MyCart);
        clickToElementByJs(BTN_MyCart);
//        getAndroidElementByXpath(BTN_MyCart).click();
    }

    @Override
    public void verifyProductInCart(String productName, String quantity) {
        waitForElementIsDisplayed(String.format(ProductInCart, productName, quantity));
        getAndroidElementByXpath(String.format(ProductInCart, productName, quantity)).isDisplayed();
    }

    @Override
    public void clickOnModule(String moduleName) {
        getAndroidElementByXpath(String.format(ModuleName, moduleName)).click();
    }
}
