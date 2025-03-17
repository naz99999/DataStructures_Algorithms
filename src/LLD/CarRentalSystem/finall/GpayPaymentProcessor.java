package LLD.CarRentalSystem.finall;

public class GpayPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
