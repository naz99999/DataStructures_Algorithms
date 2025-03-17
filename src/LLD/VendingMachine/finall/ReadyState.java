package LLD.VendingMachine.finall;


public class ReadyState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is selected, please insert money");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin of Rs " + coin.getRupees() + "is inserted");
        checkPayment();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note of Rs " + note.getRupees() + "is inserted");
        checkPayment();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product is selected, please insert money");
    }

    @Override
    public void returnChange() {
        System.out.println("Product is selected, please insert money");
    }

    private void checkPayment() {
        if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setState(vendingMachine.getReadyState());
        } else {
            System.out.println("Insufficient amount inserted");
        }
    }
}
