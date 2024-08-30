package com.sofka.test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.sofka.test.interfaces.Interfaces.*;
import static com.sofka.test.stepdefinitions.SharedDefinitionsSteps.*;

public class Task_CompletarDatos implements Task {

    String tipo;
    int randomOption = 1;

    public Task_CompletarDatos(String tipo) {
        this.tipo = tipo;
    }

    public static Task_CompletarDatos task_CompletarDatos(String tipo) {
        return Tasks.instrumented(Task_CompletarDatos.class, tipo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        switch (tipo) {
            case "invitado":
                actor.attemptsTo(
                        Click.on(rdb_GuestCheckout),
                        Click.on(btn_buttonaccount),
                        Enter.keyValues("Prueba").into(input_inputpaymentfirstname),
                        Enter.keyValues("Sofka").into(input_paymentlastname),
                        Enter.keyValues("pruebasofka@gmail.com").into(input_paymentemail),
                        Enter.keyValues("6012345678").into(input_paymenttelephone),
                        Enter.keyValues("Carrera 1 # 1 - 1").into(input_paymentaddress1),
                        Enter.keyValues("Bogotá").into(input_paymentcity),
                        Enter.keyValues("502458").into(input_paymentpostcode),
                        Click.on(input_paymentcountry)
                );

                obtenerCantidad("//div[@id='checkout-checkout']//fieldset[1]//div[6]/select", "//div[@id='checkout-checkout']//fieldset[1]//div[6]/select/option", 1);

                actor.attemptsTo(
                        Click.on("//div[@id='checkout-checkout']//fieldset[1]//div[6]/select/option[" + randomOption + "]"));

                wait.until(ExpectedConditions.visibilityOf((WebElement) WebElementQuestion.the(input_paymentzone).answeredBy(actor)));

                actor.attemptsTo(
                        Click.on(input_paymentzone)
                );

                obtenerCantidad("//div[@id='checkout-checkout']//fieldset[1]//div[7]/select", "//div[@id='checkout-checkout']//fieldset[1]//div[7]/select/option", 1);

                wait.until(ExpectedConditions.visibilityOf((WebElement) WebElementQuestion.the("//div[@id='checkout-checkout']//fieldset[1]//div[7]/select/option[" + randomOption + "]").answeredBy(actor)));

                actor.attemptsTo(
                        Click.on("//div[@id='checkout-checkout']//fieldset[1]//div[7]/select/option[" + randomOption + "]"),
                        Click.on(btn_guest),
                        Click.on(btn_shippingmethod),
                        Click.on(chk_agree),
                        Click.on(btn_paymentmethod)
                );

                break;
            case "usuario":
                System.out.println("No se ha definido");
                break;
        }
    }

    public void obtenerCantidad(String sRaiz, String sSubRaiz, int nLimiteInferior) {
        WebElement sElemento = driver.findElement(By.xpath(sRaiz));
        List<WebElement> filas = sElemento.findElements(By.xpath(sSubRaiz));
        int nLimiteSuperior = filas.size();
        randomOption = generarRangoDatos(nLimiteInferior, nLimiteSuperior);
    }

    public int generarRangoDatos(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}