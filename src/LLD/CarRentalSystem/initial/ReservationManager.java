package LLD.CarRentalSystem.initial;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private final CarManager carManager;
    private final List<Reservation> reservations;

    private final PaymentInterface paymentInterface;
    public ReservationManager() {
        this.paymentInterface = new PaymentInterface();
        this.reservations = new ArrayList<>();
        this.carManager = new CarManager();
    }

    public void createReservation(Car car, List<Integer> bookingDates) {

    }

    public void modifyReservation(Car car, List<Integer> bookingDates) {

    }

    public void cancelReservation(Car car, List<Integer> bookingDates) {

    }

}
