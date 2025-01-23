package DesignPatterns.command;

public class IncreasePriceCommand implements Command {
    private final Product product;
    private final int amount;

    public IncreasePriceCommand(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }

    public String executeAction() {
        this.product.increasePrice(this.amount);
        return String.format("The price for the %s has been increased by %d$.%n",
                this.product.getName(), this.amount);
    }

    @Override
    public String undoAction() {
        this.product.decreasePrice(this.amount);
        return String.format("The price for the %s has been decreased by %d$.%n",
                this.product.getName(), this.amount);
    }
}
