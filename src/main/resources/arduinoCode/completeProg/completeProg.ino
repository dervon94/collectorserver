
#include <UIPEthernet.h>
#include <SimpleDHT.h>
#include <Dns.h>

#define PGMprintln(x) println(F(x))
#define PGMprint(x) print(F(x))

const uint8_t mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };

const char dsthost[] = "192.168.2.3";
const char device[] = "arduinoSensor1";
const char position[] = "Lab106";
const uint16_t dstport = 8089;

EthernetClient client;
DNSClient DNSclient;
IPAddress dstip;;
SimpleDHT11 dht11;

byte temperature = 0;
byte humidity = 0;
byte rain=0;
int light=0;

  
void setup() {
  Serial.begin(9600);
  connecting();
}

void connecting(){

  Ethernet.begin(mac);

  Serial.println(Ethernet.localIP());
  DNSclient.begin(Ethernet.dnsServerIP());
  if (DNSclient.getHostByName(dsthost, dstip)) {
    Serial.println(dstip);
  } else {
    Serial.PGMprintln("Error");
  }
}
int readLight(int LDR_PIN){
  int   ldrRawData;
  float resistorVoltage, ldrVoltage;
  float ldrResistance;
  float ldrLux;
  
  
  // Perform the analog to digital conversion  
  ldrRawData = analogRead(LDR_PIN);
  
  // RESISTOR VOLTAGE_CONVERSION
  // Convert the raw digital data back to the voltage that was measured on the analog pin
  resistorVoltage = (float)ldrRawData / 1023 * 5.0;

  // voltage across the LDR is the 5V supply minus the 5k resistor voltage
  ldrVoltage = 5.0 - resistorVoltage;
  
  // LDR_RESISTANCE_CONVERSION
  // resistance that the LDR would have for that voltage  
  ldrResistance = ldrVoltage/resistorVoltage * 10030;
  
  // LDR_LUX
  // Change the code below to the proper conversion from ldrResistance to
  // ldrLux
  ldrLux = 12518931 * pow(ldrResistance, -1.405);
  return ldrLux;
}

void getSenVal(){
  dht11.read(5, &temperature, &humidity, NULL);
  rain= digitalRead(3);
  light= readLight(A3);

}

void sendHttpRequest(){

  if (client.connect(dstip, dstport)) {

    // Prepare the buffers
    char getbuf[96] = {0};
    char hostbuf[32] = {0};
    char typebuf[96] = {0};
    
    
    //char msgbuf[96] = {0};
    char msgLen[96] = {0};
    sprintf(getbuf, "POST /add HTTP/1.1");
    sprintf(hostbuf, "Host:%s:8089", dsthost);
    sprintf(typebuf,"Content-Type: application/json");
    sprintf(msgLen,"Content-Length: 200");
    // Send the data
    client.println(getbuf);
    client.println(hostbuf);
    client.println(typebuf); 
    client.println(msgLen);
    client.println();
    client.print("{");
    client.print("\"deviceId\":\"");
    client.print(device);
    client.print("\",\"ipAddress\":\"");
    client.print(Ethernet.localIP());
    client.print("\",\"position\":\"");
    client.print(position);
    client.print("\",\"sensorValues\":{");
    client.print("\"rain\":");
    client.print(rain);
    Serial.println(rain);
    client.print(",\"temperature\":");
    client.print(temperature);
    client.print(",\"humidity\":");
    client.print(humidity);
    client.print(",\"light\":");
    client.print(light);
    client.print("}}");

    // Disconnect
    client.stop();

    Serial.PGMprintln("sent");

  } else {
    Serial.PGMprintln("failed!");
  }
}
void loop() {
  getSenVal();
  sendHttpRequest();
  delay(1000);
}

