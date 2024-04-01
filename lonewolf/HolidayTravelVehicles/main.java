public class main {
    public static void main(String[] args) {
        // สร้าง Vehicle object
        CarDetails myCar = new CarDetails(1234, "Toyota", "Corolla", 2022, "ant", 59999);

        // แสดงข้อมูลของ Vehicle object บนหน้าจอ
        System.out.println("Serial Number: " + myCar.getSerialNumber());
        System.out.println("Brand: " + myCar.getBrand());
        System.out.println("Model: " + myCar.getModel());
        System.out.println("Year: " + myCar.getYear());
        System.out.println("Manufacturer: " + myCar.getManufacturer());
        System.out.println("Base Cost: " + myCar.getBaseCost());
    }
}
