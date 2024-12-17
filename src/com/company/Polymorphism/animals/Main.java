package com.company.Polymorphism.animals;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "Meat");
        dog.setFavouriteFood("Bone");
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
