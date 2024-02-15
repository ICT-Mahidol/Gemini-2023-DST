public class Vehicle {
    private String serial;
    private String model;
    private String year;
    private String manufacturer;
    private int baseCost;

    public Vehicle(String serial, String model, String year, String manufacturer, int baseCost) {
        this.serial = serial;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(int baseCost) {
        this.baseCost = baseCost;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "serial='" + serial + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", baseCost=" + baseCost +
                '}';
    }
}
