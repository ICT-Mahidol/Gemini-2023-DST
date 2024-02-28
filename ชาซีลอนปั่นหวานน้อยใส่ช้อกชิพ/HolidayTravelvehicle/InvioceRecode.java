import java.util.ArrayList;

public class InvioceRecode {
    private String invoice_id;
    private String vehicle_serial_no;
    private int price;
    private ArrayList<SalesPerson> persons; //listข้อมูลของ sale_person

    public InvioceRecode(String invoice_id, String vehicle_serial_no, int price) {
        this.invoice_id = invoice_id;
        this.vehicle_serial_no = vehicle_serial_no;
        this.price = price;
        this.persons = new ArrayList<>();
    }

    // Constructor
    public String getInvoiceId() {
        return invoice_id;
    }

    public void setInvoiceId(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getVehicleSerialNo() {
        return vehicle_serial_no;
    }

    public void setVehicleSerialNo(String vehicle_serial_no) {
        this.vehicle_serial_no = vehicle_serial_no;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<SalesPerson> getPersons() {
        return this.persons;
    }

    public void addSalePerson(SalesPerson person) {
        this.persons.add(person);
    }

    // Additional methods
    public double calculateVAT() {
        // คำนวณภาษีมูลค่าเพิ่ม (VAT) จากราคา
        double vatRate = 0.07; // อัตราภาษีมูลค่าเพิ่ม 7%
        return price * vatRate;
    }

    public void printInvioceRecodeDetails() {
        System.out.println("Invoice ID: " + invoice_id);
        //System.out.println("Employee ID: " + person.getId());
        System.out.println("Vehicle Serial Number: " + vehicle_serial_no);
        System.out.println("Price: " + price);

        // for (SalesPerson person : persons) {
        //     System.out.println("Employee ID: " + person.getId());
        //     System.out.println("Invoice ID: " + invoice_id);
        //     System.out.println("Vehicle Serial Number: " + vehicle_serial_no);
        //     System.out.println("Price: " + price);
        // }

    }
    /// end Additional methods
}
