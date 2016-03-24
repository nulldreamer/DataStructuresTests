class myArray
{
    int theArray [];
    int nElems;
    myArray(int maxSize)
    {
        theArray = new int[maxSize];
        nElems = 0;
    }

    void insert(int key)
    {
        theArray[nElems] = key;
        nElems++;
    }

    void showArray()
    {
        System.out.print("{");
        for (int i = 0; i < nElems-1; i++)
            System.out.print(theArray[i] + ",");
        System.out.println(theArray[nElems-1] + "}");
    }

    void showArray(int min, int max)
    {
        if (min!=max)
        {
            for (int i = min; i < max - 1; i++)
                System.out.print(theArray[i] + ",");
            System.out.println(theArray[max - 1]);
        }

    }

    void splitArray()
    {
        int midpoint = nElems/2;

        System.out.println("midpoint = " + midpoint);

        if (nElems >= 2)
        {
            System.out.print("\nFirst half of the array: ");
            showArray(0, midpoint);
            System.out.println();

            System.out.print("Second half of the array: ");
            showArray(midpoint, nElems);
        }

        if (nElems >= 4)
        {
            System.out.print("First Quarter of the array: ");
            showArray(0, midpoint / 2);
            System.out.print("Second Quarter of the array: ");
            showArray(midpoint / 2, midpoint);

            if(nElems%2 == 0) // if even number of elements
            {
                System.out.print("Third Quarter of the array: ");
                showArray(midpoint, midpoint + midpoint / 2);
                System.out.print("Fourth Quarter of the array: ");
                showArray(midpoint + midpoint / 2, nElems);
            }

            else // if odd number of elements
            {
                System.out.print("Third Quarter of the array: ");
                showArray(midpoint, midpoint + midpoint / 2 + 1);
                System.out.print("Fourth Quarter of the array: ");
                showArray(midpoint + midpoint / 2 + 1, nElems);
            }
        }
    }

    void splitArrayIntoHalves()
    {
        int midpoint = nElems/2;

        System.out.println("midpoint = " + midpoint);
        // split into two if 2 elements {11,22} , midpoint = 1, index: 0,1
        // half1 is 11
        // half2 is 22

        // split into 3 if 3 elements {11,22,33} , midpoint = 1, index: 0,1,2
        // half1 is 11:       0 to (midpoint - 1)
        // half2 is 22,33:  midpoint to 2 ...(nElems-1)
        //    - half3 is 22   midpoint + 0
        //    - half4 is 33   midpoint + 1

        // split into 4 if 4  more elements {11,22,33,44} , midpoint = 2, index: 0,1,2,3
        // half1 is 11,22:    0 to (midpoint - 1)
        //     - sub-half1: 11   begin + 0
        //     - sub-half2: 22   begin + 1
        // half2 is 33,44:    midpoint to 2 ...(nElems-1)
        //    - sub-half1: 11
        //    - sub-half2: 11


    }
}
public class iterativeMergeSort
{
    public static void main(String[] args)
    {
        myArray anArray = new myArray(11);
        anArray.insert(11);
        anArray.insert(22);
        anArray.insert(33);
        anArray.insert(44);
//        anArray.insert(55);
//        anArray.insert(66);
//        anArray.insert(77);
//        anArray.insert(88);
//        anArray.insert(99);
//        anArray.insert(100);
//        anArray.insert(110);
        System.out.print("Original Array: ");
        anArray.showArray();
//        anArray.splitArray();
        anArray.splitArrayIntoHalves();
    }
}
