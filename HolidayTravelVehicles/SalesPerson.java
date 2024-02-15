public class SalesPerson {
    private int ID;
    private String name;
    private String address;
    private String tel;
    private int sales_count;

    public SalesPerson(int ID, String name, String address, String tel, int sales_count) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.sales_count = sales_count;
    }

    // Getter methods
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public int getSalesCount() {
        return sales_count;
    }
}
