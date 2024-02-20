public class SaleInvoice{
    private String customerinfo;
    private String tradeinvehicle;
    private String tradeinallowance;
    public String vehicledetail;
    private String dealerinstalled;
    public int finalprice;
    public int tax;
    public int registrationfee;

    public SaleInvoice(String a, String b, String c, String d, String e, int aa, int bb, int cc) {
        this.customerinfo = a;
        this.tradeinvehicle = b;
        this.tradeinallowance = c;
        this.vehicledetail = d;
        this.dealerinstalled = e;
        this.finalprice = aa;
        this.tax = bb;
        this.registrationfee = cc;
    }
}

public static void main(String[] arg){
    SaleInvoice invoice = new SaleInvoice("customerinfo","tradeinvehicle","tradeinallowance","vehicledetail","dealerinstalled",1,2,3);
    System.out.println("Customer Info : " + invoice.customerinfo);
    System.out.println("Tradeinvehicle : " + invoice.tradeinvehicle);
    System.out.println("Tradeinallowance : " + invoice.tradeinvehicle);
    System.out.println("VehicleDetail : " + invoice.vehicledetail);
    System.out.println("DealerIntalled : " + invoice.dealerinstalled);
    System.out.println("FinalPrice : " + invoice.finalprice);
    System.out.println("Tax : " + invoice.tax);
    System.out.println("RegistrationFee: " + invoice.registrationfee);
}
