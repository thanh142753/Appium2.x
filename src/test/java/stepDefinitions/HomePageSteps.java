package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {

     HomePage homePage = new HomePage();

    public HomePageSteps() {
    }

    @And("I close the web advertisement")
    public void iCloseTheWebAdvertisement() {
        homePage.getHomePageWidget().closeTheWebAdvertisement();
    }

    @And("I add product {string} to the cart")
    public void iAddProductToTheCart(String productName) {
        homePage.getHomePageWidget().addProductToCart(productName);
    }

    @And("I click my cart")
    public void iClickMyCart() {
        homePage.getHomePageWidget().clickOnMyCart();
    }

    @Then("I verify the product {string} is displaying with the product quantity of {string}")
    public void iVerifyTheProductIsDisplayingWithTheProductQuantityOf(String productName, String quantity) {
        homePage.getHomePageWidget().verifyProductInCart(productName, quantity);
    }

    @And("I click on module {string}")
    public void iClickOnModule(String moduleName) {
        homePage.getHomePageWidget().clickOnModule(moduleName);
    }
}
