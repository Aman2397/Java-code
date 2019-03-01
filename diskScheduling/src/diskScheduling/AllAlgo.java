package diskScheduling;

import java.util.Scanner;

public class AllAlgo {
	//function 
	public static void totaltrack(int a[]){
		int total=0;
		for(int i=0;i<a.length;i++){
			total+=a[i];
		}
		System.out.println("Total head :"+total);
		System.out.println("seek length :"+(total)/a.length);
	}
	
	public static int nearvalue(int value,int a[],int visit[]){
		int index=0,small=999;
		for(int i=0;i<a.length;i++){
			if(Math.abs(a[i]-value)<small &&visit[i]==0){
				small=Math.abs(a[i]-value);
				index=i;
			}
			
		}
		
		return index;
	}
	public static void  main(String args[]){
	Scanner sc=new Scanner(System.in);	
	
	System.out.println("Enter range track , initial track position and no. of tracks");
	int NoOfTrack=sc.nextInt();  // no. of track...range
	NoOfTrack-=1;					//for 0 -..(0-199)
	int InittrackPosition=sc.nextInt();  // init track position
	int size=sc.nextInt();					//no of req
	int req_queque[]=new int[size];		
	boolean flag=true;
	System.out.println("Enter value of req queue ");
	for(int i=0;i<size;i++){
		int n=sc.nextInt();
		if(n>NoOfTrack){
			System.out.println("Error :");
			flag=false;
			break;
		}
		else{
			req_queque[i]=n;
		}
	} //for
	
	if(flag==true){
		int visit[]=new int[size];				//visit array
		int track_array[]=new int[size]; 		//result array
		int d[]=new int[size];					//distance
		int opt;
		do{
			System.out.println("1)FCFS");
			System.out.println("2)SSTF");
			System.out.println("3)SCAN");
			System.out.println("4)LOOK");
			System.out.println("5)C-SCAN");
			System.out.println("6)C-LOOK");
			System.out.println("7)Exit:");
			opt=sc.nextInt();
			switch(opt){
			case 1:
				System.out.println("FCFS");
				track_array[0]=Math.abs(InittrackPosition-req_queque[0]);
				System.out.println("track "+0+" value :"+track_array[0]);
				for(int i=1;i<size;i++){
					track_array[i]=Math.abs(req_queque[i]-req_queque[(i-1)]);
					System.out.println("track "+i+" value :"+track_array[i]);
					}
				totaltrack(track_array);
				break;
				
			//sstf
			case 2:
						System.out.println("SSTF");
						int  x=InittrackPosition,index;
						for(int i=0;i<visit.length;i++)visit[i]=0;		//init 
						for(int i=0;i<req_queque.length;i++){
							index=nearvalue(x,req_queque,visit);
							visit[index]=1;
							System.out.println(" "+req_queque[index]+" "+x);
							track_array[i]=Math.abs(req_queque[index]-x);
							x=req_queque[index];
						}
						totaltrack(track_array);
						break;
			case 3 :	System.out.println("SCAN");
						//for(int i=0;i<visit.length;i++)visit[i]=0;		//init 
						int temp;
						for(int i=0;i<req_queque.length-1;i++){			//sort
							for(int j=(i+1);j<req_queque.length;j++){
								if(req_queque[i]>req_queque[j]){
									temp=req_queque[i];
									req_queque[i]=req_queque[j];
									req_queque[j]=temp;
								}
							}
						}
						//for(int i=0;i<size;i++)System.out.println(" value :"+i+" : "+req_queque[i]);
						index=0;
						int min=Math.abs(req_queque[0]-InittrackPosition);
						for(int i=0;i<req_queque.length;i++){
							//System.out.println("comapre "+(Math.abs(req_queque[i]-InittrackPosition))+" min "+min+" i value "+i+" index "+index);
							if(min>Math.abs(req_queque[i]-InittrackPosition)){
								index=i;
								min=Math.abs(req_queque[i]-InittrackPosition);
							}
						}
						int sum=Math.abs(InittrackPosition-req_queque[index]); //
						//System.out.println("Sum"+sum);
						 sum+=Math.abs(NoOfTrack-req_queque[size-1]);			//199-last
						 //System.out.println("Sum"+sum);
						 sum+=Math.abs(0-req_queque[0]);						//0-first
						 //System.out.println("Sum"+sum);
						if((InittrackPosition-req_queque[index])>0){
							for(int i=(index+1);i<size;i++){
								sum=sum+Math.abs(req_queque[(i-1)]-req_queque[i]);
							}
							sum+=Math.abs(NoOfTrack-req_queque[index-1]); //199-index-1
							for(int i=0;i<(index-1);i++){
								sum=sum+Math.abs(req_queque[(i+1)]-req_queque[i]);
							}
						}
						else{
							for(int i=(index-1);i>0;i--){
								//System.out.println("Sum  before first loop "+req_queque[(i-1)] +" - "+req_queque[i]+" "+sum);
								sum=sum+Math.abs(req_queque[(i-1)]-req_queque[i]);
								//System.out.println("Sum  after first loop "+sum);
							}
							sum+=Math.abs(0-req_queque[index+1]); //0-index-1
							//System.out.println("Sum "+sum);
							for(int i=index+1;i<(size)-1;i++){
								//System.out.println("Sum  before 2nd loop "+req_queque[(i+1)] +" - "+req_queque[i]+" "+sum);
								sum=sum+Math.abs(req_queque[(i+1)]-req_queque[i]);
								//System.out.println("Sum 2nd after loop"+sum);
							}
						}
						System.out.println("Total head :"+sum);
						System.out.println("seek length :"+(sum)/size);
						break;
						
			case 4:
				System.out.println("LOOK");
				for(int i=0;i<req_queque.length-1;i++){			//sort
					for(int j=(i+1);j<req_queque.length;j++){
						if(req_queque[i]>req_queque[j]){
							temp=req_queque[i];
							req_queque[i]=req_queque[j];
							req_queque[j]=temp;
						}
					}
				}
				//for(int i=0;i<size;i++)System.out.println(" value :"+i+" : "+req_queque[i]);
				index=0;
				 min=Math.abs(req_queque[0]-InittrackPosition);
				for(int i=0;i<req_queque.length;i++){
					//System.out.println("comapre "+(Math.abs(req_queque[i]-InittrackPosition))+" min "+min+" i value "+i+" index "+index);
					if(min>Math.abs(req_queque[i]-InittrackPosition)){
						index=i;
						min=Math.abs(req_queque[i]-InittrackPosition);
					}
				}
				 sum=Math.abs(InittrackPosition-req_queque[index]); //
				// System.out.println("Sum"+sum);
				 //sum+=Math.abs(NoOfTrack-req_queque[size-1]);			//199-last
				 //System.out.println("Sum"+sum);
				// sum+=Math.abs(0-req_queque[0]);						//0-first
				 //System.out.println("Sum"+sum);
				if((InittrackPosition-req_queque[index])>0){
					for(int i=(index+1);i<size;i++){
						sum=sum+Math.abs(req_queque[(i-1)]-req_queque[i]);
					}
					sum+=Math.abs(NoOfTrack-req_queque[index-1]); //199-index-1
					for(int i=0;i<(index-1);i++){
						sum=sum+Math.abs(req_queque[(i+1)]-req_queque[i]);
					}
				}
				else{
					for(int i=(index-1);i>0;i--){
						//System.out.println("Sum  before first loop "+req_queque[(i-1)] +" - "+req_queque[i]+" "+sum);
						sum=sum+Math.abs(req_queque[(i-1)]-req_queque[i]);
						//System.out.println("Sum  after first loop "+sum);
					}
					sum+=Math.abs(0-req_queque[index+1]); //0-index-1
					//System.out.println("Sum "+sum);
					for(int i=index+1;i<(size)-1;i++){
						//System.out.println("Sum  before 2nd loop "+req_queque[(i+1)] +" - "+req_queque[i]+" "+sum);
						sum=sum+Math.abs(req_queque[(i+1)]-req_queque[i]);
						//System.out.println("Sum 2nd after loop"+sum);
					}
				}
				System.out.println("Total head :"+sum);
				System.out.println("seek length :"+(sum)/size);
				break;
				
			case 5:	System.out.println("C-SCAN");
				for(int i=0;i<req_queque.length-1;i++){			//sort
					for(int j=(i+1);j<req_queque.length;j++){
						if(req_queque[i]>req_queque[j]){
							temp=req_queque[i];
							req_queque[i]=req_queque[j];
							req_queque[j]=temp;
						}
					}
				}
			//for(int i=0;i<size;i++)System.out.println(" value :"+i+" : "+req_queque[i]);
			index=0;
			 min=Math.abs(req_queque[0]-InittrackPosition);
			for(int i=0;i<req_queque.length;i++){
				//System.out.println("comapre "+(Math.abs(req_queque[i]-InittrackPosition))+" min "+min+" i value "+i+" index "+index);
				if(min>Math.abs(req_queque[i]-InittrackPosition)){
					index=i;
					min=Math.abs(req_queque[i]-InittrackPosition);
				}
			}
			 sum=Math.abs(InittrackPosition-req_queque[index]); //
			// System.out.println("Sum"+sum);
			 sum+=Math.abs(NoOfTrack-req_queque[size-1]);			//199-last
			 //System.out.println("Sum"+sum);
			 sum+=Math.abs(0-req_queque[0]);						//0-first
			 //System.out.println("Sum"+sum);
			if((InittrackPosition-req_queque[index])>0){
				for(int i=(index+1);i<size;i++){
					sum=sum+Math.abs(req_queque[(i-1)]-req_queque[i]);
				}
				//sum+=Math.abs(NoOfTrack-req_queque[index-1]); //199-index-1
				for(int i=0;i<(index-1);i++){
					sum=sum+Math.abs(req_queque[(i+1)]-req_queque[i]);
				}
			}
			else{
				for(int i=(index-1);i>0;i--){
					//System.out.println("Sum  before first loop "+req_queque[(i-1)] +" - "+req_queque[i]+" "+sum);
					sum=sum+Math.abs(req_queque[(i-1)]-req_queque[i]);
					//System.out.println("Sum  after first loop "+sum);
				}
				//sum+=Math.abs(0-req_queque[index+1]); //0-index-1
				//System.out.println("Sum "+sum);
				for(int i=index+1;i<(size)-1;i++){
					//System.out.println("Sum  before 2nd loop "+req_queque[(i+1)] +" - "+req_queque[i]+" "+sum);
					sum=sum+Math.abs(req_queque[(i+1)]-req_queque[i]);
					//System.out.println("Sum 2nd after loop"+sum);
				}
			}
			System.out.println("Total head :"+sum);
			System.out.println("seek length :"+(sum)/size);
			break;
			
		case 6:	
		System.out.println("C-LOOK");
		for(int i=0;i<req_queque.length-1;i++){			//sort
			for(int j=(i+1);j<req_queque.length;j++){
				if(req_queque[i]>req_queque[j]){
					temp=req_queque[i];
					req_queque[i]=req_queque[j];
					req_queque[j]=temp;
				}
			}
		}
		//for(int i=0;i<size;i++)System.out.println(" value :"+i+" : "+req_queque[i]);
		index=0;
		 min=Math.abs(req_queque[0]-InittrackPosition);
		for(int i=0;i<req_queque.length;i++){
			//System.out.println("comapre "+(Math.abs(req_queque[i]-InittrackPosition))+" min "+min+" i value "+i+" index "+index);
			if(min>Math.abs(req_queque[i]-InittrackPosition)){
				index=i;
				min=Math.abs(req_queque[i]-InittrackPosition);
			}
		}
		sum=Math.abs(InittrackPosition-req_queque[index]); 
		// System.out.println("Sum"+sum);
		 //sum+=Math.abs(NoOfTrack-req_queque[size-1]);			//199-last
		 //System.out.println("Sum"+sum);
		 //sum+=Math.abs(0-req_queque[0]);						//0-first
		 //System.out.println("Sum"+sum);
		if((InittrackPosition-req_queque[index])>0){
			for(int i=(index+1);i<size;i++){
				sum=sum+Math.abs(req_queque[(i-1)]-req_queque[i]);
			}
			//sum+=Math.abs(NoOfTrack-req_queque[index-1]); //199-index-1
			for(int i=0;i<(index-1);i++){
				sum=sum+Math.abs(req_queque[(i+1)]-req_queque[i]);
			}
		}
		else{
			for(int i=(index-1);i>0;i--){
				//System.out.println("Sum  before first loop "+req_queque[(i-1)] +" - "+req_queque[i]+" "+sum);
				sum=sum+Math.abs(req_queque[(i-1)]-req_queque[i]);
				//System.out.println("Sum  after first loop "+sum);
			}
			//sum+=Math.abs(0-req_queque[index+1]); //0-index-1
			//System.out.println("Sum "+sum);
			for(int i=index+1;i<(size)-1;i++){
				//System.out.println("Sum  before 2nd loop "+req_queque[(i+1)] +" - "+req_queque[i]+" "+sum);
				sum=sum+Math.abs(req_queque[(i+1)]-req_queque[i]);
				//System.out.println("Sum 2nd after loop"+sum);
			}
		}
		System.out.println("Total head :"+sum);
		System.out.println("seek length :"+(sum)/size);
		
			}//switch
		}while(opt<=6);
	}
	//if
	else{
		System.out.println("Enter valid input");
	}
}//main
}//class

/*
98
183
37
122
14
124
65
67
*/
