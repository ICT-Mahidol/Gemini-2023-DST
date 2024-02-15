public class Vehicles {
    private int serialNumber;
    public String name;
    private String model;
    public int year;
    private String manufacturer;
    private double baseCost;

    public Vehicles(int serialNumber, String name, String model, int year, String manufacturer, double baseCost) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getYear() {
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

    public double getBaseCost() {
        return baseCost;
    }

    public void printInfo() {
        System.out.println("Serial Number: " + Vehicles.getSerialNumber());
        System.out.println("Name: " + Vehicles.getName());
        System.out.println("Model: " + Vehicles.getModel());
        System.out.println("Year: " + Vehicles.getYear());
        System.out.println("Manufacturer: " + Vehicles.getManufacturer());
        System.out.println("Base Cost: $" + Vehicles.getBaseCost());
    }

}

