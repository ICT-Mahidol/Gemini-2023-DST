import java.util.Scanner;
public class Main {
    public static void main (String args[]){
        
        System.out.println("\nCustomer Information------------------");
        Customer aCustomer = new Customer("001","Mrs. Robbinson Hobter",
        "999 Phutthamonthon Sai 4 Rd, Salaya, Phutthamonthon District, Nakhon Pathom 73170", "0899999999");
        aCustomer.addTradeInVehicle(
            new TradeInVehicle("601SEW","Big","AX01",2000));
        System.out.println(aCustomer.toString());
        aCustomer.showTradeInlist();

        System.out.println("\nEmployee Information------------------");
        Employee  anEmployee = new Employee("01","Miss. Alice Berman","0245789136");
        System.out.println(anEmployee.toString());

        System.out.println("\nVehicle Information------------------");
        Vehicle vehicles  = new Vehicle("A01","Austin","X1",2000,"toyota",1000000);
        System.out.println(vehicles.toString());

        System.out.println("\nInstalled Options------------------");
        DealerInstalledOptions dealerInstalledOptions = new DealerInstalledOptions("Add door", "10001" , 40000);
        System.out.println(dealerInstalledOptions.toString());

        System.out.println("\n\n");
        SalesInvoice.printInvoice(aCustomer,anEmployee,vehicles,dealerInstalledOptions);
    }
}
