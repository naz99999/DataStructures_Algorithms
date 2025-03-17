package LLD.VendingMachine.finall;

public class IdleState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.inventory.isAvailable(product)) {
            vendingMachine.selectProduct(product);
            vendingMachine.setState(vendingMachine.getReadyState());
            System.out.println("Product is selected " + product.getName());
        } else {
            System.out.println("Product is not available " + product.getName());
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Select a product first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Select a product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select a product first");
    }

    @Override
    public void returnChange() {
        System.out.println("Select a product first");
    }
}
