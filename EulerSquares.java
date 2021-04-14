/*
https://www.youtube.com/watch?v=qu04xLNrk94
Euler Squares - Numberphile

Graeco-Latin Squares
Double Latin Sqaures

2x2 cannot be done.
6x6 cannot be done.

*** Sample output:

Group 3x3:
A-1  B-2  C-3
C-2  A-3  B-1
B-3  C-1  A-2

Teams 4x4:
Mike vs Murray      Frankie vs Hank     Bella vs Saminal    Teenie vs Jessica
Teenie vs Hank      Mike vs Saminal     Frankie vs Jessica  Bella vs Murray
Bella vs Saminal    Teenie vs Jessica   Mike vs Murray      Frankie vs Hank
Frankie vs Jessica  Bella vs Murray     Teenie vs Hank      Mike vs Saminal

Group 5x5:
A-1  B-2  C-3  D-4  E-5
E-2  A-3  B-4  C-5  D-1
D-3  E-4  A-5  B-1  C-2
C-4  D-5  E-1  A-2  B-3
B-5  C-1  D-2  E-3  A-4

Group 6x6:
A-1  B-2  C-3  D-4  E-5  F-6
F-2  A-3  B-4  C-5  D-6  E-1
E-3  F-4  A-5  B-6  C-1  D-2
D-4  E-5  F-6  A-1  B-2  C-3
C-5  D-6  E-1  F-2  A-3  B-4
B-6  C-1  D-2  E-3  F-4  A-5
ERROR: does not work - the same combinations appear multiple times.

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
      int strFormatSize = getMaxItemLength (allCombinations) + 2;

      for (int row = 0; row < allCombinations.length; row++)
      {
         for (int col = 0; col < allCombinations[row].length; col++)
         {
            System.out.print (String.format ("%-" + strFormatSize + "s",
                                             allCombinations [row][col]) );
         }
         System.out.println ();
      }
   }

   private static int getMaxItemLength (String[][] allCombinations)
   {
      int maxLength = 0;

      for (int row = 0; row < allCombinations.length; row++)
      {
         for (int col = 0; col < allCombinations[row].length; col++)
         {
            if (allCombinations [row][col].length() > maxLength)
            {
               maxLength = allCombinations [row][col].length();
            }
         }
      }

      return maxLength;
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