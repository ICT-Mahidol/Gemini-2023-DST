public class SalesInvoice {
    public static void printInvoice(Customer customer, Employee employee, Vehicle vehicle, DealerInstalledOptions dealerInstalledOptions) {
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
        System.out.println("Items\t\t\t\tPrice/Unit\t\tDiscount");
        System.out.println("------------------");
        System.out.print(vehicle.getManufacturer() + " " + vehicle.getName() + " " + vehicle.getModel());
        System.out.println("\t\t\t" + vehicle.getBaseCost());
        if (dealerInstalledOptions != null) {
            System.out.println(dealerInstalledOptions.getDescription() + "\t\t\t" + dealerInstalledOptions.getPrice());
        } else {
            System.out.println("Installed Options: N/A");
        }
        System.out.println();
        System.out.println("================================================================================================================");  
    }
}
