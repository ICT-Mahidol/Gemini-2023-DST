public class SaleInvoice{
    private String invoiceID;

    public SaleInvoice(String invoiceID) {
        this.invoice = invoiceID;
    }

    public void printInfo() {
        System.out.println("Invoice Number: " + this.invoice);
    }

}

// class main {
//     public static void main(String[] args) {
//         SaleInvoice invoice1 = new SaleInvoice("5555");
//         invoice1.printInfo();
//     }
// }



