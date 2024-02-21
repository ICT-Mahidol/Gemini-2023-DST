import java.util.ArrayList;
import java.util.List;

public class Salesperson {
    private int salespersonId;
    private String name;
    private List<SalesInvoice> salesInvoices;

    // Constructor
    public Salesperson(int salespersonId, String name) {
        this.salespersonId = salespersonId;
        this.name = name;
        this.salesInvoices = new ArrayList<>();
    }

    // Getters and setters
    public int getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(int salespersonId) {
        this.salespersonId = salespersonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SalesInvoice> getSalesInvoices() {
        return salesInvoices;
    }

    public void addSalesInvoice(SalesInvoice invoice) {
        this.salesInvoices.add(invoice);
    }

    // toString method to represent Salesperson object as a String
    @Override
    public String toString() {
        return "Salesperson{" +
                "salespersonId=" + salespersonId +
                ", name='" + name + '\'' +
                ", salesInvoices=" + salesInvoices +
                '}';
    }
}
