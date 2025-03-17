package LLD.VendingMachine.finall;

public class ReturnChangeState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected, Please collect your change");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already made, Please collect your change");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already made, Please collect your change");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product already dispensed, Please collect your change");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getTotalPayment() - vendingMachine.getSelectedProduct().getPrice();
        System.out.println("Collect your change Rs " + change);

        vendingMachine.resetProduct();
        vendingMachine.resetPayment();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
