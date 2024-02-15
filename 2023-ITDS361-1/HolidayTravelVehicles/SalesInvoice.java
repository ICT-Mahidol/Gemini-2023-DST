public class SalesInvoice {
    private float tradeinAllowance;

    // public float settradeinAllowance(){
    //     this.tradeinAllowance = DealerInstalledOptions.getPrice()+TradeInVehicle.getPrice();
    // }
    public static void main(String[] args) {
        TradeInVehicle T1 = new TradeInVehicle();
        Customer C1 = new Customer();
        Employee  E1 = new Employee();
        Vehicle V1  = new Vehicle();
        DealerInstalledOptions D1 = new DealerInstalledOptions();

        T1.setTradeInVehicle("01","Big","A001",2000);
        C1.setCustomerProfile("001","P'Krit","Mahidol", "0899999999");
        E1.setEmployeeProfile("01","Mind","0245789136");
        V1.setVehicle("A01","Austin","X1",2000,"toyota",1000000);
        D1.setDealerInstalledOptions("Add door", "10001" , 40000);

        System.out.println("Trade in Vehicle \n"+T1.toString());
        System.out.println();
        System.out.println("Customer \n"+C1.toString());
        System.out.println();
        System.out.println("Employee \n"+E1.toString());
        System.out.println();
        System.out.println("Vehicle \n"+V1.toString());
        System.out.println();
        System.out.println("Dealer Installed Options\n"+D1.toString());
    }
}
