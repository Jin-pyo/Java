/*-----------------------------------------
 * Java Workshop4 Task1
 *	Name : Jinpyo Ju  
 *  SID  : 134444181
 *  Date : Feb 14,2020
 * 
 * ------------------------------------------
 */

package Workshop4;

class Bank{
	
	private int m_id;
	private double m_balance;
	private double m_loan[][];
	
	public Bank() {
		m_id=0;
		m_balance=0;
		m_loan=null;
	}
	
	public Bank(int id,double balance, int numOfloan)
	{
		this.m_id=id;
		this.m_balance=balance;
		this.m_loan=new double[numOfloan][2];
	}
	
	public void setIdAmt(int cnt,int loanId,double amt)
	{
		this.m_loan[cnt][0]=loanId;
		this.m_loan[cnt][1]=amt;
		m_balance+=amt;
	}
	
	public double getBalance()
	{
		return this.m_balance;
	}
	
	public int getId()
	{
		return this.m_id;
	}
	
	public void show()
	{
		for(int i=0;i<m_loan.length;i++)
		{
			System.out.print(m_loan[i][0] + " ,");
			System.out.print(m_loan[i][1]);
		}
	}
	
	
	public void filter(int loanId)
	{
		for(int i=0;i<m_loan.length;i++)
		{
			if(m_loan[i][0]==loanId)
			{
				m_balance-=m_loan[i][1];
				System.out.println("Test :"+m_id+" , "+ m_balance);
			}
			
		}
	}
	
	
}