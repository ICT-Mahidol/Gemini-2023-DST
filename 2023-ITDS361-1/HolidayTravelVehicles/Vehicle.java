public class Vehicle {
    private String VehicleSerialNumber;
    private String name;
    private String model;
    private int year;
    private String manufacturer;
    private float baseCost;
    
    public Vehicle(){

    }
    public Vehicle(String name,String VehicleSerialNumber,String model,int year,String manufacturer,float baseCost){
        this.name = name;
        this.VehicleSerialNumber = VehicleSerialNumber;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }
    public String getname() {
        return name;
    }
    public String getVehicleSerialNumber() {
        return VehicleSerialNumber;
    }
    public String getmodel(){
        return model;
    }
    public int getyear() {
        return year;
    }
    public String getmanufacturer() {
        return manufacturer;
    }
    public float getbaseCost() {
        return baseCost;
    }
    
    public String setname() {
        return name;
    }
    public String setmodel() {
        return VehicleSerialNumber;
    }
    public String setVehicleSerialNumber() {
        return VehicleSerialNumber;
    }
    public int setyear() {
        return year;
    }
    public String setmanufacturer() {
        return manufacturer;
    }
    public float setbaseCost() {
        return baseCost;
    }
    public void printVehicle(){
        System.out.println("Name: "+ this.name +", Model: "+this.model+", Cost: "+this.baseCost+", Year: "+this.year+ ", Manufacturer: "+this.manufacturer+", VehicleSerialNumber: "+this.VehicleSerialNumber);
    }
}
