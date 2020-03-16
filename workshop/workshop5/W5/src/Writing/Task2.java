/*-------------------------------
 * Java workshop 5
 * 
 * Name : Jinpyo Ju
 * 
 * SID : 134444181
 * 
 * Date : Feb 21, 2020
 * 
 * 
 *-----------------------------------
 */

package Writing;

import java.util.Scanner;
import java.io.*;

public class Task2 {
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	System.out.println("Enter a filename : ");
	String fileName;
	fileName=scanner.next();
	
	int[] upperCase=new int[26];
	int[] lowerCase=new int[26];
	
	FileReader in=null;
	try {
		in=new FileReader(fileName);
		
		int oneChar;
		while((oneChar=in.read())!=-1)
		{
			//System.out.println((char)oneChar);
			
			if(oneChar>='A'&&oneChar<='Z')
				upperCase[oneChar-'A']++;
			if(oneChar>='a'&&oneChar<='z')
				lowerCase[oneChar-'a']++;
		}
		in.close();
		
		for(int i = 0; i < 26; i++) {
            System.out.println("Number of "+(char)(i+'A')+ "'s : " + upperCase[i]);
            System.out.println("Number of "+(char)(i+'a')+ "'s : " + lowerCase[i]);
        }
		
	}catch(FileNotFoundException e)
	{
		System.out.println("Can't find File, Check the name of the file");
	}
	catch(IOException e)
	{
		System.out.println("Error");
	}
	
	}
}
