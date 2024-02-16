public class TradeInVehicle {
    private String serialNumber;
    private String make;
    private String model;
    private int year;
    private double tradeinAllowance;

    public TradeInVehicle(){}

    public TradeInVehicle(String serialNumber,String make,String model,int year,double tradeinAllowance){
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.tradeinAllowance = tradeinAllowance;
    }


    public String getSerialNumber(){
        return serialNumber;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public double getTradeInAllowance(){
        return tradeinAllowance;
    }

    public void setSerialNumber(String serialNumber){
        this.serialNumber = serialNumber;
    }

    public void setMake(String make){
        this.make = make;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setTradeInAllowance(double tradeinAllowance){
        this.tradeinAllowance = tradeinAllowance;
    }

    public void setTradeInVehicle(String serialNumber,String make,String model,int year, double tradeinAllowance){
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.tradeinAllowance = tradeinAllowance;
    }

    public String toString(){
        return "serialNumber: " + serialNumber + " | make: " + make + " | model: " + model + " | year: " + year + " | trade in allowance: "+tradeinAllowance;
    }

}
