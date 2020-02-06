package work;
import java.util.Date;
import java.util.Scanner;


class Task1 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Option option = new Option();
		Create create = new Create();
		Loan loan = new Loan();
		
		boolean check=true;
		int position=0;
		
		Account[] acc=new Account[0];
		
		
		while(check)
		{
			int startingOption=0;
			System.out.println("Do you wanna start Bank Wroking? \n 1:Yes 2: EXIT");
			startingOption=scanner.nextInt();
			
			if(startingOption==1)
			{
				boolean checkCustomerLoop=true;
				while(checkCustomerLoop)
				{
					
					System.out.println("Do you have ID? 1.yes 2.No");
					int checkCustomer=scanner.nextInt();
					
					if(checkCustomer==1 && acc.length>0)
					{
						boolean checkIDLoop=true;
						int tmpID=0;
						System.out.println("What is your ID");
						tmpID=scanner.nextInt();
						while(checkIDLoop)
						{
							for(int i=0;i<acc.length;i++)
							{
								
								if(tmpID==acc[i].getId())
								{
									checkIDLoop=false;
									position=i;	
								}
							}
							if(checkIDLoop==true)
							{
								System.out.println("Please enter Correct ID");
							}
						}
						checkCustomerLoop=false;
					}
					else if(checkCustomer==2)
					{
						System.out.println("================================");
						System.out.println("======Create Account ===========");
						System.out.println("================================");
						int id=create.valid_ID();
						double balance=create.valid_Balance();
						double rate=create.valid_Rate();
						Account tmp=new Account();
						tmp.setId(id);
						tmp.setBalance(balance);
						tmp.setRate(rate);
						//System.out.println("acc.length is "+acc.length);
						Account [] temp=new Account[acc.length+1];
						for(int i=0;i<acc.length;i++)
						{
							temp[i]=acc[i];
						}
						temp[acc.length]=tmp;
						acc=temp;
						position=temp.length-1;
						//System.out.println("position"+position);
						checkCustomerLoop=false;
					}
					else
					{
						System.out.println("Choice, Correct Value");
					}						
				}//checkCustomerLoop
				
				//option
				option.SelectOption(acc[position]);
			
				//Calculation for Loan
				System.out.println("Do you want to calculate about Loan? 1: Yes / Others: No");
				int checkLoan=scanner.nextInt();
				if(checkLoan==1)
					loan.calculateLoan();
			
			}//startingOption
			else
			{
				System.out.println("Bye Bye");
				check=false;
			}
			
		
	}// body while
	
	}} //Task1Class
	
	


