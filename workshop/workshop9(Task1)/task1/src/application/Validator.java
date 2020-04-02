/**********************************************
Workshop 9 Task1
Course: JAC444NAB
Last Name:Ju
First Name:Jinpyo
ID: 134444181
This assignment represents my own work in accordance with Seneca
Academic Policy.
Signature
Due Date : April 3, 2020
**********************************************/

package application;

import java.util.HashSet;
import java.util.Set;
import java.math.*;

public class Validator {
	
	private static Double plus;
	private static Double minus;
	private static Double multiply;
	private static Double divide;
	
	private static Set<Double> setPlus = new HashSet<>();
	private static Set<Double> setMinus = new HashSet<>();
	private static Set<Double> setMultiply = new HashSet<>();
	private static Set<Double> setDivide = new HashSet<>();
	
	private static Set<Double> answers = new HashSet<>();
	
	public static Set<Double> validateInput(String add,String sub, String mul, String div)
	{
		try {
			
		 plus = Double.valueOf(add);
         minus = Double.valueOf(sub);
         multiply = Double.valueOf(mul);
         divide = Double.valueOf(div);
        
         answers.add(plus);
         answers.add(minus);
         answers.add(multiply);
         answers.add(divide); 
		
		return answers;
		}catch(NumberFormatException e)
		{
			return answers;
		}
	}
	
	public static void clearSet()
	{
		answers.clear();
		setPlus.clear();
		setMinus.clear();
		setMultiply.clear();
		setDivide.clear();
	}
	
	public static boolean checkAdd(int num1, int num2,double add)
	{
		boolean check=false;
		
		double temp = num1+num2;
		
		if(add==temp)
		{
			check=true;
			return check;
		}
		return check;
	}
	public static boolean checkAddContain(double add)
	{
		boolean check=false;
		if(setPlus.contains(add))
		{
			check=true;
			return check;
		}
		else
		{
			setPlus.add(add);
			return check;
		}
	}
	
	public static boolean checkMinus(int num1, int num2,double minus)
	{
		boolean check=false;
		
		double temp = num1-num2;
		
		if(minus==temp)
		{
			check=true;
			return check;
		}
		return check;
	}
	public static boolean checkMinusContain(double minus)
	{
		boolean check=false;
		if(setMinus.contains(minus))
		{
			check=true;
			return check;
		}
		else
		{
			setMinus.add(minus);
			System.out.println(setMinus);
			return check;
		}
	}
	
	///////////////////////
	
	public static boolean checkMul(int num1, int num2,double mul)
	{
		boolean check=false;
		
		double temp = num1*num2;
		
		if(mul==temp)
		{
			check=true;
			return check;
		}
		return check;
	}
	public static boolean checkMulContain(double mul)
	{
		boolean check=false;
		if(setMultiply.contains(mul))
		{
			check=true;
			return check;
		}
		else
		{
			setMultiply.add(mul);
			System.out.println(setMultiply);
			return check;
		}
	}
	
	//////////////
	public static boolean checkDiv(int num1, int num2,double div)
	{
		boolean check=false;
		
		double temp = (double)num1/(double)num2;
		
		temp = Math.round(temp*100)/100.0;
		System.out.println(temp);
		if(div==temp)
		{
			check=true;
			return check;
		}
		return check;
	}
	public static boolean checkDivContain(double div)
	{
		boolean check=false;
		if(setDivide.contains(div))
		{
			check=true;
			return check;
		}
		else
		{
			setDivide.add(div);
			System.out.println(setDivide);
			return check;
		}
	}

}
