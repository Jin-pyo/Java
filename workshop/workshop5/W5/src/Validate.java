import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.*;
import java.io.*;


public class Validate {
	Scanner scanner = new Scanner(System.in);
	
	private String phoneNum;
	
	char letters [][]= {{'0'},{'1'},{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},{'P','R','S'},{'T','U','V'},{'W','X','Y'}};
	
	private String[] result = {};
	
	
	void write() {
		
		FileWriter fout;
		try {
			fout = new FileWriter("C:\\Users\\jjp99\\Desktop\\result.txt");
			
			for(int i=0;i<result.length;i++)
			{
				fout.write(result[i]);
			}
			
			fout.close();
			System.out.println("Writing is success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	void convert(String phone, StringBuilder sb,int cnt)
	{
		if(cnt==phone.length())
		{
			try {
				String []tmp=new String[this.result.length+1];
				
				for(int i=0;i<result.length;i++)
				{
					tmp[i]=result[i];
				}
				tmp[tmp.length-1]=sb+"\n";
				result=tmp;
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Error Array" + e);
			}
			return;
		}
		
		
		int location=Character.getNumericValue(phoneNum.charAt(cnt));
		char [] currentDigit=letters[location];
		
		for(int i=0;i<3;i++)
		{
			sb.append(currentDigit[i]);
			//System.out.print(sb+" ");
			convert(phone,sb,cnt+1);
			sb.deleteCharAt(sb.length()-1);
		}
		
		
	}
	
	String getNumber() 
	{
		boolean checkLoop=true;
		while(checkLoop)
		{
				System.out.print("Enter phone number: ");
				phoneNum=scanner.nextLine();
				
				
				
				if(this.phoneNum.length()>7 ||this.phoneNum.length()<7)
				{
					System.out.println("Please Enter Only 7 digits");
					this.phoneNum=" ";
					System.out.println("Try again");
				}
				
				else if(this.phoneNum.contains("0")|| this.phoneNum.contains("1"))
				{
					System.out.println("You can't type 0 or 1");
					this.phoneNum=" ";
					System.out.println("Try again");
				}
				else
				{
					boolean positiveValueCheck=true;
					for(int i=0;i<phoneNum.length();i++)
					{
						if(Character.getNumericValue(phoneNum.charAt(i))<1)
						{
							positiveValueCheck=false;
						}
					}
					if(positiveValueCheck)
						checkLoop=false;
					else
						System.out.println("Please, only Positive value");
				}
				
		}
		
		return phoneNum;
	}
	
	
}
