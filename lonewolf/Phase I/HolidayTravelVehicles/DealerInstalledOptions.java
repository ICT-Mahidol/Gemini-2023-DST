public class DealerInstalledOptions {
    private int option_code;
    private String description;
    private int price;

    public DealerInstalledOptions(int option_code, String description, int price) {
        this.option_code = option_code;
        this.description = description;
        this.price = price;
    }

    // Getter methods
    public int getOptionCode() {
        return option_code;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
