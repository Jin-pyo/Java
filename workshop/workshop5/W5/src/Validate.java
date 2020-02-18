import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;


public class Validate {
	Scanner scanner = new Scanner(System.in);
	
	private String phoneNum;
	
	char letters [][]= {{'0'},{'1'},{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},{'P','R','S'},{'T','U','V'},{'W','X','Y'}};
	//int cnt=0;
	
	void convert(String phone, StringBuilder sb,int cnt)
	{
		if(cnt==phone.length())
		{
			try {
				FileWriter fout=new FileWriter("C:\\Users\\jjp99\\Desktop\\result.txt");
				String tmp=sb+"\n";
				fout.write(tmp,0,tmp.length());
				//cnt=0;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		int location=Character.getNumericValue(phoneNum.charAt(cnt));
		//System.out.println("L "+location);
		char [] currentDigit=letters[location];
		
		for(int i=0;i<3;i++)
		{
			sb.append(currentDigit[i]);
			System.out.print(sb+" ");
			convert(phone,sb,cnt+1);
			sb.deleteCharAt(sb.length()-1);
		}
		
		
	}
	
	
	
	String getNumber() 
	{
		boolean checkLoop=true;
		while(checkLoop)
		{
			try {
				
				System.out.print("Enter phone number: ");
				phoneNum=scanner.nextLine();
				
				/*
				if(this.phoneNum.length()>7 ||this.phoneNum.length()<7)
				{
					System.out.println("Please Enter Only 7 digits");
					this.phoneNum=" ";
				}
				*/
				if(this.phoneNum.contains("0")|| this.phoneNum.contains("1"))
				{
					System.out.println("You can't type 0 or 1");
					this.phoneNum=" ";
				}
				else
				{
					checkLoop=false;
				}
				
			}catch(InputMismatchException e)
			{
				System.out.println("Error "+ e);
				this.phoneNum=" ";
				System.out.println("Try again");
			}
		}
		
		return phoneNum;
	}
	
	
}
