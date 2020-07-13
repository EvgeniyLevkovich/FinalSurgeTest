package pages;

import lombok.extern.log4j.Log4j2;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginPage extends BasePage {
    private final static String URL = "https://log.finalsurge.com/";
    private final static By LOGIN_FIELD = By.id("login_name");
    private final static By PASSWORD_FIELD = By.id("login_password");
    private final static By LOGIN_BUTTON = By.cssSelector(".btn.btn-beoro-1");
    private final static By INVALID_LOGIN_NOTIFICATION = By.xpath("//*[text()='Invalid login credentials. Please try again.']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get(URL);
        isPageOpened();
        return this;
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public LoginPage login(User user) {
        log.info("Login using login: " + user.getEmail() + ", password: " + user.getPassword());
        driver.findElement(LOGIN_FIELD).sendKeys(user.getEmail());
        driver.findElement(PASSWORD_FIELD).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public void isDashboardPageOpened() {
       assertEquals(driver.getCurrentUrl(), "https://log.finalsurge.com/", "Dashboard isn't opened");
    }

    public void notificationCheck() {
        assertTrue(driver.findElement(INVALID_LOGIN_NOTIFICATION).isDisplayed(), "Invalid login notification isn't displayed");
    }
}