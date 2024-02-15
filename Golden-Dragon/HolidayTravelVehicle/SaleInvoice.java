package HolidayTravelVehicle;

public class SaleInvoice {
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
}
