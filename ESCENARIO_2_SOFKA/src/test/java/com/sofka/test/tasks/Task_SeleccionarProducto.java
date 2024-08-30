package com.sofka.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.sofka.test.stepdefinitions.ParameterDefinitionsStatics.*;
import static com.sofka.test.interfaces.Interfaces.*;

public class Task_SeleccionarProducto implements Task {

    public Task_SeleccionarProducto(String producto) {
        productos = producto.split(",");
    }

    public static Task_SeleccionarProducto task_SeleccionarProducto(String producto) {
        return Tasks.instrumented(Task_SeleccionarProducto.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String sProducto : productos) {
            actor.attemptsTo(
                    Click.on(inputSearch),
                    Enter.keyValues(sProducto).into(inputSearch),
                    Click.on(btn_Search),
                    Click.on(btn_AddToCart),
                    Click.on(inputSearch)
            );
            try {
                deleteField();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void deleteField() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
    }
}