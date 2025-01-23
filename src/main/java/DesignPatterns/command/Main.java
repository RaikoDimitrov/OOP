package DesignPatterns.command;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ModifyPrice modifyPrice = new ModifyPrice();
        Product phoneOne = new Product("Iphone", 1500);
        Product phoneTwo = new Product("Samsung", 1300);
        Product phoneThree = new Product("Huawei", 1100);


        modifyPrice.setAndExecuteCommand(new IncreaseAllProductPriceCommand(Arrays.asList(phoneOne, phoneTwo, phoneThree), 50));

        execute(modifyPrice, new IncreasePriceCommand(phoneTwo, 150));
        execute(modifyPrice, new DecreasePriceCommand(phoneThree, 350));

        undoExecute(modifyPrice);
    }

    private static void execute(ModifyPrice modifyPrice, Command productCommand) {
        modifyPrice.setAndExecuteCommand(productCommand);

    }

    //unfinished
    private static void undoExecute(ModifyPrice modifyPrice) {
        modifyPrice.undoExecutedCommand();
    }
}
