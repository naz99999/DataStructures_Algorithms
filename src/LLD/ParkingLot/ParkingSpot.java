package LLD.ParkingLot;

public class ParkingSpot {
    private final int position;
    private final VehicleType vehicleType;

    private Vehicle parkedVehicle;

    public ParkingSpot(int position, VehicleType vehicleType) {
        this.position = position;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getVehicleType() == vehicleType) {
            parkedVehicle = vehicle;
            return true;
        } else {
            throw new IllegalArgumentException("Parking is full or Invalid Vehicle Type");
        }
    }

    public void removeVehicle() {
        parkedVehicle = null;
    }

    public void displayAvailability() {
        System.out.println("Spot :- Positon - " + position + " Parked Vehicle - " + parkedVehicle);
    }
}
