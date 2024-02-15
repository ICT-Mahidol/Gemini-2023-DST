public class DealerInstalled {
    private int optionCode;
    private String description;
    private String price;

    public DealerInstalled(int optionCode, String description, String price){
        this.optionCode = optionCode;
        this.description = description;
        this.price = price;
    }

    public int getOptionCode(){
        return optionCode;
    }

    public String getDescription(){
        return description;
    }

    public String getPrice(){
        return price;
    }

    public void printInfo() {
        System.out.println("Option Code: " + getOptionCode());
        System.out.println("Description: " + getDescription());
        System.out.println("Price: " + getPrice());
    }

}