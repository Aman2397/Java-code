//4 feet distance betw 2 ir sensor 

//speed detection program varible
int firstsens= 4; //add value
int secondsens= 5;//add value
unsigned long time1,time2;
float fps,elap;
int val1,val2;
int speed1;

//rfid variable 

int count = 0;                                          // count = 0
char input[12];                                         // character array of size 12 
boolean flag = 0;                                      // flag =0

//Code to send SMS from Arduino
int timesTosend=1;
int count1=0;
char phone_no[]="9920299272";  //phone number


void setup()
{
      Serial.begin(9600);
      Serial1.begin(9600);                                  // begin serial port with baud rate 9600bps

      delay(2000);
      Serial.println("AT+CMGF=1"); //set GSM to text mode
      delay(200);
      pinMode(firstsens,INPUT);
      pinMode(secondsens,INPUT);
}

void loop() 
{
      //Serial.println("waiting for object....");
      if(Serial1.available())
            {
   
                count = 0;
                while(Serial1.available() && count < 12)          // Read 12 characters and store them in input array
                   {
        
                       input[count] = Serial1.read();
                       count++;
                       delay(5);
                    }
                       Serial.print(input);                             // Print RFID tag number 
      
      
                     if((input[0] ^ input[2] ^ input[4] ^ input[6] ^ input[8] == input[10]) && 
                     (input[1] ^ input[3] ^ input[5] ^ input[7] ^ input[9] == input[11]))
                           {
                                val1=analogRead(firstsens);
                                val2=analogRead(secondsens);
                                while(val1>90)
                                    {
                                        val1=analogRead(firstsens);
                                    }
                                     while(val1<=90)
                                     {
                                        time1=micros();
                                        val1=analogRead(firstsens);
                                     }
                                       while(val2>90)
                                          {
                                            val2=analogRead(secondsens);
                          
                                          }
                                       while(val2<=90)
                                        {
                                          time2=micros();
                                          val2=analogRead(secondsens);
                                         }
                                        elap=time2-time1;
                                        fps=333333/elap;
                                        speed1=fps*1.09728;
                                        Serial.println(speed1);
                                        Serial.println("kmph");
                                        if(speed1>2) 
                                        {
                                          Serial.println(speed1);
                                          Serial.println("kmph");
                                          //gsm code
                                          while(count1<timesTosend)
                                          {
                                              delay(1500);
                                              Serial.print("AT+CMGS=\""); //body
                                              Serial.print(phone_no);
                                              Serial.println("\"");
                                              
                                              while (Serial.read()!='>');
                                                  {
                                                      Serial.print("The car with RFID Number 36006484588E");  //SMS body
                                                      delay(500);
                                                      Serial.write(0x1A);  // sends ctrl+z end of message
                                                      Serial.write(0x0D);  // Carriage Return in Hex
                                                      Serial.write(0x0A);  // Line feed in Hex
                                                                           //The 0D0A pair of characters is the signal for the end of a line and beginning of another.
                                                      delay(5000);
                                                  }
                                                  count1++;
                                          }    
                                      
                                          
                                       }
                        
                              
                                }
                              
                               else
                               {
                                  Serial.println("Error");      
                               }

    }
}
