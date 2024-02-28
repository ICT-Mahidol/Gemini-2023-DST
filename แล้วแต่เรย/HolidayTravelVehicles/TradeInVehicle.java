public class TradeInVehicle {
    public int SerialNumber;
    public String Make;
    public String Model;
    public int Year;

    // constructor
    public TradeInVehicle() {
        this.SerialNumber = SerialNumber;
        this.Make = Make;
        this.Model = Model;
        this.Year = Year;
    }

    public int GetSerialNumber() {
        return this.SerialNumber;
    }

    public String GetMake() {
        return this.Make;
    }

    public String GetModel() {
        return this.Model;
    }

    public int GetYear() {
        return this.Year;
    }
}
