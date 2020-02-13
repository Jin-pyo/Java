
public class Hangman {
	
	private String[] words= {"apple","bee","power","pig","rabbit"};
	
	public String getword() {
		
		int number=(int)(Math.random()*words.length)+1;
		System.out.println(number);
		int n=words.length;
		System.out.println(n);
		
		return this.words[number];
	}
	
}
