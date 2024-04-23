public class Main {
    public static void main(String[] args) {
        Vehicle SaleVehicle = new Vehicle("FFF12554235413","Toyota", "Corolla", 2018, "Toyota", 600000);
        //System.out.println (SaleVehicle);
        System.out.println("ข้อมูลของรถ:");
        System.out.println("เลขรุ่น: "+ SaleVehicle.getSerialNumber());
        System.out.println("ยี่ห้อ: " + SaleVehicle.getName());
        System.out.println("รุ่น: " + SaleVehicle.getModel());
        System.out.println("ปี: " + SaleVehicle.getYear());
        System.out.println("ผู้ผลิต: " + SaleVehicle.getManufacturer());
        System.out.println("ราคาต้นทุน: " + SaleVehicle.getBaseCost());
    }
    
}