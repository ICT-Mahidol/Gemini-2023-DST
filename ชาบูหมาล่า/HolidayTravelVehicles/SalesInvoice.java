import java.util.ArrayList;
import java.util.List;

public class SalesInvoice {
    private int invoiceID;
    private SalesPerson salesperson;
    private Car vehicle;
    private customer Customer;
    private TradeInVehicle tradeInVehicle;
    private List<DealerInstalledOptions> dealerInstalledOptions;
    private double negotiatedPrice;
    private double tax;
    private double registrationCost;

    public SalesInvoice() {
        this.dealerInstalledOptions = new ArrayList<>();
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

    public SalesPerson getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(SalesPerson salesperson) {
        this.salesperson = salesperson;
    }

    public Car getVehicle() {
        return vehicle;
    }

    public void setTradeInVehicle(TradeInVehicle tradeInVehicle) {
        this.tradeInVehicle = tradeInVehicle;
    }
}
