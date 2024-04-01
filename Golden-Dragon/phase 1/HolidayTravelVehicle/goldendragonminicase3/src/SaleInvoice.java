
public class SaleInvoice  {
    private String customerInfo;
    private String tradeInVehicle;
    private int tradeInAllowance;
    private int vehicleFee;
    private int finalCost;

    public SaleInvoice(String customerInfo, String tradeInVehicle, int tradeInAllowance, int vehicleFee, int finalCost) {
        this.customerInfo = customerInfo;
        this.tradeInVehicle = tradeInVehicle;
        this.tradeInAllowance = tradeInAllowance;
        this.vehicleFee = vehicleFee;
        this.finalCost = finalCost;
    }

    // Getter and setter methods

    @Override
    public String toString() {
        return "Customer Info: " + customerInfo + "\n" +
               "Trade-In Vehicle: " + tradeInVehicle + "\n" +
               "Trade-In Allowance: " + tradeInAllowance + "\n" +
               "Vehicle Fee: " + vehicleFee + "\n" +
               "Final Cost: " + finalCost;
    }

    public static void main(String[] args) {
        SaleInvoice invoice = new SaleInvoice("John Doe", "Toyota Camry", 5000, 25000, 20000);
        System.out.println(invoice);
    }
}
