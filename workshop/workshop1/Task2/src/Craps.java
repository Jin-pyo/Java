// Name: Jinpyo Ju
// Seneca Student ID: 134444181	
// Seneca email: jju3@myseneca.ca
// Date of completion: 01/24/2020
//

import java.util.Random;

public class Craps {
	
	public static int getRanVal()
	{
		int random=new Random().nextInt(6)+1;
		return random;
	}

	public static void main(String[] args) {
		
		int dice1=getRanVal();
		int dice2=getRanVal();
		
		int sum=dice1+dice2;
		
		System.out.println("You rolled "+dice1+" + "+dice2+" = "+sum);
		
		if(sum==7||sum==11)
			System.out.println("Congratulations, You win");
		else if(sum==2||sum==3||sum==12)
			System.out.println("Better Luck Next Time, You lose");
		else
		{
			System.out.println("Point is set to "+sum);
			boolean check=true;
			while(check)
			{
				dice1=getRanVal();
				dice2=getRanVal();
				int sum2=dice1+dice2;
				System.out.println("You rolled "+dice1+" + "+dice2+" = "+sum2);
				
				if(sum2==7)
				{
					System.out.println("Better Luck Next Time, You Lose");
					check=false;
				}
				else if(sum2==sum)
				{
					System.out.println("Congratulations, You Win");
					check=false;
				}
				else
				{
					
				}
			}
		}

	}

}
