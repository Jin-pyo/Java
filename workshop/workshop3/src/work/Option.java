package work;
import java.util.Scanner;
public class Option {
	
	public void SelectOption(Account acc)
	{
		Scanner scanner=new Scanner(System.in);
		boolean checkOptionLoop=true;
		while(checkOptionLoop)
		{
			System.out.println("1: Withdraw / 2: Deposite / 3: Information & History / 4: Exit");
			int option=scanner.nextInt();
			
			if(option==1)
			{
				double tmpAmt=0;
				System.out.println("How much do you wnat?: ");
				tmpAmt=scanner.nextDouble();
				if(acc.getBalance()>=tmpAmt)
				{
					System.out.println("Withdraw is success");
					System.out.println("Now your Balance: "+acc.withdraw(tmpAmt));
					
				}
				else
				{
					System.out.println("you don't have enough money");
					System.out.println("Your balance is: "+acc.getBalance());
				}
			}
			else if(option==2)
			{
				double tmpAmt=0;
				System.out.println("How much do you wnat?: ");
				tmpAmt=scanner.nextDouble();
				if(tmpAmt>0)
				{
					System.out.println("Deposite is success");
					System.out.println("Now your Balance: "+acc.deposit(tmpAmt));
				}
				else
					System.out.println("Incorrect Amount");
			}
			else if(option==3)
			{
				System.out.println("Balance: "+acc.getBalance());
				System.out.println("Monthly Interest :"+acc.getMonthlyInterest());
				System.out.println("Account was created on "+acc.getDateCreated());
				
				acc.showHistory();
			}
			else if(option==4)
			{
				checkOptionLoop=false;
			}
			else
			{
				System.out.println("Type Correct value");
			}
			
		}
	}
	
	
}
