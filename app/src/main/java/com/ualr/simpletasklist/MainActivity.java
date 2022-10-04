//
//  UALR - MAD - F22 - Assignment 3 - MVC To-Do List
//
//  Project: UALR - Mobile Applications Development - Fall 2022 - Assignment 3 - MVC To-Do List
//  Created by: Mark McCorkle on 20220925
//  Based on: Code Provided by Dr Ivan Rodriguez-Conde
//
//  IDE:
//     Android Studio Chipmunk | 2021.2.1 Patch 2
//     Build #AI-212.5712.43.2112.8815526, built on July 10, 2022
//     Runtime version: 11.0.12+0-b1504.28-7817840 x86_64
//     VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
//     macOS 11.5.2
//     GC: G1 Young Generation, G1 Old Generation
//     Memory: 2048M
//     Cores: 8
//     Registry: external.system.auto.import.disabled=true
//
package com.ualr.simpletasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;

import com.ualr.simpletasklist.databinding.ActivityMainBinding;
import com.ualr.simpletasklist.model.TaskList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // TODO 05. Add a TaskList member to the MainActivity. Initialize the new member.
    private TaskList taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize the taskList:
        taskList = new TaskList();

        //TODO 06.02 Bind the onAddBtnClicked method to the add button, so the onAddBtnClicked is
        // triggered whenever the user clicks on that button
        binding.addBtn.setOnClickListener(v -> onAddBtnClicked());

        //TODO 07.02 Bind the onDeleteBtnClicked method to the delete button, so that method is
        // triggered whenever the user clicks on that button
        binding.deleteBtn.setOnClickListener(v -> onDeleteBtnClicked());

        //TODO 08.02 Bind the onDoneBtnClicked method to the done button, so the onDoneBtnClicked method is
        // triggered whenever the user clicks on that button
        binding.doneBtn.setOnClickListener(v -> onDoneBtnClicked());

        // Remove - For testing purposes only :
        {
            //taskList.addTask("TODO 1 Define two attributes for the Task class: one to store the task description and a second one that indicates whether the task is done or not");
            //taskList.addTask("TODO 2 Define the class constructor and the corresponding getters and setters.");
            //taskList.addTask("TODO 3 Define TaskList's attributes. The class will have just one attribute to store all the tasks created by the user.");
            //taskList.addTask("TODO 4 Define the class constructor and the corresponding getters and setters.");
            //taskList.addTask("TODO 5 Add a TaskList member to the MainActivity. Initialize the new member.");
            //taskList.addTask("TODO 6 Create a new functionality to add a new task using the description provided through the text field on the top of the screen by tapping the + on the right");
            //taskList.addTask("TODO 7 Create a new functionality to delete a task from the task list");
            //taskList.addTask("TODO 8 Create a new functionality to mark a task as done.");

            //displayTasks();
        }
    }

    // TODO 06. Create a new functionality to add a new task using the description provided
    //  through the text field on the top of the screen by tapping the "+" on the right

    // TODO 06.01. Create a new method called onAddBtnClicked.
    public void onAddBtnClicked() {
        // Logic for empty task description:
        if (binding.editTextTaskDescription.getText().toString().isEmpty()) {

            // Make user acknowledge that the text has not been entered via an alert dialog box:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder
                    // Set the Title to the Alert Dialog Box:
                    .setTitle(getResources().getString(R.string.alert_dialog_title))

                    // Set the Message to the Alert Dialog Box:
                    .setMessage(getResources().getText(R.string.alert_dialog_msg))

                    // Set the Button Text on the Alert Dialog Box:
                    .setPositiveButton(getResources().getText(R.string.ok), (dialog, id) -> binding.editTextTaskDescription.requestFocus());
            AlertDialog alert = builder.create();
            alert.show();

        }
        // Logic to process new task:
        else {
            // TODO 06.05. Invoke TaskList class' add method to ask the TaskList to
            //  add a new Task with the description provided through the text field.
            // Add the new task using the task description the user has entered:
            taskList.addTask(binding.editTextTaskDescription.getText().toString());

            // Clean up:
            binding.editTextTaskDescription.getText().clear();

            // Display the tasks to the textView:
            displayTasks();
        }
    }

    // TODO 06.06. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"
    public void displayTasks() {
        binding.textView.setText(taskList.toString());
    }

    // TODO 07. Create a new functionality to delete a task from the task list

    // TODO 07.01. Create a new method called onDeleteBtnClicked.
    public void onDeleteBtnClicked() {
        // Logic for empty task id:
        if (binding.editTextTaskId.getText().toString().isEmpty()) {
            // Make user acknowledge that the id has not been entered via an alert dialog box:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder
                    // Set the Title to the Alert Dialog Box:
                    .setTitle(getResources().getString(R.string.alert_dialog_title))

                    // Set the Message to the Alert Dialog Box:
                    .setMessage(getResources().getText(R.string.alert_dialog_msg_delete_task))

                    // Set the Button Text on the Alert Dialog Box:
                    .setPositiveButton(getResources().getText(R.string.ok), (dialog, id) -> binding.editTextTaskDescription.requestFocus());
            AlertDialog alert = builder.create();
            alert.show();
        }
        // Logic to process deleting the task:
        else {
            // TODO 07.04. Invoke TaskList class' delete method to ask the TaskList to
            //  delete a Task given the id provided through the text field on the bottom.
            if(!taskList.delete(Integer.valueOf(binding.editTextTaskId.getText().toString()))) {
                // Make user acknowledge that the task has not been found via an alert dialog box:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder
                        // Set the Title to the Alert Dialog Box:
                        .setTitle(getResources().getString(R.string.alert_dialog_title_entry_not_found))

                        // Set the Message to the Alert Dialog Box:
                        .setMessage(getResources().getText(R.string.alert_dialog_msg_entry_not_found))

                        // Set the Button Text on the Alert Dialog Box:
                        .setPositiveButton(getResources().getText(R.string.ok), (dialog, id) -> binding.editTextTaskDescription.requestFocus());
                AlertDialog alert = builder.create();
                alert.show();
            }

            // Clean up:
            binding.editTextTaskId.getText().clear();
        }

        // TODO 07.05. Use TaskList class' toString method to get a string with the formatted task list
        //  and display it on screen in the TextView with the id "textView"
        displayTasks();
    }

    // TODO 08. Create a new functionality to mark a task as done.

    // TODO 08.01. Create a new method called onDoneBtnClicked
    public void onDoneBtnClicked() {
        // Logic for empty task id:
        if (binding.editTextTaskId.getText().toString().isEmpty()) {
            // Make user acknowledge that the id has not been entered via an alert dialog box:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder
                    // Set the Title to the Alert Dialog Box:
                    .setTitle(getResources().getString(R.string.alert_dialog_title))

                    // Set the Message to the Alert Dialog Box:
                    .setMessage(getResources().getText(R.string.alert_dialog_msg_delete_task))

                    // Set the Button Text on the Alert Dialog Box:
                    .setPositiveButton(getResources().getText(R.string.ok), (dialog, id) -> binding.editTextTaskDescription.requestFocus());
            AlertDialog alert = builder.create();
            alert.show();
        }
        // Logic to process deleting the task:
        else {
            // TODO 08.04. Invoke TaskList class' markDone method to ask the TaskList to
            //  mark a Task given the id provided through the text field on the bottom.
            if(!taskList.markDone(Integer.valueOf(binding.editTextTaskId.getText().toString()))) {
                // Make user acknowledge that the task has not been found via an alert dialog box:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder
                        // Set the Title to the Alert Dialog Box:
                        .setTitle(getResources().getString(R.string.alert_dialog_title_entry_not_found))

                        // Set the Message to the Alert Dialog Box:
                        .setMessage(getResources().getText(R.string.alert_dialog_msg_entry_not_found))

                        // Set the Button Text on the Alert Dialog Box:
                        .setPositiveButton(getResources().getText(R.string.ok), (dialog, id) -> binding.editTextTaskDescription.requestFocus());
                AlertDialog alert = builder.create();
                alert.show();
            }

            // Clean up:
            binding.editTextTaskId.getText().clear();
        }

        // TODO 08.05. Use TaskList class' toString method to get a string with the formatted task list
        //  and display it on screen in the TextView with the id "textView"
        // Display the tasks to the textView:
        displayTasks();
    }
}