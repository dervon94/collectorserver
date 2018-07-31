package hu.miskolc.uni.iit.collectorserver.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "SensorValues")
public class SensorValues {
    @Id
    @GeneratedValue
    private int id;
    private Calendar measuringTime = null;
    private int rain;
    private int temperature;
    private int humidity;
    private int light;
    @ManyToOne
    private MeasuringDevice device;

    public SensorValues() {
    }


    public SensorValues(final MeasuringDevice measuringDev, final int rain, final int temperature, final int humidity, final int light) {
        this.device = measuringDev;
        this.measuringTime = Calendar.getInstance();
        this.rain = rain;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
    }

    @Override
    public String toString() {
        return "SenvalModel{" +
                "id=" + this.id +
                ", measuringTime=" + this.measuringTime.getTime() +
                ", rain=" + this.rain +
                ", temperature=" + this.temperature +
                ", humidity=" + this.humidity +
                ", light=" + this.light +
                '}';
    }
}
