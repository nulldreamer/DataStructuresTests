class Stack
{
	private int max_size;
	private int [] stack_array;
	private int top;

	Stack(int array_size)
	{
		max_size = array_size;
		stack_array = new int[max_size];
		top = -1; 
	}

	void push (int element_to_push)		// put item on top of stack
	{
		top++;
		stack_array[top] = element_to_push;
	}

	int pop()							// take item from top of stack
	{
		int element_to_pop;
		element_to_pop = stack_array[top];
		top--;
		return element_to_pop;
	}

	int peek()							// peek at top of stack
	{
		int top_element = stack_array[top];
		return top_element;
	}

	boolean is_empty()					// true if stack is empty
	{
		if (top == -1)
			return true;
		return false;
	}

	boolean is_full() 					// true if stack is full
	{
		if (top == max_size - 1)
			return true;
		return false;
	}
}

class StackApp
{
	public static void main(String[] args)
    {
	      Stack theStack = new Stack(10);  // make new stack
	      theStack.push(20);               // push items onto stack
	      theStack.push(40);
	      theStack.push(60);
	      theStack.push(80);

	      while( !theStack.is_empty() )     // until it's empty,
	      {                                // delete item from stack
	         int value = theStack.pop();
	         System.out.print(value + " ");      // display it 
	      }  
	    
	      System.out.println("");
     }  // end main()
}