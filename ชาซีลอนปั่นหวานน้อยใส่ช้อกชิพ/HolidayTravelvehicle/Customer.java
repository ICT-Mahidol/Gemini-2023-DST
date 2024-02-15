public class Customer {
    private String customerID;
    public String name;
    private String address;
    private String phone_number;
    // private ArrayList<SaleInvoice> saleInvoices;

    // public ArrayList<SaleInvoice> getSaleInvoice(){
    //     return this.saleInvoices;
    // }
    // public Customer(String id,String name) {
    //     this.customerID = id;
    //     this.name = name;
    // }
    
    // public Customer(String id,String name,String address) {
    //     this.customerID = id;
    //     this.name = name;
    //     this.address = address;
    // }
    
    public Customer(String id,String name,String address,String phone_number) {
        this.customerID = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }
    public String getName() {
		return name;
	}
    public String getCustomerID() {
		return customerID;
	}
    public String getAddress() {
		return address;
	}
    public String getPhone(){
        return phone_number;
    }

    public void setName(String name) {
		this.name = name;
	}
    public void setCustomerID(String id ) {
		this.customerID = id;
	}
    public void setAddress(String address) {
		this.address = address;
	}
    public void setPhone(String phone){
        this.phone_number = phone;
    }

    public String toString(){
        return "ID: " + customerID + "Name: " + name + "Address: " + address + "Phone: " + phone_number;
    }
}