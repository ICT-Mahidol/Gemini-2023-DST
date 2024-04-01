public class Vehicle {
    public String serialnumber;
    public String name;
    public String model;
    public int year;
    public String manufacturer;
    public int basecost;
    private Saleinvoice saleinvoice;

    public Vehicle(String serialnumber, String name, String model, int year, String manufacturer, int basecost) {
        this.serialnumber = serialnumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.basecost = basecost;
    }

    public String getName() {
        return this.name;
    }

    public String getSerialNumber() {
        return this.serialnumber;
    }

    public String getModel() {
        return this.model;
    }
    
    public int getYear() {
        return this.year;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public int getBaseCost() {
        return this.basecost;
    }
}
