public class DealerInstalledOptions {
    private String description;
    private String optionCode;
    private double price;

    public DealerInstalledOptions(){}

    public DealerInstalledOptions(String description, String optionCode, double price) {
        this.description = description;
        this.optionCode = optionCode;
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(String optionCode) {
        this.optionCode = optionCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDealerInstalledOptions(String description, String optionCode, double price){
        this.description = description;
        this.optionCode = optionCode;
        this.price = price;
    }

    public String toString(){
        return "Description: " + description + " | Option Code: " + optionCode + " | Price: " + price;
    }

    
}

