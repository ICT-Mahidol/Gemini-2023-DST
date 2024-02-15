public class Main {

    public static void main(String[] args) {
        SaleInvoice invoice1 = new SaleInvoice("5555");
        invoice1.printInfo();

        Vehicle vehicle = new Vehicle(
            001,
            "Autosleeper Staton",
            "RV",
            2022,
            "Mercedes-Benz",
            250600
        ); 
        vehicle.printInfo();

        TradeIn tradeIn1 = new TradeIn(
            001, 
            "RV", 
            "RV", 
            2022
            );
        tradeIn1.printInfo();

        DealerInstalled dealerInstalled = new DealerInstalled(
            "120", 
            "New Wheel Cover", 
            32000
            );
        dealerInstalled.printInfo();

        Vehicle vehicle2 = new Vehicle(); 
        vehicle2.setBaseCost(5.55);
        vehicle2.printInfo();

    }


}