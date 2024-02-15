public class SalesInvoice {
    // private float tradeinAllowance;

    // public float settradeinAllowance(){
    //     this.tradeinAllowance = DealerInstalledOptions.getPrice()+TradeInVehicle.getPrice();
    // }
    public static void main(String[] args) {
        TradeInVehicle T1 = new TradeInVehicle();
        Customer C1 = new Customer();
        Employee  E1 = new Employee();
        Vehicle V1  = new Vehicle();
        DealerInstalledOptions D1 = new DealerInstalledOptions("Add door", "10001" , 40000);
        T1.setTradeInVehicle("01","Big","A001",2000);
        C1.setCustomerProfile("001","P'Krit","Mahidol", "0899999999");
        E1.setEmployeeProfile("01","Mind","0245789136");
        V1.setVehicle("A01","Austin","X1",2000,"toyota",1000000);
        System.out.println(T1.toString());
        System.out.println(C1.toString());
        System.out.println(E1.toString());
        System.out.println(V1.toString());
        System.out.println(D1.toString());
    }
}
