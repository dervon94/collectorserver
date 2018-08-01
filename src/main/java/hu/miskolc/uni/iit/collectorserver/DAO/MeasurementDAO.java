package hu.miskolc.uni.iit.collectorserver.DAO;

import hu.miskolc.uni.iit.model.MeasuringDevice;

import java.util.List;

public interface MeasurementDAO {
    void storeAll(MeasuringDevice measuringDevice);

    List<MeasuringDevice> listAll();

}
