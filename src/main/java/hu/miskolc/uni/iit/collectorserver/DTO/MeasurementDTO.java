
package hu.miskolc.uni.iit.collectorserver.DTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MeasurementDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeasurementDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ip-address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sensorValues">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="rain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="temperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="humidity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="light" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasurementDTO", namespace = "http://uni-miskolc/iit/arduinosens", propOrder = {
    "deviceId",
    "ipAddress",
    "position",
    "sensorValues"
})
public class MeasurementDTO {

    @XmlElement(namespace = "http://uni-miskolc/iit/arduinosens", required = true)
    protected String deviceId;
    @XmlElement(name = "ip-address", namespace = "http://uni-miskolc/iit/arduinosens", required = true)
    protected String ipAddress;
    @XmlElement(namespace = "http://uni-miskolc/iit/arduinosens", required = true)
    protected String position;
    @XmlElement(namespace = "http://uni-miskolc/iit/arduinosens", required = true)
    protected MeasurementDTO.SensorValues sensorValues;

    /**
     * Gets the value of the deviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the value of the deviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceId(String value) {
        this.deviceId = value;
    }

    /**
     * Gets the value of the ipAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAddress(String value) {
        this.ipAddress = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * Gets the value of the sensorValues property.
     * 
     * @return
     *     possible object is
     *     {@link MeasurementDTO.SensorValues }
     *     
     */
    public MeasurementDTO.SensorValues getSensorValues() {
        return sensorValues;
    }

    /**
     * Sets the value of the sensorValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasurementDTO.SensorValues }
     *     
     */
    public void setSensorValues(MeasurementDTO.SensorValues value) {
        this.sensorValues = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="rain" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="temperature" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="humidity" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="light" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rain",
        "temperature",
        "humidity",
        "light"
    })
    public static class SensorValues {

        @XmlElement(namespace = "http://uni-miskolc/iit/arduinosens")
        protected int rain;
        @XmlElement(namespace = "http://uni-miskolc/iit/arduinosens")
        protected int temperature;
        @XmlElement(namespace = "http://uni-miskolc/iit/arduinosens")
        protected int humidity;
        @XmlElement(namespace = "http://uni-miskolc/iit/arduinosens")
        protected int light;

        /**
         * Gets the value of the rain property.
         * 
         */
        public int getRain() {
            return rain;
        }

        /**
         * Sets the value of the rain property.
         * 
         */
        public void setRain(int value) {
            this.rain = value;
        }

        /**
         * Gets the value of the temperature property.
         * 
         */
        public int getTemperature() {
            return temperature;
        }

        /**
         * Sets the value of the temperature property.
         * 
         */
        public void setTemperature(int value) {
            this.temperature = value;
        }

        /**
         * Gets the value of the humidity property.
         * 
         */
        public int getHumidity() {
            return humidity;
        }

        /**
         * Sets the value of the humidity property.
         * 
         */
        public void setHumidity(int value) {
            this.humidity = value;
        }

        /**
         * Gets the value of the light property.
         * 
         */
        public int getLight() {
            return light;
        }

        /**
         * Sets the value of the light property.
         * 
         */
        public void setLight(int value) {
            this.light = value;
        }

    }

}
