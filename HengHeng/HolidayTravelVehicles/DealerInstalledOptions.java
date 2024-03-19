import java.util.ArrayList;
import java.util.List;

public class DealerInstalledOptions {
    private String optionCode;
    private String description;
    private double price;
    private List<SalesInvoice> salesInvoices;
    private Customer customer;

    public DealerInstalledOptions(String optionCode, String description, double price) {
        this.optionCode = optionCode;
        this.description = description;
        this.price = price;
        this.salesInvoices = new ArrayList<>();
    }

    public String getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(String optionCode) {
        this.optionCode = optionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<SalesInvoice> getSalesInvoices() {
        return salesInvoices;
    }

    public void addSalesInvoice(SalesInvoice invoice) {
        salesInvoices.add(invoice);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Option Code: " + optionCode +
               "\nDescription: " + description +
               "\nPrice: $" + price;
    }
}
