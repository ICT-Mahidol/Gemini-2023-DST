public class SalesInvoice {
    private float tradeinAllowance;

    public static void main(String[] args) {
        TradeInVehicle T1 = new TradeInVehicle();
        Customer C1 = new Customer();
        Employee  E1 = new Employee();
        Vehicle V1  = new Vehicle();
        DealerInstalledOptions D1 = new DealerInstalledOptions();


        T1.setTradeInVehicle("01","Big","A001",2000);
        C1.setCustomerProfile("001","Mrs. Robbinson Hobter","999 Phutthamonthon Sai 4 Rd, Salaya, Phutthamonthon District, Nakhon Pathom 73170", "0899999999");
        E1.setEmployeeProfile("01","Miss. Alice Berman","0245789136");
        V1.setVehicle("A01","Austin","X1",2000,"toyota",1000000);
        D1.setDealerInstalledOptions("Add door", "10001" , 40000);


        System.out.println("================================================Customer Invoice================================================");
        System.out.println("Estcium Co. Ltd");
        System.out.println("Contact No. 1222114");
        System.out.println("Invoice No. EST22211252");
        System.out.println("================================================================================================================");
        System.out.println("Customer: "+C1.getCustomerName());
        System.out.println("Address: "+C1.getAddress());
        System.out.println("Phone: "+C1.getPhoneNumber());
        System.out.println("\nTrade-In Vehicle \n------------------");
        System.out.println(T1.toString());
        System.out.println("\nItems\t\t\t\t\tPrice/Unit\t\tDiscount");
        System.out.println("------------------");
        System.out.print(V1.getManufacturer()+" "+V1.getName()+" "+V1.getModel());
        System.out.println("\t\t\t"+V1.getBaseCost());
        System.out.println();
        System.out.println("================================================================================================================");

        System.out.println(""+E1.getEmployeeName());
    }
}
