import javax.swing.JOptionPane;

//GallonsToLiters.java
//Gregory Gonzalez
//March 14, 2016
//Exercise 8-9, Page 331

 class GallonsToLiters
{
   public static void main(String[] args)
   {
      double liter = 3.785;
      int entries;
      String s1;

      s1 = JOptionPane.showInputDialog("Please enter the number of gallons to be converted: ");
      entries = Integer.parseInt(s1);

      int[] gallons = new int[entries];

      double[] galToLt = new double[entries];

      for (int i = 0; i < entries; i++)
      {
         s1 = JOptionPane.showInputDialog("Please enter the number of gallons for item" + (i+1) + ":");
         gallons[i] = Integer.parseInt(s1);
         galToLt[i] = gallons[i]*liter;
      }

      s1 = "Item#     Gallons     Liter Equivalent\n";
      s1 += "--------    ------------   ------------------------\n";
      for (int i = 1; i <= entries; i++)
      {
         s1 += String.format("  %2d             %4d                %9.3f%n", i, gallons[i-1], galToLt[i-1]);
      }

      JOptionPane.showMessageDialog(null, s1, "Gallons to Liters", JOptionPane.INFORMATION_MESSAGE);
   }
}