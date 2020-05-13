package pages;

import elements.Dropdown;
import elements.TextArea;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WorkoutAddPage extends BasePage {

    private final static String WORKOUT_ADD_URL = "https://log.finalsurge.com/WorkoutAdd.cshtml";
    private final static String ACTIVITY_LIST_ID = "blog_accordion_left";
    private final static String ACTIVITY_TYPE_XPATH = "//a[contains(text(), '%s')]/../../div[@class = 'accordion-heading']";
    private final static String SAVE_BUTTON_ID = "saveButton";

    public WorkoutAddPage(WebDriver driver) {
        super(driver);
    }

    public WorkoutAddPage openPage() {
        driver.get(WORKOUT_ADD_URL);
        isPageOpened();
        return this;
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ACTIVITY_LIST_ID)));
    }

    public void completeForm(String ActivityType, Workout workout) {
        driver.findElement(By.xpath(String.format(ACTIVITY_TYPE_XPATH, ActivityType))).click();
        new TextArea().write(driver, "WorkoutDate", workout.getDate());
        new TextArea().write(driver, "WorkoutTime", workout.getTime());
        new TextArea().write(driver, "Name", workout.getName());
        new TextArea().write(driver, "Desc", workout.getDescription());
        new TextArea().write(driver, "Distance", workout.getDistance());
        new TextArea().write(driver, "Duration", workout.getDuration());
        Dropdown.selectOption(driver, "PerEffort", workout.getPerceivedEffort());
        driver.findElement(By.id(SAVE_BUTTON_ID)).click();
    }
}
