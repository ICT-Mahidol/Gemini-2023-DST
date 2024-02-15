public class Vehicle {
    private String vehicleSerialNumber;
    private String name;
    private String model;
    private int year;
    private String manufacturer;
    private float baseCost;
    
    public Vehicle(){

    }
    public Vehicle(String name,String vehicleSerialNumber,String model,int year,String manufacturer,float baseCost){
        this.name = name;
        this.vehicleSerialNumber = vehicleSerialNumber;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }
    public String getName() {
        return name;
    }
    public String getVehicleSerialNumber() {
        return vehicleSerialNumber;
    }
    public String getModel(){
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public float getBaseCost() {
        return baseCost;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setVehicleSerialNumber(String vehicleSerialNumber) {
        this.vehicleSerialNumber = vehicleSerialNumber;
    }
    public void setYear(int year) {
        this.year =  year;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setBaseCost(float baseCost) {
        this.baseCost = baseCost;
    }
    public String toString(){
        return "Name: "+name+"Medel: "+model+"Cost: "+baseCost+"Year: "+year+"Manufacturer"+manufacturer+"VehicleSerailNumber: "+vehicleSerialNumber;
    }
}
