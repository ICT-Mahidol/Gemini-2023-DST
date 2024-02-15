public class Vehicle {
   private int serialNumber;
   private String model;
   private int year;
   private String name;
   public String manufacturer;
   public int baseCost;

   // Constructor
   public Vehicle(int serialNumber, String model, int year, String name, String manufacturer, int baseCost) {
       this.serialNumber = serialNumber;
       this.model = model;
       this.year = year;
       this.name = name;
       this.manufacturer = manufacturer;
       this.baseCost = baseCost;
   }

   // Getters and setters
   public int getSerialNumber() {
       return serialNumber;
   }
   public void setSerialNumber(int serialNumber) {
       this.serialNumber = serialNumber;
   }
   public String getModel() {
       return model;
   }
   public void setModel(String model) {
       this.model = model;
   }
   public int getYear() {
       return year;
   }
   public void setYear(int year) {
       this.year = year;
   }
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public String getManufacturer() {
       return manufacturer;
   }
   public void setManufacturer(String manufacturer) {
       this.manufacturer = manufacturer;
   }
   public int getBaseCost() {
       return baseCost;
   }
   public void setBaseCost(int baseCost) {
       this.baseCost = baseCost;
   }
}

