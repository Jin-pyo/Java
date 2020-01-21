import java.util.Scanner;


public class Location {
	public static int maxValRow(double [][]arr,double max)
	{
		int rowPos=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(arr[i][j]==max)
				{
					rowPos= i+1;
					//System.out.print("ro "+rowPos);
					break;
				}
			}
		}
		return rowPos;
	}
	
	public static int maxValCol(double [][]arr,double max)
	{
		int colPos=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(arr[i][j]==max)
				{
					colPos= j+1;
					//System.out.print("co "+colPos);
					break;
				}
			}
		}
		return colPos;
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int row=0,column=0;
		double maxValue=0;
		
		System.out.print("Enter the number of rows and columns in the array: ");
		
		row=scanner.nextInt();
		column=scanner.nextInt();
		
		//System.out.println("row value: "+row+" column value: "+column);
		
		double [][] array=new double[row][column];
		
		System.out.println("Enter the array: ");

		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array[i].length;j++)
			{
				array[i][j]=scanner.nextDouble();
				if(maxValue<array[i][j])
					maxValue=array[i][j];
			}
			//System.out.println();
		}
		
		System.out.println("Max value is: "+maxValue);
		
		int rowResult=0,colResult=0;
		rowResult=maxValRow(array,maxValue);
		colResult=maxValCol(array,maxValue);
		
		System.out.print("Max value is located row: "+rowResult+" col: "+colResult);
		
		scanner.close();
	}

}