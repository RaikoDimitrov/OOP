package Polymorphism.wildFarm.animalsImpl;

import Polymorphism.wildFarm.animalsFarm.Mammal;
import Polymorphism.wildFarm.food.Food;
import Polymorphism.wildFarm.food.Vegetable;

public class Mouse extends Mammal {

    private final static String INVALID_FOOD = "Mice are not eating that type of food.";

    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            super.setFoodEaten(new Vegetable(0));
            throw new IllegalArgumentException(INVALID_FOOD);
        }
        super.setFoodEaten(food);
    }
}
