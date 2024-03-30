public class Person {

    public String Name;
    public String Address;
    public String Phonenumber;

    public Person(String Name, String Address, String Phonenumber) {
        this.Name = Name;
        this.Address = Address;
        this.Phonenumber = Phonenumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String toString() {
        return "Person [Name=" + Name + ", Address=" + Address + ", Phonenumber=" + Phonenumber + "]";
    }
    // public static void main(String[] args) throws Exception {
    //     Person somchai = new Person("somchai" ,"salaya" , "02-222-2222");
    //     System.out.println(somchai);
    // }
}

