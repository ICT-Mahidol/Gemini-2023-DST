import java.util.ArrayList;
public class Customer {
    private String customerID;
    private String custormerName, address;
    private String phoneNumber;
    private ArrayList<TradeInVehicle> tradeInList;

    public Customer(){
        this.tradeInList = new ArrayList<TradeInVehicle>();
    } 

    public Customer(String customerID, String custormerName, String address, String phoneNumber){
        this.customerID = customerID;
        this.custormerName = custormerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tradeInList = new ArrayList<TradeInVehicle>();
    }

    public String getCustomerID(){
        return customerID;
    }

    public String getCustomerName(){
        return custormerName;
    }

    public String getAddress(){
        return address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setCustomerID(String customerID){
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName){
        this.custormerName = customerName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setCustomerProfile(String customerID, String customerName, String address, String phoneNumber){
        this.customerID = customerID;
        this.custormerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void addTradeInVehicle(TradeInVehicle tradeIn){
        boolean dup = false;
        for(TradeInVehicle t: tradeInList){
            if(t.getSerialNumber() == tradeIn.getSerialNumber()){
                dup = true;
                break;
            }
        }if(dup) {
            System.out.println( tradeIn.getSerialNumber()+" already in the list");
        }else{tradeInList.add(tradeIn);}
    }

    public void showTradeInlist() {
        if(tradeInList.size()>0){
            System.out.println("Trade In Vehicle");
		for(int i = 0; i < tradeInList.size(); i++) {
			System.out.println("[" + i + "] " + tradeInList.get(i).toString());
		}
        }
	}

    public void showTradeInItems(){;
        String formatString = "%-" + (25) + "s%-20s%s\n";
        if(tradeInList.size() > 0){
            System.out.println("\nTrade In Vehicles");
            System.out.println("------------------");
            for(TradeInVehicle t: tradeInList){
                System.out.printf(formatString, t.getMake() + " "+t.getModel(),"", t.getTradeInAllowance());
            }
        }
        
    }
    public String toString(){
        return "Customer ID: " + customerID + " | Customer Name: " + custormerName + " | Address: " + address + " | Phone: " + phoneNumber;
    }
}
