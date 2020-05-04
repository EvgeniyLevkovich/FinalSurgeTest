package tests;

import io.qameta.allure.Description;
import models.User;
import models.Workout;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkoutAddTest extends BaseTest {
    Workout workout;

    @BeforeMethod
    public void logIn() {
        User user = new User("integri@mailinator.com", "Qwerty12345");
        loginSteps.login(user);
    }

    public void createWorkout(){
        workout = Workout.builder()
                .date("05/20/2020")
                .time("03:10")
                .name("My first training")
                .description("Finally!")
                .distance("2000")
                .duration("00:15:00")
                .build();
    }

    @Test(description = "Workout Add")
    @Description("Check workout added via")
    public void workoutAdd() {
        createWorkout();
        workoutAddSteps.selectAnActivityType("Run");
        workoutAddSteps.completeForm(workout);
    }
}
