import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		boolean playLoopcheck=true;
		
		while(playLoopcheck)
		{
			System.out.println("Do you want to play Game? 1:Yes , 2:No ");
			
			int playcheck=scanner.nextInt();
			
			if(playcheck==2)
			{
				System.out.println("Bye Bye");
				playLoopcheck=false;
			}
			else
			{
				Hangman hangman = new Hangman();
				char[] word=hangman.getword();
				char[] asterword=new char[word.length];
				hangman.fillasteriks(asterword);
				
				boolean gameLoopCheck=true;
				
				while(gameLoopCheck)
				{
					System.out.print("(Guess) Enter a letter in word ");
					System.out.print(asterword);
					System.out.print(" > ");
					//char guessWord=scanner.next().charAt(0);
					
					System.out.println(hangman.getword());
					gameLoopCheck=false;
					
					
					
					
					
				}
				
			}
		}
		
	}
}