public class TradeIn {
    private int serialNumber;
    private String make;
    private String model;
    private int year;

    public TradeIn(int serialNumber, String make, String model, int year) {
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public int getSerialNumber(){
        return serialNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public void printInfo() {
        System.out.println("Serial Number: " + getSerialNumber());
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
    }

}