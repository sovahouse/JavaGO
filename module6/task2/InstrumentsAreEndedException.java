package task2;


public class InstrumentsAreEndedException extends Exception {

    private int userQuantity;

    public InstrumentsAreEndedException(int userQuantity) {
        this.userQuantity = userQuantity;
    }

    public int getUserQuantity() {
        return userQuantity;
    }
}
