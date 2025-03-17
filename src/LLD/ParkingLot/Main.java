package LLD.ParkingLot;

public class Main {
    public static void main(String args[]) throws Exception {
        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.addLevel(new Level(0, 10));

        parkingLot.displayLevels();

        Vehicle car = new Car("2182");
        Vehicle bike = new Bike("9177");
        Vehicle bike2 = new Bike("91377");
        Vehicle bike3 = new Bike("91747");
        Vehicle bike4 = new Bike("917237");
        Vehicle bike5 = new Bike("917327");
        Vehicle bike6 = new Bike("917337");
        parkingLot.park(car);
        parkingLot.park(bike);
        parkingLot.park(bike2);
        parkingLot.park(bike3);
        parkingLot.park(bike4);
        parkingLot.park(bike5);

        parkingLot.park(bike6);


        parkingLot.displayLevels();
    }
}
