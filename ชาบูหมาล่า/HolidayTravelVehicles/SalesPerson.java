public class SalesPerson {
    private int employeeID;
    private String firstName; 
    private String lastName; 

    //Constructor
    public SalesPerson (int employeeID, String firstName, String lastName) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Get method
    public int getEmployeeID() {
        return employeeID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    //Set method
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}