package LLD.VendingMachine.initial;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private static VendingMachine instance;

    private int cashDeposited = 0;
    private final List<Product> products;
    private VendingMachine() {
        this.products = new ArrayList<>();
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int dispense(Product product, int quantity, Note note, Coin coin) throws Exception {
        if (product.getQuantity() < quantity) {
            throw new Exception("OUT_OF_STOCK");
        }

        int cashInserted = note.getRupees() + coin.getRupees();
        if (product.getPrice() > cashInserted) {
            throw new Exception("INSUFFICIENT_AMT_INSERTED");
        }

        int cashChange = cashInserted - product.getPrice();
        cashDeposited += product.getPrice();
        product.setQuantity(product.getQuantity() - quantity);

        return cashChange;
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println("Product :- " + product.getName() + ", Quantity :- " + product.getQuantity());
        }
    }

    public int collectMoney() {
        int temp = cashDeposited;
        cashDeposited = 0;
        return temp;
    }

    public void restockProducts(Product product, int quantity) {
        product.setQuantity(product.getQuantity() + quantity);
    }

}
