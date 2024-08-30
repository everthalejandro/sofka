package com.sofka.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.sofka.test.utils.helpers.CRUD;

public class Task_Eliminar implements Task {

    public static Task_Eliminar task_Eliminar() {
        return Tasks.instrumented(Task_Eliminar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CRUD("eliminar");
    }
}