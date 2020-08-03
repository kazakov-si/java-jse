package ru.kazakov.tm;

import ru.kazakov.tm.controller.ProjectController;
import ru.kazakov.tm.controller.SystermController;
import ru.kazakov.tm.controller.TaskController;
import ru.kazakov.tm.repository.ProjectRepository;
import ru.kazakov.tm.repository.TaskRepository;
import ru.kazakov.tm.service.ProjectService;
import ru.kazakov.tm.service.ProjectTaskService;
import ru.kazakov.tm.service.TaskService;

import java.util.Scanner;

import static ru.kazakov.tm.constant.TerminalConst.*;

public class App {

    private final ProjectRepository projectRepository = new ProjectRepository();

    private final TaskRepository taskRepository = new TaskRepository();

    private final ProjectService projectService = new ProjectService(projectRepository);

    private final TaskService taskService = new TaskService(taskRepository);

    private final ProjectTaskService projectTaskService = new ProjectTaskService(projectRepository, taskRepository);

    private final ProjectController projectController = new ProjectController(projectService);

    private final TaskController taskController = new TaskController(taskService, projectTaskService );


    private final SystermController systermController = new SystermController();

    {
        projectRepository.create("DEMO PROJECT 1");
        projectRepository.create("DEMO PROJECT 2");
        taskRepository.create("TEST Task 1");
        taskRepository.create("TEST Task 2");
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final App app = new App();
        app.run(args);
        app.systermController.displayWelcome();
        String command = "";
        while (!Exit.equals(command)) {
            command = scanner.nextLine();
            app.run(command);
        }
    }

    public void run(final String[] args) {
        if (args == null) return;
        if (args.length < 1) return;
        final String param = args[0];
        final int result = run(param);
        System.exit(result);
    }

    public int run(final String param) {
        if (param == null || param.isEmpty()) return -1;
        switch (param) {
            case VERSION:
                return systermController.displayVersion();
            case ABOUT:
                return systermController.displayAbout();
            case HELP:
                return systermController.displayHelp();
            case Exit:
                return systermController.displayExit();

            case PROJECT_LIST:
                return projectController.listProject();
            case PROJECT_CLEAR:
                return projectController.clearProject();
            case PROJECT_CREATE:
                return projectController.createProject();
            case PROJECT_VIEW:
                return projectController.viewProjectByIndex();
            case PROJECT_REMOVE_BY_NAME:
                return projectController.removeProjectByName();
            case PROJECT_REMOVE_BY_ID:
                return projectController.removeProjectById();
            case PROJECT_REMOVE_BY_INDEX:
                return projectController.removeProjectByIndex();
            case PROJECT_UPDATE_BY_INDEX:
                return projectController.updateProjectByIndex();

            case TASK_LIST:
                return taskController.listTask();
            case TASK_CLEAR:
                return taskController.clearTask();
            case TASK_CREATE:
                return taskController.createTask();
            case TASK_VIEW:
                return taskController.viewTaskByIndex();
            case TASK_REMOVE_BY_NAME:
                return taskController.removeTaskByName();
            case TASK_REMOVE_BY_ID:
                return taskController.removeTaskById();
            case TASK_REMOVE_BY_INDEX:
                return taskController.removeTaskByIndex();
            case TASK_UPDATE_BY_INDEX:
                return taskController.updateTaskByIndex();
            case TASK_ADD_PROJECT_BY_IDS:
                return taskController.addTaskToProjectByIds();
            case TASK_REMOVE_FROM_PROJECT_BY_IDS:
                return taskController.removeTaskToProjectByIds();
            case TASK_LIST_BY_PROJECT_ID:
                return taskController.listTaskByProjectId();

            default:
                return systermController.displayError();
        }
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public ProjectTaskService getProjectTaskService() {
        return projectTaskService;
    }
}
