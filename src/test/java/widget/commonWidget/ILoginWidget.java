package widget.commonWidget;

public interface ILoginWidget extends IBaseWidget{


    void loginToAppSuccessfully();

    void inputUsername(String username);

    void inputPassword(String password);

    void clickOnLoginButton();

    void loginToGoogleChrome();

    void accessLink(String link);
}
