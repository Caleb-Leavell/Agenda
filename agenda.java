import java.util.*;
import java.io.*;

//Task Class
class Task{
    public String name;
    public String description;
    public String deadlineDate;
    public String deadlineTime;
    public int minuteDue;
    public int hourDue;
    public int dayDue;
    public int monthDue;
    public int yearDue;
    public long timeDue;

    public Task(String name, String description, String deadlineDate, String deadlineTime) {
      this.name = name;
      this.description = description;
      this.deadlineDate = deadlineDate;
      this.deadlineTime = deadlineTime;
    }
    public void getTimeDue() {
      int timeColonIndex = this.deadlineTime.indexOf(':');
      int[] dateSlashIndicies = {deadlineDate.indexOf('/'), deadlineDate.indexOf('/', deadlineDate.indexOf('/') + 1)};

      //hour due
      this.hourDue = Integer.parseInt(this.deadlineTime.substring(0,timeColonIndex));
      String amOrPm = this.deadlineTime.substring(deadlineTime.indexOf(' ', timeColonIndex), deadlineTime.length());
      if(amOrPm.contains("pm") || amOrPm.contains("PM") || amOrPm.contains ("Pm")) {
        hourDue += 12;
      }

      //minute due
      this.minuteDue = Integer.parseInt(this.deadlineTime.substring(timeColonIndex + 1, deadlineTime.indexOf(' ', timeColonIndex)));

      //month due
      this.monthDue = Integer.parseInt(this.deadlineDate.substring(0, dateSlashIndicies[0]));

      //day due
      this.dayDue = Integer.parseInt(this.deadlineDate.substring(dateSlashIndicies[0] + 1, dateSlashIndicies[1]));

      //year due
      this.yearDue = Integer.parseInt(this.deadlineDate.substring(dateSlashIndicies[1] + 1, deadlineDate.length()));

      //time due boiled down to a code
      //sorting based on this rather than year then month then day etc. saves a lot of processing time
            this.timeDue = this.minuteDue + (this.hourDue * 100) +  (this.dayDue * 10000) + (this.monthDue * 1000000) + (this.yearDue * 100000000);
      
    }

    public static Task[] sortTasks(Task[] tasks) {
        Task[] sortedTasks = new Task[tasks.length];
        //copy tasks to new array
        for(int i = 0; i < tasks.length; i ++) {
          sortedTasks[i] = new Task(tasks[i].name, tasks[i].description, tasks[i].deadlineDate, tasks[i].deadlineTime);
          sortedTasks[i].getTimeDue();
        }

        //selection sort tasks by time due (see getTimeDue() for how time due is calculated)
        for(int i = 0; i < sortedTasks.length-1; i ++) {

          int min = i;
          for(int j = i + 1; j < sortedTasks.length; j ++) {
            if(sortedTasks[j].timeDue < sortedTasks[min].timeDue) {
              min = j;
            }
          }

          
            Task temporary = sortedTasks[i];
            sortedTasks[i] = sortedTasks[min];
            sortedTasks[min] = temporary;
          
        }


        return sortedTasks;

    }

}

public class agenda {
  public static void main(String[] argv) {
    Scanner scnr = new Scanner(System.in);

    //tasks list (it has initial tasks for testing purposes)
    Task[] tasks = new Task[0];

    home(scnr, tasks);
  }

  //displays each task; takes in the list of tasks
  public static void displayTasks(Task[] tasks) {

      if(tasks.length > 1) {
        tasks = Task.sortTasks(tasks);
      }
      if(tasks.length > 0) {
        for(int i = 0; i < tasks.length; i ++) {
          System.out.println(tasks[i].deadlineDate + " at " + tasks[i].deadlineTime + " - " + tasks[i].name);
          System.out.println("  " + tasks[i].description + "\n");
        }
      }
      else {
        System.out.println("No tasks to complete!");
      }
  }

  public static Task[] addTask(Scanner scnr, Task[] tasks) {

      scnr.nextLine();

      //add empty index
      Task[] tempList = new Task[tasks.length + 1];
      for(int i = 0; i < tasks.length; i ++) {
        tempList[i] = tasks[i];
      }

      Task[] newTasks = new Task[tempList.length];

      for(int i = 0; i < newTasks.length; i ++) {
        newTasks[i] = tempList[i];
      }

      //fill empty index with user input
      newTasks[newTasks.length - 1] = new Task("", "", "", "");
      System.out.print("Task Name: ");
      newTasks[newTasks.length - 1].name = scnr.nextLine();
      System.out.print("Date Due (mm/dd/yyyy): ");
      newTasks[newTasks.length - 1].deadlineDate = scnr.nextLine();
      System.out.print("Time Due (hh:mm am/pm): ");
      newTasks[newTasks.length - 1].deadlineTime = scnr.nextLine();
      System.out.print("Task Description: ");
      newTasks[newTasks.length - 1].description = scnr.nextLine();

      return newTasks;
  }

  //home + get user input, takes in scnr and list of tasks
  public static void home(Scanner scnr, Task[] tasks) {
    int optionChosen;

    //Display Home Screen
    System.out.println("\n\n\n\n\n\n\n\nAGENDA\n\nInput Options:\n-View Current Tasks: 0\n-Add a new Task: 1\n-Mark a Task as Completed: 2\n-Exit: 4");
    
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
      tasks = addTask(scnr, tasks);
      home(scnr, tasks);
    }
    //exit program
      return;
  }
}
