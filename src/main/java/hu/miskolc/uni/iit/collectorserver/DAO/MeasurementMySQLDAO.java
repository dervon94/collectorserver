package hu.miskolc.uni.iit.collectorserver.DAO;


import hu.miskolc.uni.iit.collectorserver.model.MeasuringDevice;
import hu.miskolc.uni.iit.collectorserver.model.repository.MeasuringRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MeasurementMySQLDAO implements MeasurementDAO {

    @Autowired
    MeasuringRepository measuringRepository;

    @Override
    public void storeAll(final MeasuringDevice devModel) {
        System.out.println(devModel);
        this.measuringRepository.save(devModel);
    }

    @Override

    public List<MeasuringDevice> listAll() {
        final List<MeasuringDevice> measuringDevices = (List<MeasuringDevice>) this.measuringRepository.findAll();
        return measuringDevices;
    }


}