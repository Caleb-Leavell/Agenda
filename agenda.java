import java.util.Scanner;

//Task Class
class Task {
    public String name;
    public String description;
    public String deadlineDate;
    public String deadlineTime;
    public int minuteDue;
    public int hourDue;
    public int dayDue;
    public int monthDue;
    public int yearDue;

    public Task(String name, String description, String deadlineDate, String deadlineTime) {
      this.name = name;
      this.description = description;
      this.deadlineDate = deadlineDate;
      this.deadlineTime = deadlineTime;
    }
    public void getTimeDue() {
      int timeColonIndex = this.deadlineTime.indexOf(':');
      int[] dateSlashIndicies = {deadlineDate.indexOf('/'), deadlineDate.indexOf('/', deadlineDate.indexOf('/') + 1)};
      this.hourDue = Integer.parseInt(this.deadlineTime.substring(0,timeColonIndex));
      this.minuteDue = Integer.parseInt(this.deadlineTime.substring(timeColonIndex + 1, deadlineTime.indexOf(' ', timeColonIndex)));
      this.monthDue = Integer.parseInt(this.deadlineDate.substring(0, dateSlashIndicies[0]));
      this.dayDue = Integer.parseInt(this.deadlineDate.substring(dateSlashIndicies[0] + 1, dateSlashIndicies[1]));
      this.yearDue = Integer.parseInt(this.deadlineDate.substring(dateSlashIndicies[1] + 1, deadlineDate.length()));

      System.out.println("hour: " + this.hourDue);
      System.out.println("minute: " + this.minuteDue);
      System.out.println("day: " + this.dayDue);
      System.out.println("month: " + this.monthDue);
      System.out.println("year: " + yearDue);
    }

}

public class agenda {
  public static void main(String[] argv) {
    Scanner scnr = new Scanner(System.in);

    //tasks list
    Task[] tasks = new Task[1];

    home(scnr, tasks);
  }

  //displays each task; takes in the list of tasks
  public static void displayTasks(Task[] tasks) {
      if(tasks.length > 1) {
        for(int i = 0; i < tasks.length - 1; i ++) {
          System.out.println(tasks[i].deadlineDate + " at " + tasks[i].deadlineTime + " - " + tasks[i].name);
          System.out.println("  " + tasks[i].description);
        }
      }
      else {
        System.out.println("No tasks to complete!");
      }
  }

  //home + get user input, takes in scnr and list of tasks
  public static void home(Scanner scnr, Task[] tasks) {
    int optionChosen;

    //Display Home Screen
    System.out.println("\nAGENDA\n\nInput Options:\n-View Current Tasks: 0\n-Add a new Task: 1\n-Mark a Task as Completed: 2\n-Exit: 4");
    
    //Get Input
    System.out.print("Choose Option: ");
    optionChosen = scnr.nextInt();
    System.out.println("");

    doAppNavigation(optionChosen, tasks, scnr);
  }

  //handles user input to navigate through app, takes in the option chosen by the user, the list of tasks, and scnr
  public static void doAppNavigation(int optionChosen, Task[] tasks, Scanner scnr) {

    //display tasks
    if(optionChosen == 0) {
      displayTasks(tasks);
      home(scnr, tasks);
    }

    //add task
    if(optionChosen == 1) {
      scnr.nextLine();
      tasks[tasks.length - 1] = new Task("", "", "", "");
      System.out.print("Task Name: ");
      tasks[tasks.length - 1].name = scnr.nextLine();
      System.out.print("Date Due (mm/dd/yyyy): ");
      tasks[tasks.length - 1].deadlineDate = scnr.nextLine();
      System.out.print("Time Due (hh:mm am/pm): ");
      tasks[tasks.length - 1].deadlineTime = scnr.nextLine();
      System.out.print("Task Description: ");
      tasks[tasks.length - 1].description = scnr.nextLine();

      Task[] tempList = new Task[tasks.length+1];
      for(int i = 0; i < tasks.length; i ++) {
        tempList[i] = tasks[i];
      }
      tasks = new Task[tempList.length];
      for(int i = 0; i < tasks.length; i ++) {
        tasks[i] = tempList[i];
      }
      System.out.println(tasks[0].name);

      home(scnr, tasks);
    }

    if(optionChosen == 2) {
      tasks[0].getTimeDue();
    }
    //exit program
      return;
  }
}
