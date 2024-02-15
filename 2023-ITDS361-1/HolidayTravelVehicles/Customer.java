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

    public void setCustomerName(String customerName){
        this.custormerName = customerName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setCutomerProfile(int customerID, String customerName, String address, int phoneNumber){
        this.customerID = customerID;
        this.custormerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return "Customer ID: " + customerID + "Customer Name: " + custormerName + "Address: " + address + "Phone: " + phoneNumber;
    }
}
