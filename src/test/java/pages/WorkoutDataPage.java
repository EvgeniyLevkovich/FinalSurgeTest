package pages;

import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WorkoutDataPage extends BasePage {

    private final static String UPDATE_WORKOUT_CSS = ".dropdown-toggle";
    private final static String ACTIVITY_TYPE_NAME_CSS = ".activityTypeName";
    private final static String WORKOUT_NAME_CSS = "div[style='clear: both; padding-top: 10px;']";
    private final static String WORKOUT_DESCRIPTION_CSS = ".dont-break-out";

    public WorkoutDataPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(UPDATE_WORKOUT_CSS)));
    }

    public void dataChecking(String activityType, Workout workout) {
        isPageOpened();
        assertEquals(driver.findElement(By.cssSelector(ACTIVITY_TYPE_NAME_CSS)).getText(), activityType, "Activity type doesn't match");
        assertEquals(driver.findElement(By.cssSelector(WORKOUT_NAME_CSS)).getText(), workout.getName(), "Workout name doesn't match");
        assertTrue(driver.findElement(By.cssSelector(WORKOUT_DESCRIPTION_CSS)).getText().contains(workout.getDescription()), "Workout time doesn't match");
    }
}
