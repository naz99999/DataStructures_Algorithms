package LLD.CarRentalSystem.finall;

public class Car {
    private final String make;
    private final String model;
    private final int year;
    private final String licensePlate;
    private final double rentalPricePerDay;
    private final CarBodyType bodyType;
    private boolean available;

    public Car(String make, String model, int year, String licensePlate, double rentalPricePerDay, CarBodyType bodyType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.bodyType = bodyType;
        this.available = true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public CarBodyType getBodyType() {
        return bodyType;
    }

    public boolean isAvailable() {
        return available;
    }
}
