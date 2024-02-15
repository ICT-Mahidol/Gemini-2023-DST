import java.util.*;

public class Saleinvoice{
    private String customerinfo;
    private String tradeinvehicle;
    private String tradeinallowance;
    public String vehicledetail;
    private String dealerinstalled;
    public int finalprice;
    public int tax;
    public int registrationfee;
}

public Saleinvoice(customerinfo,tradeinvehicle,tradeinallowance,vehicledetail,dealerinstalled,finalprice,tax,registrationfee){
    this.customerinfo = customerinfo;
    this.tradeinvehicle = tradeinvehicle;
    this.tradeinallowance = tradeinallowance;
    this.vehicledetail = vehicledetail;
    this.dealerinstalled = dealerinstalled;
    this finalprice = finalprice;
    this.tax = tax;
    this.registrationfee = registrationfee;
}

public static void main(String[] arg){
    Saleinvoice invoice = new Saleinvoice("customerinfo","tradeinvehicle","tradeinallowance","vehicledetail","dealerinstalled","finalprice","tax","registrationfee")
}

System.out.println("Customer Info : " + invoice.customerinfo)
System.out.println("Tradeinvehicle : " + invoice.tradeinvehicle)
System.out.println("Tradeinallowance : " + invoice.tradeinvehicle)
System.out.println("VehicleDetail : " + invoice.vehicledetail)
System.out.println("DealerIntalled : " + invoice.dealerinstalled)
System.out.println("FinalPrice : " + invoice.finalprice)
System.out.println("Tax : " + invoice.tax)
System.out.println("RegistrationFee: " + invoice.registrationfee)