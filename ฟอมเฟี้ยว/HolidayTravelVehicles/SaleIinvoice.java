public class SaleInvoice {
    private saleDetail sD;
    private TradeinVehical tV;
    private TradeinAllowance tA;
    private DearlerinstalledOption dO;
    private SubmitToData sD;

    // Constructor
    public SaleInvoice(String saleDetail, String TradeinVehical, String TradeinAllowance, String DearlerinstalledOption, String SubmittoData) {
        this.saleDetail = saleDetail;
        this.TradeinVehical = TradeinVehical;
        this.TradeinAllowance = TradeinAllowance;
        this.DearlerinstalledOption = DearlerinstalledOption;
        this.SubmittoData = SubmittoData;
    }

    //CreatObject
    public static void main(String[] args) {
        SaleInvoice invoice = new SalePerson("saleDetail", "TradeinVehical", "TradeinAllowance", "DearlerinstalledOption", "SubmittoData" )

    }

    System.out.println("Sale Detail: " + invoice.saleDetail);
    System.out.println("Trade-in Vehical: " + invoice.TradeinVehical);
    System.out.println("Trade-in Allowance: " + invoice.TradeinAllowance);
    System.out.println("DearlerinstalledOption: " + invoice.DearlerinstalledOption);
    System.out.println("SubmittoData: " + invoice.SubmitToData);

}