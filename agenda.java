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

    Task[] tasks = new Task[1];

    home(scnr, tasks);
    
  }

  public static void displayTaskNames(Task[] tasks) {
      if(tasks.length > 1) {
        for(int i = 0; i < tasks.length - 1; i ++) {
          System.out.println(tasks[i].name);
        }
      }
      else {
        System.out.println("No tasks to complete!");
      }
  }

  public static void home(Scanner scnr, Task[] tasks) {
    int optionChosen;

    System.out.println("\nAGENDA\n\nInput Options:\n-View Current Tasks: 0\n-Add a new Task: 1\n");

    System.out.print("Choose Option: ");
    optionChosen = scnr.nextInt();
    System.out.println("");

    doAppNavigation(optionChosen, tasks, scnr);
  }

  public static void doAppNavigation(int optionChosen, Task[] tasks, Scanner scnr) {
    if(optionChosen == 0) {
      displayTaskNames(tasks);
      home(scnr, tasks);
    }

    if(optionChosen == 1) {
      tasks[tasks.length - 1] = new Task("", "", "", "");
      System.out.print("Task Name: ");
      tasks[tasks.length - 1].name = scnr.nextLine();
      System.out.print("Task Description: ");
      tasks[tasks.length - 1].description = scnr.nextLine();

      Task[] tempList = new Task[tasks.length+1];
      for(int i = 0; i < tasks.length; i ++) {
        tempList[i] = tasks[i];
      }
      tasks = tempList;

      home(scnr, tasks);
    }

    if(optionChosen == 4) {
      return;
    }
  }
}
