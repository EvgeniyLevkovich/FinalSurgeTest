package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.WorkoutAddPage;
import models.Workout;

public class WorkoutAddSteps {

    WorkoutAddPage workoutAddPage;

    public WorkoutAddSteps(WebDriver driver) {
        workoutAddPage = new WorkoutAddPage(driver);
    }

    @Step("Select An Activity Type")
    public void selectAnActivityType(String ActivityType) {
        workoutAddPage.openPage()
                      .SelectAnActivity(ActivityType);
    }

    @Step("Complete form")
    public void completeForm(Workout workout) {
        workoutAddPage.completeForm(workout);
    }
}
