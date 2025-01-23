package DesignPatterns.singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonDataContainer implements  SingletonContainer {

    private volatile static SingletonDataContainer instance;
    Map<String, Integer> capitals;

    private SingletonDataContainer() {
        if (instance != null) {
            throw new RuntimeException("Use getter");
        }
        this.capitals = new HashMap<>();
        System.out.println("Initializing Singleton object");
    }

    public static SingletonDataContainer getInstance() {
        if (instance == null) {
            synchronized (SingletonDataContainer.class) {
                if (instance == null) {
                    instance = new SingletonDataContainer();
                }
            }
        }
        return instance;
    }

    @Override
    public int getPopulation(Map<String, Integer> capitals, String name) {
        return capitals.get(name);
    }
}
