package th.ac.mahidol.ict.ocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import th.ac.mahidol.ict.ocs.model.Astronomer;
import th.ac.mahidol.ict.ocs.model.SciObserver;
import th.ac.mahidol.ict.ocs.model.UserInterface;
import th.ac.mahidol.ict.ocs.respository.Astronomerrepository;

import th.ac.mahidol.ict.ocs.respository.ScienceObserverRepository;
import th.ac.mahidol.ict.ocs.respository.UserRepository;


@SpringBootApplication
public class HengHengOcsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HengHengOcsApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        Astronomerrepository astronomerRepository = context.getBean(Astronomerrepository.class);
        ScienceObserverRepository sciObserverRepository = context.getBean(ScienceObserverRepository.class);


        // Get the UserInterface bean from the context
        UserInterface userInterface = context.getBean(UserInterface.class);

        //After RunApplication in the Firsttime please comment this code
        //In Line 31-63
//      // Create and save three Astronomer users
        for (int i = 1; i <= 10; i++) {
            String username = "astronomer" + i;
            String password = "password" + i;
            String email = "astronomer" + i + "@example.com";
            String usercode = "ASTR" + String.format("%02d", i); // Assuming usercode follows this format
            String name = "Astronomer " + i;

            // Call the createUser method to create Astronomer instances
            Astronomer astronomer = (Astronomer) userInterface.createUser(username, password, email, usercode, name);

            // Save the Astronomer instance to the database
            astronomerRepository.save(astronomer);

//            // Save the Astronomer instance to the database
            userRepository.save(astronomer);
        }

        for (int i = 1; i <= 10; i++) {
//            // Similar process for creating and saving SciObserver users
            String sciObserverUsername = "sciobserver" + i;
            String sciObserverPassword = "password" + i;
            String sciObserverEmail = "sciobserver" + i + "@example.com";
            String sciObserverUsercode = "SCIOBS" + String.format("%02d", i); // Assuming usercode follows this format
            String sciObserverName = "Science Observer " + i;

            // Call the createUser method to create SciObserver instances
            SciObserver sciObserver = (SciObserver) userInterface.createUser(sciObserverUsername, sciObserverPassword, sciObserverEmail, sciObserverUsercode, sciObserverName);

            // Save the SciObserver instance to the
           sciObserverRepository.save(sciObserver);

            userRepository.save(sciObserver);
       }
    }
}