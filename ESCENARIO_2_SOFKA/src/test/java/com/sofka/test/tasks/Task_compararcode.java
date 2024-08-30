package com.sofka.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.junit.Assert;

import static com.sofka.test.stepdefinitions.ParameterDefinitionsStatics.Statuscode;

public class Task_compararcode implements Task {
    String code;
    public Task_compararcode(String code) {
        this.code = code;
    }

    public static Task_compararcode task_compararcode(String code) {
        return Tasks.instrumented(Task_compararcode.class, code);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Assert.assertEquals(code, String.valueOf(Statuscode));
    }
}