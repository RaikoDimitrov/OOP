package com.company.Polymorphism.wildFarm.animalsImpl;

import com.company.Polymorphism.wildFarm.animalsFarm.Felime;
import com.company.Polymorphism.wildFarm.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private final String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meeeow");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food);
    }

    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.breed,
                format.format(super.getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}
