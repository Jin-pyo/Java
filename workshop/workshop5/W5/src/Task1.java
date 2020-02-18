import java.util.Scanner;


public class Task1 {

	public static void main(String[] args) {
		
		Validate vali= new Validate();
		
		String phoneNum = vali.getNumber();
		
		//System.out.println(phoneNum);
		
		
		StringBuilder sb = new StringBuilder();
		
		vali.convert(phoneNum, sb,0);
		
		
		
	}
	
	

}
