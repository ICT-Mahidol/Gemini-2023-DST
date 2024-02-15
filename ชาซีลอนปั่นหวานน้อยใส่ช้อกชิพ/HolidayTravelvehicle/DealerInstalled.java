public class DealerInstalled {
    private String optionCode;
    private String description;
    private int price;

    public DealerInstalled(String optionCode, String description, int price){
        this.optionCode = optionCode;
        this.description = description;
        this.price = price;
    }

    public String getOptionCode(){
        return optionCode;
    }

    public String getDescription(){
        return description;
    }

    public int getPrice(){
        return price;
    }

    public void printInfo() {
        System.out.println("Option Code: " + getOptionCode());
        System.out.println("Description: " + getDescription());
        System.out.println("Price: " + getPrice());
    }
}