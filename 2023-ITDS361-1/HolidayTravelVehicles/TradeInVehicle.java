import java.util.ArrayList;

public class TradeInVehicle {
    private int serialNumber;
    public String make;
    public String model;
    public int year;

    public int getserialNumber(){
        return serialNumber;
    }

    public void setserialNumber(int serialNumber){
        this.serialNumber = serialNumber;
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
