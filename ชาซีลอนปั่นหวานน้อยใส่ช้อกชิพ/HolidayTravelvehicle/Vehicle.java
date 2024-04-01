public class Vehicle  {
    private int serialNumber;
    public String name;
    private String model;
    public int year;
    private String manufacturer;
    private double baseCost;

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

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public void printInfo() {
        System.out.println("Serial Number: " + getSerialNumber());
        System.out.println("Name: " + getName());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Base Cost: " + getBaseCost() + "$");
    }

}

