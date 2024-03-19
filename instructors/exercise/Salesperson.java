import java.util.ArrayList;

public class Salesperson extends Person {
    private int salespersonID;
    private double salary;
    private String position;
    private ArrayList<Vehicle> vehicles;

    public Salesperson() {
    }

    public Salesperson(String name, String address, String phone, int salespersonID, double salary, String position) {
        super();
        this.salespersonID = salespersonID;
        this.salary = salary;
        this.position = position;
    }

    public int getSalespersonID() {
        return salespersonID;
    }
    
    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public void setSalespersonID(int salespersonID) {
        this.salespersonID = salespersonID;
    }  

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
