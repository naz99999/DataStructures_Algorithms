package LLD.CarRentalSystem.initial;

import java.util.List;

public class CarRentalSystem {
    private final ReservationManager reservations;
    private final CarManager carManager;

    private Customer customer;

    private CarRentalSystem() {
        this.reservations = new ReservationManager();
        this.carManager = new CarManager();
        this.customer = null;
    }

    public void loginCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addCar(Car car, List<Integer> availableDates) {
        carManager.addCar(car, availableDates);
    }

    public void browseByPriceRange(int minRange, int maxRange) {
        carManager.browseByPriceRange(minRange, maxRange);
    }

    public void browseByAvailability(List<Integer> dates) {
        carManager.browseByAvailability(dates);
    }

    public void browseByType(CarBodyType bodyType) {
        carManager.browseByType(bodyType);
    }

    public void createReservation(Car car, List<Integer> bookingDates) {
        ;
    }

    public void modifyReservation(Car car, List<Integer> bookingDates) {
        ;
    }

    public void cancelReservation(Car car, List<Integer> bookingDates) {
        ;
    }
}
