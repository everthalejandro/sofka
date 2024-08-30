package com.sofka.test.tasks;

import com.sofka.test.stepdefinitions.SharedDefinitionsSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static com.sofka.test.stepdefinitions.ParameterDefinitionsStatics.*;

public class Task_URL implements Task {

    public static Task_URL task_url(){
        return new Task_URL();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            SharedDefinitionsSteps.driver.manage().window().maximize();
            actor.wasAbleTo(Open.url(url));
            Thread.sleep(waitSleep);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}