class TheArray
{
	int [] array;
	int number_elements;

	TheArray ( int max )
	{
		array = new int [ max ];
		number_elements = 0;
	}

	void insert_at_the_end ( int value_to_insert )
	{
		array [ number_elements ] = value_to_insert;
		number_elements++;
	}

	void show_array ()
	{
		for (int i = 0; i < number_elements; i++)
			System.out.println("array [ " + i + " ] = " + array [ i ] );
	}

	void swap (int left_index, int right_index)
	{		
		int temp = array[left_index];			
		array[left_index] = array[right_index];
		array[right_index] = temp;				
	}

	// BUBBLE SORT: move biggest numbers to the right
	// moves the biggest number to the right-most place
	// moves the second largest number to the second right-most place
	// moves the third largest number to the third right most place...etc
	
	// the variable "end" changes to right-most place, to second right-most, etc
	// The "Invariant" of the algorithm (conditions that remain unchanged)
	//  is that the elements to the right of "end" variable are always sorted
	void bubble_sort ()
	{
		// "end" starts at last element and goes down to second element
		// "begin" always starts at first element and goes to "end"		
		int begin, end;

		for (end = number_elements - 1; end > 1; end--)
			for (begin = 0; begin < end; begin++)  // move biggest to the right
				if (array[begin] > array[begin+1]) // if left number is bigger	
					swap ( begin, begin + 1 );	   // swap their values	
			// swap is in the inner loopw so N*(N-1), or approximately N^2 swaps
	} // END bubble_sort()

	/* SELECTION SORT: move smallest numbers to the left
	  Pass through all the numbers and pick (or select) the smallest one. 
	  This smallest number is then swapped with the left-most element
	  on the left end of the line, at position 0. 
	  Now the leftmost player is sorted and won’t need to be moved again.
	  The variable "out" changes to left-most place, to second left-most, etc
	  
	  Find smallest element and swap values of that element and first element
	  Find second-smallest and swap value of that element and second element
	  Find third-smallest and swap value of that element and third element
	  
	  
	  The "Invariant" of the algorithm (conditions that remain unchanged)
	  is that the elements to the left of "out" variable are  sorted
	*/
	void selection_sort ()
	{
		int out, in, min_index;

		for (out = 0; out < number_elements -1; out++)
		{
			min_index = out;
			for (in = out+1; in < number_elements; in++)
				if (array[in] < array[min_index])
					min_index = in;
			swap(out, min_index); // swap is in outer loop so N swaps
		}
				
		/* 
		// For 4 element array select sort works like this:

		// {2, 4, 1, 3} <-- INITIALLY
		min_index = 0;
		for (in = 1; in < number_elements; in++)
			if (array[in] < array[min_index])
				min_index = in;
		swap(0, min_index);
		
		// {1, 4, 2, 3} <-- AFTER FIRST SWAP
		min_index = 1;
		for (in = 2; in < number_elements; in++)
			if (array[in] < array[min_index])
				min_index = in;
		swap(1, min_index);

		// {1, 2, 4, 3} <-- AFTER SECOND SWAP
		min_index = 2;
		for (in = 3; in < number_elements; in++)
			if (array[in] < array[min_index])
				min_index = in;
		swap(2, min_index);
		// {1, 2, 3, 4} <-- AFTER THIRD SWAP
		// min_index goes from 0 to number_elements-1
		*/
	} // END selection_sort()


	/* INSERTION SORT: 
	In the outer for loop, "out" starts at 1 (second element) and moves right.
	"out" marks the leftmost unsorted data. 
	"out" is the index of the element that is to be inserted in place     

	In the inner while loop, "in" starts at "out" and moves left,
	until either "temp" is smaller than the array element there,
	or it can’t go left any further. 

	Each pass through the while loop shifts another sorted element
	one space right.

	1) left of "out" is a sorted sub-array, store element at "out" in "temp"
	2) find where the element at "out" is supposed to go in the above sub-array
	3) shift right all elements of the sub-array > the element at "out"  
	4) insert "temp" where value is supposed to go

	The "Invariant" of the algorithm (conditions that remain unchanged):
	At the end of each pass, following the insertion of the item from "temp",
	 the data items with smaller indices than "out" are partially sorted.
	*/
	void insertion_sort ()
	{
		int in, out, temp;

		for (out = 1; out <number_elements; out++)
		{
			in = out;
			temp = array[in]; // 1)
			while ( in > 0 && array[in-1] > temp) // 2) & 3)
			{ // ^^ while doesn't happen much for partially sorted array
				array[in] = array[in-1]; 
				in--;
			}
			array[in] = temp; // 4)
		}
		
		/*
		// For 4 element array insertion_sort works like this:

		// {4, 2, 1, 3} <-- AT THE BEGINNING
		in = 1;
		temp = array[in]; // temp = 2
		while ( in > 0 && array[in-1] > temp)
		{
			array[in] = array[in-1]; // array[1] = array[0] = 4
			in--;
			// in = 0 ... so while loop stops
		}
		array[in] = temp; // array[0] = 2

		// {2, 4, 1, 3}  
		in = 2;
		temp = array[in]; // temp = 1
		while ( in > 0 && array[in-1] > temp)
		{
			array[in] = array[in-1]; 
			// array[2] = array[1] = 4
			// array[1] = array[0] = 2
			in--;
			// in = 0...so while loop stops
		}
		array[in] = temp; // array[0] = 1

		// {1, 2, 4, 3}  
		in = 3;
		temp = array[in]; // temp = 3
		while ( in > 0 && array[in-1] > temp)
		{
			array[in] = array[in-1]; // array[3] = array[2] = 4			
			in--;
			// array[in-1] = array[2-1] = array[1] = 2
			// array[1] = 2  <  temp = 3 ... so while loop stops
		}
		array[in] = temp; // array[2] = 3
		// {1, 2, 3, 4} <-- AT THE END
		*/



	}
}

class BasicSortsApp
{

	public static void main(String [] args)
	{
		TheArray an_array = new TheArray(20); // make an array of 20 elements
		
        an_array.insert_at_the_end(77);       // insert 10 items
        an_array.insert_at_the_end(99);
        an_array.insert_at_the_end(44);
        an_array.insert_at_the_end(55);
        an_array.insert_at_the_end(22);
        an_array.insert_at_the_end(88);
        an_array.insert_at_the_end(11);
        an_array.insert_at_the_end(00);
        an_array.insert_at_the_end(66);
        an_array.insert_at_the_end(33);

        System.out.println("Unsorted Array:");
        an_array.show_array();                // display items

        an_array.insertion_sort();             //  sort them

        System.out.println("Sorted Array:");
        an_array.show_array();                // display them again

	}
}