package th.ac.mahidol.ict.ocs.respository;

import org.springframework.data.repository.CrudRepository;
import th.ac.mahidol.ict.ocs.model.DataRequirement;
import th.ac.mahidol.ict.ocs.model.SciObserver;

public interface dataRequirementRepository extends CrudRepository<DataRequirement, Long> {

}
