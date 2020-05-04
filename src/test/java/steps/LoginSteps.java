package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login using valid username and password")
    public void login(User user) {
        loginPage.openPage()
                 .login(user)
                 .isDashboardPageOpened();
    }

    @Step("Try to login using incorrect password")
    public void invalidPasswordLogin(User user) {
        loginPage.openPage()
                .login(user)
                .notificationCheck();
    }
}

