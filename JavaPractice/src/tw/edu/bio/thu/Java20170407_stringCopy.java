package tw.edu.bio.thu;

public class Java20170407_stringCopy {

	public static void main(String[] args) {
		
		Car[] c1 = {new Car("Large","red"), new Car("Small","blue")};
		Car[] c2 = new Car[c1.length];
		
		for(int i = 0; i < c1.length; i++)
		{
			c2[i] = new Car(c1[i].size, c1[i].color);
		}
		
		c1[0].color = "white";
		
		System.out.println(c2[0].color);
		
		
	}
		

}


class Car
{
	String size, color;
	
	Car(String size, String color)
	{
		this.size = size;
		this.color = color;
	}
}
