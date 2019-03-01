package file_organized;

import java.io.File;
import java.util.Scanner;

public class hlevel {
	private static Scanner sc;
	public static void main(String args[]){
		int opt=0,user=0;
		 sc=new Scanner(System.in);
		//System.out.println("Enter ur how many user ");
		//user=sc.nextInt();
		do{
			System.out.println("1)create file ");
			System.out.println("2)delete file");
			System.out.println("3)create directory");
			System.out.println("4)delete directory");
			System.out.println("5)search file");
			System.out.println("6)exit");
			opt=sc.nextInt();
			switch(opt){
			case 1:	create_fil();		
					break;
			case 2:delete_fil();
					break;
			case 3:create_dir();
				break;
			case 4:delete_dir();
				break;
			case 5:search_fil();
					break;

			}//switch
		}while(opt<=6);
		
	}//main
	
	public static void create_fil(){
		String loc="/Users/aman/hlevel/root";
		System.out.println("Enter in which file you want to add file /path/ format");
		String path=sc.next();
		try{
			if(new File(loc+path).exists()){
				String filename="";
				System.out.println("Enter file name with .extension :");
				filename=sc.next();
				if(new File(loc+path+"/"+filename).createNewFile()){
					System.out.println("file created ");
				}
				else{
					System.out.println("file created");
				}
			}
			else{
				System.out.println("wrong path");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public static void delete_fil(){
		String loc="/Users/aman/hlevel/root";
		System.out.println("Enter in which file you want to delete file /path format from root");
		String path=sc.next();
		try{
			if(new File(loc+path).exists()){
				String filename="";
				System.out.println("Enter file name with .extension to delete:");
				filename=sc.next();
				if(new File(loc+path+"/"+filename).delete()){
					System.out.println("file delted ");
				}
				else{
					System.out.println("file not deleted");
				}
			}
			else{
				System.out.println("wrong path");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
	}
public static void create_dir(){
	String loc="/Users/aman/hlevel/root";
	System.out.println("Enter in which file you want to add file /path format from root");
	String path=sc.next();
	if(new File(loc+path).exists()){
		System.out.println("dirctory exit");
	}
	else{
		new File(loc+path).mkdirs();
		System.out.println("Directroy created:");
	}
		
	}
	public static void delete_dir(){
		String loc="/Users/aman/hlevel/root";
		System.out.println("Enter in which file you want to delete file /path format from root");
		String path=sc.next();
		if(new File(loc+path).exists()){
			new File(loc+path).delete();
			System.out.println("dirctory deleted");
		}
		else{
			System.out.println("Directroy doesnt exists");
		}
		
	}
	public static void search_fil(){
		String loc="/Users/aman/hlevel/root";
		System.out.println("Enter Path in /path format from root");
		String dir=sc.next();
		if(new File(loc+dir).exists()){
			System.out.println("path is valid ");
			System.out.println("Enter the file to be Searched with extension");
			String fileName=sc.next();
			if(new File(loc+dir+"/"+fileName).exists())
				System.out.println("File Exists");
			else
				System.out.println("File Does Not exist");
		}
		else
			System.out.println("Path Does Not Exists");
		
	}

}
