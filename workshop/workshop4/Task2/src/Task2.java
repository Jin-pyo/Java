/*-----------------------------------------
 * Java Workshop4 Task2
 *	Name : Jinpyo Ju  
 *  SID  : 134444181
 *  Date : Feb 14,2020
 * 
 * ------------------------------------------
 */

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean playLoopcheck=true;
		
		while(playLoopcheck)
		{
			System.out.println("Do you want to play Game? 1:Yes , 2:No ");
			
			int playcheck=scanner.nextInt();
			
			if(playcheck==1)
			{
				Hangman hangman = new Hangman();
				char[] word=hangman.getword();
				hangman.fillasteriks();
				
				boolean gameLoopCheck=true;
				
				while(gameLoopCheck)
				{
					System.out.print("(Guess) Enter a letter in word ");
					System.out.print(hangman.getAsteriks());
					System.out.print(" > ");
					char guessWord=scanner.next().charAt(0);
					hangman.playGame(guessWord);
					
					if(hangman.finishGame())
					{
						gameLoopCheck=false;
						System.out.print("The word is ");
						System.out.println(hangman.getword());
						System.out.println("you missed "+ hangman.worngCount()+ "times");
					}	
				}
			}
			else if(playcheck==2)
			{
				System.out.println("Bye Bye");
				playLoopcheck=false;
			}
			else
			{
				System.out.println("Enter Correct value");
			}
		}
		
	}
}