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
