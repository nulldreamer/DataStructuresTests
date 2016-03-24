/**
 * Created by anonymous on 3/12/16.
 */
class aLink
{
    int data;
    aLink next;
    aLink previous;

    aLink(int value) { data = value; next = null; previous = null; }
    public String toString() { return  data+" "; }
}

class doubleLinkedQueue
{
    aLink first;
    aLink last;

    doubleLinkedQueue()    {        first = null; last = null;    }

    void showSmallest()
    {
        if (!empty())
        {
            System.out.println("Smallest is: " + findSmallest());
        }
    }

    aLink findSmallest()
    {
        if (!empty())
        {
            aLink smallest = first;
            aLink current = first;

            while(current != null)
            {
                if ( current.data  < smallest.data)
                    smallest = current;

                current = current.next;
            }

            return smallest;
        }
        return null;
    }

    void showLargest()
    {
        if (!empty())
        {
            System.out.println("Largest is: " + findLargest());
        }
    }

    aLink findLargest()
    {
        if (!empty())
        {
            aLink largest = first;
            aLink current = first;

            while(current != null)
            {
                if (current.data > largest.data)
                    largest = current;

                current = current.next;
            }

            return largest;
        }
        return null;
    }

    void insertInAscendingOrder(int value)
    {

        aLink newLink = new aLink(value);

        // INSERT IN AN EMPTY LIST ...10
        if (empty())
        {
            first = newLink;
            last = newLink;
            return;
        }

        // INSERT IF ONLY 1 Link
        if (first == last)
        {
            if (newLink.data >= first.data) // INSERT TO THE RIGHT OF Link1 ...10 <--> 100
            {
                first.next = newLink;
                newLink.previous = first;
                last = newLink;
            }
            else                            // INSERT TO THE LEFT OF Link2  ...-100 <--> 10
            {
                newLink.next = first;
                first.previous = newLink;
                first = newLink;
            }
            return;
        }

        // INSERT IF 2 OR MORE LINKS  ...10 <--> 100 ...
        aLink current = first;
        aLink before, after;
        while(current != null)
        {


            if (newLink.data <= current.data) // INSERT TO THE LEFT of current, if newLink <= current
            {
                // INSERT *5* BEFORE THE FIRST LINK ... *5* <--> 10 <--> 100
                // ...inserting *5*
                if (current == first)
                {
                    newLink.next = first;
                    first.previous = newLink;
                    first = newLink;
                    break;
                }

                // INSERT BEFORE THE LAST LINK
                // 5(@430)/First <--> 20(@432)/Last/Current ... inserting 20(@435)/newLink
                else if (current == last)      // current = last = @432
                {
                    // before = @430
                    before = current.previous;
                    // @430.next = @435
                    before.next = newLink; // @430 --> @435
                    // @435.previous = @430
                    newLink.previous = before; //  @430 <-- @435
                    // @430 <--> @435

                    // @432.previous = @435
                    current.previous = newLink; // @435 <-- @432
                    // @435.next = @432
                    newLink.next = current;    // @435 --> @432
                    // @435 <--> @432
                    // @430/First <--> @435/newLink <--> @432/Last

                    break;
                }


                // INSERT BETWEEN TWO LINKS ... 5/first <--> 10 <--> 50/current <--> 100/last
                // ...inserting 20/newLink
                else                           // current: 50
                {
                    before = current.previous; // before = 10

                    before.next = newLink;     // 10 --> 20
                    newLink.previous = before; // 10 <-- 20

                    newLink.next = current;     // 20 --> 50
                    current.previous = newLink; // 20 <-- 50
                    break;
                }

            }
            // if newLink > current, and we are all the way at the end of the list
            // then, newLink becomes the new last link
            else if (current == last)
            {
                last.next = newLink;
                newLink.previous = last;
                last = newLink;
                break;
            }
            current = current.next;
        }
    }

    void insertBeforeALink(int LinkValue, int value)
    {
        aLink newLink = new aLink(value);
        aLink before, linkWhereLinkValueFound;

        // IF THE LINK IS FOUND
        if ( findLink(LinkValue) != null )
        {
            linkWhereLinkValueFound = findLink(LinkValue);

            // IF IT IS THE ONLY LINK, THEN LINK TO THE LEFT IS null
            if (linkWhereLinkValueFound.previous == null)
            {
                linkWhereLinkValueFound.previous = newLink;
                newLink.next = linkWhereLinkValueFound;
                first = newLink;
                return;
            }

            // IF THERE IS A LINK TO THE LEFT, LINK TO THE LEFT IS NOT null
            else
            {
                // ... LinkA <--> LinkB ...
                // linkWhereLinkValueFound is LinkB

                before = linkWhereLinkValueFound.previous; // before = LinkA
                linkWhereLinkValueFound.previous = newLink;// newLink <-- LinkB
                newLink.next = linkWhereLinkValueFound;    // newLink --> LinkB ... newLink <--> LinkB

                before.next = newLink;         // before/LinkA --> newLink ... before/LinkA  --> newLink <--> LinkB
                newLink.previous = before;     // before/LinkA <-- newLink ... before/LinkA <--> newLink <--> LinkB
            }
        }
    }

    void insertAfterALink(int LinkValue, int value)
    {
        aLink newLink = new aLink(value);
        aLink after, linkWhereLinkValueFound;

        // IF THE LINK IS FOUND
        if ( findLink(LinkValue) != null )
        {
            linkWhereLinkValueFound = findLink(LinkValue);

            // IF IT IS THE ONLY LINK, LINK TO THE RIGHT IS null ... linkWhereLinkValueFound/First/Last
            if (linkWhereLinkValueFound.next == null)
            {
                linkWhereLinkValueFound.next = newLink;     // linkWhereLinkValueFound/First/Last  --> newLink
                newLink.previous = linkWhereLinkValueFound; // linkWhereLinkValueFound/First/Last <--> newLink
                newLink.next = null;
                last = newLink;                             // linkWhereLinkValueFound/First <--> newLink/Last

                return;
            }

            // IF THERE IS A LINK TO THE RIGHT
            else
            {
                // ... LinkA <--> LinkB ...
                // linkWhereLinkValueFound is LinkA

                after = linkWhereLinkValueFound.next;      // after = LinkB
                linkWhereLinkValueFound.next = newLink;    // LinkA --> newLink
                newLink.previous = linkWhereLinkValueFound;// LinkA <-- newLink  ... LinkA <--> newLink
                // ... LinkA <--> newLink

                newLink.next = after;         //  ...LinkA --> newLink --> LinkB ...
                after.previous = newLink;     //  ...LinkA --> newLink <-- LinkB ... newLink <--> LinkB
                // ...LinkA <--> newLink <--> LinkB
            }

        }
    }

    void insertFirstLeft(int value)
    {
        aLink newLink = new aLink(value);
        if ( empty() ) // first link
        {
            first = newLink;
            last = newLink;
        }
        else // it's not the first link
        {
            newLink.next = first;     //  newLink --> old first ...
            first.previous = newLink; //  newLink <--> old first ...
            first = newLink;          //  first/newLink <--> old first ...
        }
    }

    void insertLastRight(int value)
    {
        aLink newLink = new aLink(value);
        if ( empty() ) // first link
        {
            first = newLink;
            last = newLink;
        }
        else // it's not the first link
        {
            last.next = newLink;
            newLink.previous = last;
            last = newLink;
        }
    }

    void removeFirstLeft()
    {
        if ( !empty() )
        {
            if (first == last) // IF ONLY ONE LINK
            {
                removeOnlyLink();
                return;
            }

            first = first.next;
            first.previous = null;
        }
    }

    void removeOnlyLink()
    {
        first = null;
        last = null;
    }

    void removeFirstRight()
    {
        if ( !empty() )
        {
            if (first == last) // IF ONLY ONE LINK
            {
                removeOnlyLink();
                return;
            }
            last = last.previous;
            last.next = null;
        }
    }

    void removeLink(int key)
    {
        if ( findLink(key) != null )
        {
            aLink toRemove = findLink(key);

            if ( !empty() )
            {
                // REMOVE THE ONLY LINK
                if (toRemove.next == null && toRemove.previous==null)
                {
                    first=null;
                    last=null;
                    return;
                }

                // REMOVE THE LAST LINK
                if (toRemove.next == null)
                {
                    last = last.previous;
                    last.next = null;
                    return;
                }

                // REMOVE THE FIRST LINK
                if (toRemove.previous == null)
                {
                    first = first.next;
                    first.previous = null;
                    return;
                }

                // REMOVE A LINK THAT IS IN BETWEEN TWO OTHER LINKS
                if (toRemove.previous != null && toRemove.next != null)
                {
                    aLink before, after;
                    before = toRemove.previous;
                    after = toRemove.next;

                    before.next = after;
                    after.previous = before;
                }
            }
        }
    }

    void showLink(int key)
    {
        if (findLink(key) != null)
            System.out.println( "Key " + findLink(key) +"found!");
        else
            System.out.println("Key " + key + " not found :( ");

    }

    aLink findLink(int key)
    {
        aLink current = first;
        while (current != null)
        {
            if (current.data == key)
                return current;

            current = current.next;
        }
        return null;
    }

    void showDLQ()
     {
        aLink current = first;

        if (!empty())
        {
            while (current != null)
            {
                System.out.print(current);
                current = current.next;
            }
        }
        System.out.println();

    }

    boolean empty() { return (first==null && last==null);  }


}

class doubleLinkedQueueApp
{
    public static void main(String[] args)
    {
        doubleLinkedQueue double_linked_queue = new doubleLinkedQueue();

        double_linked_queue.insertInAscendingOrder(5);
        double_linked_queue.insertInAscendingOrder(10);

        double_linked_queue.insertInAscendingOrder(100);
        double_linked_queue.insertInAscendingOrder(100);
        double_linked_queue.insertInAscendingOrder(-100);
        double_linked_queue.insertInAscendingOrder(-100);

        double_linked_queue.insertInAscendingOrder(50);
        double_linked_queue.insertInAscendingOrder(20);
        double_linked_queue.insertInAscendingOrder(20);
//
        double_linked_queue.insertInAscendingOrder(30);
        double_linked_queue.insertInAscendingOrder(40);
        double_linked_queue.insertInAscendingOrder(6);
        //double_linked_queue.insertLastRight(10);
        //double_linked_queue.insertLastRight(20);
        //double_linked_queue.insertLastRight(30);
        //double_linked_queue.removeFirstRight();
        //double_linked_queue.removeFirstRight();
        //double_linked_queue.removeFirstRight();
        //double_linked_queue.removeLink(30);
        //double_linked_queue.removeLink(10);
        //double_linked_queue.removeLink(20);
        //double_linked_queue.insertBeforeALink(10,20);
        //double_linked_queue.insertBeforeALink(10,40);
        //double_linked_queue.insertBeforeALink(40,50);
        //double_linked_queue.insertBeforeALink(20,30);
        //double_linked_queue.insertBeforeALink(10,99);
        //double_linked_queue.insertAfterALink(10,20);

        //double_linked_queue.insertAfterALink(10,30);
        //double_linked_queue.insertAfterALink(20,50);
        //double_linked_queue.insertAfterALink(30,5);
        //double_linked_queue.insertFirstLeft(100);
        //double_linked_queue.insertAfterALink(10,200);

        //double_linked_queue.showLargest();
        //double_linked_queue.showSmallest();
        //double_linked_queue.showDLQ();
        //double_linked_queue.bubbleSort();
        double_linked_queue.showDLQ();
    }
}
