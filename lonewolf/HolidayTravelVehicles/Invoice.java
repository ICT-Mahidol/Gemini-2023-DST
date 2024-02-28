public class Invoice {
    public static void main(String[] args) {
        // สร้าง object
        CarDetails myCar = new CarDetails(1234, "Toyota", "Corolla", 2022, "Ant", 699999);
        TradeInVihicle myTradeInVihicle = new TradeInVihicle(1234, "Toyota", "Corolla", 1022, 749000);
        Customer myCustomer = new Customer(1, "Naruebet Phonsin", "999 Salaya", "097-264-3855");
        DealerInstalledOptions myDealerInstalledOptions = new DealerInstalledOptions(111, "red color", 8999);
        // แสดงข้อมูลของ object บนหน้าจอ
        System.out.println("--------------------------------------");
        System.out.println("---Customer---");
        System.out.println("Customer ID: " + myCustomer.getID());
        System.out.println("Customer name: " + myCustomer.getName());
        System.out.println("Address: " + myCustomer.getAddress());
        System.out.println("Telephone: " + myCustomer.getTel());
        System.out.println("--------------------------------------");
        System.out.println("---Car---");
        System.out.println("Serial Number: " + myCar.getSerialNumber());
        System.out.println("Brand: " + myCar.getBrand());
        System.out.println("Model: " + myCar.getModel());
        System.out.println("Year: " + myCar.getYear());
        System.out.println("Price: " + myTradeInVihicle.getSellingPrice());
        System.out.println("--------------------------------------");
        System.out.println("---Option---");
        System.out.println("Option Code: " + myDealerInstalledOptions.getOptionCode());
        System.out.println("Description: " + myDealerInstalledOptions.getDescription());
        System.out.println("Price: " + myDealerInstalledOptions.getPrice());
        System.out.println("--------------------------------------");
        System.out.println("---Total---");
        System.out.println(
                "Total Price: " + ((myDealerInstalledOptions.getPrice()) + myTradeInVihicle.getSellingPrice()));
        System.out.println("--------------------------------------");
    }
}
