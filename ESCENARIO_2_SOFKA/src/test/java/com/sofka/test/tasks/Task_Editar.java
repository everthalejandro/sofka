package com.sofka.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;
import java.util.HashMap;

import static com.sofka.test.utils.helpers.CRUD;
import static com.sofka.test.stepdefinitions.ParameterDefinitionsStatics.*;

public class Task_Editar implements Task {
    String[] set, values;

    private final Map<String, String> variables;

    public Task_Editar(String set, String values) {
        this.set = set.split(",");
        this.values = values.split(",");
        this.variables = new HashMap<>();
    }

    public static Task_Editar task_Editar(String set, String values) {
        return Tasks.instrumented(Task_Editar.class, set, values);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < set.length; i++) {
            String key = set[i].trim();
            String value = values[i].trim();

            switch (key) {
                case "username": username = value; break;
                case "firstName": firstName = value; break;
                case "lastName": lastName = value; break;
                case "email": email = value; break;
                case "password": password = value; break;
                case "phone": phone = value; break;
                default:
                    System.out.println("Clave no reconocida: " + key);
            }
        }

        CRUD("editar");
    }

    public String getVariable(String key) {
        return variables.get(key);
    }
}