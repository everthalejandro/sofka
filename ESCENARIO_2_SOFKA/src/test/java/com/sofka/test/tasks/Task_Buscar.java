package com.sofka.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.sofka.test.utils.helpers.CRUD;

public class Task_Buscar implements Task {

    public static Task_Buscar task_Buscar() {
        return Tasks.instrumented(Task_Buscar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CRUD("buscar");
    }
}