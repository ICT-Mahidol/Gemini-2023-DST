public class Main {
    public static void Main(String[] args) {
        Car car = new Car(11502567, "Toyota", "Yaris", 2005, "Toyota Motor Corporation", 300000);
     
    System.out.println("Serial Number: " + car.getVehicle_serial_number());
    System.out.println("Name: " + car.getName());
    System.out.println("Model: " + car.model());
    System.out.println("Year: " + car.year());
    System.out.println("Manufacturer: " + car.manufacturer());
    System.out.println("Base cost: " + car.basecost());
    }
}