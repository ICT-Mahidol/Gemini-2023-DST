public class SaleInvoice{
    private String invoiceID;

    public SaleInvoice(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void printInfo() {
        System.out.println("Invoice Number: " + this.invoiceID);
    }

}

// class main {
//     public static void main(String[] args) {
//         SaleInvoice invoice1 = new SaleInvoice("5555");
//         invoice1.printInfo();
//     }
// }



