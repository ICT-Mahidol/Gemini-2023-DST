public class TradeInVihicle {
    private int serial_number;
    private String brand;
    private String model;
    private int year;
    private int selling_price;

    public TradeInVihicle(int serial_number, String brand, String model, int year, int selling_price) {
        this.serial_number = serial_number;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.selling_price = selling_price;
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

    public int getSellingPrice() {
        return selling_price;
    }
}
