public class Vehicles {
    private int serialNumber;
    public String name;
    private String model;
    public int year;
    private String manufacturer;
    private double baseCost;

    public Vehicle(String serialNumber, String name, String model, int year, String manufacturer, double baseCost) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBaseCost() {
        return baseCost;
    }

    public void printInfo() {
        System.out.println("Serial Number: " + vehicle.getSerialNumber());
        System.out.println("Name: " + vehicle.getName());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year: " + vehicle.getYear());
        System.out.println("Manufacturer: " + vehicle.getManufacturer());
        System.out.println("Base Cost: $" + vehicle.getBaseCost());
    }

}

