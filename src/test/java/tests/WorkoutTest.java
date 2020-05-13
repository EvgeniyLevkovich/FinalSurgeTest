package tests;

import io.qameta.allure.Description;
import models.User;
import models.Workout;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Retry;

public class WorkoutTest extends BaseTest {
    Workout workout;

    @BeforeMethod
    public void logIn() {
        User user = new User("integri@mailinator.com", "Qwerty12345");
        loginSteps.login(user);
    }

    public void createWorkout(){
        workout = Workout.builder()
                .date("05/25/2020")
                .time("03:10")
                .name("My first training")
                .description("Finally!")
                .distance("2000")
                .duration("00:15:00")
                .perceivedEffort("3 (Light)")
                .build();
    }

    @Test(retryAnalyzer = Retry.class, description = "Workout add", priority = 1)
    @Description("Checking workout added via full add")
    public void workoutFullAdd() {
        createWorkout();
        workoutSteps.completeFullForm("Bike", workout);
    }

    @Test(retryAnalyzer = Retry.class, description = "Checking workout data", priority = 2)
    @Description("Checking workout data contains all data from the Add Workout form")
    public void workoutDataChecking() {
        createWorkout();
        workoutSteps.dataChecking("Bike", workout);
    }

    @Test(retryAnalyzer = Retry.class, description = "Workout quick add", priority = 3)
    @Description("Checking workout added via quick add")
    public void workoutQuickAdd() {
        createWorkout();
        workoutSteps.completeQuickForm("Bike", workout);
    }

    @Test(retryAnalyzer = Retry.class, description = "Delete workout", priority = 4)
    @Description("Checking workout can be deleted from calendar")
    public void workoutDelete() {
        workoutSteps.deleteWorkout(2);
    }
}


