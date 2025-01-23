package DesignPatterns.command;

import java.util.List;

public class IncreaseAllProductPriceCommand implements Command {

    private final List<Product> productList;
    private final int amount;

    public IncreaseAllProductPriceCommand(List<Product> productList, int amount) {
        this.productList = productList;
        this.amount = amount;
    }

    @Override
    public String executeAction() {
        StringBuilder sb = new StringBuilder();
        for (Product product : productList) {
            product.increasePrice(amount);
            sb.append(String.format("The price for the %s has been increased by %d.%n",
                    product.getName(),
                    this.amount));
        }
        return sb.toString();
    }

    @Override
    public String undoAction() {
        StringBuilder sb = new StringBuilder();
        for (Product product : productList) {
            product.decreasePrice(amount);
            sb.append(String.format("The price for the %s has been decreased by %d.%n",
                    product.getName(),
                    this.amount));
        }
        return sb.toString();
    }
}
