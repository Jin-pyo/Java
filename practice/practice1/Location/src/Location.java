import java.util.Scanner;

public class Location {
	int m_row;
	int m_column;
	double m_maxValue=0;
	
	public int largestRow(double [][] arr)
	{
		int rowPos=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(arr[i][j]==m_maxValue)
				{
					rowPos= i+1;
					break;
				}
			}
		}
		return rowPos;
	}
	
	public int largestCol(double[][]arr)
	{
		int colPos=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(arr[i][j]==m_maxValue)
				{
					colPos= j+1;
					break;
				}
			}
		}
		return colPos;
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		Location location=new Location();
		
		System.out.print("Enter the number of rows and columns in the array: ");
		location.m_row=scanner.nextInt();
		location.m_column=scanner.nextInt();
		
		double [][] array=new double[location.m_row][location.m_column];
		
		System.out.println("Enter the array: ");
		
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array[i].length;j++)
			{
				array[i][j]=scanner.nextDouble();
				if(array[i][j]>location.m_maxValue)
				{
					location.m_maxValue=array[i][j];
				}
			}
		}
		
		System.out.println("The largest value is :"+location.m_maxValue);
		
		System.out.print("The largest value's location is : row "+location.largestRow(array)+" column "+location.largestCol(array));
		
		scanner.close();

	}

}
