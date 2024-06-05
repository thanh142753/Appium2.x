package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class LoginSteps {

     HomePage homePage = new HomePage();

    public LoginSteps() {
    }


    @Given("the user navigates to login page")
    public void user_navigate_to_login_page() {
//        homePage2.getSearchWidget().enterProductName("vivo");
//        homePage2.getSearchWidget().clickSearch();
                   
    }

    @Given("I login to app successfully")
    public void iLoginToAppSuccessfully() {
        homePage.getLoginWidget().loginToAppSuccessfully();
    }

    @When("I input username {string}")
    public void iInputUsername(String username) {
        homePage.getLoginWidget().inputUsername(username);
    }

    @And("I input password {string}")
    public void iInputPassword(String password) {
        homePage.getLoginWidget().inputPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        homePage.getLoginWidget().clickOnLoginButton();
    }

    @Given("I login to google chrome")
    public void iLoginToGoogleChrome() {
        homePage.getLoginWidget().loginToGoogleChrome();
    }

    @And("I access link {string}")
    public void iAccessLink(String link) {
        homePage.getLoginWidget().accessLink(link);
    }


}
