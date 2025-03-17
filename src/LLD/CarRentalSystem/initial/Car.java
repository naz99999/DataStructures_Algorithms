package LLD.CarRentalSystem.initial;

public class Car {
    private String model;
    private String year;
    private String licensePlate;
    private int pricePerDay;

    private CarBodyType bodyType;

    public Car(String model, String year, String licensePlate, int pricePerDay, CarBodyType bodyType) {
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.pricePerDay = pricePerDay;
        this.bodyType = bodyType;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public CarBodyType getBodyType() {
        return bodyType;
    }
}
