package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Login")
    @Description("Login using valid credentials")
    public void logIn() {
        User user = new User("integri@mailinator.com", "Qwerty12345");
        loginSteps.login(user);
    }

    @Test(retryAnalyzer = Retry.class, description = "Incorrect password")
    @Description("Login using invalid password")
    public void invalidPassword() {
        User user = new User("integri@mailinator.com", "1234512345");
        loginSteps.invalidPasswordLogin(user);
    }
}