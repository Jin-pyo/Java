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
		
		//while(check)
		{
			System.out.println("1- personal Tax");
			System.out.println("2- Tax table for taxable Income");
			System.out.println("3- exit");
			int option;
			option=scanner.nextInt();
			//System.out.println(option);
			switch(option) 
			{
			case 1: personalTax();
					break;
			case 2: TaxableIncome();
					break;
			case 3: check=false;
					break;
			default: System.out.println("Enter Correct Option\n");
					
			}
		}//while
		
		scanner.close();
	}//main
	
	public static void TaxableIncome()
	{
		Scanner scanner = new Scanner(System.in);
		
		Tax Taxable=new Tax();
		
		double income,maxAmt;
		System.out.print("Enter the amount From $ ");
		income=scanner.nextDouble();
		
		System.out.print("Enter the amount To $ ");
		maxAmt=scanner.nextDouble();
		
		Taxable.setTaxableIncome(income);
		
		double []tempRate=new double[]{0.15,0.275,0.305,0.355,0.391};
		Taxable.setRates(tempRate);
		
		int [][]tempBrakets=new int[][]{{27050,65550,136750,297350},{45200,109250,166500,297350},{22600,54625,83250,148675},{36250,93650,151650,297350}};
		Taxable.setBrackets(tempBrakets);
	
		//need to call
		showTaxTable(Taxable,maxAmt);
		
		tempRate=new double[]{0.1,0.15,0.25,0.28,0.33,0.35};
		Taxable.setRates(tempRate);
		
		tempBrakets=new int[][]{{8350,33950,82250,171550,372950},{16700,67900,137050,208850,372950},{8350,33950,68525,104425,186475},{11950,45500,117450,190200,372950}};
		Taxable.setBrackets(tempBrakets);
		
		showTaxTable(Taxable,maxAmt);
		//need to call
		
		scanner.close();
	}//TaxableIncome
	
	static void showTaxTable(Tax tmp,double maxAmt) {
		for(int income=(int)tmp.getTaxableIncome();income<maxAmt;income+=1000)
		{
			System.out.print(income+"    ");
			
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
				System.out.print(tax+"    \n");
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
			
			if(personal.getFilingStatus()>HEAD_OF_HOUSEHOLD||personal.getFilingStatus()<SINGLE_FILER)
			{
				System.out.println("Enter Correct options\n");
			}
			else
			{
				System.out.print("Enter the Taxable Income: $ ");
				personal.setTaxableIncome(scanner.nextDouble());
				
				double []tempRate=new double[]{0.1,0.15,0.25,0.28,0.33,0.35};
				personal.setRates(tempRate);
				
				int [][]tempBrakets=new int[][]{{8350,33950,82250,171550,372950},{16700,67900,137050,208850,372950},{8350,33950,68525,104425,186475},{11950,45500,117450,190200,372950}};
				personal.setBrackets(tempBrakets);
				
				System.out.println("Tax is: "+personal.getTax(personal));
				System.out.println(" ");
				
				check=false;
			}//1st-else
			
		}//while
		
	}//personalTax_Method
	
	
	///////////getTax/////////
	double getTax(Tax tmp) {
		Scanner scanner = new Scanner(System.in);
		double tax=0;
		double income=tmp.getTaxableIncome();
		
	
		switch(tmp.getFilingStatus())
		{
		case SINGLE_FILER:
			
			tax+=(income<=tmp.getBrackets(0, 0)) ? income*tmp.getRates(0) : tmp.getBrackets(0, 0)*tmp.getRates(0);
			
			if(income>tmp.getBrackets(0, 0))
				tax += (income <= tmp.getBrackets(0, 1)) ? (income - tmp.getBrackets(0, 0)) * tmp.getRates(1) : (tmp.getBrackets(0, 1) - tmp.getBrackets(0, 0)) * tmp.getRates(1);
			if (income > tmp.getBrackets(0, 1))
				tax += (income <= tmp.getBrackets(0, 2)) ? (income - tmp.getBrackets(0, 1)) * tmp.getRates(2) :(tmp.getBrackets(0, 2) - tmp.getBrackets(0, 1)) * tmp.getRates(2);
			if (income > tmp.getBrackets(0, 2))
				tax += (income <= tmp.getBrackets(0, 3)) ? (income - tmp.getBrackets(0, 2)) * tmp.getRates(3) :(tmp.getBrackets(0, 3) - tmp.getBrackets(0, 2)) * tmp.getRates(3);
			if (income > tmp.getBrackets(0, 3))
				tax += (income <= tmp.getBrackets(0, 4)) ? (income - tmp.getBrackets(0, 3)) * tmp.getRates(4) :(tmp.getBrackets(0, 4) - tmp.getBrackets(0, 3)) * tmp.getRates(4);
			if (income > tmp.getBrackets(0, 4))
				tax += (income - tmp.getBrackets(0, 4)) * tmp.getRates(5);
			break;
				
		case MARRIED_JOINTLY_OR_QUALIFYING_WIDOW:
			
			tax+=(income<=tmp.getBrackets(1, 0)) ? income*tmp.getRates(0) : tmp.getBrackets(1, 0)*tmp.getRates(0);
			
			if(income>tmp.getBrackets(1, 0))
				tax += (income <= tmp.getBrackets(1, 1)) ? (income - tmp.getBrackets(1, 0)) * tmp.getRates(1) : (tmp.getBrackets(1, 1) - tmp.getBrackets(1, 0)) * tmp.getRates(1);
			if (income > tmp.getBrackets(1, 1))
				tax += (income <= tmp.getBrackets(1, 2)) ? (income - tmp.getBrackets(1, 1)) * tmp.getRates(2) :(tmp.getBrackets(1, 2) - tmp.getBrackets(1, 1)) * tmp.getRates(2);
			if (income > tmp.getBrackets(1, 2))
				tax += (income <= tmp.getBrackets(1, 3)) ? (income - tmp.getBrackets(1, 2)) * tmp.getRates(3) :(tmp.getBrackets(1, 3) - tmp.getBrackets(1, 2)) * tmp.getRates(3);
			if (income > tmp.getBrackets(1, 3))
				tax += (income <= tmp.getBrackets(1, 4)) ? (income - tmp.getBrackets(1, 3)) * tmp.getRates(4) :(tmp.getBrackets(1, 4) - tmp.getBrackets(1, 3)) * tmp.getRates(4);
			if (income > tmp.getBrackets(1, 4))
				tax += (income - tmp.getBrackets(1, 4)) * tmp.getRates(5);
			break;
			
		case MARRIED_SEPARATELY:
			tax+=(income<=tmp.getBrackets(2, 0)) ? income*tmp.getRates(0) : tmp.getBrackets(2, 0)*tmp.getRates(0);
			
			if(income>tmp.getBrackets(2, 0))
				tax += (income <= tmp.getBrackets(2, 1)) ? (income - tmp.getBrackets(2, 0)) * tmp.getRates(1) : (tmp.getBrackets(2,1) - tmp.getBrackets(2, 0)) * tmp.getRates(1);
			if (income > tmp.getBrackets(2, 1))
				tax += (income <= tmp.getBrackets(2, 2)) ? (income - tmp.getBrackets(2, 1)) * tmp.getRates(2) :(tmp.getBrackets(2,2) - tmp.getBrackets(2, 1)) * tmp.getRates(2);
			if (income > tmp.getBrackets(2, 2))
				tax += (income <= tmp.getBrackets(2, 3)) ? (income - tmp.getBrackets(2, 2)) * tmp.getRates(3) :(tmp.getBrackets(2,3) - tmp.getBrackets(2, 2)) * tmp.getRates(3);
			if (income > tmp.getBrackets(2, 3))
				tax += (income <= tmp.getBrackets(2, 4)) ? (income - tmp.getBrackets(2, 3)) * tmp.getRates(4) :(tmp.getBrackets(2,4) - tmp.getBrackets(2,3)) * tmp.getRates(4);
			if (income > tmp.getBrackets(2, 4))
				tax += (income - tmp.getBrackets(2, 4)) * tmp.getRates(5);
			break;
			
		case HEAD_OF_HOUSEHOLD:
			tax+=(income<=tmp.getBrackets(3, 0)) ? income*tmp.getRates(0) : tmp.getBrackets(3, 0)*tmp.getRates(0);
			
			if(income>tmp.getBrackets(3, 0))
				tax += (income <= tmp.getBrackets(3, 1)) ? (income - tmp.getBrackets(3, 0)) * tmp.getRates(1) : (tmp.getBrackets(3,1) - tmp.getBrackets(3, 0)) * tmp.getRates(1);
			if (income > tmp.getBrackets(3, 1))
				tax += (income <= tmp.getBrackets(3, 2)) ? (income - tmp.getBrackets(3, 1)) * tmp.getRates(2) :(tmp.getBrackets(3,2) - tmp.getBrackets(3, 1)) * tmp.getRates(2);
			if (income > tmp.getBrackets(3, 2))
				tax += (income <= tmp.getBrackets(3, 3)) ? (income - tmp.getBrackets(3, 2)) * tmp.getRates(3) :(tmp.getBrackets(3,3) - tmp.getBrackets(3, 2)) * tmp.getRates(3);
			if (income > tmp.getBrackets(3, 3))
				tax += (income <= tmp.getBrackets(3, 4)) ? (income - tmp.getBrackets(3, 3)) * tmp.getRates(4) :(tmp.getBrackets(3,4) - tmp.getBrackets(3, 3)) * tmp.getRates(4);
			if (income > tmp.getBrackets(3, 4))
				tax += (income - tmp.getBrackets(3, 4)) * tmp.getRates(5);
			break;
		default : System.out.println("Error: invalid status");
		}//switch
		
		scanner.close();
		return tax;
	}//getTax()
	
	
	
	
	
	

	
	
}//class
