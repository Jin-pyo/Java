/********************************************************************************* 
 * *JAC444 Workshop2 * 
 *  
 * * Name: Jinpyo Ju /  Student ID: 134444181 /  Date: Jan 31 2020 * 
 * * ********************************************************************************/

import java.util.Scanner;

public class Tax {
	
	int filingStatus;
	public static final int SINGLE_FILER = 0;
	public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW=1;
	public static final int MARRIED_SEPARATELY=2;
	public static final int HEAD_OF_HOUSEHOLD=3;
	int[][]brackets;
	double[]rates;
	double taxableIncome;
	
	public Tax() 
	{
		this.filingStatus=0;
		this.brackets=new int[4][6];
		this.rates=new double[6] ;
		this.taxableIncome=0;
	}
	
	
	///////filingStatus////////
	//////////////////////////
	int getFilingStatus() {
		return this.filingStatus;
	}
	void setFilingStatus(int status)
	{
		this.filingStatus=status;
	}
	
	///////////Brackets///////////////
	
	int getBrackets(int row,int col){
		return this.brackets[row][col];
	}
	
	void setBrackets(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				this.brackets[i][j]=arr[i][j];
			}
		}
	}
	
	////////////RATE////////////////
	double getRates(int num)
	{
		return this.rates[num];
	}
	
	void setRates(double[] val)
	{
		for(int i=0;i<val.length;i++)
		{
			this.rates[i]=val[i];
		}
	}
	
	///////////Taxable Income/////
	double getTaxableIncome()
	{
		return this.taxableIncome;
	}
	void setTaxableIncome(double income)
	{
		if(income>0)
		{
			this.taxableIncome=income;
		}
		else
		{
			this.taxableIncome=0;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean check=true;
		int option=0;
		while(check)
		{
			System.out.println("1- personal Tax");
			System.out.println("2- Tax table for taxable Income");
			System.out.println("3- exit");
			
			option=scanner.nextInt();
			//System.out.println(option);
			switch(option) 
			{
			case 1: personalTax();
					break;
			case 2: taxableIncome();
					break;
			case 3: check=false;
					scanner.close();
					break;
			default: System.out.println("Enter Correct Option\n");
			}
		}//while
		
		scanner.close();
	}//main
	
	public static void taxableIncome()
	{
		Scanner scanner = new Scanner(System.in);
		
		Tax Taxable=new Tax();
		
		double income,maxAmt;
		System.out.print("Enter the amount From $ ");
		income=scanner.nextDouble();
		
		System.out.print("Enter the amount To $ ");
		maxAmt=scanner.nextDouble();
		
		Taxable.setTaxableIncome(income);
		
		double []tempRate=Global.rates2001;
		Taxable.setRates(tempRate);
		
		int [][]tempBrakets=Global.brackets2001;
		Taxable.setBrackets(tempBrakets);
	
		//need to call
		showTaxTable(Taxable,maxAmt,0);
		
		tempRate=Global.rates2009;
		Taxable.setRates(tempRate);
		
		tempBrakets= Global.brackets2009;
		Taxable.setBrackets(tempBrakets);
		
		showTaxTable(Taxable,maxAmt,1);
		//need to call
		
		
	}//TaxableIncome
	
	static void showTaxTable(Tax tmp,double maxAmt,int cnt) {
		
		if(cnt==0)
			System.out.print("2001");
		else
			System.out.print("2009");
			
		System.out.println(" tax tables for taxble income from $"+tmp.getTaxableIncome()+ " to " +maxAmt);
					
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("--TaxableIncome ----  Single ---- Married Joint ---- Married separate ---- Head of a House----");
		System.out.println("----------------------------------------------------------------------------------------------");
		
		for(int income=(int)tmp.getTaxableIncome();income<=maxAmt;income+=1000)
		{
			System.out.print("     "+income+"            ");
			
			for(int j=0;j<4;j++)
			{//Single
				double tax=0;
				tax+=(income<=tmp.getBrackets(j, 0)) ? income*tmp.getRates(0) : tmp.getBrackets(j, 0)*tmp.getRates(0);
				
				if(income>tmp.getBrackets(j, 0))
					tax += (income <= tmp.getBrackets(j, 1)) ? (income - tmp.getBrackets(j, 0)) * tmp.getRates(1) : (tmp.getBrackets(j, 1) - tmp.getBrackets(j, 0)) * tmp.getRates(1);
				if (income > tmp.getBrackets(j, 1))
					tax += (income <= tmp.getBrackets(j, 2)) ? (income - tmp.getBrackets(j, 1)) * tmp.getRates(2) :(tmp.getBrackets(j, 2) - tmp.getBrackets(j, 1)) * tmp.getRates(2);
				if (income > tmp.getBrackets(j, 2))
					tax += (income <= tmp.getBrackets(j, 3)) ? (income - tmp.getBrackets(j, 2)) * tmp.getRates(3) :(tmp.getBrackets(j, 3) - tmp.getBrackets(j, 2)) * tmp.getRates(3);
				if (income > tmp.getBrackets(j, 3))
					tax += (income <= tmp.getBrackets(j, 4)) ? (income - tmp.getBrackets(j, 3)) * tmp.getRates(4) :(tmp.getBrackets(j, 4) - tmp.getBrackets(j, 3)) * tmp.getRates(4);
				if (income > tmp.getBrackets(j, 4))
					tax += (income - tmp.getBrackets(j, 4)) * tmp.getRates(5);
				System.out.print("|     "+tax+"      |");
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println(" ");
	}
	
	public static void personalTax()
	{
		Scanner scanner = new Scanner(System.in);
		
		int status;
		boolean check=true;
		
		//Create Tax class
		Tax personal = new Tax();
		
		while(check)
		{
			System.out.println("0- single filer");
			System.out.println("1-  married jointly or qualifying widow(er)");
			System.out.println("2-  married separately");
			System.out.println("3- head of household");
			//System.out.println("4- exit");
			System.out.print("Enter the filling status: ");
			
			personal.setFilingStatus(scanner.nextInt());
			status=personal.getFilingStatus();
			
			if(status>HEAD_OF_HOUSEHOLD||status<SINGLE_FILER)
			{
				System.out.println("Enter Correct options\n");
			}
			else
			{
				System.out.print("Enter the Taxable Income: $ ");
				personal.setTaxableIncome(scanner.nextDouble());
				
				double []tempRate=Global.rates2009;
				personal.setRates(tempRate);
				
				int [][]tempBrakets=Global.brackets2009;
				personal.setBrackets(tempBrakets);
				
				System.out.println("Tax is: "+personal.getTax(personal));
				System.out.println(" ");
				
				check=false;
			}//1st-else
			
		}//while
		
		
	}//personalTax_Method
	
	
	///////////getTax/////////
	double getTax(Tax tmp) {
		//Scanner scanner = new Scanner(System.in);
		double tax=0;
		double income=tmp.getTaxableIncome();
		
		int status=tmp.getFilingStatus();
		
			tax+=(income<=tmp.getBrackets(status, 0)) ? income*tmp.getRates(0) : tmp.getBrackets(status, 0)*tmp.getRates(0);
			
			if(income>tmp.getBrackets(status, 0))
				tax += (income <= tmp.getBrackets(status, 1)) ? (income - tmp.getBrackets(status, 0)) * tmp.getRates(1) : (tmp.getBrackets(status, 1) - tmp.getBrackets(status, 0)) * tmp.getRates(1);
			if (income > tmp.getBrackets(status, 1))
				tax += (income <= tmp.getBrackets(status, 2)) ? (income - tmp.getBrackets(status, 1)) * tmp.getRates(2) :(tmp.getBrackets(status, 2) - tmp.getBrackets(status, 1)) * tmp.getRates(2);
			if (income > tmp.getBrackets(status, 2))
				tax += (income <= tmp.getBrackets(status, 3)) ? (income - tmp.getBrackets(status, 2)) * tmp.getRates(3) :(tmp.getBrackets(status, 3) - tmp.getBrackets(status, 2)) * tmp.getRates(3);
			if (income > tmp.getBrackets(status, 3))
				tax += (income <= tmp.getBrackets(status, 4)) ? (income - tmp.getBrackets(status, 3)) * tmp.getRates(4) :(tmp.getBrackets(status, 4) - tmp.getBrackets(status, 3)) * tmp.getRates(4);
			if (income > tmp.getBrackets(status, 4))
				tax += (income - tmp.getBrackets(status, 4)) * tmp.getRates(5);
			
		return tax;
	}//getTax()
	
	
}//class
