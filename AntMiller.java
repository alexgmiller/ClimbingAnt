
/*
 1. Alex Miller
 July 7, 2022
 3. This program simulates an ant trying to crawl up a building of certain height. It takes in input for height from the user and displays how many times the ant slips with it havin a 50% chance of slipping on each step.
 4. The program is complete and works exactly the same as the sample output but is late so I'm hoping to get half credit if  I'm allowed any credit at all.
 */
import java.util.*;

// calls the run method and creates a scanner and random variable
public class AntMiller {
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    Random rand = new Random();
    run(kb, rand);
  }

  // runs the program and displays the results of the getHeight and move methods
  public static void run(Scanner kb, Random rand) {
    boolean repeat = true;
    while (repeat) {
      int h = getHeight(kb);
      int slip = move(h, rand);
      System.out.println("To climb up the building of height " + h + " steps the ant slipped " + slip + " times.");
      System.out.println("Would you like to run the program again?");
      String answer = kb.next();
      if (answer.toLowerCase().equals("yes")) {
        repeat = true;
      } else if (answer.toLowerCase().equals("no")) {
        repeat = false;
      }
    }
  }

  // uses a nested while loop to get the height of the building from the user
  // making sure it's above 0
  public static int getHeight(Scanner kb) {
    boolean repeat = true;
    int getHeight = 0;
    while (repeat) {
      System.out.println("What is the height of the building: ");
      while (!kb.hasNextInt()) {
        kb.next();
        System.out.println("Please enter an integer above 0.");
      }
      getHeight = kb.nextInt();
      if (getHeight >= 0) {
        repeat = false;
      }
    }
    return getHeight;
  }

  // uses a do-while loop in order to determine whether the ant slips using the
  // random class
  public static int move(int h, Random rand) {
    int slip = 0;
    int height = 0;
    do {
      int r = rand.nextInt(2);
      if (r == 0) {
        slip++;
        height = 0;
      } else if (r == 1) {
        height++;
      }
    } while (h > height);
    return slip;
  }
}