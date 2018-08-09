package hu.miskolc.uni.iit.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MeasuringDevices")
public class MeasuringDevice {

    @OneToMany(cascade = CascadeType.MERGE
            , mappedBy = "device")
    final Set<SensorValues> sensorValues = new HashSet<>();
    @Id
    public String deviceId;
    public String position;
    private String ipAddress;

    public MeasuringDevice() {

    }

    public MeasuringDevice(final String deviceId, final String ipAddress, final String position, final boolean rain, final int temperature, final int humidity, final int light) {
        this.deviceId = deviceId;
        this.ipAddress = ipAddress;
        this.position = position;
        this.sensorValues.add(new SensorValues(this, rain, temperature, humidity, light));
    }

    @Override
    public String toString() {
        return "MeasuringDevice{" +
                "deviceId='" + this.deviceId + '\'' +
                ", ipAddress='" + this.ipAddress + '\'' +
                ", position='" + this.position + '\'' +
                ", sensorValues=" + this.sensorValues +
                '}';
    }

    public Set<SensorValues> getSensorValues() {
        return this.sensorValues;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(final String position) {
        this.position = position;
    }

}
