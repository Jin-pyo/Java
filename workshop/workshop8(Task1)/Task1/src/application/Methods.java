/**********************************************
Workshop 8
Course: JAC444NAB
Last Name:Ju
First Name:Jinpyo
ID: 134444181
This assignment represents my own work in accordance with Seneca
Academic Policy.
Signature
Date:Mar25, 2020
**********************************************/

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Methods {
  
    private static Scanner scanner;

    public static int findRanking(int year, char gender, String name) {
        
        try {
        	String line;
        	String information;
        	
	        scanner = new Scanner(new File("babynamesranking" + year + ".txt"));	
	        
	        if(gender == 'M') {
	            information = "[0-9]+\\s*" + name + "[^a-z].*";
	        }
	        else {
	        	information = "^[0-9]+\\s*[A-Za-z]+.*" + name + "[^a-z].*";
	        }
	
	        int lineNumber = 0;
	        while (scanner.hasNextLine()) {
	        	lineNumber++;
	            line = scanner.nextLine();
	            if(line.matches(information)) {
	                System.out.println(line);
	                return lineNumber;
	            }
	        }
	        return 0;
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found.");
            return -1;
        }
    }

   
}