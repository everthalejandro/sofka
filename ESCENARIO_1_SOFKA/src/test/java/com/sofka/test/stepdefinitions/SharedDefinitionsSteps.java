package com.sofka.test.stepdefinitions;

import com.sofka.test.tasks.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

import static com.sofka.test.stepdefinitions.ParameterDefinitionsStatics.SOFKA;

public class SharedDefinitionsSteps {

    @Managed(driver = "chrome")
    public static WebDriver driver;
    public static Actions actions;
    public static Random random = new Random();

    @Before
    public void config() {
        actions = new Actions(driver);
        SOFKA.can(BrowseTheWeb.with(driver));
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(2000);
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe"); // Para ChromeDriver
            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe"); // Para Google Chrome
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Dado("que se ingresa a la url")
    public void que_se_ingresa_a_la_url() {
        SOFKA.attemptsTo(Task_URL.task_url());
    }

    @Dado("que se buscan los producto {string}")
    public void que_se_buscan_los_producto(String productos) {
        SOFKA.attemptsTo(Task_SeleccionarProducto.task_SeleccionarProducto(productos));
    }

    @Cuando("se da click en {string}")
    public void se_da_click_en(String boton) {
        SOFKA.attemptsTo(Task_Acciones.task_Acciones(boton));
    }

    @Cuando("se confirman datos de {string}")
    public void se_confirman_datos_de(String tipo) {
        SOFKA.attemptsTo(Task_CompletarDatos.task_CompletarDatos(tipo));
    }

    @Entonces("se visualiza mensaje {string}")
    public void se_visualiza_mensaje(String mensaje) {
        SOFKA.attemptsTo(Task_mensaje.task_mensaje(mensaje));
    }

}