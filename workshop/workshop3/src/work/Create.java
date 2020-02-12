/*
 * Jinpyo Ju / 134444181 / jju3@myseneca.ca
 * Workshop3
 * 
 * 
 */


package work;

import java.util.Scanner;

public class Create {
	
	int valid_ID() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter ID: ");
		int ID;
		ID=scanner.nextInt();
		return ID;
	}
	
	
	int valid_Balance() {
		boolean checkLoop=true;
		int balance=0;
		while(checkLoop)
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter balance: ");
			balance=scanner.nextInt();
			if(balance>0)
				checkLoop=false;
			else
				System.out.println("Please,Enter Over 0 ");
		}
		return balance;
	}
	
	
	double valid_Rate(){
		Scanner scanner=new Scanner(System.in);
		double rate=0.0;
		int option=0;
		boolean checkLoop=true;
		while(checkLoop)
		{
			System.out.println("=============Option========================");
			System.out.println("5=>4.95% , 4=>3.95, 2=>2.95, 1=>1.95, 0 (under1) =>0.99");
			option=scanner.nextInt();
			if(option>0)
				checkLoop=false;
			else
				System.out.println("Please, Enter correct option");
		}
			
			switch(option)
			{
			case 5: 
				rate=4.95;
				break;
			case 4: 
				rate=3.95;
				break;
			case 2: 
				rate=2.95;
				break;
			case 1: 
				rate=1.95;
				break;
			case 0: 
				rate=0.99;
				break;
			}
			
			
		return rate;
	}

}
