class InsertInOrder
{
	
	// Mergest two arrays into destination array 
	// returns the destination array
	public static int [] merge_arrays(int [] a, int [] b)
	{
		int i, a_track = 0, b_track = 0;

		int total_elements = a.length + b.length;
		int [] destination = new int[total_elements];
		
		for (i = 0; i < total_elements; i++)
		{
			if (a_track < a.length) // add first array
			{
				destination[i] = a[a_track++];
				//a_track++;<-- same as ^^^
			}
			else // add the second array
			{
				destination[i] = b[b_track++];
				//b_track++;<-- same as ^^^
			}
		}

		return destination;
	}

	// Makes a string of array elements in the format of:  {1,2,3,4}
	// returns the formatted string
	public static String show_array(int [] a)
	{
		String array_as_string ="{";

		for (int i = 0; i < a.length; i++)
		{
			if (i < a.length - 1) // put commas if you are not at the last number
				array_as_string = array_as_string + a[i] + ",";
			
			else if (i < a.length)
				array_as_string = array_as_string + a[i];			
		}

		return array_as_string + "}\n";
			
	}

	// inserts a number into ordered array, values > get shifted one to the right
	public static void insert_in_order(int [] ordered, int value_to_insert)
	{
		// find where value_to_insert is supposed to go
		int index_to_insert;
		for (index_to_insert = 0; index_to_insert < ordered.length; index_to_insert++)
			if ( ordered[index_to_insert] > value_to_insert)
				break;
		
		System.out.print ("before shift: ordered [ ] = " + show_array(ordered) );
		// move bigger ones up. assumption is that
		// 1) the array is 1 size bigger than original, in order to insert a new number
		// 2) we have to move the right-most elements first one to the right...
		// ...in order to push all the elements by one to the right 
		for (int i = ordered.length - 1; i > index_to_insert; i--)
			ordered [i] = ordered [i - 1];
		
		System.out.print ("after shift: ordered [ ] = " + show_array(ordered) );
		//System.out.println("index_to_insert = " + index_to_insert);
		
		ordered[index_to_insert] = value_to_insert;	

		System.out.print ("after insertion of " + value_to_insert+ " : ordered [ ] = " + 
																	show_array(ordered) );
	}

	public static void main(String[] args) 
	{
		int [] a;
		a = new int[] {1,2,3};
		int [] b = {4,5,6};

		int total_elements = a.length + b.length;
		int [] destination = new int[total_elements];

		destination = merge_arrays(a,b);

		System.out.print ("destination [ ] = " + show_array(destination) );

		int [] ordered = new int [6];
		ordered[0] = 1; 
		ordered[1] = 2; 
		ordered[2] = 4; 
		ordered[3] = 5;
		ordered[4] = 6;
		System.out.print ("ordered [ ] = " + show_array(ordered) );

		insert_in_order(ordered, 3);


	}
}