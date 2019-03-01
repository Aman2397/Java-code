int firstsens=4;
int secondsens=5;

int val1;
int val2;

void setup() {
  Serial.begin(9600);
  pinMode(firstsens,INPUT);
  pinMode(secondsens,INPUT);

}

void loop() {
 val1=analogRead(firstsens);
 val2=analogRead(secondsens);
 Serial.println("first sensor");
 Serial.println(val1);
 Serial.println("second sensor");
 Serial.println(val2);
 delay(1000);
}
