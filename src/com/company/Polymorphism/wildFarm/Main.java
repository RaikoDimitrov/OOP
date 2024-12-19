package com.company.Polymorphism.wildFarm;

import com.company.Polymorphism.wildFarm.animalsFarm.Animal;
import com.company.Polymorphism.wildFarm.animalsImpl.Cat;
import com.company.Polymorphism.wildFarm.animalsImpl.Mouse;
import com.company.Polymorphism.wildFarm.animalsImpl.Tiger;
import com.company.Polymorphism.wildFarm.animalsImpl.Zebra;
import com.company.Polymorphism.wildFarm.food.Food;
import com.company.Polymorphism.wildFarm.food.Meat;
import com.company.Polymorphism.wildFarm.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String animalInfo;
        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(animalInfo = scanner.nextLine())) {
            String[] animalData = animalInfo.split("\\s+");
            Animal animal = getAnimal(animalData);
            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = getFood(foodData);
            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException invalidFood) {
                System.out.println(invalidFood.getMessage());
            }

            animals.add(animal);
            System.out.println(animal);

        }
        //animals.forEach(System.out::println);
    }

    private static Food getFood(String[] foodData) {
        Food food;
        if (foodData[0].equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodData[1]));
        } else food = new Meat(Integer.parseInt(foodData[1]));
        return food;
    }

    private static Animal getAnimal(String[] animalData) {
        Animal animal;
        String animalType = animalData[0];
        String animalName = animalData[1];
        Double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];
        String catBreed = animalData.length == 5 ? animalData[4] : null;

        switch (animalType) {
            case "Cat" -> animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
            case "Tiger" -> animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            case "Zebra" -> animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            case "Mouse" -> animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            default -> throw new IllegalArgumentException("No such animal.");
        }
        return animal;
    }

}
