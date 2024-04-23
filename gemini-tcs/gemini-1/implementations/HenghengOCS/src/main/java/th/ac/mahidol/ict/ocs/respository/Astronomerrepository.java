package th.ac.mahidol.ict.ocs.respository;
import th.ac.mahidol.ict.ocs.model.Astronomer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface Astronomerrepository extends  CrudRepository <Astronomer, Long>{

    Optional<Object> findByUsercode(String astronomerCode);
}



