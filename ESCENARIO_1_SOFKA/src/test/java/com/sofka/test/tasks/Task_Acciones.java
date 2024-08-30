package com.sofka.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.sofka.test.interfaces.Interfaces.*;

public class Task_Acciones implements Task {
    String boton;
    public Task_Acciones(String boton) {
        this.boton = boton;
    }

    public static Task_Acciones task_Acciones(String boton) {
        return Tasks.instrumented(Task_Acciones.class, boton);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (boton){
            case "carrito": actor.attemptsTo(Click.on(btn_Cart)); break;
            case "checkout": actor.attemptsTo(Click.on(lnk_Checkout)); break;
            case "confirm order": actor.attemptsTo(Click.on(btn_confirm)); break;
        }
    }
}