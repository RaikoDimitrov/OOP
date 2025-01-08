package com.company.Reflection.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();

        Method[] declaredMethods = blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input;

        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split("_");
            String methodName = data[0];
            int value = Integer.parseInt(data[1]);
            invokeMethod(declaredMethods, methodName, value, blackBoxInt);
            System.out.println(innerValue.getInt(blackBoxInt));
        }

    }

    private static void invokeMethod(Method[] declaredMethods, String methodName, int value, BlackBoxInt blackBoxInt) throws InvocationTargetException, IllegalAccessException {
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals(methodName)) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(blackBoxInt, value);
                break;
            }
        }
    }
}
