package TestDrivenDevelopment.productTracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class InStockTest {

    private static final String[] NAMES = {"First", "Second", "Third"};
    private static final double[] PRICES = {55.55, 49.32, 13.13};
    private static final int[] QUANTITIES = {55, 32, 13};
    private static final int ZERO_SIZE = 0;

    private ProductStock productStock;
    private Product firstProduct;
    private Product secondProduct;
    private Product thirdProduct;

    @BeforeEach
    void setUp() {
        this.productStock = new InStock();
        this.firstProduct = new Product(NAMES[0], PRICES[2], QUANTITIES[0]);
        this.secondProduct = new Product(NAMES[1], PRICES[1], QUANTITIES[2]);
        this.thirdProduct = new Product(NAMES[2], PRICES[0], QUANTITIES[1]);
    }

    @Test
    void testThatReturnsFalseWhenProductIsAbsentAndTrueWhenAdded () {
        assertFalse(productStock.contains(firstProduct));
        productStock.add(firstProduct);
        assertTrue(productStock.contains(firstProduct));
    }

    @Test
    void testThatCountReturnsZeroWhenEmptyAndNonZeroWhenProductsAdded () {
        assertEquals(ZERO_SIZE, productStock.getCount());
        productStock.add(firstProduct);
        productStock.add(secondProduct);
        productStock.add(thirdProduct);
        assertEquals(3, productStock.getCount());
    }

    @Test
    void testThatFindByIndexReturnsCorrectIndexElement () {
        productStock.add(firstProduct);
        productStock.add(secondProduct);
        assertEquals(secondProduct, productStock.find(1), "Invalid index element");
    }

    @Test
    void testThatFindByIndexThrowsExceptionWhenIndexIsGreater () {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            addRandomProduct(10, getRandomPrice(0.5, 95.5), getRandomQuantity(50));
            productStock.find(10);
        });

    }

    @Test
    void testThatFindByIndexThrowsExceptionWhenIndexIsNegative () {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            addRandomProduct(10, getRandomPrice(0.5, 95.5), getRandomQuantity(50));
            productStock.find(-2);
        });
    }

    @Test
    void testThatCanChangeQuantityIfProductInStock () {
        productStock.add(firstProduct);
        productStock.changeQuantity(NAMES[0], 40);
        int newQuantity = productStock.find(0).getQuantity();
        assertEquals(40, newQuantity, "Did not change quantity");
    }

    @Test
    void testThatChangeQuantityThrowsExceptionIfProductIsMissing () {
        assertThrows(IllegalArgumentException.class, () -> productStock.changeQuantity(NAMES[0], 40));
    }

    @Test
    void testThatFindByLabelReturnsProductInStock () {
        productStock.add(firstProduct);
        productStock.add(secondProduct);
        assertEquals(productStock.find(0), productStock.findByLabel(firstProduct.getLabel()), "Could not find such product");
    }

    @Test
    void testThatFindByLabelThrowsExceptionIfProductIsMissing () {
        assertThrows(IllegalArgumentException.class, () -> productStock.findByLabel("Invalid"));
    }

    //private methods for testing
    //create and add products
    private void addRandomProduct(int count, double price, int quantity) {
        for (int i = 0; i < count; i++) {
            this.productStock.add(randomProductFactory(getRandomString(), price, quantity));
        }
    }

    private Product randomProductFactory(String name, double price, int quantity) {
        return new Product(name, price, quantity);
    }

    //generating random parameters for product
    private int getRandomQuantity(int bound) {
        return new Random().nextInt(bound);
    }

    private double getRandomPrice(double start, double bound) {
        return ThreadLocalRandom.current().nextDouble(start, bound);
    }

    private String getRandomString () {
        String letterOrDigit = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        while (sb.length() < 8) {
            int index = (int) (random.nextFloat() * letterOrDigit.length());
            sb.append(letterOrDigit.charAt(index));
        }
        return sb.toString();
    }
}