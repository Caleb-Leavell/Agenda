import java.util.Scanner;

class Task {
    String name;
    String description;
    String deadlineDate;
    String deadlineTime;

    public Task(String name, String description, String deadlineDate, String deadlineTime) {
      this.name = name;
      this.description = description;
      this.deadlineDate = deadlineDate;
      this.deadlineTime = deadlineTime;
    }

}

public class agenda {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    int optionChosen;
    Task task1 = new Task("hw 1", "it's hw 1", "5/5/7", "5:00");

    System.out.println(task1.name);

    //Display Home Screen
    System.out.println("\nAGENDA\n\nInput Options:\n-View Current Tasks: 0\n-Add a new Task: 1\n");
    
    //Get Input
    System.out.print("Choose Option: ");
    optionChosen = scnr.nextInt();
    System.out.println("");

    System.out.println("You chose option " + optionChosen  + "!");
  }
}
