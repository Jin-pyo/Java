package T2;
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		boolean GameCheckLoop=true;
		int GameCheck=0;
		
		while(GameCheckLoop)
		{
		
			Disk disk = new Disk();
			disk.displayBoard();
			
			do
			{
				if(disk.numDisk%2==0)
				{
					disk.setName("red");
					disk.setCheck(1);
				}
				else
				{
					disk.setName("Yellow");
					disk.setCheck(2);
				}	
				disk.numDisk++;
				
				System.out.print("Drop a (" + disk.getName());
				System.out.print(") disk at column(0-6): ");
				
				int column = 0;
				boolean columnCheck=true;
				while(columnCheck)
				{
					column=scanner.nextInt();
					
					if(column<7)
					{
						columnCheck=false;
					}
					else
					{
						System.out.println("Column should be lower 7. Try again");
						disk.displayBoard();
					}
				}
				
				for(int row=disk.values.length-1; row>=0; row--)
				{
					if(disk.values[row][column]==0)
					{
						disk.values[row][column]=disk.getCheck();
						break;
					}
					
					if(row==0)
					{
						System.out.println("This Column is full. Try again");
					}
				}
				
				disk.displayBoard();
			}while(disk.checkBoard()==false && disk.numDisk!=42);
			
			if(disk.checkBoard())
			{
				System.out.println(" Player " + disk.getName() + " Win ");
			}
			else
			{
				System.out.println(" DRAW ");
			}
			
			
			System.out.println("Do you want to play game again? Yes - 1 , No - Any Number");
			GameCheck=scanner.nextInt();
			
			if(GameCheck==1)
			{
				System.out.println(" NEW GAME START");
				System.out.println(" ");
			}
			else
			{
				System.out.println(" BYE BYE ");
				GameCheckLoop=false;
			}
		}
	}

}
