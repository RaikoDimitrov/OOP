package TestDrivenDevelopment.productTracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    void testThatReturnsFalseWhenProductIsAbsentAndTrueWhenAdded() {
        assertFalse(productStock.contains(firstProduct));
        productStock.add(firstProduct);
        assertTrue(productStock.contains(firstProduct));
    }

    @Test
    void testThatCountReturnsZeroWhenEmptyAndNonZeroWhenProductsAdded() {
        assertEquals(ZERO_SIZE, productStock.getCount());
        productStock.add(firstProduct);
        productStock.add(secondProduct);
        productStock.add(thirdProduct);
        assertEquals(3, productStock.getCount());
    }

    @Test
    void testThatFindByIndexReturnsCorrectIndexElement() {
        productStock.add(firstProduct);
        productStock.add(secondProduct);
        assertEquals(secondProduct, productStock.find(1), "Invalid index element");
    }

    @Test
    void testThatFindByIndexThrowsExceptionWhenIndexIsGreater() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            addRandomProduct(10, getRandomPrice(0.5, 95.5), getRandomQuantity(45));
            productStock.find(10);
        });

    }

    @Test
    void testThatFindByIndexThrowsExceptionWhenIndexIsNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            addRandomProduct(10, getRandomPrice(0.5, 95.5), getRandomQuantity(50));
            productStock.find(-2);
        });
    }

    @Test
    void testThatCanChangeQuantityIfProductInStock() {
        productStock.add(firstProduct);
        int newQuantity = firstProduct.getQuantity() + 15;
        productStock.changeQuantity(firstProduct.getLabel(), newQuantity);
        assertEquals(newQuantity, firstProduct.getQuantity(), "Did not change quantity");
    }

    @Test
    void testThatChangeQuantityThrowsExceptionIfProductIsMissing() {
        assertThrows(IllegalArgumentException.class, () ->
                productStock.changeQuantity(firstProduct.getLabel(), firstProduct.getQuantity() + 15));
    }

    @Test
    void testThatFindByLabelReturnsProductInStock() {
       /* productStock.add(firstProduct);
        productStock.add(secondProduct);
        assertEquals(productStock.find(0), productStock.findByLabel(firstProduct.getLabel()), "Could not find such product");
*/
        addRandomProduct(10, 5.5, 15);
        String expectedLabel = productStock.find(2).getLabel();
        Product byLabel = productStock.findByLabel(expectedLabel);
        assertNotNull(byLabel);
        String actualLabel = byLabel.getLabel();
        assertEquals(expectedLabel, actualLabel, "Label not matching");
    }

    @Test
    void testThatFindByLabelThrowsExceptionIfProductIsMissing() {
        assertThrows(IllegalArgumentException.class, () -> productStock.findByLabel("Invalid"));
    }

    @Test
    void testThatFindFirstByAlphabeticalOrderReturnsCorrectNumberOfProducts() {
        addRandomProduct(15, 5.5, 25);
        productStock.add(firstProduct);
        Iterable<Product> iterable = productStock.findFirstByAlphabeticalOrder(productStock.getCount());
        assertNotNull(iterable);
        int count = 0;
        for (Product product : iterable) {
            count++;
        }
        assertEquals(count, productStock.getCount(), "Incorrect count");
    }

    @Test
    void testThatFindFirstByAlphabeticalOrderReturnsCorrectOrderOfProducts() {
       /* addRandomProduct(15, 5.5, 25);
        Iterable<Product> iterable = productStock.findFirstByAlphabeticalOrder(productStock.getCount());
        assertNotNull(iterable, "The iterable returned by method is null.");
        List<String> actualProducts = new ArrayList<>();
        for (Product product : iterable) {
            actualProducts.add(product.getLabel());
        }
        List<String> expectedProducts = StreamSupport.stream(productStock.spliterator(), false)
                .map(Product::getLabel)
                .sorted().collect(Collectors.toList());
        assertEquals(expectedProducts, actualProducts, "Not in correct order");*/
        Product[] products = {
                new Product("A", 5, 5),
                new Product("B", 6, 6),
                new Product("C", 7, 7),
        };

        Arrays.stream(products).forEach(e -> this.productStock.add(e));

        Product[] expected = Arrays.stream(products).toArray(Product[]::new);

        Iterable<Product> firstByAlphabeticalOrder = this.productStock.findFirstByAlphabeticalOrder(3);

        Product[] actual = StreamSupport.stream(firstByAlphabeticalOrder.spliterator(), false).toArray(Product[]::new);

        assertArrayEquals(expected, actual);
    }

    @Test
    void testThatFindFirstByAlphabeticalOrderReturnsEmptyCollectionWhenOutOfRange() {
        addRandomProduct(15, 5.5, 25);
        Iterable<Product> iterable = productStock.findFirstByAlphabeticalOrder(productStock.getCount() + 1);
        List<String> products = assertAndExtract(iterable, Product::getLabel);
        assertTrue(products.isEmpty());
    }

    @Test
    void testThatFindAllInRangeReturnsTheCorrectRange() {
        Product[] products = {
                new Product("A", 5.5, 5),
                new Product("B", 50.5, 6),
                new Product("C", 45.5, 7),
        };
        Arrays.stream(products).forEach(e -> this.productStock.add(e));
        double start = products[0].getPrice();
        double end = products[2].getPrice();
        Iterable<Product> iterable = this.productStock.findAllInRange(start, end);
        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        assertEquals(1, returnedPrices.size());
        Double actual = returnedPrices.get(0);
        assertEquals(end, actual, 0.00);
    }

    @Test
    void testThatFindAllInRangeReturnsTheCorrectRangeAndCorrectOrder() {
        Product[] products = {
                new Product("A", 5.5, 5),
                new Product("B", 50.5, 6),
                new Product("C", 45.5, 7),
                new Product("D", 35.5, 7),
        };
        Arrays.stream(products).forEach(e -> this.productStock.add(e));
        double start = products[0].getPrice();
        double end = products[1].getPrice();
        Iterable<Product> iterable = this.productStock.findAllInRange(start, end);
        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);


        List<Double> expected = StreamSupport.stream(iterable.spliterator(), false)
                .map(Product::getPrice)
                .filter(p -> p > start && p <= end)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        assertEquals(expected, returnedPrices);
    }

    @Test
    void testThatFindAllInRangeReturnsEmptyCollectionWhenNoneMatch() {
        Product[] products = {
                new Product("A", 5.5, 5),
                new Product("B", 50.5, 6),
                new Product("C", 45.5, 7),
                new Product("D", 35.5, 7),
        };
        Arrays.stream(products).forEach(e -> this.productStock.add(e));
        double start = -10;
        double end = -4;
        Iterable<Product> iterable = this.productStock.findAllInRange(start, end);
        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        assertTrue(returnedPrices.isEmpty());
    }

    @Test
    void testThatFindAllByPriceReturnsCorrectProducts() {
        addRandomProduct(10, 13.3, getRandomQuantity(142));
        addRandomProduct(25, getRandomPrice(0.0, 550.0), getRandomQuantity(50));
        Iterable<Product> allByPrice = this.productStock.findAllByPrice(13.3);
        assertNotNull(allByPrice);

        long count = StreamSupport.stream(allByPrice.spliterator(), false).count();
        assertEquals(10, count);
    }

    @Test
    void testThatFindAllByPriceReturnsEmptyCollection() {
        addRandomProduct(10, 13.3, getRandomQuantity(142));
        addRandomProduct(25, 50.5, getRandomQuantity(50));
        Iterable<Product> allByPrice = this.productStock.findAllByPrice(15.5);
        List<Double> expectedEmpty = assertAndExtract(allByPrice, Product::getPrice);

        long count = StreamSupport.stream(allByPrice.spliterator(), false).count();
        assertEquals(0, count);
        assertTrue(expectedEmpty.isEmpty());
    }

    @Test
    void testThatFindAllByQuantityReturnsCorrectProducts() {
        addRandomProduct(10, 13.3, 15);
        Iterable<Product> allByQuantity = this.productStock.findAllByQuantity(15);
        assertNotNull(allByQuantity);

        long count = StreamSupport.stream(allByQuantity.spliterator(), false).count();
        assertEquals(10, count);
    }

    @Test
    void testThatFindAllByQuantityReturnsEmptyCollection() {
        addRandomProduct(10, 13.3, 50);
        Iterable<Product> allByQuantity = this.productStock.findAllByQuantity(15);
        List<Integer> expectedEmpty = assertAndExtract(allByQuantity, Product::getQuantity);

        long count = StreamSupport.stream(allByQuantity.spliterator(), false).count();
        assertEquals(0, count);
        assertTrue(expectedEmpty.isEmpty());
    }

    @Test
    void testThatFindFirstMostExpensiveProductsThrowsExceptionIfLessThanCountExists() {
        assertThrows(IllegalArgumentException.class, () -> {
            addRandomProduct(25, getRandomPrice(0.0, 550.0), getRandomQuantity(50));
            this.productStock.findFirstMostExpensiveProducts(26);
        });
    }

    @Test
    void testThatIteratorReturnsCorrectValue() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            productList.add(randomProductFactory(getRandomString(),
                    getRandomPrice(0.0, 555.5),
                    getRandomQuantity(100)));
        }
        productList.forEach(productStock::add);
        Product[] expected = productList.toArray(Product[]::new);
        Product[] actual = StreamSupport.stream(productStock.spliterator(), false).toArray(Product[]::new);
        assertNotNull(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void testThatFindFirstMostExpensiveProductsReturnsCorrectValue() {
        addRandomProduct(25, getRandomPrice(0.0, 550.0), getRandomQuantity(50));
        Iterable<Product> firstMostExpensiveProducts = this.productStock.findFirstMostExpensiveProducts(15);
        assertNotNull(firstMostExpensiveProducts);

        long count = StreamSupport.stream(firstMostExpensiveProducts.spliterator(), false).count();
        assertEquals(15, count);
    }

    //private methods for testing
    //create and add products

    private static <T> List<T> assertAndExtract(Iterable<Product> iterable, Function<Product, T> mapper) {
        assertNotNull(iterable);
        List<T> result = new ArrayList<>();
        for (Product product : iterable) {
            result.add(mapper.apply(product));
        }
        return result;
    }

    private List<Product> addRandomProduct(int count, double price, int quantity) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Product product = randomProductFactory(getRandomString(), price, quantity);
            this.productStock.add(product);
            productList.add(product);
        }
        return productList;
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

    private String getRandomString() {
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