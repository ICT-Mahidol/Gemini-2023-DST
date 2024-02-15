public class TradeIn {
    private String serialNumber;
    private String make;
    private String model;
    private int year;

    public TradeIn(String serialNumber, String make, String model, int year) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getSerialNumber(){
        return serialNumber;
    }
}