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

