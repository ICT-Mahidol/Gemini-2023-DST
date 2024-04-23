import java.util.ArrayList;

public class SaleInvoice {
    private Customer customer;
    private SalePerson salePerson;
    private ArrayList<Customer> cus_list;

    // Constructor
    public SaleInvoice(Customer customer, SalePerson salePerson) {
        this.customer = customer;
        this.salePerson = salePerson;
        this.cus_list = new ArrayList<Customer>();
    }

    // Getter methods
    public Customer getCustomer() {
        return this.customer;
    }

    public SalePerson getSalePerson() {
        return this.salePerson;
    }

    public ArrayList<Customer> getCus() {
        return this.cus_list;
    }

    // Method to add customer authors
    public void addCus(Customer aCustomer) {
        this.cus_list.add(aCustomer);
    }
}


