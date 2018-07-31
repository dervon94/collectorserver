package hu.miskolc.uni.iit.collectorserver.model.repository;

import hu.miskolc.uni.iit.collectorserver.model.MeasuringDevice;
import org.springframework.data.repository.CrudRepository;

public interface MeasuringRepository extends CrudRepository<MeasuringDevice, Integer> {

}
