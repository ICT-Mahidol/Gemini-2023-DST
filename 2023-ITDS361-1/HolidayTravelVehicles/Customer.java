public class Customer {
    private int customerID;
    private String custormerName, address;
    private int phoneNumber;

    public Customer(){}

    public Customer(int customerID, String custormerName, String address, int phoneNumber){
        this.customerID = customerID;
        this.custormerName = custormerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerID(){
        return customerID;
    }

    public String getCustomerName(){
        return custormerName;
    }

    public String getAddress(){
        return address;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }

    public void setCustomerName(){
        this.custormerName = custormerName;
    }

    public void setAddress(){
        this.address = address;
    }

    public void setPhoneNumber(){
        this.phoneNumber = phoneNumber;
    }
}
