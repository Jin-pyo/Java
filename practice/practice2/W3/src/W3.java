class A{
	public int x;
}
class B extends A{
	public int y;
}


public class W3{
	public static void main(String[] args)
	{
		A a = new A();
		B b = new B();
		
		b=(B)new A();
		
	}
}