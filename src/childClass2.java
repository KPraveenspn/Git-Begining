
public class childClass2 extends childClass3 {

	int a;
	
	//default constructor
	public childClass2(int a) {
		
		super(a);   //parent class constructor is invoked
		
		this.a=a;  //this.a is refer to global(current) class variable

	}

	public int increment()
	{
		a=a+1;
		return a;
		
	}
	
	public int decrement()
	{
		a=a-1;
		return a;
		
	}
}
