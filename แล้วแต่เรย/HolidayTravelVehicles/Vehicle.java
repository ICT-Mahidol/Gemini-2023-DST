public class Vehicle {
    public int SerialNumber;
    public String Name;
    public String Model;
    public int Year;
    public String Manufacturer;
    public int BaseCost;

    // constructor
    public Vehicle(int i, String string, String string2, int j, String string3, int k) {
        this.SerialNumber = i;
        this.Name = string;
        this.Model = string2;
        this.Year = j;
        this.Manufacturer=string3;
        this.BaseCost=k;
    }

    public int GetSerialNumber() {
        return this.SerialNumber;
    }

    public String GetName() {
        return this.Name;
    }

    public String GetModel() {
        return this.Model;
    }

    public int GetYear() {
        
        return this.Year;
    }
    public String GetManufacturer() {
        return this.Manufacturer;
    }
    public int GetBaseCost(){
        return this.BaseCost;
    }

    public String toString() {
        return SerialNumber+" "+Name+" "+Model+" "+Year+" "+Manufacturer+" "+BaseCost;
    }
     
}
