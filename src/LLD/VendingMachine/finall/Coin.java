package LLD.VendingMachine.finall;

public enum Coin {
    ZERO(0),
    ONE(1),
    TWO(2),
    FIVE(5);
    private final int rupees;
    Coin(int value) {
        this.rupees = value;
    }

    public int getRupees() {
        return rupees;
    }
}
