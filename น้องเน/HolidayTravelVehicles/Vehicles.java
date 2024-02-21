public class Vehicles {
    private String name;
    private String serialNumber;
    private String model;
    private int year;
    private String manufacturer;
    private int baseCost;
    private SaleInvoice saleInvoice;

    public Vehicles(String name, String serialNumber, String model, int year, String manufacturer, int baseCost) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
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
        return baseCost;
    }
}
