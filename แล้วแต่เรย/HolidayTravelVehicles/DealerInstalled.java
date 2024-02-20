public class DealerInstalled {
    private String OptionCode;
    private String Description;
    private float Price;

    public DealerInstalled(String OptionCode, String Description, float Price) {
        this.OptionCode = OptionCode;
        this.Description = Description;
        this.Price = Price;
    }

    public String getOp() {
        return OptionCode;
    }
    public String getDes() {
        return Description;
    }
    public float getPrice() {
        return Price;
    }
}
