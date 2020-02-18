/*-----------------------------------------
 * Java Workshop4 Task1
 *	Name : Jinpyo Ju  
 *  SID  : 134444181
 *  Date : Feb 14,2020
 * 
 * ------------------------------------------
 */

package Workshop4;

import java.util.Scanner;


public class Task1{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int numOfBank=0;
		int limit=0;
		
		System.out.print("Number of banks: ");
			numOfBank=checkValue(1);
				
		System.out.print("Minimum asset limit: ");
			limit=checkValue(0);
			
		Bank[] bank=new Bank[numOfBank];
		
		for(int i=0;i<numOfBank;i++)
		{
			int balance=0, numOfBankLoaned=0;
			System.out.println("=======================");
			System.out.print("Bank #"+i+" -> ");
			System.out.print("Balance: ");
				balance=checkValue(0);
			
			System.out.print("Number of banks Loaned: ");
				numOfBankLoaned=checkValue(1);
			
				if(numOfBankLoaned>numOfBank)
				{
					System.out.println("It Couldn't over" + numOfBank+"/ Try again ");
					i--;
				}
				else
				{
					bank[i]=new Bank(i,balance,numOfBankLoaned);
					
					for(int j=0;j<numOfBankLoaned;j++)
					{
						System.out.println("-----------------------");
						System.out.print("Bank Id: ");
						int id=checkValue(0);
						if(id<numOfBank && j!=id)
						{
							System.out.print("Amount: ");
							double amt=checkValue();
							
							bank[i].setIdAmt(j, id, amt);
						}
						else if(j==id)
						{
							System.out.println("You can't borrow yourself");
							j--;
						}
						
						else
						{
							System.out.println("This bank doesn't exist ");
							j--;
						}
					}
				}
		}
		System.out.println("=======================");
		
		/*
		for(int i=0;i<numOfBank;i++)
		{
			System.out.println(bank[i].getId()+ " "+bank[i].getBalance());
			bank[i].show();
			
			System.out.println(" ");
		}
		*/
		
		for(int i=0;i<numOfBank;i++)
		{
			if(bank[i].getBalance()<limit)
			{
				//System.out.println("LL"+i+" "+bank[i].getBalance());
				for(int j=0;j<numOfBank;j++)
				{
					bank[j].filter(i);
				}
			}
			
		}
		System.out.println("Number of banks entered: "+numOfBank);
		System.out.println("Number of unsafe banks are :");
		for(int i=0;i<numOfBank;i++)
		{
			if(bank[i].getBalance()<limit)
				System.out.println("Bank wiht id "+bank[i].getId());
		}
		
		
	}//main
	
	static int checkValue(int min)
	{
		Scanner scanner= new Scanner(System.in);
		boolean check=true;
		int val = 0;
		while(check)
		{
			val=scanner.nextInt();
			if(val>=min)
				check=false;
			else
				System.out.println("Eneter, over "+min+" value");
		}
		return val;
	}
	
	static double checkValue()
	{
		Scanner scanner= new Scanner(System.in);
		boolean check=true;
		double val = 0;
		while(check)
		{
			val=scanner.nextDouble();
			if(val>0)
				check=false;
			else
				System.out.println("Eneter, Correct value");
		}
		return val;
	}
	
	
}// Task2 class