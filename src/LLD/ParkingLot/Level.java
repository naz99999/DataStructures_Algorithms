package LLD.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        this.parkingSpots = new ArrayList<>(numSpots + 1);

        double bikeSpotRatio = 0.5;
        double carSpotRatio = 0.4;

        int bikeSpots = (int) (bikeSpotRatio * numSpots);
        int carSpots = (int) (carSpotRatio * numSpots);

        for (int i = 1; i <= bikeSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.BIKE));
        }

        for (int i = bikeSpots + 1; i <= bikeSpots + carSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for (int i = bikeSpots + carSpots + 1; i <= numSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.BUS));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.addVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (!parkingSpot.isAvailable() && parkingSpot.getParkedVehicle().equals(vehicle)) {
                parkingSpot.removeVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level floor : " + floor );
        System.out.println("Parking Spots : ");
        for (ParkingSpot parkingSpot : parkingSpots) {
            parkingSpot.displayAvailability();
        }
    }
}
