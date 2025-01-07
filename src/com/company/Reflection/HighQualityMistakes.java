package com.company.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class HighQualityMistakes {
    public static void main(String[] args) {

        Class<Reflection> refClazz = Reflection.class;

        Field[] declaredFields = refClazz.getDeclaredFields();
        System.out.printf("Fields:%n");
        Arrays.stream(declaredFields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        System.out.println();
        System.out.printf("Methods:%n");
        System.out.println();

        System.out.printf("Getters:%n");
        Method[] declaredMethods = refClazz.getDeclaredMethods();
        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().contains("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!%n", method.getName()));

        System.out.printf("Setters:%n");
        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().contains("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!%n", method.getName()));

    }
}
