import java.util.Scanner;

public class Circle {
	int m_width;
	int m_height;
	
	public Circle()
	{
		this(0,0);
	}
	
	public Circle(int width,int height)
	{
		this.m_width=width;
		this.m_height=height;
	}
	public int getArea()
	{
		return m_width*m_height;
	}
	
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		int width;
		int height;
		
		System.out.print("Enter width");
		width=scanner.nextInt();
		
		System.out.print("Enter height");
		height=scanner.nextInt();
		
		Circle a=new Circle(width,height);
		
		System.out.print("area is "+a.getArea());
		
		scanner.close();
		
	}

}
