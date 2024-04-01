public class SalePerson {

    public int salePersonID ;
    public String namesalePerson ;
    public int phoneNumber ;
    private SaleInvoice saleInvoice ;

public SalePerson(int salePersonID, String namesalePerson, int phoneNumber) {
    
    this.salePersonID = salePersonID;
    this.namesalePerson = namesalePerson;
    this.phoneNumber = phoneNumber;
    }

    public int getsalePersonID() {
        return salePersonID;
    }

    public String getnamesalePerson() {
        return namesalePerson;
    }

    public int getphoneNumber() {
        return phoneNumber;
    }
}