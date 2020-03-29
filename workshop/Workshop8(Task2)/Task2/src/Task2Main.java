/**********************************************
Workshop 8
Course: JAC444NAB
Last Name:Ju
First Name:Jinpyo
ID: 134444181
This assignment represents my own work in accordance with Seneca
Academic Policy.
Signature
Date:Mar25, 2020
**********************************************/

import java.util.Scanner;

public class Task2Main {
	
	public static ArrayProcessor counter(double value){
  	  return array->{
  		  int cnt=0;
  		  for(int i=0;i<array.length;i++)
  		  {
  			  if(value==array[i])
  			  {
  				  cnt++;
  			  }
  		  }
  		  System.out.println(cnt);
  		  return cnt;
  	  };
    }
    
    public static void main(String[] args) {
    	Scanner scanner=new Scanner(System.in);
    	////MAX
    	ArrayProcessor max= (array)->{
    		double maxValue=array[0];
    		
    		for(int i=1;i<array.length;i++)
    		{
    			if(array[i]>maxValue)
    			{
    				maxValue=array[i];
    			}
    		}
    		
    		return maxValue;
    	};
    	
    	////Min
    	ArrayProcessor min=(array)->{
    		double minValue=array[0];
    		
    		for(int i=1;i<array.length;i++)
    		{
    			if(minValue>array[i])
    			{
    				minValue=array[i];
    			}
    		}
    		return minValue;
    	};
        
	    ////SUM///////
	      ArrayProcessor sum= (array)->{
	    	  double total=0;
	    	  for(int i=0;i<array.length;i++)
	    	  {
	    		  total+=array[i];
	    	  }
	    	  return total;
	      };
      
	      /////AVG
	      ArrayProcessor avg=(array)->{
	    	 double temp=0;
	    	 
	    	 for(int i=0;i<array.length;i++)
	    	 {
	    		 temp +=array[i];
	    	 }
	    	 
	    	 temp= temp/array.length;
	    	 
	    	 return temp;
	    	  
	      };
	      
	      
     ///////MAIN 
      double[] List1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        
      System.out.println("MAX: "+ max.set(List1));
      System.out.println("MIN: "+ min.set(List1));
      System.out.println("SUM: "+ sum.set(List1));
      System.out.println("AVG: "+ avg.set(List1));
      
      /////////COUNTER
      double[] List2 = {14.9, 14.9, 24, 2.4, 2.4, -2.4, 88};
      double check=0;
      System.out.println("=======COUNT=========");
      System.out.println("Enter the vlaue you want to find: ");
      check=scanner.nextDouble();
      
      double cnt=counter(check).set(List2);
      System.out.println("The count of "+check+" : "+cnt);
      
    }
    
    
} 