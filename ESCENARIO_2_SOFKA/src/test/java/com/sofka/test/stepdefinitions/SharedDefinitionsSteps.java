package com.sofka.test.stepdefinitions;

import com.sofka.test.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Task;

import static com.sofka.test.stepdefinitions.ParameterDefinitionsStatics.SOFKA;

public class SharedDefinitionsSteps {


    @Cuando("se envian los datos {string}, {string}, {string}, {string}")
    public void se_envian_los_datos(String username, String firstName, String lastName, String email) {
        SOFKA.attemptsTo(Task_Enviardatos.task_Enviardatos(username, firstName, lastName, email));
    }

    @Cuando("se obtiene code {string}")
    public void se_obtiene_code(String code) {
        SOFKA.attemptsTo(Task_compararcode.task_compararcode(code));
    }

    @Cuando("se busca el valor del registro creado")
    public void se_busca_el_valor_del_registro_creado() {
        SOFKA.attemptsTo(Task_Buscar.task_Buscar());
    }

    @Cuando("se editan los datos {string} del registro buscado por {string}")
    public void se_editan_los_datos_del_registro_buscado_por(String set, String values) {
        SOFKA.attemptsTo(Task_Editar.task_Editar(set, values));
    }

    @Entonces("se elimina el registro creado buscado y actualizado anteriormente")
    public void se_elimina_el_registro_creado_buscado_y_actualizado_anteriormente() {
        SOFKA.attemptsTo(Task_Eliminar.task_Eliminar());
    }
}