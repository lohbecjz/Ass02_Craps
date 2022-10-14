/**
 * @author lohbecjz@mail.uc.edu
 */

import java.util.Random; // must import Random
import java.util.Scanner;

public class Ass02_Craps
{
    public static void main(String[] args)
    {

        // Define variables
        Scanner in = new Scanner(System.in); // create a Scanner object called in
        Random rnd = new Random(); // create a Random object called rnd
        int die1 = 0;
        int die2 = 0;
        int crapsRoll = 0;
        int thePoint = 0;
        int pointRoll = 0;
        String playAgain = "";

        // Process and output
        do
        {
            die1 = rnd.nextInt(6) + 1; // generates a random int between 1 and 6
            die2 = rnd.nextInt(6) + 1;
            crapsRoll = die1 + die2; // Gaussian range from 2 to 12 as in rolling two dice

            System.out.printf("You rolled %d + %d = %d %n", die1, die2, crapsRoll);

            if ((crapsRoll == 2) || (crapsRoll == 3) || (crapsRoll == 12))
            {
                System.out.println("CRAPS! You lose!!!");
            }
            else if ((crapsRoll == 7) || (crapsRoll == 11))
            {
                System.out.println("NATURAL! You win!!!");
            }
            else // crapsRoll is now thePoint
            {
                thePoint = crapsRoll;
                System.out.println(thePoint + " is now the point!");

                do
                {
                    System.out.println("Trying for point!");
                    die1 = rnd.nextInt(6) + 1; // generates a random int between 1 and 6
                    die2 = rnd.nextInt(6) + 1;
                    pointRoll = die1 + die2; // Gaussian range from 2 to 12 as in rolling two dice
                    System.out.printf("You rolled %d + %d = %d %n", die1, die2, pointRoll);

                    if (pointRoll == thePoint) // player rolled the point and wins
                    {
                        System.out.println("You rolled the point! You win!!!");
                    }

                    if (pointRoll == 7) // pointRoll is seven and player loses
                    {
                        System.out.println("You rolled seven! You lose!!!");
                    }

                } while ((pointRoll != thePoint) && (pointRoll != 7));
            }

            while (true)
            {
                System.out.print("Play again [Y / N]: ");
                playAgain = in.nextLine();

                if ((playAgain.equalsIgnoreCase("Y")) || (playAgain.equalsIgnoreCase("N")))
                {
                    break;
                }
                else
                {
                    System.out.println(playAgain + " is not a valid choice.");
                }
            }

        } while (playAgain.equalsIgnoreCase("Y"));
    }
}