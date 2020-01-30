package simple.SampleCasting.Example;

public class TesterClass {
	public static void main(String [] args) {
		Cat c = new Cat();
		System.out.println("Printing with Cat Object: " + c.health);
		
		Dog d = new Dog();
		System.out.println("Printing with Dog Object: " + d.health);
		
		Mammal m = c;			
		
		System.out.println("Printin Object C: " + c);
		System.out.println("Printin variable type Mammal: " + m);
		
		System.out.println("\n++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++");

		Cat c1 = new Cat();
		System.out.println("Value of c1 (original): " + c1);
		Animal a = c1;		//up casting to Animal Class
		System.out.println("Value of a (upcasted): " + a);
		
		
		
		if(a instanceof Cat) {
			//Cat c9 = (Cat) new Animal();
			//System.out.println("Value of c2 (downcasted): " + c9);
		}
		
		System.out.println("\n++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++");
		
		Mammal m1 = new Mammal();
		Mammal m2 = new Cat();
		
		Cat c4 = (Cat) m2;
		System.out.println(c4.health);
		if (m1 instanceof Cat)
		{	Cat c5 = (Cat) m1;
			System.out.println("Where am i"+c5.health);
			
			System.out.println("++++++++++++++++++++++++++");
		}
		
		Object b = new String("this is string");
		System.out.println(b);
		//String s = (String) new Object();
		//System.out.println(s);
		if(b instanceof String){
			String s =  (String) b;
			System.out.println("what is" + b);
			System.out.println(s);
			
		
		}
	}
}
