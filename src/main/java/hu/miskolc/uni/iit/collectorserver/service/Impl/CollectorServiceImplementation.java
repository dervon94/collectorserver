package hu.miskolc.uni.iit.collectorserver.service.Impl;

import hu.miskolc.uni.iit.collectorserver.DAO.MeasurementDAO;
import hu.miskolc.uni.iit.collectorserver.DTO.MeasurementDTO;
import hu.miskolc.uni.iit.collectorserver.service.CollectorService;
import hu.miskolc.uni.iit.model.MeasuringDevice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CollectorServiceImplementation implements CollectorService {
    @Autowired
    private MeasurementDAO measurementDAO;


    @Override
    public void storeAll(final MeasurementDTO measurement) {


        this.measurementDAO.storeAll(new MeasuringDevice(measurement.getDeviceId(), measurement.getIpAddress(), measurement.getPosition(), !measurement.getSensorValues().isRain(), measurement.getSensorValues().getTemperature(), measurement.getSensorValues().getHumidity(), measurement.getSensorValues().getLight()));

    }

    @Override
    public List<MeasuringDevice> listAll() {
        return this.measurementDAO.listAll();
    }

}
