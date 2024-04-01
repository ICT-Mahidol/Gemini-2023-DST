public class CarDetails {
    private int serial_number;
    private String brand;
    private String model;
    private int year;
    private String manufacturer;
    private int base_cost;

    public CarDetails(int serial_number, String brand, String model, int year, String manufacturer, int base_cost) {
        this.serial_number = serial_number;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.base_cost = base_cost;
    }

    // Getter methods
    public int getSerialNumber() {
        return serial_number;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getBaseCost() {
        return base_cost;
    }
}
