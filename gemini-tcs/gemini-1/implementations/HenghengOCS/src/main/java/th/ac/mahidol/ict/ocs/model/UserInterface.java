package th.ac.mahidol.ict.ocs.model;

public interface UserInterface {
    User createUser(String username, String password, String email);

    Object createUser(String username, String password, String email, String usercode, String name);
}
