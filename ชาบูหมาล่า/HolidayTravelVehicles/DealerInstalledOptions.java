public class DealerInstalledOptions {
    public int optioncode;
    public String description;
    public int price;  
    
    
    public void printDealerInstalledOptions(int optioncode, String description, int price) {
        this.optioncode = optioncode;
        this.description = description;
        this.price = price;

        System.out.println("Option Code: " + optioncode);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        DealerInstalledOptions options = new DealerInstalledOptions();

        options.printDealerInstalledOptions(001, "LED Lighting", 180);
    }
};
