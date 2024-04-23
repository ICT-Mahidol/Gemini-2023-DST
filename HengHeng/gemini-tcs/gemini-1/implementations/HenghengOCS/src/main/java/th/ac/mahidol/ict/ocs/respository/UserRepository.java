package th.ac.mahidol.ict.ocs.respository;

import org.springframework.data.repository.CrudRepository;
import th.ac.mahidol.ict.ocs.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByUsercode(String usercode);
}
