public class Vehicle {

    // fields
    private String vehicle_serial_number;
    private String name;
    private String model;
    private int year;
    private String manufacturer;
    private int base_cost;

    // Constructor
    public Vehicle(String vehicle_serial_number, String name, String model, int year, String manufacturer, int base_cost) {
        this.vehicle_serial_number = vehicle_serial_number;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.base_cost = base_cost;
    }

    // Method to get the base cost
    public int getBaseCost() {
        return base_cost;
    }

    // Method to set the base cost
    public void setBaseCost(int base_cost) {
        this.base_cost = base_cost;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_serial_number='" + vehicle_serial_number + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", manufacturer='" + manufacturer + '\'' +
                ", base_cost=" + base_cost +
                '}';
    }

   
}

