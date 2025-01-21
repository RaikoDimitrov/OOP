package TestDrivenDevelopment.productTracking;

import java.util.*;

public class InStock implements ProductStock {

    private Map<String, Product> products;

    public InStock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.containsValue(product);
    }

    @Override
    public void add(Product product) {
        this.products.putIfAbsent(product.getLabel(), product);

    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if (!this.products.containsKey(product)) {
            throw new IllegalArgumentException("Product missing: " + product);
        }
        this.products.get(product).setQuantity(quantity);

    }

    @Override
    public Product find(int index) {
        List<Product> productList = new ArrayList<>(this.products.values());
        if (index < 0 || index >= productList.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return productList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        if (!this.products.containsKey(label)) {
            throw new IllegalArgumentException("Product missing: " + label);
        }
        return this.products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        return null;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return null;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        return null;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return null;
    }

    @Override
    public Iterator<Product> iterator() {
        return null;
    }
}
