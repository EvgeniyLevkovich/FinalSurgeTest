package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.LoginSteps;
import steps.WorkoutSteps;
import utils.CapabilitiesGenerator;
import java.util.concurrent.TimeUnit;

@Log4j2
public class BaseTest {
    WebDriver driver;
    LoginSteps loginSteps;
    WorkoutSteps workoutSteps;

    @BeforeMethod(description = "Opening Chrome Driver")
    public void setUp() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginSteps = new LoginSteps(driver);
        workoutSteps = new WorkoutSteps(driver);
    }

    @AfterMethod(description = "Closing browser", alwaysRun = false, enabled = false)
    public void closeBrowser() {
        driver.quit();
    }
}
