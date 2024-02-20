    public class Main {
        public static void main(String[] args) {
            Car car = new Car(11502567, "Toyota", "Yaris", 2005, "Toyota Motor Corporation", 300000);
        
            System.out.println("Serial Number: " + car.getVehicle_serial_number());
            System.out.println("Name: " + car.getName());
            System.out.println("Model: " + car.getModel());
            System.out.println("Year: " + car.getYear());
            System.out.println("Manufacturer: " + car.getManufacturer());
            System.out.println("Base cost: " + car.getBasecost());
        }
    }