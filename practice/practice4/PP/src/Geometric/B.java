package Geometric;

public class B extends A {
    private int fieldB;

    public B(String a, int b) {
        // Call the overloaded constructor of the class A
    	super.setFieldA(a);
    	
         // replaces the implicit call to super()
        setFieldB(b);
    }

	public int getFieldB() {
		System.out.println(super.getFieldA());
		return fieldB;
	}

	public void setFieldB(int fieldB) {
		this.fieldB = fieldB;
	}
}