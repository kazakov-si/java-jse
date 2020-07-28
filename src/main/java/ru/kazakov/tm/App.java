package ru.kazakov.tm;

import ru.kazakov.tm.dao.ProjectDAO;
import ru.kazakov.tm.dao.TaskDAO;
import ru.kazakov.tm.entity.Project;
import ru.kazakov.tm.entity.Task;

import java.util.Arrays;
import java.util.Scanner;

import static ru.kazakov.tm.constant.TerminalConst.*;

public class App {

    private static final ProjectDAO projectDAO = new ProjectDAO();

    private static final TaskDAO taskDAO = new TaskDAO();

    private static final Scanner scanner = new Scanner(System.in);

    static {
        projectDAO.create("DEMO PROJECT 1");
        projectDAO.create("DEMO PROJECT 2");
        taskDAO.create("TEST Task 1");
        taskDAO.create("TEST Task 2");
    }

    public static void main(String[] args) {
        run(args);
        displayWelcome();
        String command = "";
        while (!Exit.equals(command)) {
            command = scanner.nextLine();
            run(command);
        }
    }

    private static void run(final String[] args) {
        if (args == null) return;
        if (args.length < 1) return;
        final String param = args[0];
        final int result = run(param);
        System.exit(result);
    }

    private static int run(final String param) {
        if (param == null || param.isEmpty()) return -1;
        switch (param) {
            case VERSION:
                return displayVersion();
            case ABOUT:
                return displayAbout();
            case HELP:
                return displayHelp();
            case Exit:
                return displayExit();

            case PROJECT_LIST:
                return listProject();
            case PROJECT_CLEAR:
                return clearProject();
            case PROJECT_CREATE:
                return createProject();
            case PROJECT_VIEW:
                return viewProjectByIndex();
            case PROJECT_REMOVE_BY_NAME:
                return removeProjectByName();
            case PROJECT_REMOVE_BY_ID:
                return removeProjectById();
            case PROJECT_REMOVE_BY_INDEX:
                return removeProjectByIndex();
            case PROJECT_UPDATE_BY_INDEX:
                return updateProjectByIndex();

            case TASK_LIST:
                return listTask();
            case TASK_CLEAR:
                return clearTask();
            case TASK_CREATE:
                return createTask();
            case TASK_VIEW:
                return viewTaskByIndex();
            case TASK_REMOVE_BY_NAME:
                return removeTaskByName();
            case TASK_REMOVE_BY_ID:
                return removeTaskById();
            case TASK_REMOVE_BY_INDEX:
                return removeTaskByIndex();
            case TASK_UPDATE_BY_INDEX:
                return updateTaskByIndex();

            default:
                return displayError();
        }
    }

    private static int createProject() {
        System.out.println("[CREATE PROJECT]");
        System.out.println("PLEASE, ENTER PROJECT NAME:");
        final String name = scanner.nextLine();
        System.out.println("PLEASE, ENTER PROJECT DESCRIPTION:");
        final String description = scanner.nextLine();
        projectDAO.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateProjectByIndex() {
        System.out.println("[UPDATE PROJECT]");
        System.out.println("ENTER, PROJECT INDEX:");
        final int index = Integer.parseInt(scanner.nextLine()) - 1;
        final Project project = projectDAO.findByIndex(index);
        if (project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("PLEASE, ENTER PROJECT NAME:");
        final String name = scanner.nextLine();
        System.out.println("PLEASE, ENTER PROJECT DESCRIPTION:");
        final String description = scanner.nextLine();
        projectDAO.update(project.getId(), name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int removeProjectById() {
        System.out.println("[REMOVE PROJECT BY ID]");
        System.out.println("PLEASE, ENTER PROJECT ID:");
        final long id = scanner.nextLong();
        final Project project = projectDAO.removeById(id);
        if (project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeProjectByIndex() {
        System.out.println("[REMOVE PROJECT BY INDEX]");
        System.out.println("PLEASE, ENTER PROJECT INDEX:");
        final int index = scanner.nextInt() - 1;
        final Project project = projectDAO.removeByIndex(index);
        if (project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeProjectByName() {
        System.out.println("[REMOVE PROJECT BY NAME]");
        System.out.println("PLEASE, ENTER PROJECT NAME:");
        final String name = scanner.nextLine();
        final Project project = projectDAO.removeByName(name);
        if (project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int clearProject() {
        System.out.println("[CLEAR PROJECT]");
        projectDAO.clear();
        System.out.println("[OK]");
        return 0;
    }

    private static int listProject() {
        System.out.println("[LIST PROJECT]");
        int index = 1;
        for (final Project project : projectDAO.findAll()) {
            System.out.println(index + ". " + project.getId() + ": " + project.getName());
            index++;
        }
        System.out.println("[OK]");
        return 0;
    }

    private static int createTask() {
        System.out.println("[CREATE TASK]");
        System.out.println("PLEASE, ENTER TASK NAME:");
        final String name = scanner.nextLine();
        System.out.println("PLEASE, ENTER TASK DESCRIPTION:");
        final String description = scanner.nextLine();
        taskDAO.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateTaskByIndex() {
        System.out.println("[UPDATE TASK]");
        System.out.println("ENTER, TASK INDEX:");
        final int index = Integer.parseInt(scanner.nextLine()) - 1;
        final Task task = taskDAO.findByIndex(index);
        if (task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("PLEASE, ENTER TASK NAME:");
        final String name = scanner.nextLine();
        System.out.println("PLEASE, ENTER TASK DESCRIPTION:");
        final String description = scanner.nextLine();
        taskDAO.update(task.getId(), name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int removeTaskById() {
        System.out.println("[REMOVE TASK BY ID]");
        System.out.println("PLEASE, ENTER TASK ID:");
        final long id = scanner.nextLong();
        final Task task = taskDAO.removeById(id);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeTaskByIndex() {
        System.out.println("[REMOVE TASK BY INDEX]");
        System.out.println("PLEASE, ENTER TASK INDEX:");
        final int index = scanner.nextInt() - 1;
        final Task task = taskDAO.removeByIndex(index);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeTaskByName() {
        System.out.println("[REMOVE TASK BY NAME]");
        System.out.println("PLEASE, ENTER TASK NAME:");
        final String name = scanner.nextLine();
        final Task task = taskDAO.removeByName(name);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int clearTask() {
        System.out.println("[CLEAR TASK]");
        taskDAO.clear();
        System.out.println("[OK]");
        return 0;
    }

    private static void viewTask(final Task task) {
        if (task == null) return;
        System.out.println("[VIEW TASK]");
        System.out.println("ID: " + task.getId());
        System.out.println("NAME: " + task.getName());
        System.out.println("DESCRIPTION: " + task.getDescription());
        System.out.println("[OK]");
    }

    private static void viewProject(final Project project) {
        if (project == null) return;
        System.out.println("[VIEW TASK]");
        System.out.println("ID: " + project.getId());
        System.out.println("NAME: " + project.getName());
        System.out.println("DESCRIPTION: " + project.getDescription());
        System.out.println("[OK]");
    }

    private static int viewTaskByIndex() {
        System.out.println("ENTER, TASK INDEX:");
        final int index = scanner.nextInt() - 1;
        final Task task = taskDAO.findByIndex(index);
        viewTask(task);
        return 0;
    }

    private static int viewProjectByIndex() {
        System.out.println("ENTER, PROJECT INDEX:");
        final int index = scanner.nextInt() - 1;
        final Project project = projectDAO.findByIndex(index);
        viewProject(project);
        return 0;
    }

    private static int listTask() {
        System.out.println("[LIST TASK]");
        int index = 1;
        for (final Task task : taskDAO.findAll()) {
            System.out.println(index + ". " + task.getId() + ": " + task.getName());
            index++;
        }
        System.out.println("[OK]");
        return 0;
    }

    private static int displayExit() {
        System.out.println("Terminate program...");
        return 0;
    }

    private static int displayError() {
        System.out.println("Error! Unknown program argument...");
        return -1;
    }

    private static void displayWelcome() {
        System.out.println("** WELCOME TO TASK MANAGER **");
    }

    private static int displayHelp() {
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

    private static int displayVersion() {
        System.out.println("1.0.0");
        return 0;
    }

    private static int displayAbout() {
        System.out.println("Kazakov Sergey");
        System.out.println("kazakov_si@nlmk.com");
        return 0;
    }
}
