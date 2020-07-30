package ru.kazakov.tm.controller;

public class SystermController {

    public int displayExit() {
        System.out.println("Terminate program...");
        return 0;
    }

    public int displayError() {
        System.out.println("Error! Unknown program argument...");
        return -1;
    }

    public void displayWelcome() {
        System.out.println("** WELCOME TO TASK MANAGER **");
    }

    public int displayHelp() {
        System.out.println("version - Display application version.");
        System.out.println("about - Display developer info.");
        System.out.println("help - Display list of commands.");
        System.out.println("exit - Terminate console application.");
        System.out.println();
        System.out.println("project-list - Display list of projects.");
        System.out.println("project-create - Create new project by name.");
        System.out.println("project-clear - Remove all projects.");
        System.out.println("project-list - Display all projects.");
        System.out.println("project-view - Display project by index.");
        System.out.println("project-remove-by-id - Delete project by id.");
        System.out.println("project-remove-by-index - Delete project by index.");
        System.out.println("project-remove-by-name - Delete project by name");
        System.out.println("project-update-by-index - Update project by index.");
        System.out.println();
        System.out.println("task-list - Display list of tasks.");
        System.out.println("task-create - Create new task by name.");
        System.out.println("task-clear - Remove all tasks.");
        System.out.println("task-list - Display all tasks.");
        System.out.println("task-view - Display task by index.");
        System.out.println("task-remove-by-id - Delete task by id.");
        System.out.println("task-remove-by-index - Delete task by index.");
        System.out.println("task-remove-by-name - Delete task by name");
        System.out.println("task-update-by-index - Update task by index.");

        return 0;
    }

    public int displayVersion() {
        System.out.println("1.0.9");
        return 0;
    }

    public int displayAbout() {
        System.out.println("Kazakov Sergey");
        System.out.println("kazakov_si@nlmk.com");
        return 0;
    }

}
