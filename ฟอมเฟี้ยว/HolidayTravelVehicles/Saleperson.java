import java.util.ArrayList;

public class Saleperson {

    public int salePersonID ;
    public String namesalePerson ;
    public int phoneNumber ;
    private Saleinvoice saleinvoice ;

public Saleperson(int salePersonID, String namesalePerson, int phoneNumber) {
    
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