package com.company.Polymorphism.wildFarm.animalsImpl;

import com.company.Polymorphism.wildFarm.animalsFarm.Felime;
import com.company.Polymorphism.wildFarm.food.Food;
import com.company.Polymorphism.wildFarm.food.Meat;

public class Tiger extends Felime {

    private final static String INVALID_FOOD = "%ss are not eating that type of food.";

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!");

    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Meat)) {
            super.setFoodEaten(new Meat(0));
            throw new IllegalArgumentException(String.format(INVALID_FOOD, this.getAnimalType()));
        }
        super.setFoodEaten(food);
    }
}
