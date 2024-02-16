import java.util.ArrayList;
public class Vehicle {
    private String vehicleSerialNumber;
    private String name;
    private String model;
    private int year;
    private String manufacturer;
    private double baseCost;
    private ArrayList<DealerInstalledOptions> installedList;
    
    public Vehicle(){
        this.installedList = new ArrayList<DealerInstalledOptions>();
    }
    public Vehicle(String name,String vehicleSerialNumber,String model,int year,String manufacturer,double baseCost){
        this.name = name;
        this.vehicleSerialNumber = vehicleSerialNumber;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
        this.installedList = new ArrayList<DealerInstalledOptions>();
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
    public double getBaseCost() {
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
    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }
    public void setVehicle(String vehicleSerialNumber,String name,String model,int year,String manufacturer,double baseCost){
        this.vehicleSerialNumber = vehicleSerialNumber;
        this.name = name;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.baseCost = baseCost;
    }
    public void addInstalledOptions(DealerInstalledOptions installed){
        boolean dup = false;
        for(DealerInstalledOptions t: installedList){
            if(t.getDescription() == installed.getDescription()){
                dup = true;
                break;
            }
        }if(dup) {
            System.out.println( installed.getDescription()+" already in the list");
        }installedList.add(installed);
    }

    public void showInstalledOptions() {
        if(installedList.size()>0){
            System.out.println("Installed Options");
		for(int i = 0; i < installedList.size(); i++) {
			System.out.println("[" + i + "] " + installedList.get(i).toString());
		}
        }
	}

    public void showVehicleItems(){
        String formatString = "%-" + (25) + "s%-20s%s\n";
        System.out.printf(formatString, manufacturer+" "+name+" "+model, baseCost,"");
    }
    
    public void showInstalledOptionsItems() {
        if (installedList.size() > 0) {
            System.out.println("\nInstalled Options");
            System.out.println("------------------");
            String formatString = "%-" + (25) + "s%-20s%s\n";
            for (DealerInstalledOptions options : installedList) {
                System.out.printf(formatString, options.getDescription(), options.getPrice(), "");
            }
        }
    }   

    public String toString(){
        return "VehicleSerailNumber: " + vehicleSerialNumber + " | Name: " + name + " | Model: " + model + 
        " | Year: " + year + " | Manufacturer: " + manufacturer + " | Base Cost: " + baseCost;
    }
}
