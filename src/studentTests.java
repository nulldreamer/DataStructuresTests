import javax.swing.*;
 class wages
{
    public static void main(String[] args)

    {
        double number, part, full;
        String s1;



        s1= JOptionPane.showInputDialog ( "Enter your hours worked ");
        number = Double.parseDouble(s1);

        if (number <= 1|| number > 100)
            System.out.println("Invalid percentage, must be between 1 - 100");

        else if (number <= 40)
        {
            part = 8 * number;
            System.out.println("You will recieve" +part);
        }
        else
        {
            full = 12 * number + 320;
            System.out.println("You will recieve" +full);
        }



    }

}