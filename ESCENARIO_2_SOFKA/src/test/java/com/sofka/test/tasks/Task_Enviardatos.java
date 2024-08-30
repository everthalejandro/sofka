package com.sofka.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.sofka.test.stepdefinitions.ParameterDefinitionsStatics.*;
import static com.sofka.test.utils.helpers.CRUD;
import static com.sofka.test.utils.helpers.generarCadena;

public class Task_Enviardatos implements Task {

    public Task_Enviardatos(String userName, String firstname, String lastname, String eMail) {username = userName;
      firstName = firstname;
      lastName = lastname;
      email = eMail;
      password = generarCadena(6, "alfabético", "");
      phone = generarCadena(7, "numérico", "0");
    }

    public static Task_Enviardatos task_Enviardatos(String username, String firstName, String lastName, String email) {
        return Tasks.instrumented(Task_Enviardatos.class, username, firstName, lastName, email);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        CRUD("crear");
    }
}