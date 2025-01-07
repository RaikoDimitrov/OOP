package com.company.Reflection;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {

        Class<Reflection> refClazz = Reflection.class;
        System.out.println(refClazz);
        Class<? super Reflection> superClazz = Reflection.class.getSuperclass();
        System.out.println(superClazz);

        //modifiers
        Field[] declaredFields = refClazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getModifiers() + " -> " + Modifier.toString(declaredField.getModifiers()));
        }

        try {
            Arrays.stream(refClazz.getInterfaces()).map(Class::getSimpleName).forEach(System.out::println);
            Constructor<Reflection> ctor = refClazz.getDeclaredConstructor();
            ctor.setAccessible(true);
            Reflection reflection = ctor.newInstance();
            System.out.println(reflection);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ex)
        {
            ex.printStackTrace();
        }

        //get methods by annotation
        Method[] declaredMethods = refClazz.getDeclaredMethods();
        Map<String, List<String>> methodsByAuthor = new HashMap<>();

        for (Method declaredMethod : declaredMethods) {
            Author annotation = declaredMethod.getAnnotation(Author.class);

            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(declaredMethod.getName() + "()");
            }
        }

        methodsByAuthor.forEach((k, v) -> System.out.printf("%s: %s%n", k, v.toString().replaceAll("[\\[\\],]", "")));
    }
}
