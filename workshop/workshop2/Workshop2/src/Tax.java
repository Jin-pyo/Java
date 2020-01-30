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
	
	public Tax(int fillingStatus,int[][]brackets,double[]rates,double taxableIncome)
	{
		
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
		
	}
	
	////////////RATE////////////////
	double getRates(int num)
	{
		return this.rates[num];
	}
	
	void setRates(double[] val)
	{
		
	}
	
	///////////Taxable Income/////
	double getTaxableIncome()
	{
		return this.taxableIncome;
	}
	void setTaxableIncome(double income)
	{
		this.taxableIncome=income;
	}
	
	
	
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int option;
		boolean check=true;
		
		while(check)
		{
			System.out.println("1- personal Tax");
			System.out.println("2- Tax table for taxable Income");
			System.out.println("3- exit");
			
			option=scanner.nextInt();
			
			switch(option) 
			{
			case 1: personalTax();
					break;
			case 2: TaxableIncome();
					break;
			case 3: check=false;
					break;
			default: System.out.println("Enter Correct Option");
			
			}
		}//while
		
		scanner.close();
	}//main
	
	public static void personalTax()
	{
		Scanner scanner = new Scanner(System.in);
		
		int status;
		boolean check=false;
		
		//Create Tax class
		Tax personal = new Tax();
		
		while(check)
		{
			System.out.println("0- single filer");
			System.out.println("1-  married jointly or qualifying widow(er)");
			System.out.println("2-  married separately");
			System.out.println("3- head of household");
			System.out.println("Enter the filling status: ");
			
			personal.setFilingStatus(scanner.nextInt());
			
			if(personal.getFilingStatus()>HEAD_OF_HOUSEHOLD||personal.getFilingStatus()<SINGLE_FILER)
			{
				System.out.println("Enter Correct options");
			}
			else
			{
				System.out.println("Enter the Taxable Income: $");
				personal.setTaxableIncome(scanner.nextDouble());
				
				double []tempRate=new double[]{10,15,25,28,33,35};
				personal.setRates(tempRate);
				
				int [][]tempBrakets=new int[][]{{8350,33950,82250,171550,372950},{16700,67900,137050,208850,372950},{8350,33950,68525,104425,186475},{11950,45500,117450,190200,372950}};
				personal.setBrackets(tempBrakets);
				
				System.out.println(personal.getTax(personal));
				
				check=true;
			}//1st-else
			
		}//while
		
	}//personalTax_Method
	
	
	///////////getTax/////////
	double getTax(Tax tmp) {
		Scanner scanner = new Scanner(System.in);
		int tax=0;
		
		switch(tmp.getFilingStatus())
		{
		case SINGLE_FILER:
			double income=tmp.getTaxableIncome();
			tax+=(income<=tmp.getBrackets(0, 0)) ? income*tmp.getRates(0) : tmp.getBrackets(0, 0)*tmp.getRates(0);
			
			if(income>tmp.getBrackets(0, 0))
				tax+=(income<=)
				
			
				
		
		}
		
		
		
		
		return tax;
	}

}//class
