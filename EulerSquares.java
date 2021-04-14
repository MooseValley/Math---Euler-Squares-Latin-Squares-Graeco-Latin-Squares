/*
https://www.youtube.com/watch?v=qu04xLNrk94
Euler Squares - Numberphile

Graeco-Latin Squares
Double Latin Sqaures

2x2 cannot be done.
6x6 cannot be done.
10x10 cannot be done.

*** Sample output:

Group 3x3:
A VS 1              B VS 2              C VS 3
C VS 2              A VS 3              B VS 1
B VS 3              C VS 1              A VS 2

Teams 4x4:
Mike VS Murray      Frankie VS Hank     Bella VS Saminal    Teenie VS Jessica
Teenie VS Hank      Mike VS Saminal     Frankie VS Jessica  Bella VS Murray
Bella VS Saminal    Teenie VS Jessica   Mike VS Murray      Frankie VS Hank
Frankie VS Jessica  Bella VS Murray     Teenie VS Hank      Mike VS Saminal

Group 5x5:
A VS 1              B VS 2              C VS 3              D VS 4              E VS 5
E VS 2              A VS 3              B VS 4              C VS 5              D VS 1
D VS 3              E VS 4              A VS 5              B VS 1              C VS 2
C VS 4              D VS 5              E VS 1              A VS 2              B VS 3
B VS 5              C VS 1              D VS 2              E VS 3              A VS 4

*/
public class EulerSquares
{
   static String[] group3A  = {"A",   "B", "C"};
   static String[] group3B  = {"1",   "2", "3"};

   static String[] team1Players = {"Mike",   "Frankie", "Bella",   "Teenie"};
   static String[] team2Players = {"Murray", "Hank",    "Saminal", "Jessica"};

   static String[] group5A  = {"A", "B", "C", "D", "E"};
   static String[] group5B  = {"1", "2", "3", "4", "5"};

   static String[] group6A  = {"A", "B", "C", "D", "E", "F"};
   static String[] group6B  = {"1", "2", "3", "4", "5", "6"};

   public static String[][] getAllCombinations (String[] arr1, String[] arr2, String separatorStr)
   {
      String[][] allCombinations = null;

      if (arr1.length < 3)
      {
         System.out.println ("ERROR: will not work for groups of 2 or less items.");
      }
      else if (arr1.length != arr2.length)
      {
         System.out.println ("ERROR: both groups must be the same size.");
      }
      else
      {
         int len = arr1.length;

         allCombinations = new String [len][len];

         int t1Index = 0;
         int t2Index = 0;

         for (int row = 0; row < len; row++)
         {
            for (int col = 0; col < len; col++)
            {
               t1Index = t1Index % len;
               t2Index = t2Index % len;

               //System.out.println ("allCombinations [" + row + "][" + col + "] = " +
               //                    "arr1 [" + t1Index + "]" + separatorStr + "arr2 [" + t2Index + "]");

               allCombinations [row][col] = arr1 [t1Index] + separatorStr + arr2 [t2Index];

               t1Index++;
               t2Index++;
            }

            /*
            Lots of ways to do this ... but this way gives a nice
            result where the 1st item in the 1st array moves
            across the resulting grid 1 square each row.
            */

              // t1Index++;
              // t2Index++;

            //t1Index = row + 1;
            t1Index--;
            t2Index = row + 1;
         }

      }

      return allCombinations;
   }

   public static void displayAllCombinations (String[][] allCombinations)
   {
      for (int row = 0; row < allCombinations.length; row++)
      {
         for (int col = 0; col < allCombinations[row].length; col++)
         {
            System.out.print (String.format ("%-5s", allCombinations [row][col]) );
         }
         System.out.println ();
      }
   }

   public static void main (String[] args)
   {
      String[][] resultArray = getAllCombinations (group3A, group3B, "-");

      System.out.println ("\n" + "Group 3x3:");
      displayAllCombinations (resultArray);

      System.out.println ("\n" + "Teams 4x4:");
      displayAllCombinations (getAllCombinations (team1Players, team2Players, " vs ") );

      System.out.println ("\n" + "Group 5x5:");
      displayAllCombinations (getAllCombinations (group5A, group5B, "-") );

      System.out.println ("\n" + "Group 6x6:");
      displayAllCombinations (getAllCombinations (group6A, group6B, "-") );
      System.out.println ("ERROR: does not work - the same combinations appear multiple times.");

      System.out.println ();
   }
}