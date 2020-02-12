/*
 * Jinpyo Ju / 134444181 / jju3@myseneca.ca
 * Workshop3
 * 
 * 
 */


package work;
import java.util.Scanner;

public class Loan {

	public void calculateLoan() 
	{
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("How much are you going to borrow?");
		double amount=scanner.nextDouble();
		
		double rate=0.0;
		int option=0;
		boolean check=true;
		while(check)
		{
			System.out.println("=============Option========================");
			System.out.println("5=>4.95% , 4=>3.95, 2=>2.95, 1=>1.95, 0 (under1) =>0.99");
			option=scanner.nextInt();
			if(option>0)
				check=false;
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
		double totalAmt;
		totalAmt= amount+(amount*(rate/100));
		

		
		System.out.println("==========Result of loan=================");
		System.out.println("If you Borrow"+amount+" for "+option+" rate is "+rate);
		System.out.println("Total amt: "+totalAmt);
		System.out.println("You have to pay for: "+totalAmt/(option*12)+ " months\n");

		
		
	}
}
