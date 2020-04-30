package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Login", enabled = true)
    @Description("Login using valid credentials")
    public void registration() {
        User user = new User("integri@mailinator.com", "Qwerty12345");
        loginSteps.login(user);
    }
}