

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

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getTradeInVehicle() {
        return tradeInVehicle;
    }

    public void setTradeInVehicle(String tradeInVehicle) {
        this.tradeInVehicle = tradeInVehicle;
    }

    public int getTradeInAllowance() {
        return tradeInAllowance;
    }

    public void setTradeInAllowance(int tradeInAllowance) {
        this.tradeInAllowance = tradeInAllowance;
    }

    public int getVehicleFee() {
        return vehicleFee;
    }

    public void setVehicleFee(int vehicleFee) {
        this.vehicleFee = vehicleFee;
    }

    public int getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(int finalCost) {
        this.finalCost = finalCost;
    }
}
