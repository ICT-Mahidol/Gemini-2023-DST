public class CustomerID {
    private int customerID;
    public String name;
    public String address;
    public int phoneNumber;
    private SaleInvoice saleinvoice;

    public CustomerID(int newCustomerID, String newName, String newAddress, int newPhonenumber) {
        this.customerID = newCustomerID;
        this.name = newName;
        this.address = newAddress;
        this.phoneNumber = newPhonenumber;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPhonenumber() {
        return this.phoneNumber;
    }
}
