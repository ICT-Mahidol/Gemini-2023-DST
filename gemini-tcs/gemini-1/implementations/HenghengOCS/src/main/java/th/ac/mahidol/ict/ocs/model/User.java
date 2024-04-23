package th.ac.mahidol.ict.ocs.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users",indexes = {
        @Index(name = "idx_usercode", columnList = "usercode")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "usercode")
    private String usercode;

    public User() {
    }

    // Constructor with protected access to enforce creation via Factory Method
    protected User(String username, String password, String email, String role, String usercode) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.usercode = usercode;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = this.usercode;
    }

    // Factory method to create User instances
    public static User createUser(UserInterface factory, String username, String password, String email) {
        return factory.createUser(username, password, email);
    }
}
