public class Saleinvoice {
    private Customer cT;
    private Saleperson sP;
    private Vehicle vC;
    private TradeinVehicle tV;
    private Options dO;

    // Constructor
    public Saleinvoice(Customer newcT, Saleperson newsP, Vehicle newvC, TradeinVehicle newtV, Options newdO) {
        this.cT = newcT;
        this.sP = newsP;
        this.vC = newvC;
        this.tV = newtV;
        this.dO = newdO;
    }

    public Customer getcT() {
        return this.cT;
    }
    public Saleperson getsP() {
        return this.sP;
    }
    public Vehicle getvC() {
        return this.vC;
    }
    public TradeinVehicle gettV(){
        return this.tV;
    }

    public Options getdO(){
        return this.dO;
    }
}