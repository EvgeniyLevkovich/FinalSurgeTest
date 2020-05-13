package pages;

import elements.Dropdown;
import elements.TextArea;
import models.Workout;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class CalendarPage extends BasePage {
    public int numberOfWorkouts;
    private final static String CALENDAR_URL = "https://log.finalsurge.com/Calendar.cshtml";
    private final static String FULL_ADD_BUTTON_ID = "FullAddBtn";
    private final static String WORKOUT_CSS = ".fc-event-activity";
    private final static String QUICK_ADD_BUTTON_XPATH = "//*[text()='Quick Add']";
    private final static String SAVE_BUTTON_ID = "saveButton";
    private final static String DELETE_BUTTON_CSS = ".quick-delete";
    private final static String CONFIRM_DELETE_BUTTON_CSS = "a[class='btn btn-primary']";

    public CalendarPage(WebDriver driver) {
        super(driver);
    }
    public void openPage() {
        driver.get(CALENDAR_URL);
        isPageOpened();
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(FULL_ADD_BUTTON_ID )));
    }

    public void getNumberOfWorkouts() {
        openPage();
        List<WebElement> workouts = driver.findElements(By.cssSelector(WORKOUT_CSS));
        numberOfWorkouts = workouts.size();
    }

     public void checkWorkoutAddedToCalendar() {
         openPage();
         List<WebElement> workoutsAfterAdding = driver.findElements(By.cssSelector(WORKOUT_CSS));
         int numberOfWorkoutsAfterAdding = workoutsAfterAdding.size();
         assertEquals(numberOfWorkoutsAfterAdding, numberOfWorkouts + 1, "Workout hasn't added");
     }

    public void completeQuickForm(String ActivityType, Workout workout) {
        driver.findElement(By.xpath(QUICK_ADD_BUTTON_XPATH)).click();
        new TextArea().write(driver, "WorkoutDate", workout.getDate());
        new TextArea().write(driver, "WorkoutTime", workout.getTime());
        Dropdown.selectOption(driver, "ActivityType", ActivityType );
        new TextArea().write(driver, "Name", workout.getName());
        new TextArea().write(driver, "Desc", workout.getDescription());
        new TextArea().write(driver, "Distance", workout.getDistance());
        new TextArea().write(driver, "Duration", workout.getDuration());
        driver.findElement(By.id(SAVE_BUTTON_ID)).click();
    }

    public void deleteWorkout(int workoutIndex) {
        List<WebElement> deleteButton = driver.findElements(By.cssSelector(DELETE_BUTTON_CSS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton.get(workoutIndex - 1));
        WebElement confirmDeleteButton =  driver.findElement(By.cssSelector(CONFIRM_DELETE_BUTTON_CSS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmDeleteButton);
    }

    public void checkWorkoutDeletedFromCalendar() {
        openPage();
        List<WebElement> workoutsAfterAdding = driver.findElements(By.cssSelector(WORKOUT_CSS));
        int numberOfWorkoutsAfterRemoving = workoutsAfterAdding.size();
        assertEquals(numberOfWorkoutsAfterRemoving, numberOfWorkouts - 1, "Workout hasn't deleted");
    }
}
