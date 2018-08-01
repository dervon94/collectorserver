package hu.miskolc.uni.iit.collectorserver.service;

import hu.miskolc.uni.iit.collectorserver.DTO.MeasurementDTO;
import hu.miskolc.uni.iit.model.MeasuringDevice;

import java.util.List;

public interface CollectorService {
    void storeAll(MeasurementDTO measurement);

    List<MeasuringDevice> listAll();


}
