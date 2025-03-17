package LLD.VendingMachine.finall;

public enum Note {
    ZERO(0),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    private final int rupees;
    Note(int value) {
        this.rupees = value;
    }

    public int getRupees() {
        return rupees;
    }
}
