public class Saleinvoice {
    private Customer cT;
    private Saleperson sP;
    private Vehicle vC;
    private TradeInVehicle tV;
    private Options dO;

    // Constructor
    public Saleinvoice(Customer newcT, Saleperson newsP, Vehicle newvC, TradeInVehicle newtV, Options newdO) {
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
    public TradeInVehicle gettV(){
        return this.tV;
    }

    public Options getdO(){
        return this.dO;
    }
}