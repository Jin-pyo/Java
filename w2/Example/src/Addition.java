
public class Addition {
	public static void main(String[] args){
		
		if(args.length==2)
		{
			int a=Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			
			System.out.println("The addition of two numbers: "+(a+b));
			//
			String s1=args[0];
			System.out.println("args[0]= "+s1);
			
		}
		else
			System.out.println("Please enter two integer values!!");
		
		/////using for loop
		for(String a:args)
		{
			System.out.println("using for loop: "+a);
		}
		/////double loop
		double[]
				doubleList=new double[5];
		for(double c:doubleList)
		{
			c=Math.random()*12;
			//c=(int)Math.random()*12 -> delet after .
			System.out.println("Double array: "+c);
		}
		
		///////////array
		int [] myList = new int[5];
		
		for(int a : myList){
			System.out.println("The values int the array are: "+a);
		}
		
		for(int i=0;i<myList.length;i++)
		{
			System.out.println("The valeu int array are: "+myList[i]);
		}
	}
}
