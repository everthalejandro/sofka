package com.sofka.test.stepdefinitions;

import net.serenitybdd.screenplay.Actor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class ParameterDefinitionsStatics {

    public static Actor SOFKA = Actor.named("SOFKA");

    public static Properties properties = new Properties();

    public static int waitSleep;
    public static String url;
    public static String[] productos;

    public ParameterDefinitionsStatics() {
        loadProperties();
    }

    public static void loadProperties() {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("serenity.properties");
            properties.load(fileInputStream);

            url = getPropertyOrEnv("URL");

        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getPropertyOrEnv(String key) {
        return System.getenv(key) == null ? properties.getProperty(key) : System.getenv(key);
    }
}