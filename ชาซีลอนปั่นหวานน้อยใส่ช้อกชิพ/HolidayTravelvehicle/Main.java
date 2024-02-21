import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.err.println("========== Print Vehicle Object ==========");
        Vehicle vehicle = new Vehicle(
            001,
            "Autosleeper Staton",
            "RV",
            2022,
            "Mercedes-Benz",
            250600
        ); 
        vehicle.printInfo();
        System.err.println("================================================");

        System.err.println("========== Print TradeInVehicle Object ==========");
        TradeIn tradeIn1 = new TradeIn(
            001, 
            "RV", 
            "RV", 
            2022
            );
        tradeIn1.printInfo();
        System.err.println("================================================");

        System.err.println("========== Print DealerInstalled Object ==========");
        DealerInstalled dealerInstalled = new DealerInstalled(
            "120", 
            "New Wheel Cover", 
            32000
            );
        dealerInstalled.printInfo();
        System.err.println("================================================");


        System.err.println("========= Print SaleInvoice Object ==========");
        Customer customer = new Customer("12345", "test01", "123 Main St.", "555-1234");
        
        TradeIn tradeInVehicle = new TradeIn(999, null, null, 0);
        
        double tradeInAllowance = 1000.0;
        
        Vehicle vehicle1 = new Vehicle(999, "Car", "Red", 2020, null, 20000.0);

        DealerInstalled dealerInstalled1 = new DealerInstalled("Option Code 1", "Description 1", 500);
        List<DealerInstalled> dealerInstalledList = new ArrayList<>();
        dealerInstalledList.add(dealerInstalled1);
        
        String invoiceID = "ABC123";
        
        SalesPerson employee = new SalesPerson("555", "test01", 25, "087999999");
        
        SaleInvoice invoice1 = new SaleInvoice(customer, tradeInVehicle, tradeInAllowance, vehicle1, dealerInstalledList, invoiceID, employee);
        invoice1.printInfo();
        System.err.println("================================================");
    }


}
