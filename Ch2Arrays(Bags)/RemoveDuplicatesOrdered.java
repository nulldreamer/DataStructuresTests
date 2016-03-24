class RemoveDuplicatesOrdered {
	
	static int [] a = {12, 13, 13, 14, 14, 15}; // assumption is that array is already sorted
	static int nElems = 6;
	
	public static void show_array()
	{
		for (int i = 0; i < nElems; i++)
            System.out.print(a[i] + " ");
        System.out.println();
	}
	
	public static void shift_left(int index_to_remove)
	{
		for (int i = index_to_remove; i< nElems - 1; i++) 
		{
			a[i] = a[i+1];// shift elements to the left
		}
		nElems--; // decrease number of elements after shift
	}
	
    public static void main(String[] args) 
    {        
        show_array();
        
        // Find a duplicate, then shift all others one to the left
        for (int i = 0; i < nElems - 1; i++)
        {
        	if (a[i] == a[i+1])
        	{
        		System.out.println("Duplicates a["+i+"] and a["+(i+1)+"]" );
        		System.out.println("Remove a["+i+"] , shift_left(), then do i-- to re-check");
        		shift_left(i);
        		i--; // decrease index so that loop rechecks the same a[i] and a[i+1]
        		show_array();
        	}        		
        }        
    }
}


