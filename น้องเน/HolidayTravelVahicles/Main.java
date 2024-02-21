//Main Class
public class Main {
    public static void main(String[] args) {
        Vehicles SaleVehicle = new Vehicles("BMW", "AAUD4686453", "X1", 2023, "BMW", 1200000);
        System.out.println("Vehicle Information:");
        System.out.println("Brand: " + SaleVehicle.getName());
        System.out.println("SerialNumber: " + SaleVehicle.getSerialNumber());
        System.out.println("Model: " + SaleVehicle.getModel());
        System.out.println("Year: " + SaleVehicle.getYear());
        System.out.println("Manufacturer: " + SaleVehicle.getManufacturer());
        System.out.println("BaseCost: " + SaleVehicle.getBaseCost());
    }
}