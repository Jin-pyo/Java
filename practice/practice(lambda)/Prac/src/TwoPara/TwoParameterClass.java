package TwoPara;

public class TwoParameterClass {
	public static void main(String[] args) {
		Summable obj = (x,y) -> {
					return (x + y) % 2 == 0;
		};
		
		System.out.println("Is the Sum Even: " + obj.evenSum(2, 10));
		
		System.out.println(obj.evenSum(3, 10));
		
		System.out.println(evenSum(2,10,obj));
		
	}
	
	static boolean evenSum( int x, int y, Summable obj) {
			return obj.evenSum(x, y);	
	}
}
