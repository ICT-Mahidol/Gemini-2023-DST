public class Customer {
    private int customerID;

    public Customer(){}

    public Customer(int customerID, String custormerName, String address, int phoneNumber){
        this.customerID = customerID;
    }

    public int getCustomerID(){
        return customerID;
    }

    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }
}
