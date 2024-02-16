public class TradeInVehicle {
    private String serialNumber;
    private String make;
    private String model;
    private int year;

    public TradeInVehicle(){}

    public TradeInVehicle(String serialNumber,String make,String model,int year){
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
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

    public void setTradeInVehicle(String serialNumber,String make,String model,int year){
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String toString(){
        return "serialNumber: " + serialNumber + " | make: " + make + " | model: " + model + " | year: " + year;
    }

}
