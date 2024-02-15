import java.util.ArrayList;

public class TradeInVehicle {
    private int serialNumber;
    private String customer; 
    public String make;
    public String model;
    public int year;


    public int getserialNumber(){
        return serialNumber;
    }

    public void setcustomer(){
        this.customer = customer.toString();
    }

    public void setSerialNumber(int serialNumber){
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

    public void setTradeInVehicle(int serialNumber,String make,String model,int year){
        this.serialNumber = serialNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String toString(){
        return "serialNumber: " + serialNumber + "make: " + make + "model: " + model + "year: " + year;
    }

}
