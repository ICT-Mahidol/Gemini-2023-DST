package th.ac.mahidol.ict.ocs.model;

import org.springframework.stereotype.Component;

@Component
public class userInterfaceImpl implements UserInterface {

    @Override
    public User createUser(String username, String password, String email) {
        // Implement logic to create a User instance
        // Assuming the User constructor is public or package-private
        return new User(username, password, email, null, null);
    }

    @Override
    public Object createUser(String username, String password, String email, String usercode, String name) {
        // Implement logic to create a specific type of User instance (e.g., Astronomer or SciObserver)
        // Here, you can determine the type of user based on some condition, such as usercode or name,
        // and create the corresponding object
        if (usercode != null && usercode.startsWith("ASTR")) {
            // Create and return an Astronomer instance
            return new Astronomer(username, password, email, "Astronomer", usercode, name);
        } else if (usercode != null && usercode.startsWith("SCIOBS")) {
            // Create and return a SciObserver instance
            return new SciObserver(username, password, email, "Science Observer", usercode, name);
        } else {
            // Handle other cases if needed
            return null;
        }
    }
}
