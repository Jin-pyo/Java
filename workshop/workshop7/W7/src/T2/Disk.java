package T2;

public class Disk {
	
	int [][]values;
	int numDisk;
	String name;
	int check;
	
	Disk()
	{
		this.values=new int[6][7];
		this.numDisk=0;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setCheck(int check)
	{
		this.check=check;
	}
	public int getCheck()
	{
		return this.check;
	}
	
	public void displayBoard()
	{
		for(int i=0;i<this.values.length;i++)
		{
			System.out.print("|");
			
			for(int j=0;j<this.values[i].length;j++)
			{
				char temp;
				if(this.values[i][j]==1)
				{
					temp='R';
				}
				else if(this.values[i][j]==2)
				{
					temp='Y';
				}
				else
				{
					temp=' ';
				}
				
				System.out.print(temp+"|");
			}
			System.out.println();
		}
		
		System.out.println("================");
	}
	
	public boolean checkBoard()
	{
		return checkVer()||checkHor()||checkDia();
	}
	
	public boolean checkVer()
	{
		for(int i=0;i<this.values[0].length;i++)
		{
			int startPoint=this.values[0][i];
			int count=1;
			
			for(int j=0;j<this.values.length;j++)
			{
				if(startPoint==this.values[j][i]&&startPoint!=0)
				{
					count++;
				}
				else
				{
					startPoint=this.values[j][i];
					count=1;
				}
				
				if(count==4)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkHor()
	{
		for(int i=1;i<this.values.length;i++)
		{
			int startPoint=this.values[i][0];
			int count=1;
			
			for(int j=1;j<this.values[i].length;j++)
			{
				if(startPoint==values[i][j]&&startPoint!=0)
				{
					count++;
				}
				else
				{
					startPoint=values[i][j];
					count=1;
				}
				if(count==4)
					return true;
			}
		}
		return false;
	}
	
	public boolean checkDia()
	{
		for(int i=0;i<this.values.length;i++)
		{
			int startPoint=values[i][0];
			int count=1;
			
			for(int j=i+1,k=1; j<this.values.length && k<values[0].length; j++,k++)
			{
				if(startPoint==this.values[j][k] && startPoint!=0)
				{
					count++;
				}
				else
				{
					startPoint=this.values[j][k];
					count=1;
				}
				if(count==4)
				{
					return true;
				}
			}
		}
		
		for(int i=0; i<this.values[0].length;i++)
		{
			int startPoint =values[0][i];
			int count=1;
			
			for(int j=i+1,k=1; j<this.values[0].length && k<this.values.length;j++,k++)
			{
				if(startPoint==this.values[k][j] && startPoint!=0)
				{
					count++;
				}
				else
				{
					startPoint=this.values[k][j];
					count=1;
				}
				if(count==4)
				{
					return true;
				}
			}
		}
		
		for (int i = 0; i < this.values[0].length; i++) 
		{
			int startPoint = this.values[0][i];
			int count = 1;
			   
			for (int j = 1, k = i-1; j < this.values.length && k >= 0; j++, k--) 
			{
				if (startPoint == this.values[j][k] && startPoint != 0) 
				{
					count++;
				} 
				else 
				{
					startPoint = this.values[j][k];
			    	count = 1;
				}
				   
				if (count == 4) 	
				{
					 return true;
				}
			}	
		}
		
		for (int i = 0; i < values.length; i++) 
		{
			int start = values[i][values[i].length-1];
			int count = 1;
			for (int j = i+1, k = values[0].length-2; j < values.length && k >= 0; j++, k--) 
			{
			    if (start == values[j][k] && start != 0) 
			    {
			     count++;
			    }
			    else 
			    {
			     start = values[j][k];
			     count = 1;
			    }
			    
			    if (count == 4) 
			    {
			     return true;
			    }
			}
		}
		
		return false;
		
	}

}
