public class Customer extends Person {

    private String customerId;

    public Customer(String name, String address, String phoneNumber, String customerId) {
        super(name, address, phoneNumber);
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer [Name=" + getName() + ", Address=" + getAddress() + ", Phonenumber=" + getPhonenumber() +
                ", CustomerId=" + customerId + "]";
    }

//     public static void main(String[] args) throws Exception {
//         Customer someCustomer = new Customer("John", "123 Main", "088-555-1234", "C12345");
//         System.out.println(someCustomer);
//     }
}
