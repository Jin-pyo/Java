import java.util.Scanner;

public class Play {
	
	static int[] makeArray(){
		int temp[]=new int[4];
		
		for(int i=0;i<temp.length;i++)
		{
			temp[i]=i;
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int intArray[];
		intArray=makeArray();
	

		
		scanner.close();

	}
	
	

}
