package file_organized;

import java.io.File;
import java.util.Scanner;

public class single_level {
	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opt=0;
		 sc=new Scanner(System.in);
		System.out.println("Enter ur option ");
		do{
			System.out.println("1)create");
			System.out.println("2)delete");
			System.out.println("3)search");
			System.out.println("4)exit");
			opt=sc.nextInt();
			switch(opt){
			case 1:	create_fun();		
					break;
			case 2:delete_fun();
					break;

			case 3:search_fun();
					break;

			}//switch
		}while(opt<=4);
	}//main
	
	public static void create_fun(){
		String filename,extension="";
		System.out.println("Enter file name with .extension :");
		filename=sc.next();
		String loc= "/Users/aman/firstlvl/";
		File f=new File(loc+filename);
	    try {
	    	if(f.createNewFile()){
	    		System.out.println("File created");
	    	}
	    	else{
	    		System.out.println("File exit");
	    	}
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}
	public static void delete_fun(){
		String filename;
		System.out.println("Enter file name  :");
		filename=sc.next();
		String loc="/Users/aman/firstlvl/";
		if(new File(loc+filename).delete()){
			System.out.println("Delete done");
		}
		else{
			System.out.println("Not exit");
		}
	}
	public static void search_fun(){
		String filename="";
		System.out.println("Enter file name to search with extension 2gether :");
		filename=sc.next();
		String loc="/Users/aman/firstlvl/";
		File f=new File(loc+filename);
		if(f.exists()){
			  System.out.println("File existed path :"+f.getAbsolutePath());
		  }else{
			  System.out.println("File not found!");
		  }
	}
}
