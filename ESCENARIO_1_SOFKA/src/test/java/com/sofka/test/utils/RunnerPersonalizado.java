package com.sofka.test.utils;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class RunnerPersonalizado extends Runner {
    private Class<CucumberWithSerenity> classValue;
    private CucumberWithSerenity cucumberWithSerenity;
    private final String messageError = "Error con el Runner Personalizado";
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RunnerPersonalizado.class);

    public RunnerPersonalizado(Class<CucumberWithSerenity> classValue) {
        try {
            this.classValue = classValue;
            cucumberWithSerenity = new CucumberWithSerenity(classValue);
        } catch (InitializationError e) {
            LOGGER.info(messageError);
        }
    }

    @Override
    public Description getDescription() {
        return cucumberWithSerenity.getDescription();
    }

    private void runAnnotatedMethods() {
        try {
            if (!BeforeSuite.class.isAnnotation()) {
                return;
            }
            Method[] methods = this.classValue.getMethods();
            for (Method method : methods) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation item : annotations) {
                    if (item.annotationType().equals(BeforeSuite.class)) {
                        method.invoke(null);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.info(messageError);
        }
    }

    @Override
    public void run(RunNotifier notifier) {
        try {
            runAnnotatedMethods();
            cucumberWithSerenity = new CucumberWithSerenity(classValue);
        } catch (Exception e) {
            LOGGER.info(messageError);
        }
        cucumberWithSerenity.run(notifier);
    }
}