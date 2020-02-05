package Geometric;

public class TestAB {
	public static void main(String[] args) {
		
		A aObj = new A();
		System.out.println(aObj.getFieldA());
		aObj.setFieldA("New Value");
		System.out.println(aObj.getFieldA());
		
		B bObj = new B("I am B", 2);
		System.out.println(bObj.getFieldB());
		
		A childB = new B("I am Child", 3);
		A parent = childB;
		
		if(childB instanceof A) {
			System.out.println(((B)parent).getFieldB());
		}
		
	}
}
