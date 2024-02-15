public class Main {
    public static void main(String[] args) {
        // สร้าง Object ของคลาส Vehicle
        Vehicle SaleVehicle = new Vehicle("Toyota", "Corolla", 2018, "Toyota", 600000);
        // แสดงข้อมูลของ Object นี้บนหน้าจอ
        System.out.println("ข้อมูลของรถ:");
        System.out.println("ยี่ห้อ: " + SaleVehicle.getName());
        System.out.println("รุ่น: " + SaleVehicle.getModel());
        System.out.println("ปี: " + SaleVehicle.getYear());
        System.out.println("ปี: " + SaleVehicle.getmanufacturer());
        System.out.println("ปี: " + SaleVehicle.getbasecost());
    }
}