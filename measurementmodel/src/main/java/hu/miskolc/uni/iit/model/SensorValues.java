package hu.miskolc.uni.iit.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "SensorValues")
public class SensorValues {
    @ManyToOne
    private MeasuringDevice device;
    @Id
    @GeneratedValue
    private int id;
    private Calendar measuringTime = null;
    private boolean rain;
    private int temperature;
    private int humidity;
    private int light;

    public SensorValues() {
    }


    public SensorValues(final MeasuringDevice measuringDev, final boolean rain, final int temperature, final int humidity, final int light) {
        this.device = measuringDev;
        this.measuringTime = Calendar.getInstance();
        this.rain = rain;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
    }

    @Override
    public String toString() {
        return "Sensor Values{" +
                "id=" + this.id +
                ", measuringTime=" + this.measuringTime.getTime() +
                ", rain=" + this.rain +
                ", temperature=" + this.temperature +
                ", humidity=" + this.humidity +
                ", light=" + this.light +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Calendar getMeasuringTime() {
        return this.measuringTime;
    }

    public void setMeasuringTime(final Calendar measuringTime) {
        this.measuringTime = measuringTime;
    }

    public boolean isRain() {
        return this.rain;
    }

    public void setRain(final boolean rain) {
        this.rain = rain;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void setTemperature(final int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public void setHumidity(final int humidity) {
        this.humidity = humidity;
    }

    public int getLight() {
        return this.light;
    }

    public void setLight(final int light) {
        this.light = light;
    }

    public MeasuringDevice getDevice() {
        return this.device;
    }

    public void setDevice(final MeasuringDevice device) {
        this.device = device;
    }
}
