package com.sofka.test.utils;

import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.sofka.test.stepdefinitions.ParameterDefinitionsStatics.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class helpers {
    public static void CRUD(String accion) {
        String myRequest = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"phone\": \"" + phone + "\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        SOFKA.whoCan(CallAnApi.at(baseurl));
        switch (accion) {
            case "crear":
                SOFKA.attemptsTo(
                        Post.to("/v2/user")
                                .with(request -> request.header(swaggerheadername, swaggerheadervalue)
                                        .body(myRequest)
                                )
                );
                break;
            case "editar":
                SOFKA.attemptsTo(
                        Put.to("/v2/user/" + username)
                                .with(request -> request.header(swaggerheadername, swaggerheadervalue)
                                        .body(myRequest)
                                )
                );
                break;
            case "buscar":
                SOFKA.attemptsTo(
                        Get.resource("/v2/user/" + username)
                                .with(request -> request.header(swaggerheadername, swaggerheadervalue))
                );
                break;
            case "eliminar":
                SOFKA.attemptsTo(
                        Delete.from("/v2/user/" + username)
                                .with(request -> request.header(swaggerheadername, swaggerheadervalue))
                );
                break;
        }

        Statuscode = lastResponse().statusCode();
    }

    public static String generarCadena(int longitud, String tipoDato, String valoresOmitidos) {
        String caracteresValidos;

        switch (tipoDato.toLowerCase()){
            case "alfanumérico": caracteresValidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%&/()?¡¿*{}:;,.[]"; break;
            case "alfabético": caracteresValidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; break;
            case "caracteres": caracteresValidos = "'!#$%&/()?¡¿'*"; break;
            case "numérico": caracteresValidos = "0123456789"; break;
            case "vocales": caracteresValidos = "aeiouAEIOU"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + tipoDato);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            char caracter;
            do {
                int indice = random.nextInt(caracteresValidos.length());
                caracter = caracteresValidos.charAt(indice);
            } while (valoresOmitidos.indexOf(caracter) >= 0);
            sb.append(caracter);
        }
        return sb.toString();
    }
}