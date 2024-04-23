package th.ac.mahidol.ict.ocs.respository;

import org.springframework.data.repository.CrudRepository;
import th.ac.mahidol.ict.ocs.model.SciPlan;

import java.util.Optional;

public interface SciencePlanRepository extends CrudRepository<SciPlan, Long> {
    Optional<SciPlan> findById(Long intExact);
}







