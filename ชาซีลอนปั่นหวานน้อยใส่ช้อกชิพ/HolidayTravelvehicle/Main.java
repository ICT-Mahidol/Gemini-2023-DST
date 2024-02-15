public class Main {

    public static void main(String[] args) {
        SaleInvoice invoice1 = new SaleInvoice("5555");
        invoice1.printInfo();

        Vehicles vehicle = new Vehicles(
            001,
            "Autosleeper Staton",
            "RV",
            2022,
            "Mercedes-Benz",
            250600
        ); 
        vehicle.printInfo();



        
    }

}