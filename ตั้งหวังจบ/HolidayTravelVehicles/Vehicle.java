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

public class Main {
   public static void main(String[] args) {

       // สร้างอ็อบเจกต์ของคลาส Vehicle
       Vehicle car = new Vehicle(123456, "Toyota Camry", 2022, "Camry", "Toyota", 25000);

       // แสดงข้อมูลของรถ
       System.out.println("Serial Number: " + car.getSerialNumber());
       System.out.println("Model: " + car.getModel());
       System.out.println("Year: " + car.getYear());
       System.out.println("Name: " + car.getName());
       System.out.println("Manufacturer: " + car.getManufacturer());
       System.out.println("Base Cost: $" + car.getBaseCost());

       // อัพเดทข้อมูลรถ
       car.setModel("Toyota Corolla");
       car.setBaseCost(20000);
       
       // แสดงข้อมูลหลังอัพเดท
       System.out.println("\nAfter Update:");
       System.out.println("Model: " + car.getModel());
       System.out.println("Base Cost: $" + car.getBaseCost());
   }
}