import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> vehicles;
    private List<SalesInvoice> salesInvoices;
    private List<DealerInstalledOptions> dealerInstalledOptions;
    private TradeInVehicle tradeInVehicle;

    public Customer(int customerId, String name, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
        this.salesInvoices = new ArrayList<>();
        this.dealerInstalledOptions = new ArrayList<>();
        this.tradeInVehicle = null;
    }


    
    // Getters and Setters for customerId, name, address, phone...

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<SalesInvoice> getSalesInvoices() {
        return salesInvoices;
    }

    public void addSalesInvoice(SalesInvoice invoice) {
        salesInvoices.add(invoice);
    }

    public List<DealerInstalledOptions> getDealerInstalledOptions() {
        return dealerInstalledOptions;
    }

    public void addDealerInstalledOptions(DealerInstalledOptions options) {
        dealerInstalledOptions.add(options);
    }

    public TradeInVehicle getTradeInVehicle() {
        return tradeInVehicle;
    }

    public void setTradeInVehicle(TradeInVehicle tradeInVehicle) {
        this.tradeInVehicle = tradeInVehicle;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId +
               "\nName: " + name +
               "\nAddress: " + address +
               "\nPhone: " + phone +
               "\nVehicles: " + (vehicles.isEmpty() ? "None" : vehicles) +
               "\nSales Invoices: " + (salesInvoices.isEmpty() ? "None" : salesInvoices) +
               "\nDealer Installed Options: " + (dealerInstalledOptions.isEmpty() ? "None" : dealerInstalledOptions) +
               "\nTrade-In Vehicle: " + (tradeInVehicle != null ? tradeInVehicle : "None");
    }
}
