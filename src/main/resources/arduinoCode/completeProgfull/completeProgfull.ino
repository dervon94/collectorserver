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
//const int humtemp_pin = 4;
//const int rainPin = A0;
//const int lightPin=A1;
EthernetClient client;
DNSClient DNSclient;
IPAddress dstip;;
SimpleDHT11 dht11;

byte temperature = 0;
byte humidity = 0;
byte rain=0;
byte light=0;

  
void setup() {
  Serial.begin(9600);
  connecting();
}

void connecting(){
  // Initializing Ethernet
  Serial.PGMprintln("Initializing");
  Ethernet.begin(mac);
  Serial.PGMprint("IP: ");
  Serial.println(Ethernet.localIP());
 // Serial.PGMprint("Subnet mask: ");
  Serial.println(Ethernet.subnetMask());
//  Serial.PGMprint("Gateway: ");
  Serial.println(Ethernet.gatewayIP());
  Serial.PGMprint("DNS: ");
  Serial.println(Ethernet.dnsServerIP());

 // Serial.PGMprintln("Init DNS...");
  DNSclient.begin(Ethernet.dnsServerIP());
  if (DNSclient.getHostByName(dsthost, dstip)) {
 //   Serial.PGMprint("Resolved remote host to: ");
    Serial.println(dstip);
  } else {
    Serial.PGMprintln("Error");
  }
}
void getSenVal(){
  dht11.read(4, &temperature, &humidity, NULL);
  rain= analogRead(A0);
  light= analogRead(A1);

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
    client.print(",\"temperature\":");
    client.print(temperature);
    client.print(",\"humidity\":");
    client.print(humidity);
    client.print(",\"light\":");
    client.print(light);
    client.print("}}");

    // Disconnect
    client.stop();

   // Serial.PGMprintln("sent");

  } else {
   // Serial.PGMprintln("failed!");
  }
}
void loop() {
  getSenVal();
  sendHttpRequest();
  delay(1000);
}

