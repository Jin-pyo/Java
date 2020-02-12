/*
 * Jinpyo Ju / 134444181 / jju3@myseneca.ca
 * Workshop3
 * 
 * 
 */

package work;

import java.util.Date;

public class Account {
	
	private int id=0;
	private double balance=0;
	private double annulInterestRate=0;
	private Date dateCreated;
	private double [] history;
	
	Account(){
		dateCreated = new java.util.Date();
		history=new double[0];
	}
	
	Account(int id,double bal){
		this.id=id;
		this.balance=bal;
		dateCreated = new java.util.Date();
		
	}
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public double getBalance(){
		return this.balance;
	}
	public void setBalance(double bal){
		this.balance=bal;
	}
	public double getRate(){
		return this.annulInterestRate;
	}
	public void setRate(double rate){
		this.annulInterestRate=rate;
	}
	
	 public java.util.Date getDateCreated() {
		    return dateCreated;
		  }
	
	public double getMonthlyInterestRate() {
		return annulInterestRate/12;
	}
	public double getMonthlyInterest() {
		return this.balance*getMonthlyInterestRate();
	}
	
	double withdraw(double amount) {
		double [] tmp =new double[history.length+1];
		for(int i=0;i<history.length;i++)
		{
			tmp[i]=history[i];
		}
		tmp[history.length]=-amount;
		history=tmp;
		
	    return balance -= amount;
	}   

	double deposit(double amount) {
		double [] tmp =new double[history.length+1];
		for(int i=0;i<history.length;i++)
		{
			tmp[i]=history[i];
		}
		tmp[history.length]=amount;
		history=tmp;
		
	    return balance += amount;   
	}
	
	void showHistory()
	{
		for(int i=0;i<history.length;i++)
		{
			System.out.print(history[i]+" / ");
		}
		System.out.println(" ");
	}
	
	
}
