class Item
{
	private String name;
	private double cost;

	Item(String name, double cost)
	{
		this.name = name;
		this.cost = cost;
	}

	public String toString() { return  "\""+name + "\", Cost = $" + cost;	}
	String getName() { return name; }
	double getCost() { return cost; }
	void setName(String name) { this.name = name; }
	void setCost(double cost) { this.cost = cost; }
}

class Bag
{
	private Item [] items;
	private int num_items;

	// makes a bag of items that has a max number of items
	Bag (int max) 
	{ 
		items = new Item [max]; 
		this.num_items = 0; // used as index to insert in items[index]
	}

	// inserts an item at the end of the array of items
	void insert_item (String name, double cost)
	{
		System.out.print("Inserting \"" +name+"\", \""+cost+"\" in the bag" );
		System.out.println(" at index: " + num_items);
		items [num_items] = new Item(name, cost);
		num_items++; // is the index of the last item
	}

	int size () { return items.length; }
	int numItems() { return num_items; }

	void show_items ()
	{
		for (int i = 0; i < num_items; i++)
			System.out.println("Item " + i + ": " + items[i]);
		//   toString() shows information using only ^^ the object "items[i]"
	}

	Item find_item(String search_name)
	{
		int i; 
		for ( i = 0; i < num_items; i++ )
			if ( items[i].getName().equals(search_name) )
				break;		

		if (i == num_items) 				// can't find it
			return null;
		else								// found it
			return	items[i];
	}	

	boolean item_is_in_bag(String search_name)
	{
		for ( int i = 0; i < num_items; i++ )
			if ( items[i].getName().equals(search_name) )
				return true;

		return false;
	}

	boolean delete_item(String search_name)
	{
		int i;
		for ( i = 0; i < num_items; i++ )
			if ( items[i].getName().equals(search_name) )
				break;
		
		if ( i == num_items) 					// can't find it
			return false; 
		else									// found it
		{
			for (int j = i; j < num_items; j++) // shift down
				items[j] = items[j+1];
			
			num_items--; 						// decrement size
			return true;
		}

	}
}

class GroceryApp
{
	public static void main (String[] args) 
	{
		System.out.println("     ========== GroceryApp ========== ");
		Item item = new Item("beans" , 5.24);
		System.out.println("\nTesting \"Item\" class, Item: " + item+"\n");

		int max_items_in_bag = 5;
		Bag bag = new Bag(max_items_in_bag);
		System.out.println("the bag size is = " + bag.size() );
		System.out.println("the number of items in the bag:  "+bag.numItems()+"\n");
		
		// insert items in bag:
		bag.insert_item("avocado", 3.99);
		bag.insert_item("milk", 4.99);
		bag.insert_item("turkey", 3.79);
		bag.insert_item("cheese", 2.99);

		// show items:
		System.out.println("\nThe following items are in the bag:");
		bag.show_items();	
		System.out.println("the number of items in the bag:  "+bag.numItems());
		
		// find items:
		System.out.println( "\nTrying to find \"turkey\": ");
		if ( bag.find_item("turkey") != null)
			System.out.println( bag.find_item("turkey") );
		else 
			System.out.println("item not found");
		// ===
		System.out.println( "Trying to find \"bacon\": ");
		if ( bag.find_item("bacon") != null)
			System.out.println( bag.find_item("bacon") );
		else 
			System.out.println("item not found");
		
		// see if item is in the bag:
		System.out.println("\n\"bacon\" is in the bag:"+bag.item_is_in_bag("bacon"));
		System.out.println("\"turkey\" is in the bag:"+bag.item_is_in_bag("turkey"));

		// delete item:
		System.out.println("Deleted item \"milk\" : "+bag.delete_item("milk"));

		// show items:
		System.out.println("\nThe following items are in the bag:");
		bag.show_items();	
		System.out.println("the number of items in the bag:  " + bag.numItems() );
		
		System.out.println("\n     ========== END GroceryApp ========== ");
		
	}
}

