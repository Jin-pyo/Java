package onePara;



public class OneParameterClass {
	public static void main(String[] args) {
		
		System.out.println(SquareValue((value) -> (value * value), 5));
		System.out.println(SquareValue(value -> (value - 10), 100));
	}
	
	static int SquareValue(OneParameterInterface inter, int value) 
		{
			return inter.SquareValue(value);	
		}
	
}
