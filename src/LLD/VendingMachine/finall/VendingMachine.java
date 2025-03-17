package LLD.VendingMachine.finall;

public class VendingMachine {

    private static VendingMachine instance;
    Inventory inventory;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState dispenseState;
    private final VendingMachineState returnChangeState;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private double totalPayment;

    private VendingMachine() {
        this.idleState = new IdleState(this);
        this.readyState = new ReadyState(this);
        this.dispenseState = new DispenseState(this);
        this.returnChangeState = new ReturnChangeState(this);
        this.inventory = new Inventory();
        this.selectedProduct = null;
        this.totalPayment = 0.0;
        this.currentState = idleState;
    }

    private VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void insertNote(Note note) {
        currentState.insertNote(note);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void returnChange() {
        currentState.returnChange();
    }

    public void setState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public void addCoin(Coin coin) {
        totalPayment += coin.getRupees();
    }

    public void addNote(Note note) {
        totalPayment += note.getRupees();
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public VendingMachineState getDispenseState() {
        return dispenseState;
    }

    public VendingMachineState getReturnChangeState() {
        return returnChangeState;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void resetProduct() {
        selectedProduct = null;
    }

    public void resetPayment() {
        totalPayment = 0.0;
    }
}