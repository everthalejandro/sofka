package com.sofka.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.Assert;

import static com.sofka.test.interfaces.Interfaces.*;

public class Task_mensaje implements Task {
    String mensaje;
    public Task_mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public static Task_mensaje task_mensaje(String mensaje) {
        return Tasks.instrumented(Task_mensaje.class, mensaje);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String actual = Text.of(lbl_Result).answeredBy(actor);
        Assert.assertEquals(mensaje,actual);
    }
}