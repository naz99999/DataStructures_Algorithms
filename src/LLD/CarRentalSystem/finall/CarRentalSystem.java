package LLD.CarRentalSystem.finall;

import java.time.LocalDate;
import java.util.*;

public class CarRentalSystem {
    private final Map<String, Car> cars;
    private final Map<String, Reservation> reservations;
    private final PaymentProcessor paymentProcessor;

    private CarRentalSystem() {
        this.cars = new HashMap<>();
        this.reservations = new HashMap<>();
        this.paymentProcessor = new GpayPaymentProcessor();
    }

    public void addCar(Car car) {
        cars.put(car.getLicensePlate(), car);
    }

    public void removeCar(Car car) {
        cars.remove(car.getLicensePlate());
    }

    public List<Car> searchCars(CarBodyType bodyType, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> searchResults = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getBodyType().equals(bodyType) && car.getModel().equals(model) && car.isAvailable()) {
                if (isCarAvailable(car, startDate, endDate)) {
                    searchResults.add(car);
                }
            }
        }
        return searchResults;
    }

    public synchronized Reservation makeReservation(Car car, LocalDate startDate, LocalDate endDate, Customer customer) {
        if (isCarAvailable(car, startDate, endDate)) {
            String reservationId = getReservationId();
            Reservation reservation = new Reservation(reservationId, customer, car, startDate, endDate);
            reservations.put(reservationId, reservation);
            car.setAvailable(false);
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(Reservation reservation) {
        reservations.remove(reservation.getReservationId());
        reservation.getCar().setAvailable(true);
    }

    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation.getTotalPricePerDay());
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations.values()) {
            if (reservation.getCar().equals(car)) {
                if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                    return false;
                }
            }
        }
        return true;
    }

    private String getReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}
