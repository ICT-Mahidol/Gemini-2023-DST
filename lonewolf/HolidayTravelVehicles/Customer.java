public class Customer {
    private int ID;
    private String name;
    private String address;
    private String tel;

    public Customer(int ID, String name, String address, String tel) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    // Getter methods
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }
}
