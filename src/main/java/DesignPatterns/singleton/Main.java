package DesignPatterns.singleton;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> capitals = new HashMap<>();

        capitals.put("Sofia", 3000000);
        capitals.put("Montana", 35000);

        SingletonDataContainer instance = SingletonDataContainer.getInstance();
        System.out.println(instance.getPopulation(capitals, "Sofia"));

        SingletonDataContainer instance1 = SingletonDataContainer.getInstance();
        System.out.println(instance1.getPopulation(capitals, "Montana"));
    }
}
