public class TradeInVehicle {
    public String Trade_serial_number;
    public String Trade_make;
    public String Trade_model;
    public int Trade_year;

    public void printTradeInVehicle(String Trade_serial_number, String Trade_make, String Trade_model, int Trade_year) {
        this.Trade_serial_number = Trade_serial_number;
        this.Trade_make = Trade_make;
        this.Trade_model = Trade_model;
        this.Trade_year = Trade_year;

        System.out.println("Serial number: " + Trade_serial_number);
        System.out.println("Make: " + Trade_make);
        System.out.println("Model: " + Trade_model);
        System.out.println("Year: " + Trade_year);
    }
}
