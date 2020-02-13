
public class Hangman {
	
	private String[] words= {"apple","bee","power","pig","rabbit","Tiger","program","chair","subway","venus"};
	private char[] word;
	private char[] asterword;
	
	private char[] wrongword;
	
	public Hangman(){
		int number=(int)(Math.random()*words.length)+1;
		//System.out.println(number);
		
		this.word=new char[words[number-1].length()];
		this.wrongword=new char[0];
		
		for(int i=0;i<word.length;i++)
		{
			word[i]=words[number-1].charAt(i);
		}
		
	}
	
	public char[] getword() {
		
		return word;
		
	}
	
	public void fillasteriks()
	{
		asterword=new char[this.word.length];
		for(int i=0;i<asterword.length;i++)
		{
			asterword[i]='*';
			//System.out.print(asterword[i]);
		}
		//System.out.println(" ");
	}
	
	public char[] getAsteriks()
	{
		return this.asterword;
	}
	
	
	public void playGame(char guess)
	{
		if(!checkCorrectDuplicate(guess))
		{
			boolean checkCorrect=true;
			for(int i=0;i<this.word.length;i++)
			{
				if(word[i]==guess)
				{
					asterword[i]=guess;
					checkCorrect=false;
				}
			}
			
			if(checkCorrect)
			{
				pushWrongword(guess);
			}
		}
	}
	
	public boolean checkCorrectDuplicate(char guess)
	{
		for(int i=0;i<this.asterword.length;i++)
		{
			if(this.asterword[i]==guess)
			{
				System.out.println(guess+" already in the word");
				return true;
			}
		}
		return false;
	}
	
	public boolean checkWrongDuplicate(char guess)
	{
		for(int i=0;i<this.wrongword.length;i++)
		{
			if(this.wrongword[i]==guess)
			{
				System.out.println(guess+" already wrong");
				return true;
			}
		}
		return false;
	}
	
	public void pushWrongword(char guess)
	{
		if(!checkWrongDuplicate(guess))
		{
			char [] tmp=new char[this.wrongword.length+1];
			for(int i=0;i<wrongword.length;i++)
			{
				tmp[i]=wrongword[i];
			}
			tmp[wrongword.length]=guess;
			wrongword=tmp;
			
			System.out.println(guess +" is not in the word");
		}
	}
	
	public int worngCount()
	{
		return this.wrongword.length;
	}
	
	public boolean finishGame()
	{
		for(int i=0;i<asterword.length;i++)
		{
			if(asterword[i]=='*')
				return false;
		}
		return true;
	}
	
	
	
}
