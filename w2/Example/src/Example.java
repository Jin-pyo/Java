import java.util.Scanner;

public class Example {
	public static void main(String[] args){
		int value =Maximum.max(4,5);
		
		System.out.println("The Maximum value is : "+value);
	
		
		/////////////
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 1st value: ");
		int val1=input.nextInt();
		System.out.print("Enter 2nd value: ");
		int val2=input.nextInt();
		
		int result = Maximum.max(val1,val2);
		System.out.println("Max : "+result);
		
	}
	
	
}
class Maximum{
	public static int max(int a,int b){
		if(a<b)
			return b;
		else
			return a;
	}
}