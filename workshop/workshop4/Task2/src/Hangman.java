
public class Hangman {
	
	private String[] words= {"apple","bee","power","pig","rabbit"};
	private char[] word;
	
	public Hangman(){
		int number=(int)(Math.random()*words.length)+1;
		System.out.println(number);
		this.word=new char[words[number-1].length()];
		
		for(int i=0;i<word.length;i++)
		{
			word[i]=words[number-1].charAt(i);
		}
	}
	
	public char[] getword() {
		
		return word;
		
	}
	
	public void fillasteriks(char[] list)
	{
		for(int i=0;i<list.length;i++)
		{
			list[i]='*';
			System.out.print(list[i]);
		}
		System.out.println(" ");
	}
	
	
	
}
