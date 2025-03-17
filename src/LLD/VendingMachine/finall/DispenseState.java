package LLD.VendingMachine.finall;


public class DispenseState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Payment is made, please collect your product");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment is made, please collect your product");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment is made, please collect your product");
    }

    @Override
    public void dispenseProduct() {
        Product productSelected = vendingMachine.getSelectedProduct();
        vendingMachine.inventory.updateQuantity(productSelected, vendingMachine.inventory.getQuantity(productSelected) - 1);

        System.out.println("Product dispensed " + productSelected + ", Please collect ");

        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Payment is made, please collect your product");
    }
}
