import java.util.Scanner;


public class Location {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int row,column;
		
		System.out.print("Enter the number of rows and columns in the array: ");
		
		row=scanner.nextInt();
		column=scanner.nextInt();
		
		System.out.print(row+" "+column);
		
		scanner.close();
	}

}
