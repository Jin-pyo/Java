package onePara;


public interface Test{
	public String method();
}

public class TesterClass {
	public static void main(String[] args) {
		Test msg=()->{return "Interface is called";};
		
		System.out.println(msg.method());
	}

}
