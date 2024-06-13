package todoapp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//we define the class Tank
class Task {
	//we define the "variables" needed
    int taskId; //task identifier, integer type
    LocalDate date; // date of the task, we use the date format for it 
    String taskName; //name of the task, string type 
    String taskDescription; //description of the task -> string type 
    boolean taskState; //state of the task: true -> completed / false -> incomplete
    char taskPriority; //char type allows only ONE character 

    //this is a CONSTRUCTOR, we need it to initialize the object "Task"
    //this constructor will take 6 parameters: taskId, date, taskName, taskDescription, taskState and task Priority
    Task(int taskId, LocalDate date, String taskName, String taskDescription, boolean taskState, char taskPriority) {
    	//assigns the value contained in the parameter "taskId" to the variable taskId (the one in the class)
    	//"this" indicates the object being created
        this.taskId = taskId;
        //same as this.taskId
        this.date = date;
        //...
        this.taskName = taskName;
        //...
        this.taskDescription = taskDescription;
        //...
        this.taskState = taskState;
        //...
        this.taskPriority = taskPriority;
    }
}