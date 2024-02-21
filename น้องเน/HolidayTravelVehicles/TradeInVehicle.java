public class TradeInVehicle {
    public String serialnumber;
    public String model;
    public int year;
    private SaleInvoice saleinvoice;

    public TradeInVehicle(String serialnumber, String model, int year) {

        this.serialnumber = serialnumber;
        this.model = model;
        this.year = year;
    }

    public String getSerialNumber() {
            return serialnumber;
        }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}