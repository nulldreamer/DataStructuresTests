// Queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      System.out.println("New Queue...\nrear:" + rear + ", front:" + front+", nItems:" + nItems);
      System.out.println("0's indicate \"empty slot\"");
      }

   public void show_que()
   {
      System.out.print("{");
      for (int i = 0; i < maxSize; i++)
      {
         if(i<maxSize-1)
            System.out.print(queArray[i]+",");
         else
            System.out.println(queArray[i]+"}");
      }
   }
//--------------------------------------------------------------
   public void insert(long j)   // put item at rear of queue
      {
      System.out.println("\nInserting " + j + " into the queue.");

      if(rear == maxSize-1)         // deal with wraparound
         rear = -1; // if rear gets to the end, restart it at the beginning
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item

      System.out.println("rear:" + rear + ", front:" + front+", nItems:" + nItems);
      }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      long temp = queArray[front]; // get value and incr front
      queArray[front] = 0; // make it zero, so element looks "empty" in show_que()
      front++;
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item

      System.out.println("\nRemoving " + temp + " from the queue.");
      System.out.println("rear:" + rear + ", front:" + front+", nItems:" + nItems);
      return temp;


      }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }
//--------------------------------------------------------------
   }  // end class Queue
////////////////////////////////////////////////////////////////
class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items
      theQueue.show_que();

      System.out.print("====== I N S E R T ======");
      
      theQueue.insert(10);            // insert 5 items
      theQueue.show_que();
      theQueue.insert(20);
      theQueue.show_que();
      theQueue.insert(30);
      theQueue.show_que();
      theQueue.insert(40);
      theQueue.show_que();
      theQueue.insert(50);
      theQueue.show_que();

      System.out.print("====== R E M O V E ======");
      theQueue.remove();              // remove 3 items
      theQueue.show_que();
      theQueue.remove();              //    (10, 20, 30)
      theQueue.show_que();
      theQueue.remove();
      theQueue.show_que();

      System.out.print("====== I N S E R T ======");
      theQueue.insert(60);            // insert 4 more items  ,(wraps around)
      theQueue.show_que();
      theQueue.insert(70);            
      theQueue.show_que();
      theQueue.insert(80);
      theQueue.show_que();

      if (!theQueue.isFull())
      {
         theQueue.insert(90);
         theQueue.show_que();
      }
      
      System.out.print("====== R E M O V E ======");
      while( !theQueue.isEmpty() )    // remove and display
         {                            //    all items
            theQueue.remove();
            theQueue.show_que();
         //long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         //System.out.print(n);
         //System.out.print(" ");
         }
      //System.out.println("");
      }  // end main()
   }  // end class QueueApp
////////////////////////////////////////////////////////////////
