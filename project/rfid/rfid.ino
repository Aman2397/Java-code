int count=0;

void setup() {
Serial.begin(9600);
}

void loop() {
if(Serial.available())
{
  count=0;
  {
    Serial.println("started");
    char input=Serial.read();
    Serial.print(input);
    count++;
    delay(5);
    
  }
   Serial.println();
   Serial.print("tag length:");
   Serial.print(count);
   Serial.println("bytes");
   
  
  }
}
