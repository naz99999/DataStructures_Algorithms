package LLD.VendingMachine.initial;

public class Main {
    public static void main(String args[]) throws Exception {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        Product chips = new Product("Chips", 25, 5);
        Product gum = new Product("Gum", 2, 25);
        vendingMachine.addProduct(chips);
        vendingMachine.addProduct(gum);

        vendingMachine.displayProducts();

        System.out.println(vendingMachine.dispense(chips, 1, Note.FIFTY, Coin.ZERO));

        vendingMachine.displayProducts();

        System.out.println(vendingMachine.collectMoney());
    }
}
