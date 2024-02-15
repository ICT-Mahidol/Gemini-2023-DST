import java.util.ArrayList;
import java.util.List;

public class SalesInvoice {
    private int invoiceID;
    private Salesperson salesperson;
    private Vehicle vehicle; 
    private List<Customer> customers; 
    private TradeInVehicle tradeInVehicle;
    private List<DealerInstalledOptions> dealerInstalledOptions;
    private double negotiatedPrice;
    private double tax;
    private double registrationCost;

    public SalesInvoice() {
        this.customers = new ArrayList<>();
        this.dealerInstalledOptions = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addDealerInstalledOption(DealerInstalledOptions option) {
        this.dealerInstalledOptions.add(option);
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(Salesperson salesperson) {
        this.salesperson = salesperson;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public TradeInVehicle getTradeInVehicle() {
        return tradeInVehicle;
    }

    public void setTradeInVehicle(TradeInVehicle tradeInVehicle) {
        this.tradeInVehicle = tradeInVehicle;
    }

    public List<DealerInstalledOptions> getDealerInstalledOptions() {
        return dealerInstalledOptions;
    }

    public void setDealerInstalledOptions(List<DealerInstalledOptions> dealerInstalledOptions) {
        this.dealerInstalledOptions = dealerInstalledOptions;
    }

    public double getNegotiatedPrice() {
        return negotiatedPrice;
    }

    public void setNegotiatedPrice(double negotiatedPrice) {
        this.negotiatedPrice = negotiatedPrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getRegistrationCost() {
        return registrationCost;
    }

    public void setRegistrationCost(double registrationCost) {
        this.registrationCost = registrationCost;
    }
}
