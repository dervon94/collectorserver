package hu.miskolc.uni.iit.collectorserver.repository;


import hu.miskolc.uni.iit.model.MeasuringDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasuringCollectRepository extends CrudRepository<MeasuringDevice, Integer> {

}
