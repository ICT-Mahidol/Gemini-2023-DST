import java.util.List;

public class SaleInvoice {
    private Customer customer;
    private TradeIn tradeInVehicle;
    private double tradeInAllowance;
    private Vehicle vehicle;
    private List<DealerInstalled> dealerInstalled;
    private String invoiceID;
    private SalesPerson employee;

    public SaleInvoice(Customer customer, TradeIn tradeInVehicle, double tradeInAllowance, Vehicle vehicle, List<DealerInstalled> dealerInstalledOptions, String invoiceID, SalesPerson employee) {
        this.customer = customer;
        this.tradeInVehicle = tradeInVehicle;
        this.tradeInAllowance = tradeInAllowance;
        this.vehicle = vehicle;
        this.dealerInstalled = dealerInstalledOptions;
        this.invoiceID = invoiceID;
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TradeIn getTradeInVehicle() {
        return tradeInVehicle;
    }

    public void setTradeInVehicle(TradeIn tradeInVehicle) {
        this.tradeInVehicle = tradeInVehicle;
    }

    public double getTradeInAllowance() {
        return tradeInAllowance;
    }

    public void setTradeInAllowance(double tradeInAllowance) {
        this.tradeInAllowance = tradeInAllowance;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<DealerInstalled> getDealerInstalledOptions() {
        return dealerInstalled;
    }

    public void setDealerInstalledOptions(List<DealerInstalled> dealerInstalledOptions) {
        this.dealerInstalled = dealerInstalledOptions;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getEmployeeAge() {
        return employee.getAge();
    }

    public void setEmployee(SalesPerson employee) {
        this.employee = employee;
    }

    public void printInfo() {
        System.out.println("Customer:");
        System.out.println("\tID: " + customer.getCustomerID());
        System.out.println("\tName: " + customer.getName());
        System.out.println("\tAddress: " + customer.getAddress());
        System.out.println("\tPhone: " + customer.getPhone());

        System.out.println("Trade-In Vehicle:");
        System.out.println("\tID: " + tradeInVehicle.getSerialNumber());
        System.out.println("\tMake: " + tradeInVehicle.getMake());
        System.out.println("\tModel: " + tradeInVehicle.getModel());
        System.out.println("\tYear: " + tradeInVehicle.getYear());

        System.out.println("Trade-In Allowance: $" + tradeInAllowance);

        System.out.println("Vehicle Options:");
        System.out.println("\tID: " + vehicle.getSerialNumber());
        System.out.println("\tName: " + vehicle.getName());
        System.out.println("\tModel: " + vehicle.getModel());
        System.out.println("\tYear: " + vehicle.getYear());
        System.out.println("\tManufacturer: $" + vehicle.getManufacturer());
        System.out.println("\tCost: $" + vehicle.getBaseCost());

        System.out.println("Dealer Installed Options:");
        for (DealerInstalled option : dealerInstalled) {
            System.out.println("\tOption Code: " + option.getOptionCode());
            System.out.println("\tDescription: " + option.getDescription());
            System.out.println("\tPrice: $" + option.getPrice());
        }

        System.out.println("Invoice ID: " + invoiceID);
        
        System.out.println("Employee:");
        System.out.println("\tID: " + employee.getId());
        System.out.println("\tName: " + employee.getName());
        System.out.println("\tAge: " + employee.getAge());
        System.out.println("\tPhone Number: " + employee.getPhonenumber());
    }
}