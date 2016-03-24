
class Recursions
{

    static void iterativeTriangularNumbers(int term)
    {
        /*
         1 3 6 10 15 21 28 <-- TRIANGULAR NUMBERS

         TERM CURRENT = INDEX + PREVIOUS
          1     1
          2     3     =    2    +  1    =           2+1
          3     6     =    3    +  3    =         3+2+1
          4     10    =    4    +  6    =       4+3+2+1
          5     15    =    5    +  10   =     5+4+3+2+1
          6     21    =    6    +  15   =   6+5+4+3+2+1
          7     28    =    7    +  21   = 7+6+5+4+3+2+1

        GIVEN 'TERM', FIND 'CURRENT':
        */
        int current = 1;
        for (int index = 2; index <= term; index++)
            current = index + current;

        System.out.println("For term " + term + " current = " + current);
    }
                                                                //                                                        STOPS
    static int recursiveTriangularNumbers(int term)             // term=4          term=3              term=2            term=1
    {
        if (term == 1)
            return 1;
        else
            return term + recursiveTriangularNumbers(term-1); //return 4+rec..(3) return 3+rec..(2)  return 2+rec..(1)  return 1

    }

    static void iterativeFactorials(int term)
    {
        /*
         1 2 6 24 120 720 5040 <-- TRIANGULAR NUMBERS

         TERM CURRENT = INDEX * PREVIOUS
          1     1
          2     2     =    2    *  1   = 2*1
          3     6     =    3    *  2   = 3*2*1
          4     24    =    4    *  6   = 4*3*2*1
          5     120   =    5    *  24  = 5*4*3*2*1
          6     720   =    6    *  120 = 6*5*4*3*2*1
          7     5040  =    7    *  720 = 7*6*5*4*3*2*1

        GIVEN 'TERM', FIND 'CURRENT':
        */
        int current = 1;
        for (int index = 1; index <= term; index++)
        {
            current = current * index;
        }

        System.out.println("For term " + term + " current = " + current);
    }

    static int recursiveFactorial(int term)
    {
        if (term == 1)
            return 1;
        else
            return term * recursiveFactorial(term-1);
    }

    static void mergeTwoArrays(int [] first, int [] second)
    {

    }



    static void showArray(int [] array)
    {
        System.out.print("{");
        for (int i = 0; i < array.length-1; i++)
            System.out.print(array[i]+",");
        System.out.println(array[array.length-1]+"}");
    }

    public static void main(String[] args)
    {
        //iterativeFactorials(7);
        //System.out.println("For term " + 6 + " current = " + recursiveFactorial(6));

        // Make the array
        int [] first =  {1,2,3}; //new int[3];
        int [] second = {4,5,6};

        //showArray(bigArray);
    }
}
