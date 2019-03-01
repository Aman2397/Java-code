import java.io.*;
import java.util.*;

public class lex {
	static String [] operator={"+","-","*","/","%","=","<",">","&&","||"};
	static String [] keyword={"auto","double","int","struct","break","else","long",	"switch","case",	"enum",	"register",	"typedef","char",	"extern",	
			"return",	"union","const	","float	","short	","unsigned","continue	","for ","signed	","void","default"	,"goto"	,"sizeof	","volatile",
			"do	","if",	"static",	"while","include","printf"};
	static String []SpcialCharacter={"#",";",",","\""};
	static String []Delimiter={";","(",")","{","}"," ","[","]"};
	static ArrayList<String> constants=new ArrayList<String>();
	static ArrayList<String> variable=new ArrayList<String>();
	static ArrayList<String> keywordA=new ArrayList<String>(Arrays.asList(keyword));
	static ArrayList<String> operatorA=new ArrayList<String>(Arrays.asList(operator));
	static ArrayList<String> specialCharactersA=new ArrayList<String>(Arrays.asList(SpcialCharacter));
	static ArrayList<String> DelimiterA=new ArrayList<String>(Arrays.asList(Delimiter));


	public static void main(String[] args)throws Exception {
		File f=new File("/Users/aman/Downloads/DFS.C");
		BufferedReader bufferReader=new BufferedReader(new FileReader(f));
		String line;
		int i=1;
		while((line=bufferReader.readLine())!=null){
			System.out.println("Line"+i);
			System.out.println(line);
			contain(line);
			i++;
		}
		
		
	}
	
	static void contain(String line)throws Exception{
		String delimiter="=+#<>[]{}-;&* \"",temptoken;
		int i=1;
		boolean flag=true;
		StringTokenizer token=new StringTokenizer(line,delimiter,true);
		//System.out.println("Token "+token.nextToken());
		while(token.hasMoreTokens()){
			//System.out.println("loop "+i);
			temptoken=token.nextToken();
			//System.out.println("temptoken :"+temptoken);
			if(temptoken==" " ||temptoken=="	")flag=false;
			if(keywordA.contains(temptoken)){
				System.out.println("keyword["+keywordA.indexOf(temptoken)+"]");
			}
			if(specialCharactersA.contains(temptoken)){
				
				System.out.println("SpecialCharacter["+specialCharactersA.indexOf(temptoken)+"]");
			}
			if(operatorA.contains(temptoken)){
				System.out.println("operator["+operatorA.indexOf(temptoken)+"]");
			}
			if(!(operatorA.contains(temptoken))&&!(keywordA.contains(temptoken))&&!(specialCharactersA.contains(temptoken))&& !(DelimiterA.contains(temptoken))&&!(temptoken.equals(" "))){
				if(constants.contains(temptoken))System.out.println("constant["+constants.indexOf(temptoken)+"]");
				else{
					constants.add(temptoken);
					System.out.println("constant["+constants.indexOf(temptoken)+"]");
				}
			}
			
		}
		
		
	}

}
