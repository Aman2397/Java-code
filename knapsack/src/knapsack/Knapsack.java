//Greedy method 
//All three cases 
//Coded by @Aman_Doshi

package knapsack;

import java.util.*;
import java.io.*;
class Knapsack 
{
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n;
		float m;
		System.out.println("Enter no of obj");
		n=sc.nextInt();
		System.out.println("Enter Capacity");
		m=sc.nextFloat();
		n=n+1;
		float p[]=new float[n];
		float w[]=new float[n];
		float ratio[]=new float[n];
		for(int i=1;i<n;i++)
		{
			System.out.println("Profit of obj "+i);
			p[i]=sc.nextInt();
			System.out.println("Weight of obj "+i);
			w[i]=sc.nextInt();
			ratio[i]=p[i]/w[i];
		}
		float tp;
		float optimalratio[]=new float[n];
		int ch=0;
		do
		{
			System.out.print("1)by ratio");
			System.out.print("2)by profit");
			System.out.print("3)by weight");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1 :sort_r(n,w,p,ratio);
					optimalratio=greedyKnapsack(m,n,w);
					System.out.println("Feasible solution ");
					for(int i=1;i<n;i++)
					{
						System.out.println(optimalratio[i]);
					}
					tp=totalprofit(optimalratio,p);
					System.out.println("total profit "+tp);
					break;
					
			case 2 :sort_p(n,w,p,ratio);
					optimalratio=greedyKnapsack(m,n,w);
					System.out.println("Feasible solution ");
					for(int i=1;i<n;i++)
					{
						System.out.println(optimalratio[i]);
					}
					tp=totalprofit(optimalratio,p);
					System.out.println("total profit "+tp);
					break;
			case 3 :sort_w(n,w,p,ratio);
					optimalratio=greedyKnapsack(m,n,w);
					System.out.println("Feasible solution ");
					for(int i=1;i<n;i++)
					{
						System.out.println(optimalratio[i]);
					}
					tp=totalprofit(optimalratio,p);
					System.out.println("total profit "+tp);
					break;
			}
		}while(ch>=4);
		
	}
	 public static void sort_w(int n,float w[],float p[],float ratio[])
	 {
	 	
	 		for(int i=2;i<n;i++)
	 		{
	 			for(int j=1;j<i;j++)
	 			{
	 				
	 				if(w[i]>w[j]) swap(i,j,w,p,ratio);	
	 			}	
	 		}
	 	
	 	
	 	
	 }
 public static void sort_p(int n,float w[],float p[],float ratio[])
	 {
	 	
	 		for(int i=2;i<n;i++)
	 		{
	 			for(int j=1;j<i;j++)
	 			{
	 				
	 				if(p[i]>p[j]) swap(i,j,w,p,ratio);	
	 			}	
	 		}
	 	
	 	
	 	
	 }
	 public static void sort_r(int n,float w[],float p[],float ratio[])
	 {
	 	
	 		for(int i=2;i<n;i++)
	 		{
	 			for(int j=1;j<i;j++)
	 			{
	 				
	 				if(ratio[i]>ratio[j]) swap(i,j,w,p,ratio);	
	 			}	
	 		}	 	
	 	
	 }
	 
	 public static float totalprofit(float optimalsolution[],float p[])
	 {
		 float tp=0.0f;
		 for(int i=1;i<optimalsolution.length;i++)
		 {
			 tp=tp+(p[i]*optimalsolution[i]);
		}
		 return tp;
	 }
	 public static void swap(int i,int j,float w[],float p[],float r[])
	 {
		 
		 
		 float temp;
		 	temp =w[i];
			w[i]=w[j];
			w[j]=temp;
			
			temp =p[i];
			p[i]=p[j];
			p[j]=temp;
			
			temp =r[i];
			r[i]=r[j];
			r[j]=temp;
			
	 }
	public static float[] greedyKnapsack(float m,int n,float w[])
	{
		int i;
		
		float fes[]=new float[n];	
		for(i=1;i<n;i++)
		{
			fes[i]=0.00f;
			
		}
		float u=m;
		for(i=1;i<n;i++)
		{
			if(w[i]>u)break;
			
			else
			{
				
				fes[i]=1.0f;
				u=(u-w[i]);
				
				
			}
		}
		if(i<n)  //to see all obj are compared .used when capacity is less than weight of an obj
		{
			
			fes[i]=u/w[i];
				
				
		}
		return fes;		
	}
		
}