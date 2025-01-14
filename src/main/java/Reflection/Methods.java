package Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Comparator;

public class Methods {
    public static void main(String[] args) {
        Class<Reflection> reflectionClazz = Reflection.class;
        Method[] declaredMethods = reflectionClazz.getDeclaredMethods();

        declaredMethods = Arrays.stream(declaredMethods).sorted(Comparator.comparing(Method::getName)).toArray(Method[]::new);
        for (Method declaredMethod : declaredMethods) {
            String name = declaredMethod.getName();
            if (name.startsWith("get")) {
                System.out.printf("%s will return class %s%n", name, declaredMethod.getReturnType().getSimpleName());
            }
            if (name.startsWith("set")) {
                System.out.printf("%s and will set field of class ", name);
                Parameter[] parameters = declaredMethod.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.print(parameter.getType().getSimpleName() + " ");
                }
                System.out.println();
            }
        }
    }
}
