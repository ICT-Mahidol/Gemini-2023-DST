public class Main {
    public static void main (String args[]){
        
        System.out.println("\nCustomer Information------------------");
        Customer aCustomer = new Customer("001","Mrs. Robbinson Hobter",
        "999 Phutthamonthon Sai 4 Rd, Salaya, Phutthamonthon District, Nakhon Pathom 73170", "0899999999");
        aCustomer.addTradeInVehicle(new TradeInVehicle("601SEW","Big","AX01",2000,0));
        aCustomer.addTradeInVehicle(new TradeInVehicle("7731X","Nissan","ZX6Y",2000,15000));
        System.out.println(aCustomer.toString());
        aCustomer.showTradeInlist();

        System.out.println("\nEmployee Information------------------");
        Employee  anEmployee = new Employee("01","Miss. Alice Berman","0245789136");
        System.out.println(anEmployee.toString());

        System.out.println("\nVehicle Information------------------");
        Vehicle vehicles  = new Vehicle("A01","Austin","X1",2000,"toyota",1000000);
        System.out.println(vehicles.toString());

        vehicles.addInstalledOptions(new DealerInstalledOptions("Add door", "10001" , 40000));
        vehicles.addInstalledOptions(new DealerInstalledOptions("Filmed", "10002" , 40000));
        vehicles.showInstalledOptions();

        System.out.println("\n\n");
        SalesInvoice.printInvoice(aCustomer,anEmployee,vehicles);
    }
}
