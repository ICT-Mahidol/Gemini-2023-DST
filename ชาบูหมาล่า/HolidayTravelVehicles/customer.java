public class customer {
    private String customerid;
    private String name;
    private String address;
    private String phone;

    public customer(String customerid, String name, String address, String phone) {
        this.customerid = customerid;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getcustomerid() {
        return customerid;
    }

    public String getname() {
        return name;
    }

    public String getaddress() {
        return address;
    }

    public String getphone() {
        return phone;
    }

    public static void main(String[] args) {
        customer mycustomer = new customer("001", "por", "mahidol", "0123456789");
        System.out.println("ID : " + mycustomer.getcustomerid());
        System.out.println("name : " + mycustomer.getname());
        System.out.println("address : " + mycustomer.getaddress());
        System.out.println("phone : " + mycustomer.getphone());

    }
}
