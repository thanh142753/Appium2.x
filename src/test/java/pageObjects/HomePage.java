package pageObjects;

import widget.commonWidget.HomePageWidget;
import widget.commonWidget.IHomePageWidget;
import widget.commonWidget.ILoginWidget;
import widget.commonWidget.LoginWidget;

public class HomePage {

    private ILoginWidget iLoginWidget;
    private IHomePageWidget iHomePageWidget;

    public ILoginWidget getLoginWidget() {
        return iLoginWidget = new LoginWidget();
    }
    public IHomePageWidget getHomePageWidget() {
        return iHomePageWidget = new HomePageWidget();
    }
}
