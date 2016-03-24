class obj
{
	int one, two;

	obj(int one, int two)
	{
		this.one = one;
		this.two = two;
	}

	public void displayObj()
	{
		System.out.println("one = " + one + " two = " + two);
	}
}

class objTests
{
	public static void main(String [] args)
	{
		obj a = new obj(1,2);
		System.out.println("Making a new object a(1,2) ");
		System.out.print("a:");
		a.displayObj();

		System.out.println("Making an object b = a ");
		obj b = a;
		System.out.print("b:");
		b.displayObj();

		System.out.println("Changing b's 'one' , also changes a's one");
		b.one = 10;
		System.out.print("b:");
		b.displayObj();

		System.out.print("a:");
		a.displayObj();

		System.out.println("Making a new object c(3,4) ");
		obj c = new obj(3,4);
		System.out.print("c:");
		c.displayObj();

		System.out.println("Making an object b = c ");
		b = c;
		System.out.print("a:");
		a.displayObj();
		System.out.print("b:");
		b.displayObj();
		System.out.print("c:");
		c.displayObj();
		System.out.println("Changing b's 'one'");
		b.one = 66;
		System.out.print("a:");
		a.displayObj();
		System.out.print("b:");
		b.displayObj();
		System.out.print("c:");
		c.displayObj();

		//System.out.println("Changing 's 'one' ");
		/*
		a:one = 1 two = 2
		b:one = 1 two = 2
		Changing b's 'one' 
		b:one = 10 two = 2
		a:one = 10 two = 2
		*/
	}	
}