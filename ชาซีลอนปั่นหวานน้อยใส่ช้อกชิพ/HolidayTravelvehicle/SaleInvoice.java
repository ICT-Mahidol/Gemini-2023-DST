public class SaleInvoice{
    private String invoiceID;

    public SaleInvoice(String id) {
        this.invoiceID = id;
    }

    public void printInfo() {
        System.out.println("Invoice Number: " + this.invoiceID);
    }

}




