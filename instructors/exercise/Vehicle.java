
public class Vehicle {
    private int serialNo;
    private String name;
    private String model;
    private int year;
    private String manufacturer;
    private double basePrice;

    public Vehicle() {
    }
    
    public Vehicle(int serialNo, String name, String model, int year, String manufacturer, double basePrice) {
        this.serialNo = serialNo;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
    }
}
