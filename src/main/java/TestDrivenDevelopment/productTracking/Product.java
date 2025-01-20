package TestDrivenDevelopment.productTracking;

public class Product {

    private String label;
    private double price;
    private int quantity;

    public Product(String label, double price, int quantity) {
        this.label = label;
        this.price = price;
        this.quantity = quantity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
