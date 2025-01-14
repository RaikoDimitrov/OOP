package Polymorphism.wildFarm.animalsImpl;

import Polymorphism.wildFarm.animalsFarm.Mammal;
import Polymorphism.wildFarm.food.Food;
import Polymorphism.wildFarm.food.Vegetable;

public class Zebra extends Mammal {

    private final static String INVALID_FOOD = "%ss are not eating that type of food.";

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            super.setFoodEaten(new Vegetable(0));
            throw new IllegalArgumentException(String.format(INVALID_FOOD, this.getAnimalType()));
        }
        super.setFoodEaten(food);
    }
}
