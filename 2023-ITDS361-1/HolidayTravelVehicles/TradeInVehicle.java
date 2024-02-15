import java.util.ArrayList;

public class TradeInVehicle {
    private int serialNumber;
    public String make;
    public String model;
    public int year;

    public int getserialNumber(){
        return serialNumber;
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

    public ArrayList<String> getAllData()    {
    ArrayList<String>  TradeInData = new ArrayList<String>();   //create list
    String serialNumberSTR = String.valueOf(serialNumber);  //convert int to str
    String yearSTR = String.valueOf(year);  //convert int to str
    TradeInData.add(serialNumberSTR);
    TradeInData.add(make);
    TradeInData.add(model);
    TradeInData.add(yearSTR);
    return(TradeInData);
}
}
