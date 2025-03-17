package LLD.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level addedLevel) {
        levels.add(addedLevel);
    }
    public void park(Vehicle vehicle) {
        for (Level level : levels) {
            level.parkVehicle(vehicle);
        }
    }

    public void unPark(Vehicle vehicle) {
        for (Level level : levels) {
            level.unParkVehicle(vehicle);
        }
    }

    public void displayLevels() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }
}
