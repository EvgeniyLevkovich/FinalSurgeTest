package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CalendarPage;
import pages.WorkoutAddPage;
import models.Workout;
import pages.WorkoutDataPage;

public class WorkoutSteps {
    WorkoutAddPage workoutAddPage;
    CalendarPage calendarPage;
    WorkoutDataPage workoutDataPage;

    public WorkoutSteps(WebDriver driver) {
        workoutAddPage = new WorkoutAddPage(driver);
        calendarPage = new CalendarPage(driver);
        workoutDataPage = new WorkoutDataPage(driver);
    }

    @Step("Complete full form")
    public void completeFullForm(String ActivityType, Workout workout) {
        calendarPage.getNumberOfWorkouts();
        workoutAddPage.openPage();
        workoutAddPage.completeForm(ActivityType, workout);
        calendarPage.checkWorkoutAddedToCalendar();
    }

    @Step("Complete full form and checking the workout profile contains all data from the Add Workout form")
    public void dataChecking(String ActivityType, Workout workout) {
        workoutAddPage.openPage();
        workoutAddPage.completeForm(ActivityType, workout);
        workoutDataPage.dataChecking(ActivityType, workout);
    }

    @Step("Complete quick form")
    public void completeQuickForm(String ActivityType, Workout workout) {
        calendarPage.getNumberOfWorkouts();
        calendarPage.completeQuickForm(ActivityType, workout);
        calendarPage.checkWorkoutAddedToCalendar();
    }

    @Step("Delete workout")
    public void deleteWorkout(int workoutIndex) {
        calendarPage.getNumberOfWorkouts();
        calendarPage.deleteWorkout(workoutIndex);
        calendarPage.checkWorkoutDeletedFromCalendar();
    }
}
