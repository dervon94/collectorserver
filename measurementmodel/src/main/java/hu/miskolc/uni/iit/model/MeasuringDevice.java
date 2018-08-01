package hu.miskolc.uni.iit.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MeasuringDevices")
public class MeasuringDevice {

    @OneToMany(cascade = CascadeType.MERGE
            , mappedBy = "device")
    private final Set<SensorValues> sensorValues = new HashSet<>();
    @Id
    private String deviceId;
    private String ipAddres;
    private String position;

    public MeasuringDevice() {

    }

    public MeasuringDevice(final String deviceId, final String ipAddres, final String position, final int rain, final int temperature, final int humidity, final int light) {
        this.deviceId = deviceId;
        this.ipAddres = ipAddres;
        this.position = position;
        this.sensorValues.add(new SensorValues(this, rain, temperature, humidity, light));
    }

    @Override
    public String toString() {
        return "MeasuringDevice{" +
                "deviceId='" + this.deviceId + '\'' +
                ", ipAddres='" + this.ipAddres + '\'' +
                ", position='" + this.position + '\'' +
                ", sensorValues=" + this.sensorValues +
                '}';
    }


}
