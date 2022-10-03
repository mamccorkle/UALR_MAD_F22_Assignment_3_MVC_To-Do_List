package com.ualr.simpletasklist.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TaskList {

    // TODO 03. Define TaskList's attributes. The class will have just one attribute to store all
    //  the tasks created by the user.
    // TIP. We need a data structure able to dynamically grow and shrink. That's why we'll use a HashMap.
    // where keys will be integer values and the mapped values will be a task object
    Map<Integer, Task> mTaskList;

    // TODO 04. Define the class constructor and the corresponding getters and setters.
    public TaskList() {
        mTaskList = new HashMap<>();
    }

    // TODO 06.03. Define a new method called "add" that, given a task description, will create a
    //  new task and add it to the task list.
    public void addTask( String taskDescription ) {
        mTaskList.put( mTaskList.size() + 1, new Task(taskDescription, false ));
    }

    // TODO 06.04. Define a new "toString" method that provides a formatted string with all the tasks in the task list.
    // Format: 1 line per task. Each line should start with the id number of the task, then a dash, and the task description right after that.
    // If the task is marked as done, "Done" should be included at the end of the line
    public String toString() {
        // Create a new instance of the a string builder object to append the string data together:
        StringBuilder returnString = new StringBuilder();

        // Loop through each element in the map listing its key, task description, and completion
        // status. Each will be concatenated to a final string to be displayed in the textview:
        for (Map.Entry<Integer, Task> pair : mTaskList.entrySet()) {

            // List the id and description:
            returnString.append(
                    pair.getKey()).append(" - ").append(pair.getValue().getTaskDescription()
            );

            // List the task completion status
            if(pair.getValue().getTaskComplete())
                returnString.append(" - Done\n");
            else
                returnString.append(" - NOT Done\n");
        }

        // Return the final string to be displayed in the text view:
        return returnString.toString();
    }

    // TODO 07.03. Define a new method called "delete" that, given a task id, will delete the
    //  corresponding task from the task list.
    public boolean delete( Integer id ) {
        // Loop through each of the tasks in the task list using an iterator. If one is found,
        // delete it and return true that it has been deleted. Otherwise, return false.
        for( Iterator<Map.Entry<Integer, Task>> itr = mTaskList.entrySet().iterator(); itr.hasNext(); ) {
            Map.Entry<Integer, Task> entry = itr.next();
            if(entry.getKey().equals(id)) {
                itr.remove();
                return true;
            }
        }

        // Task has not been found:
        return false;
    }

    // TODO 08.03. Define a new method called "markDone" that, given a task id, will mark the
    //  corresponding task as done.
    public boolean markDone( Integer id ) {
        // Loop through each of the tasks in the task list using a range-based for-loop. If one is
        // found, mark it as complete and return true that it has been completed. Otherwise, return
        // false:
        for (Map.Entry<Integer, Task> pair : mTaskList.entrySet() ) {
            if(pair.getKey().equals(id)) {
                pair.getValue().setTaskComplete(true);
                return true;
            }
        }

        // Task has not been found:
        return false;
    }

}
