public class Customer extends Person {
    private int customerID;
    private int membershipLevel;

    public Customer() {
    }

    public Customer(String name, String address, String phone, int customerID, int membershipLevel) {
        super();
        this.customerID = customerID;
        this.membershipLevel = membershipLevel;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getMembershipLevel() {
        return membershipLevel;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setMembershipLevel(int membershipLevel) {
        this.membershipLevel = membershipLevel;
    }
}
