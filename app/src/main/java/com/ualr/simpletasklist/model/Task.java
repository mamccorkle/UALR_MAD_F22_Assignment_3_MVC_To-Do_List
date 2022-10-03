package com.ualr.simpletasklist.model;

public class Task {
    // TODO 01. Define two attributes for the Task class: one to store the task description and a second one that
    //  indicates whether the task is done or not
    private String  taskDescription;
    private Boolean taskComplete;

    // TODO 02. Define the class constructor and the corresponding getters and setters.
    public Task(String taskDescription, Boolean taskComplete) {
        this.taskDescription = taskDescription;
        this.taskComplete = taskComplete;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Boolean getTaskComplete() {
        return taskComplete;
    }

    public void setTaskComplete(Boolean taskComplete) {
        this.taskComplete = taskComplete;
    }

}
