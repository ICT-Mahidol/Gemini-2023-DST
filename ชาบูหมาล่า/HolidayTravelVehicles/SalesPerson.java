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

    public static void main(String[] args){
        SalesPerson salesPerson = new SalesPerson(123, "John", "Doe");

        int employeeID = salesPerson.getEmployeeID(); // returns 123
        String firstname = salesPerson.getFirstName(); // returns "John"
        String lastname = salesPerson.getLastName(); // returns "Doe"

        System.out.println("Salesperson employee ID: " + employeeID);
        System.out.println("Salesperson name: " + firstname + " " + lastname);
    }

}