package LLD.CarRentalSystem.initial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CarManager {
    private final List<Car> cars;
    private final HashMap<Car, List<Integer>> availableDates;

    public CarManager() {
        this.cars = new ArrayList<>();
        this.availableDates = new HashMap<>();
    }

    public boolean isAvailable(Car car, Integer date) {
        return availableDates.getOrDefault(car, new ArrayList<>()).contains(date);
    }

    public void addCar(Car car, List<Integer> addDates) {
        availableDates.put(car, addDates);
    }

    public void modifyDates(Car car, List<Integer> bookingDates) {
        List<Integer> getDates = availableDates.get(car);
        getDates.removeAll(bookingDates);
        availableDates.put(car, getDates);
    }

    public void browseByType(CarBodyType bodyType) {
        for (Car car : cars) {
            if (car.getBodyType().equals(bodyType)) {
                System.out.println(car.getModel());
            }
        }
    }

    public void browseByPriceRange(int priceRangeLow, int priceRangeHigh) {
        for (Car car : cars) {
            if (car.getPricePerDay() >= priceRangeLow && priceRangeHigh <= car.getPricePerDay()) {
                System.out.println(car.getModel());
            }
        }
    }

    public void browseByAvailability(List<Integer> dates) {
        availableDates.forEach((key, value) -> {
            if (new HashSet<>(value).containsAll(dates)) {
                System.out.println(key.getModel());
            }
        });
    }
}
