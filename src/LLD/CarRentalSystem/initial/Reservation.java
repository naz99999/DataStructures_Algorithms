package LLD.CarRentalSystem.initial;

import java.util.List;

public class Reservation {
    private int id;
    private Car car;
    private List<Integer> reservationDates;

    public Reservation(int id, Car car, List<Integer> reservationDates) {
        this.id = id;
        this.car = car;
        this.reservationDates = reservationDates;
    }

    public int getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public List<Integer> getReservationDates() {
        return reservationDates;
    }
}
