package file_organized;
import java.io.File;
import java.util.Scanner;
public class second_lvl {
	private static Scanner sc;
	public static void main(String args[]){
		int opt=0,user=0;
		 sc=new Scanner(System.in);
		//System.out.println("Enter ur how many user ");
		//user=sc.nextInt();
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
		System.out.println("Enter which user write in u0 format:");
		String user=sc.next();
		String loc="/Users/aman/secondlvl/";
		File file=new File(loc+user);
		try{
			if(new File(loc+user).exists()){
			System.out.println("User exist");
			System.out.println("Enter the file to be created with extension");
			String fileName=sc.next();
			if(new File(loc+user+"/"+fileName).createNewFile())
				System.out.println("File Created");
			else
				System.out.println("Cannot Create A New File");	
			}
			else{//user not exisit 
				new File(loc+user).mkdirs();
				System.out.println("Enter the file to be created with extension");
				String fileName=sc.next();
				if(new File(loc+user+"/"+fileName).createNewFile())
					System.out.println("File Created");
				else
					System.out.println("Cannot Create A New File");
				
			}
		}	
		catch(Exception e){
			System.out.println(e);
			
		}
		
		
	}
	public static void delete_fun(){
		System.out.println("Enter which user write in u0 format:");
		String user=sc.next();
		String loc="/Users/aman/secondlvl/";
		File file=new File(loc+user);
		String filename;
		System.out.println("Enter file name  :");
		filename=sc.next();
		if(new File(loc+user+"/"+filename).delete()){
			System.out.println("Delete done");
		}
		else{
			System.out.println("Not exit");
		}
		
	}
	public static void search_fun(){
		System.out.println("Enter which user write in u0 format:");
		String user=sc.next();
		String loc="/Users/aman/secondlvl/";
		File file=new File(loc+user);
		String filename="";
		System.out.println("Enter file name to search with extension 2gether :");
		filename=sc.next();
		File f=new File(loc+user+"/"+filename);
		if(f.exists()){
			  System.out.println("File existed path :"+f.getAbsolutePath());
		  }else{
			  System.out.println("File not found!");
		  }
		
	}
	

}
