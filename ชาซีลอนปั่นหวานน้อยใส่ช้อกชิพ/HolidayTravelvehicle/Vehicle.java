public class Vehicle {
    private int serialNumber;
    public String name;
    private String model;
    public int year;
    private String manufacturer;
    private double baseCost;

    public Vehicle() {}

    public Vehicle(int serialNumber, String name, String model, int year, String manufacturer, double baseCost) {
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

    public void setBaseCost(double a) {
        this.baseCost = a;
    }

    public void printInfo() {
        System.out.println("Serial Number: " + getSerialNumber());
        System.out.println("Name: " + getName());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Base Cost: $" + getBaseCost());
    }

}

