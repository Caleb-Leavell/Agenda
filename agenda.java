import java.util.Scanner;

public class agenda {
  public static void main(String[] argv) {
    Scanner scnr = new Scanner(System.in);

    int optionChosen;
    String[] taskNames = new String[argv.length + 1];
    for(int i = 0; i < argv.length; i ++) {
      taskNames[i] = argv[i];
    }

    //Display Home Screen
    System.out.println("\nAGENDA\n\nInput Options:\n-View Current Tasks: 0\n-Add a new Task: 1\n-Mark a Task as Completed: 2\n-Exit: 4");
    
    //Get Input
    System.out.print("Choose Option: ");
    optionChosen = scnr.nextInt();
    System.out.println("");

   if(optionChosen == 0) {
      System.out.println("");
      if(argv.length == 0) {
        System.out.println("No tasks to complete!");
      }
      else {
        for(int i = 0; i < taskNames.length-1; i ++) {
          System.out.println(taskNames[i]);
        }
      }
   }

    if(optionChosen == 1) {
      System.out.print("\nCreate the Task Name: ");
      taskNames[taskNames.length - 2] = scnr.next();
      System.out.println("");
    }

    if(optionChosen != 4) {
      main(taskNames);
    }
    //System.out.println("You chose option " + optionChosen  + "!");
  }
}
