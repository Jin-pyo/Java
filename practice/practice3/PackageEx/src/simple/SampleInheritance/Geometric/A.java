package simple.SampleInheritance.Geometric;

public class A {
    private String fieldA;

    public A() {
    	
    	fieldA= "default value";
    	
    }
    public A(String a)
    {
    	fieldA=a;
    }

	public String getFieldA() {
		return fieldA;
	}

	public void setFieldA(String fieldA) {
		
		this.fieldA = fieldA;
		
	}
}