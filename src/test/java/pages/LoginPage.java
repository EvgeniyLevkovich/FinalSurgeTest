package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final static String URL = "https://log.finalsurge.com/";
    private final static By LOGIN_FIELD = By.id("login_name");
    private final static By PASSWORD_FIELD = By.id("login_password");
    private final static By LOGIN_BUTTON = By.cssSelector(".btn.btn-beoro-1");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
        isPageOpened();
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public void login(User user) {
        driver.findElement(LOGIN_FIELD).sendKeys(user.getEmail());
        driver.findElement(PASSWORD_FIELD).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
    }
}