package todoapp;

//import libraries needed for our project
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//Definition of the class "ToDoApp"
public class App {
	//HashMap is a data structure that stores key-value pairs
	//the "key" is an integer that represents the task ID, and the value is an object "Task"
  private static HashMap<Integer, Task> tasks = new HashMap<>();
  //declares a variable named "taskIdCounter" of type integer and initializes it to 1
  //the ID counter increments every time we add a new task 
  private static int taskIdCounter = 1; 

  //this is the main method, we call this method when the progam starts running
  //it will take an array of strings as input
  public static void main(String[] args) {
  	//we create a scanner object named "scanner"
  	//we use System.in to obtain the input from the console
      Scanner scanner = new Scanner(System.in);

      //condition "true" indicates the loop will run forever unless interrupted by a "break"
      while (true) {
      	//this is our menu
      	//"System.out.println" prints the options the user will see 
          System.out.println("\nSelect an option:");
          System.out.println("1. Add Task");
          System.out.println("2. Delete Task");
          System.out.println("3. Mark Task as Completed/In Progress");
          System.out.println("4. Order Tasks");
          System.out.println("5. Display Tasks");
          System.out.println("6. Exit");

          //scanner.nextInt reads the input from the user (it will read an integer type)
          int choice = scanner.nextInt();
          //.nextLine()--> consumes the newline character (enter key) that's pressed after entering the choice
          //we can have issues when running the code if we forget to add this
          scanner.nextLine(); 

          //"switch" will perform different actions, depending on the users choice 
          switch (choice) {
          	//if the users chooses option 1
              case 1:
              	//then the "addTask" method is called, it reads the choice...
                  addTask(scanner);
                  //and breaks the loop 
                  break;
              case 2:
                  deleteTask(scanner);
                  break;
              case 3:
                  markTask(scanner);
                  break;
              case 4:
                  orderTasks(scanner);
                  break;
              case 5:
                  displayTasks();
                  break;
              case 6:
                  System.out.println("Exiting...");
                  return;
              //if the user prints an option that does not exist...
              default:
              	//this message gets print out 
                  System.out.println("Invalid choice. Please try again.");
          }
      }
  }

  //we declare a method called "addTask", it takes a Scanner type of value as a parameter
  private static void addTask(Scanner scanner) {
  	//it prints out the message "Enter Date (YYYY-MM-DD):" 
      System.out.println("Enter Date (YYYY-MM-DD):");
      //reads the input from the user and assigns the value to the "dateString" variable
      String dateString = scanner.nextLine();
      //it parses the string value to date format
      LocalDate date = LocalDate.parse(dateString);

      //prints out the message and prompts the user to enter a string value 
      System.out.println("Enter Task Name:");
      //reads input from the user
      String taskName = scanner.nextLine();

      System.out.println("Enter Task Description:");
      String taskDescription = scanner.nextLine();

      //prints the message and prompts the user to enter the state of the task
      System.out.println("Enter Task State (Type 'completed' or 'in progress'): ");
      //reads the input, converts the string to lowercase and assigns the value to the "taskStateInput" variable
      String taskStateInput = scanner.nextLine().toLowerCase();
      //declare a variable named "taskState", boolean type
      boolean taskState;
      //if the user enters the string "completed"
      if (taskStateInput.equals("completed")) {
      	//the value of taskState will be set to "true"
          taskState = true;
          
      //if the user enters "in progress"         
      } else if (taskStateInput.equals("in progress")) {
      	//taskState will be set to "false"
          taskState = false;
        //if none of the past conditions happens, the status will be set to "false" automatically  
      } else {
          System.out.println("Invalid input. Defaulting to 'in progress'.");
          taskState = false; // Default to 'in progress' if input is invalid
      }

      //we print the instruction for the user
      System.out.println("Enter Task Priority as follows H = High, I = Intermediate, L = Low:");
      //reads the first character of the input from the user and assigns it to the taskPriority variable 
      char taskPriority = scanner.nextLine().charAt(0);

      //declares a new object of the class "Task", this new object is named "task"
      //new initializes the object with the provided parameters 
      //taskIdCounter++ increments the value within the variable and assigns the new value to the variable each time 
      
      Task task = new Task(taskIdCounter++, date, taskName, taskDescription, taskState, taskPriority);
      //this refers to the HashMap named "tasks" that stores task objects -> private static HashMap<Integer, Task> tasks = new HashMap<>();
      //"put" is a method is used to add a new key-value pair to the HashMap
      //"task.taskId" is the key for the HashMap entry
      //"task" is is the value for the HashMap entry (refers to the task object, which contains all the information about the task"
      tasks.put(task.taskId, task);

      //prints confirmation message for the user
      System.out.println("Task added successfully!!");
  }

  //declares the "deleteTask" method, which will take the input in "scanner" as a parameter
  private static void deleteTask(Scanner scanner) {
  	//it prints out the instruction for the user
      System.out.println("Enter Task ID to delete:");
      //declare the variable "taskIdToDelete", which will take an integer as a value
      //takes the input from the user and assigns it to the taskIdToDelete variable
      int taskIdToDelete = scanner.nextInt();
      //remember to consume the enter character
      scanner.nextLine(); 
      
      //this condition checks if the value of "taskIdToDelete" exists within the HashMap
      if (tasks.containsKey(taskIdToDelete)) {
      	//if the condition is true...
      	//removes the task from the tasks HashMap using the remove method
      	//it removes the key-value pair associated with the value entered in "taskIdToDelete"
          tasks.remove(taskIdToDelete);
          //then prints a confirmation message for the user
          System.out.println("Task deleted successfully!");
        //if the condition is not true
      } else {
      	//we print out an error message to let the user know that their choice was not found 
          System.out.println("Task not found with provided ID.");
      }
  }

  //we declare the "marTask" method, it will take the Scanner object named "scanner" value a parameter
  private static void markTask(Scanner scanner) {
  	//print a message for the user
      System.out.println("Enter Task ID to mark:");
      //we read the input from the user and save it to the "taskIdToMark" variable
      //this variable expects an integer as an input
      int taskIdToMark = scanner.nextInt();
      //gets rid of the "enter"
      scanner.nextLine();

      //if the input is found within "tasks" as a key value
      if (tasks.containsKey(taskIdToMark)) {
      	//we retrieve the task associated with the provided task ID
      	//we will take this out of the HashMap values using the "get" method 
      	//then we assign it to the variable "task"
          Task task = tasks.get(taskIdToMark);
          //prompts the user to enter the new status of the task
          System.out.println("Enter Task State (True for completed, False for in progress):");
          //reads the input from the user and assigns it to the "newTaskState" variable
          //this new variable will take a boolean type of input 
          boolean newTaskState = scanner.nextBoolean();
          scanner.nextLine(); 
          //updates the attribute "taskState" with the new state provided by the user in "newTaskState"
          task.taskState = newTaskState;
          //confirmation message 
          System.out.println("Task state updated successfully!");
        //if the task ID is not found, we print a message alert for the user 
      } else {
          System.out.println("Task not found with provided ID.");
      }
  }

  //we declare a method named "orderTasks", this method will take value in "scanner" as a parameter
  private static void orderTasks(Scanner scanner) {
  	//mini menu
  	//prints out the first line of the menu
      System.out.println("Order tasks by:");
      //prints out the first option
      System.out.println("1. Date (Ascending)");
      //...second option
      System.out.println("2. Date (Descending)");
      //...third...
      System.out.println("3. Priority");

      //define "orderChoice" variable and save the input from the user into it 
      int orderChoice = scanner.nextInt();
      //consume the "enter"
      scanner.nextLine();

      //we take the value in orderChoice and execute the proper method
      switch (orderChoice) {
      	//if the option is = 1 
          case 1:
          	//we call the "orderTasksByDate" method and set it to "true"
          	//it gets set to "true" so it shows the the asc order
              orderTasksByDate(true);
              //breaks the loop
              break;
          //if the option selected is 2 
          case 2:
          	//we call the same method but set it to false
          	//so we get the list in desc order (opposite to the 1st option)
              orderTasksByDate(false);
              //breaks the cycle 
              break;
          //if the input is = 3
          case 3:
          	//we call the "orderTaskByPriority" method
              orderTasksByPriority();
              //and break the loop
              break;
          //if none of the past 3 options are chosen, we let the user know the option was not valid
          //and no action is executed
          default:
              System.out.println("Invalid choice. Tasks remain unordered.");
      }

      //if one of the 2 options was executed, a confirmation message gets print out
      System.out.println("Tasks ordered successfully!");
      //and we display the tasks in the selected order
      displayTasks();
  }

  //declaration of the "orderTasksByDate" method
  //this method will take a boolean type of data as a parameter
  private static void orderTasksByDate(boolean ascending) {
  	//creates a new array list named "taskList" and initializes it with the values contained in the HashMap "tasks"
  	//this array will allow us to manipulate the list without modifying the HashMap
  	//values() is a method provided by the Map interface, it returns a "Collection" view of the values contained in the map
      List<Task> taskList = new ArrayList<>(tasks.values());
      //if the ascending parameter is true...
      if (ascending) {
      	//we use the "sort" method from the "Collections" class
      	//it sorts the taskList in ascending order based on the attribute "date" of each task
          Collections.sort(taskList, Comparator.comparing(task -> task.date));
         //if the ascending parameter is false, the tasks will be sorted out in descending order 
      } else {
      	//it sorts out the tasks in ascending order as before...
          Collections.sort(taskList, Comparator.comparing(task -> task.date));
          //and then we use the "reverse" method to reverse the order of the elements in the task list
          Collections.reverse(taskList);
      }
      //it clears all entries in the HashMap "tasks"
      tasks.clear();
      //iterates over each object in the task list of the class Task
      for (Task task : taskList) {
      	//adds each task object (task) back to the HashMap "tasks"
      	//it uses the task's ID (task.taskId) as the key and the task object itself as the value
      	//basically updates the tasks HashMap with the sorted tasks
          tasks.put(task.taskId, task);
      }
  }

  //declaration of the "orderTasksByPriority" method
  private static void orderTasksByPriority() {
  	//creates an array list named "taskList" and initializes it with the values (task objects) from the "tasks" HashMap
  	//uses the method "values"
      List<Task> taskList = new ArrayList<>(tasks.values());
  	//remember... values() is a method provided by the Map interface, it returns a "Collection" view of the values contained in the map
      //lambda expression: task -> task.taskPriority 
      //it indicates that tasks should be sorted based on the "taskPriority" attribute
      Collections.sort(taskList, Comparator.comparing(task -> task.taskPriority));
      //clears the entries of HashMap
      tasks.clear();
      //this for iterates over each Task object in the "taskList"
      for (Task task : taskList) {
      	//then adds each task object (task) back to the HashMap named "tasks"
          tasks.put(task.taskId, task);
      }
  }

  //we declare the method "displayTasks"
  private static void displayTasks() {
  	//if there is no data in "tasks"
      if (tasks.isEmpty()) {
      	//prints a message advising the user there are no tasks to show 
          System.out.println("No tasks to display.");
          return;
      }
      
      //if there is data stored in "tasks"
      //we print it in the following format...
      //prints the string "Tasks:"...
      // "\n" is used to create a visual separation between different sections of output in the console
      System.out.println("\nTasks:");
      //this "for" iterates over each Task (object) stored in the HashMap "tasks"
      for (Task task : tasks.values()) {
      	//prints out the phrase "Task ID:" and adds the value contained in the "taskId" (attribute) of the object "task"
          System.out.println("Task ID: " + task.taskId);
          //prints out the phrase "Date:" and adds the value contained in the "date" (attribute) of the object "task"
          System.out.println("Date: " + task.date);
          //prints out the phrase "Task Name:" and adds the value contained in the "taskName" (attribute) of the object "task"
          System.out.println("Task Name: " + task.taskName);
          //prints out the phrase "Task Description:" and adds the value contained in the "taskDescription" (attribute) of the object "task"
          System.out.println("Task Description: " + task.taskDescription);
          //prints out the phrase "Task State:" and adds the value contained in the "taskState" (attribute) of the object "task"
          //it uses a ternary operator to determine whether the task is completed or in progress...
          //...based on the "taskState" attribute of the object "tasks"...
          //...then prints the corresponding task state (as a string)
          System.out.println("Task State: " + (task.taskState ? "Completed" : "In Progress"));
          //prints out the phrase "Task Priority:" and adds the value contained in the "taskPriority" (attribute) of the object "task"
          System.out.println("Task Priority: " + task.taskPriority);
          //prints a new line to the console to separate 
          System.out.println();
      }
  }
}