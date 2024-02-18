import java.util.ArrayList;
import java.util.List;

public class SalesInvoice {
    private int invoiceID;
    private Salesperson salesperson;
    private Vehicle vehicle;
    private Customer customer;
    private TradeInVehicle tradeInVehicle;
    private List<DealerInstalledOption> dealerInstalledOptions;
    private double negotiatedPrice;
    private double tax;
    private double registrationCost;

    public SalesInvoice() {
        this.dealerInstalledOptions = new ArrayList<>();
    }

    public void addDealerInstalledOption(DealerInstalledOption option) {
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
}