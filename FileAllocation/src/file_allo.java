import java.util.Random;
import java.util.Scanner;
class block{
	int sr;
	block(int i){
		sr=i;}
	int visited=0;
	String filename="";
}
class indexBlock{
	int index[];
	int pointer=0;
	int visit;//0=not visited 1=visited
	indexBlock(int j){
		index=new int[j];
	}
	
}
class chainBlock{
	int index;
	int visit;//0=not visited 1=visited
}
public class file_allo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ch;
		do{
			
			System.out.println("1)Sequential\n2)Linked\n3)Indexed");
			ch=sc.nextInt();
			switch(ch){
			case 1:	conti_Alloc();
					break;
			case 2:	chain_Alloc();
					break;
			case 3:index_Alloc();
					break;
			}

		}while(ch<4 && ch>0);



	}
	public static void index_Alloc(){
		System.out.println("Index Allocation");
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the  Number Of Blocks 1unit=512kb");
		int b_no=sc.nextInt(),main_index,fillval=0,filesize=0;  //no of block 
		indexBlock i_blk[]=new indexBlock[b_no]; //creating block
		for ( int i=0; i<i_blk.length; i++) {
			i_blk[i]=new indexBlock(b_no);		//assuming there can max index size=no of block
			}			//allocating space
		System.out.println("Enter how file u want to add");
		int file_no=sc.nextInt();
		for(int i=0;i<file_no;i++){
			if((filesize+fillval)<b_no){
				fillval+=filesize;
				main_index=r.nextInt(b_no);
				if(i_blk[main_index].visit==0){
				filesize=createAlloc(i_blk,main_index,fillval,filesize,b_no);
				}
				else{
					i--;
				}
			}
			
		}
		
		
	}
	public static int createAlloc(indexBlock i_blk[],int main_index,int fillvalue,int datafill,int b_no){
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		int prev_index,next_index;
		System.out.println("Enter file name");
		String filename=sc.next();
		System.out.println("Enter file size");
		int filesize=sc.nextInt();
		System.out.println("file name        index");
		System.out.println(filename+"        "+main_index);
		prev_index=next_index=r.nextInt(i_blk.length);
		
		//System.out.println("fillvalue "+fillvalue+" datafill "+datafill+" b_no "+b_no+" file size "+filesize);
		if((fillvalue+filesize)<b_no){
			for(int i=0;i<filesize;i++){
				while(i_blk[next_index].visit==1 || prev_index==next_index && next_index!=main_index ){
					next_index=r.nextInt(i_blk.length);
				}
				for(int z=0;z<b_no;z++){
					if(i_blk[prev_index].index[z]==next_index || i_blk[next_index].visit==1 || prev_index==next_index || next_index==main_index||prev_index==main_index){
						next_index=r.nextInt(i_blk.length);

					}
				}
				
				if(i_blk[prev_index].visit==0 && prev_index!=next_index){
					i_blk[main_index].index[i_blk[main_index].pointer]=prev_index;	
					i_blk[main_index].pointer+=1;
					i_blk[prev_index].visit=1;
					prev_index=next_index;
				}
				else{
					prev_index=next_index;
					i--;
				}
			
			}
			System.out.println("Index structure :"+main_index);
			for(int i=0;i<i_blk.length;i++)
			{
				if(i_blk[main_index].index[i]!=0){
					System.out.println(i_blk[main_index].index[i]);
				}
			}
		}
		else{
			System.out.println("Space not there");
		}
		//System.out.println(" at ret fillvalue "+fillvalue+" datafill "+datafill+" b_no "+b_no);
		return filesize;
		
	}
	public static void chain_Alloc(){
		Random r=new Random();
		System.out.println("Chain Allocation");
		Scanner sc=new Scanner(System.in);		
		System.out.println("Enter the  Number Of Blocks 1unit=512kb");
		int b_no=sc.nextInt();  //no of block 
		chainBlock c_blk[]=new chainBlock[b_no]; //creating block
		for ( int i=0; i<c_blk.length; i++) {
			c_blk[i]=new chainBlock();
			}
		int count=0;
		System.out.println("how file u want to add");
		int temp=sc.nextInt();
		int t=0,fillvalue=0,fileSize;
		String filename;
		while(t<temp){
			System.out.println("Enter file name ");
			filename=sc.next();
			System.out.println("Enter size of file");
			fileSize=sc.nextInt();
			int end;
			//System.out.println("count "+count+" c_blk[count].visit "+c_blk[count].visit);
			if((fillvalue+fileSize)<b_no){
				if(c_blk[count].visit==0 ){//is there space?
					int next_index=r.nextInt(b_no);
					//System.out.println("next_index"+next_index);
					c_blk[count].visit=1;
					while(c_blk[next_index].visit!=0)next_index=r.nextInt(b_no);//find next till it is not visited
					//System.out.println("next_index after 1 st while"+next_index);
					c_blk[count].index=next_index;
					int prev_index=next_index;
					//System.out.println("count "+count+" c_blk[count].next "+next_index+" fileSize "+fileSize);
					for(int i=0;i<fileSize-1;i++){//allocation loop
						//System.out.println("count "+count+" c_blk[count].next "+next_index+" prev_index "+prev_index);
						int check=next_index=r.nextInt(b_no);	
							while(c_blk[next_index].visit==1 || check==next_index)next_index=r.nextInt(b_no);
						//System.out.println("next_index after 2 nd while"+next_index);
						c_blk[prev_index].index=next_index;
						c_blk[prev_index].visit=1;
						prev_index=next_index;
						/*for(int j=0;j<c_blk.length;j++){
							System.out.println("value "+j+" : index = "+c_blk[j].index+" visit "+c_blk[j].visit );
							//System.out.println(" ");
						}*/
					}//for
					System.out.println("File name    start     end");
					System.out.println(filename+"        "+count+"        "+fileSize);
					count++;
				}//if
				else{
					System.out.println("count"+count);
					count++;}
				
			}
						else{
				System.out.println("There is no space ");
				break;

			}
			//System.out.println("File name    start     end");
		//	System.out.println(filename+"        "+count+"        "+fileSize);

			fillvalue+=fileSize;
			t++;
		}//while
		
		
		
	}
	public static void conti_Alloc(){
		
		int i=0,temp=0,filesize=0;
		System.out.println("Sequential Allocation");
		Scanner sc=new Scanner(System.in);		
		String filename="";
		System.out.println("no Of Blocks 1unit = 512kb");
		int size=sc.nextInt();  //no of block 
		block b[]=new block[size];
		for(i=0;i<size;i++)b[i]=new block(i); //for locating space
		System.out.println("Enter the number of files:");
		int num = sc.nextInt();
		int avail = size-1;
		int pointer=0,count=0,start=0;
		while(temp < num){
			System.out.println("Enter the name of the file:");
			filename = sc.next();
			System.out.println("Enter the size of the file:");
			filesize = sc.nextInt();
				if(avail < filesize){
					System.out.println("No memory availble");
					System.exit(1);
				}
				for(i=0;i<size;i++){
					//System.out.println(b[i]+"viisted:"+b[i].visited);
					if(b[i].visited!=1){
						count++;
						pointer++;
						if(count == filesize){					
							//System.out.print("Avaulable:"+count);
							//System.out.println("Equal");
							break;
						}
					}
					else{
						pointer++;
						count=0;
						//System.out.println("pointer:"+pointer);
					}
					
				}
				if(count == filesize){
					//System.out.println("Inside count==size");
					pointer-=filesize;		//to restore previous value 
					//System.out.println("-vePointer:"+pointer);
					for(i=0;i<filesize;i++){
						b[pointer].visited=1;
						b[pointer].filename=filename;
						avail--;
						if(i==0)
							start =pointer;
						pointer++;
					}
					System.out.println("FileName\tStart\tFileSize");
					System.out.println(filename+"\t\t"+start+"\t"+filesize);
				}
				else if(pointer == filesize-1)
					System.out.println("No space");
					
			temp++;
			pointer=0;
	
	}
}//while
		
		
				
}
	


