import java.util.Scanner;

public class agenda {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    int optionChosen;

    //Display Home Screen
    System.out.println("\nAGENDA\n\nInput Options:\n-View Current Tasks: 0\n-Add a new Task: 1\n");
    
    //Get Input
    System.out.print("Choose Option: ");
    optionChosen = scnr.nextInt();
    System.out.println("");

    System.out.println("You chose option " + optionChosen  + "!");
  }
}
