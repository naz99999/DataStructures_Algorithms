package LLD.VendingMachine.finall;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

    private final Map<Product, Integer> products;

    public Inventory() {
        this.products = new ConcurrentHashMap<>();
    }

    public boolean isAvailable(Product product) {
        return products.containsKey(product) && products.get(product) > 0;
    }

    public void updateQuantity(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }
}
