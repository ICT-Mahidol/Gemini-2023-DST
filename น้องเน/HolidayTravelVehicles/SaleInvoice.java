import javax.swing.text.html.Option;

public class SaleInvoice {
    private CustomerID cus;
    private SalePerson sap;
    private Vehicles vhc;
    private TradeInVehicle tiv;
    private Option opt;

    // Constructor
    public SaleInvoice(CustomerID newcus, SalePerson newsap, Vehicles newvhc, TradeInVehicle newtiv, Option newopt) {
        this.cus = newcus;
        this.sap = newsap;
        this.vhc = newvhc;
        this.tiv = newtiv;
        this.opt = newopt;
    }

    public CustomerID getcus() {
        return this.cus;
    }
    public SalePerson getsap() {
        return this.sap;
    }
    public Vehicles getvhc() {
        return this.vhc;
    }
    public TradeInVehicle gettiv(){
        return this.tiv;
    }

    public Option getopt(){
        return this.opt;
    }
}
