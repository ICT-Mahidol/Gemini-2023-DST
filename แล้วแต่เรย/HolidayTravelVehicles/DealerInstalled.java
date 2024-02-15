public class DealerInstalled {
    private string OptionCode;
    private string Description;
    private float Price;

    public DealerInstalled(string OptionCode, string Description, float Price) {
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