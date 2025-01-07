package com.company.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Reflection> refClazz = Reflection.class;
        System.out.println(refClazz);
        Class<? super Reflection> superClazz = Reflection.class.getSuperclass();
        System.out.println(superClazz);

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

    }
}
