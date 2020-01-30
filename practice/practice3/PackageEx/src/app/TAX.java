
import java.util.Scanner;

public class Tax {
	public static final int SINGLE_FILER = 0;
	public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
	public static final int MARRIED_SEPARATELY = 2;
	public static final int HEAD_OF_HOUSEHOLD = 3;
	int filingStatus; //0 to 3 for the maritial status
	int[][] brackets; //stores tax brackets for status
	double[] rates; //tax rates per bracket
	double taxableIncome; //stores taxable income
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choice = 0;
		boolean on = true;
		Tax tax = new Tax();
		/*System.out.println("Option Menu");
		System.out.println("1. Compute Personal Income Tax");
		System.out.println("2. Print the tax tables for taxable income (with range)");
		System.out.println("3. Exit");
		System.out.print("Select option(1 to 3): ");
		choice = in.nextInt();*/
		while (on) {
			System.out.println("Option Menu");
			System.out.println("1. Compute Personal Income Tax");
			System.out.println("2. Print the tax tables for taxable income (with range)");
			System.out.println("3. Exit");
			System.out.print("Select option(1 to 3): ");
			choice = in.nextInt();
			
			switch(choice) {
			case 1:
				PersonalInformation(tax);
				break;
			case 2:
				PrintTaxTables();
				break;
			case 3:
				on = false;
				in.close();
				break;
			default:
				System.out.println("Invalid Character");
			}
		}
		
	}
	
	public static void PersonalInformation(Tax tax) {
		Scanner in = new Scanner(System.in);
		int x = 0;
		int y = 0;
		boolean on = true;
		while(on) {
			if(tax.getStatus() == 23) {
				System.out.println("Marital Statuses");
				System.out.println("0. Single Filer");
				System.out.println("1. Married Filing Jointly or Widow");
				System.out.println("2. Married Filing Separately");
				System.out.println("3. Head of Household");
				System.out.print("Select Marital Status: ");
				tax.setStatus(in.nextInt());
			}
			if(tax.getStatus() < 7 && tax.getStatus() >= 0) {
				if(tax.getTaxable() == 0) {
					System.out.println("");
					System.out.print("Enter Taxable Income: ");
					tax.setTaxableIncome(in.nextDouble());
					//in.close();
				}
				if(tax.getTaxable() != 0 && tax.getStatus() != 23) {
					System.out.println("Tax is : $" + tax.getTax(tax));
					//System.out.println("its working!!");
					on = false;
				}
				else {
					System.out.println("Status: " + tax.filingStatus + " Income: " +  tax.taxableIncome);
					on = false;
				}
			}
			else {
				System.out.println("Invalid Value Selected, Try Again");
				break;
				/*if(x != 0)
					x--;
				x++;*/
			}
			
		}
		
	}
	
	public static void PrintTaxTables() {
		Scanner in = new Scanner(System.in);
		//Finish Later
	}
	
	public Tax() {
		this.filingStatus = 23;
		this.brackets = new int[6][2];
		this.rates = new double[] {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
		this.taxableIncome = 0;
	}
	
	public Tax(int status, int bracketX, int bracketY, int rate, int income) {
		this.filingStatus = status;
		this.brackets = new int[bracketX][bracketY];
		this.rates = new double[rate];
		this.taxableIncome = income;
	}
	public void setStatus(int status) {
		this.filingStatus = status;
	}
	
	public void setRates(double taxRate, int status) {
		this.rates[status] = taxRate;
	}
	
	public void setBrackes(int[] value) {
		System.out.println("1d Array size: " + value.length + " 2d Array Size: " + brackets.length + " " + brackets[0].length);
		int i = 0;
		for(int x = 0; x < brackets.length; x++) {
			for(int y = 0; y <brackets[0].length; y++) {
				this.brackets[x][y] = value[i];
				i++;
			}
			//i++;
		}
	}
	
	public void setTaxableIncome(double tIncome) {
		this.taxableIncome = tIncome;
	}
	
	public int getStatus() {
		return this.filingStatus;
	}
	
	public double getRates(int numb) {
		return this.rates[numb];
	}
	
	public int getBrackets(int x, int y) {
		return this.brackets[x][y];
	}
	
	public double getTaxable() {
		return this.taxableIncome;
	}
	
	public double getTax(Tax tax) {
		double taxMoney = 0;
		
		switch(tax.filingStatus) {
		case 0:
			tax.setBrackes(new int[] {0, 8350, 8531, 33950, 33951, 82250, 82251, 171550, 171551, 372950, 372951, 0});
			taxMoney = CalcTax(tax.taxableIncome, tax);
			break;
		case 1:
			tax.setBrackes(new int[] {0, 16700, 16701, 679000, 679001, 137050, 137051, 208850, 208851, 372950, 372951, 0});
			taxMoney = CalcTax(tax.taxableIncome, tax);
			break;
		case 2:
			tax.setBrackes(new int[] {0, 8350, 8351, 33950, 33951, 68525, 68526, 104425, 104426, 186475, 186476, 0});
			taxMoney = CalcTax(tax.taxableIncome, tax);
			break;
		case 3:
			tax.setBrackes(new int[] {0, 11950, 11951, 45500, 45501, 117450, 117451, 190200, 190201, 372950, 372951, 0});
			taxMoney = CalcTax(tax.taxableIncome, tax);
			break;
		default:
			System.out.println("Erro with method getTax(Tax), wrong fillingStatus");
			break;
		}
		
		return taxMoney;
	}
	
	public double CalcTax(double money, Tax tax) {
		double taxPercent = 0;
		
		if(money <= tax.getBrackets(0, 1)) {
			taxPercent = tax.getRates(0);
		}
		else if(money >= getBrackets(1, 0) && money >= getBrackets(1, 1)) {
			taxPercent = tax.getRates(1);
		}
		else if(money >= getBrackets(2, 0) && money >= getBrackets(2, 1)) {
			taxPercent = tax.getRates(2);
		}
		else if(money >= getBrackets(3, 0) && money >= getBrackets(3, 1)) {
			taxPercent = tax.getRates(3);
		}
		else if(money >= getBrackets(4, 0) && money >= getBrackets(4, 1)) {
			taxPercent = tax.getRates(4);
		}
		else {
			taxPercent = tax.getRates(5);
		}
		
		return money * taxPercent;
	}
}
