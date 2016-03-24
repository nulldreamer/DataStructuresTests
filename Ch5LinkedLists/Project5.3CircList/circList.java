// circList.java
// demonstrates circular list
// to run this program: C>java CircApp
////////////////////////////////////////////////////////////////
class Link
{
   public long iData;              // data item (key)
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(long id)            // constructor
   { iData = id; }             // (next automatically null)
// -------------------------------------------------------------
   public void displayLink()      // display ourself
   { System.out.print(iData + " "); }
   public String toString()
   {
      return " " + iData;
   }
}  // end class Link
////////////////////////////////////////////////////////////////
class CircList
{
   private Link current;          // ref to current link
   private int count;             // # of links on list
// -------------------------------------------------------------
   public CircList()              // constructor
   {
      count = 0;                  // no links on list yet
      current = null;
   }

   public void display_current()
   {
      System.out.println("current.iData: " + current.iData);
      System.out.println("current.next ..." + current.next);
   }

// -------------------------------------------------------------
   public boolean isEmpty()
   { return count==0; }
// -------------------------------------------------------------
   public int getSize()
   { return count; }
// -------------------------------------------------------------
   public void insert(long id)    // insert after current link
   {                           // make new link
      Link newLink = new Link(id);
      if(count == 0)              // if first one
      {
         current = newLink;       // current points to it
         current.next = current;  // next one is ourself
      }
      else                        // already at least one link
      {
         newLink.next = current.next; // downstream of new link
         current.next = newLink;      // upstream of new link
      }
      count++;                    // one more link
   }
// -------------------------------------------------------------
   public Link delete()           // delete one beyond current
   {
      Link tempLink;
      switch(count)
      {
         case 0:                  // nothing to delete
            tempLink = current;   // current is already null
            break;
         case 1:                  // delete ourself
            tempLink = current;
            current = null;
            count--;
            break;
         default:                 // delete the next one
            tempLink = current.next;
            current.next = tempLink.next;
            count--;
            break;
      }
      return tempLink;
   }
// -------------------------------------------------------------
   public Link find(long key)      // find link with given key
   {                           //    at one past current
      int getHome = count;
  
      while(getHome > 0)          // while not back to
      {                        // beginning
         if(current.next.iData == key)  // found it?
            return current.next;        // return next one
         
            
         else                     // not found
         {                     // go to next link
            current = current.next;
            getHome--;            // one item closer to home
         }
      }
      return null;                // can't find it
   }
// -------------------------------------------------------------
   public Link delete(long key)    // delete link with given key
   {
      Link nextLink = find(key);        // find it
      if(nextLink != null)              // if found,
      {
         current.next = nextLink.next;  // delete it
         count--;
      }
      return nextLink;            // return null or deleted link
   }
// -------------------------------------------------------------
   public void displayList()      // display the list
   {
      System.out.print("List: ");
      for(int j=0; j<count; j++)
      {
         current.next.displayLink(); // always display next link
         current = current.next;     // move to next link
      }
      System.out.println("");     // return null or deleted link
   }
// -------------------------------------------------------------
   public void step()
   {
      if(count != 0)
         current = current.next; // go to next link
   }
// -------------------------------------------------------------
   public Link peek()
   {
      if(count  > 0)
         return current.next;
      else
         return null;
   }
// -------------------------------------------------------------
}  // end class CurcList
////////////////////////////////////////////////////////////////
class CircApp
{
   public static void main(String[] args)
   {
      Link f, d;
      CircList theList = new CircList();  // make list

      
      theList.insert(10);      // insert items
      
      theList.insert(20);
      
      theList.insert(30);
      
      theList.insert(40);
      
      theList.insert(50);
      
      theList.insert(60);
      
      theList.insert(70);

      System.out.println("DISPLAY THE WHOLE LIST::");
      theList.displayList();              // display list

      System.out.println("======LOOKING FOR \"30\"========");
      f = theList.find(30);               // find item
      if( f != null)
         System.out.println("Found link with key " + f.iData);
      else
         System.out.println("Can't find link with key 30");
      theList.displayList();              // display list

      System.out.println("Inserting link with key 80");
      theList.insert(80);
      theList.displayList();              // display list

      d = theList.delete(60);             // delete item
      if( d != null )
         System.out.println("Deleted link with key " + d.iData);
      else
         System.out.println("Can't delete link with key 60");
      theList.displayList();              // display list

      f = theList.find(99);               // find item
      if( f != null)
         System.out.println("Found link with key " + f.iData);
      else
         System.out.println("Can't find link with key 99" );
      theList.displayList();              // display list

      d = theList.delete(13);             // delete item
      if( d != null )
         System.out.println("Deleted link with key " + d.iData);
      else
         System.out.println("Can't delete link with key 13");
      theList.displayList();              // display list

      System.out.println("Stepping through list");
      for(int j=0; j<theList.getSize(); j++)
      {
         theList.step();
         theList.displayList();
      }

      System.out.println("Will delete and step one by one");
      while(theList.isEmpty() == false)
      {
         theList.delete();
         theList.step();
         theList.displayList();
      }

   }  // end main()
}  // end class CircApp
////////////////////////////////////////////////////////////////
/*
The current pointer (reference) always points to the link
immediately before the link that will be operated on:
delete() removes the link following current
insert() inserts a new link following current
find() finds a link one link beyond current
display() displays all the links starting
          one link beyond current
peek() returns the link beyond current

*/