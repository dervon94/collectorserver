package hu.miskolc.uni.iit.collectorserver.DAO;


import hu.miskolc.uni.iit.collectorserver.repository.MeasuringCollectRepository;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MeasurementMySQLDAO implements MeasurementDAO {

    @Autowired
    MeasuringCollectRepository measuringCollectRepository;

    @Override
    public void storeAll(final MeasuringDevice devModel) {
        System.out.println(devModel);
        this.measuringCollectRepository.save(devModel);
    }

    @Override

    public List<MeasuringDevice> listAll() {
        return (List<MeasuringDevice>) this.measuringCollectRepository.findAll();

    }


}