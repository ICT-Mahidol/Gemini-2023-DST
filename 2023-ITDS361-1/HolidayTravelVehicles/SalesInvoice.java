public class SalesInvoice {
    public static void printInvoice(Customer customer, Employee employee, Vehicle vehicle) {
        System.out.println("================================================Customer Invoice================================================");
        System.out.println("Estcium Co. Ltd");
        System.out.println("Contact No. 1222114");
        System.out.println("Invoice No. EST22211252");
        System.out.println("Saler: " + employee.getEmployeeName());
        System.out.println("================================================================================================================");
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Phone: " + customer.getPhoneNumber());
        System.out.println();

        String formatString = "%-" + (25) + "s%-20s%s\n";
        System.out.printf(formatString, "Items", "Price/Unit", "Discount");
        System.out.println("------------------");
        vehicle.showVehicleItems();
        vehicle.showInstalledOptionsItems();
        customer.showTradeInItems();
        System.out.println("================================================================================================================");
        System.out.println();
    }
}
