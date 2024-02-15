public class Vehical {
    private String vehicalSerialNumber;
    private String name;
    private String model;
    private int year;
    private String manufacturer;
    private float baseCost;
    
    public Vehical(String initialN,String intialVSN,String initialM,int initialY,String initialMF,float initialBC){
        this.name = initialN;
        this.vehicalSerialNumber = intialVSN;
        this.model = initialM;
        this.year = initialY;
        this.manufacturer = initialMF;
        this.baseCost = initialBC;
    }
    public void printVehical(){
        System.out.println("Name: "+ this.name +", Model: "+this.model+", Cost: "+this.baseCost+", Year: "+this.year+ ", Manufacturer: "+this.manufacturer+", VehicalSerialNumber: "+this.vehicalSerialNumber);
    }
}
