package th.ac.mahidol.ict.ocs.model;

import jakarta.persistence.*;

@Entity
public class SciObserver extends User{

    @Column(name = "name")
    private String name;

    // Constructor with protected access to enforce creation via Factory Method
    protected SciObserver(String username, String password, String email,String role, String usercode,String name) {
        super(username,password,email,role,usercode);
        this.name = name;
    }

    public SciObserver() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Factory method to create SciObserver instances
    public static SciObserver createSciUser(UserInterface factory, String username, String password, String email) {
        // Assigning role and usercode for SciObserver
        String role = "science observer";
        String usercode = generateUserCode(); // You can implement this method to generate a unique usercode
        return (SciObserver) factory.createUser(username, password, email, role, usercode);
    }

    private static int lastGeneratedId = 0;
    // Method to generate a unique usercode
    private static String generateUserCode() {
        // Increment the lastGeneratedId for the next usercode

        lastGeneratedId++;

        // Create a usercode prefix
        String prefix = "SCIOBS";

        // Format the numerical part with leading zeros if necessary
        String numericalPart = String.format("%02d", lastGeneratedId);

        // Concatenate the prefix and numerical part
        String usercode = prefix + numericalPart;

        return usercode;
    }

}
