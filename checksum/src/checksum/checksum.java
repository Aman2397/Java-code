package checksum;
import java.util.*;
public class checksum 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n;
		String datastring=new String();
		System.out.println("Enter size of data ");
		n=sc.nextInt();
		n=n+4;
		char maindata[];
		System.out.println("Enter data ");
		datastring=sc.next();
		
		//StringBuffer sb=new StringBuffer(datastring); 
		maindata=datastring.toCharArray();

		//for(int i=0;i<maindata.length;i++)System.out.println(maindata[i]+"for"+i);
		int i=3,carry=0,ans,mans;
		String res=new String(); 
		char res_r[]=new char[4];
		for(int j=4;j>=1;j--)
		{	
			
			String s1=new String();
			s1=Character.toString(maindata[i]);
			int num1=Integer.parseInt(s1,16);
			
			
			s1=Character.toString(maindata[(i+4)]);
			int num2=Integer.parseInt(s1,16);
			
			s1=Character.toString(maindata[(i+8)]);
			int num3=Integer.parseInt(s1,16);
			
			s1=Character.toString(maindata[(i+12)]);
			int num4=Integer.parseInt(s1,16);
			
/*			s1=Character.toString(maindata[(i+16)]);
			int num5=Integer.parseInt(s1,10);
*/			
			ans=num1+num2+num3+num4+carry;
			/*System.out.println("n1 "+num1);
			System.out.println("n2 "+num2);
			System.out.println("n3 "+num3);
			System.out.println("n4 "+num4);
			System.out.println("carry "+carry);
			System.out.println("in loop "+ans);
			*/
			carry=0;
			
			res=Integer.toHexString(ans);
			System.out.println("ans "+res);
			
			char temp[]=res.toCharArray();
			if(temp.length==2)
			{
				//System.out.println("temp value 0 to 1 :"+temp[0]+"-"+temp[1]);
				s1=Character.toString(temp[0]);
				carry=Integer.parseInt(s1,16);
				res_r[i]=temp[1];
			}
			else{
				//System.out.println("temp value 0 :"+temp[0]);	
			res_r[i]=temp[0];
			
			}
			
			i=i-1;
		}
		//for( i=0;i<4;i++)System.out.println(" res r "+res_r[i]);
		//datastring=sb.toString();
		//System.out.println("Data to be send "+datastring);
		toHex(res_r);
		//for( i=0;i<4;i++)System.out.println(" After 1's  r "+res_r[i]);
		StringBuffer send_data=new StringBuffer(datastring);
		send_data.append(res_r);
		System.out.println("Data to be send "+send_data);
		
		
	}
	public static void toHex(char res[])
	{
		String s1=new String();
		char temp[];
		for(int i=0;i<res.length;i++)
		{
			
			s1=Character.toString(res[i]);
			int num1=Integer.parseInt(s1,16);
			num1=15-num1;
			s1=Integer.toHexString(num1);
			temp=s1.toCharArray();
			res[i]=temp[0];
		}
		
	}

}
