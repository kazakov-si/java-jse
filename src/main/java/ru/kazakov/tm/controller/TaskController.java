package ru.kazakov.tm.controller;

import ru.kazakov.tm.entity.Task;
import ru.kazakov.tm.service.ProjectTaskService;
import ru.kazakov.tm.service.TaskService;

import java.util.List;

public class TaskController extends AbstractController {

    private final TaskService taskService;

    private final ProjectTaskService projectTaskService;

    public TaskController(TaskService taskService, ProjectTaskService projectTaskService) {
        this.taskService = taskService;
        this.projectTaskService = projectTaskService;
    }

    public int createTask() {
        System.out.println("[CREATE TASK]");
        System.out.println("PLEASE, ENTER TASK NAME:");
        final String name = scanner.nextLine();
        System.out.println("PLEASE, ENTER TASK DESCRIPTION:");
        final String description = scanner.nextLine();
        taskService.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int updateTaskByIndex() {
        System.out.println("[UPDATE TASK]");
        System.out.println("ENTER, TASK INDEX:");
        final int index = Integer.parseInt(scanner.nextLine()) - 1;
        final Task task = taskService.findByIndex(index);
        if (task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("PLEASE, ENTER TASK NAME:");
        final String name = scanner.nextLine();
        System.out.println("PLEASE, ENTER TASK DESCRIPTION:");
        final String description = scanner.nextLine();
        taskService.update(task.getId(), name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int removeTaskById() {
        System.out.println("[REMOVE TASK BY ID]");
        System.out.println("PLEASE, ENTER TASK ID:");
        final long id = scanner.nextLong();
        final Task task = taskService.removeById(id);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeTaskByIndex() {
        System.out.println("[REMOVE TASK BY INDEX]");
        System.out.println("PLEASE, ENTER TASK INDEX:");
        final int index = scanner.nextInt() - 1;
        final Task task = taskService.removeByIndex(index);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeTaskByName() {
        System.out.println("[REMOVE TASK BY NAME]");
        System.out.println("PLEASE, ENTER TASK NAME:");
        final String name = scanner.nextLine();
        final Task task = taskService.removeByName(name);
        if (task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int clearTask() {
        System.out.println("[CLEAR TASK]");
        taskService.clear();
        System.out.println("[OK]");
        return 0;
    }

    public void viewTask(final Task task) {
        if (task == null) return;
        System.out.println("[VIEW TASK]");
        System.out.println("ID: " + task.getId());
        System.out.println("NAME: " + task.getName());
        System.out.println("DESCRIPTION: " + task.getDescription());
        System.out.println("[OK]");
    }

    public int viewTaskByIndex() {
        System.out.println("ENTER, TASK INDEX:");
        final int index = scanner.nextInt() - 1;
        final Task task = taskService.findByIndex(index);
        viewTask(task);
        return 0;
    }

    public int listTask() {
        System.out.println("[LIST TASK]");
        int index = 1;
        viewTasks(taskService.findAll());
        System.out.println("[OK]");
        return 0;
    }

    public void viewTasks(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) return;
        int index = 1;
        for (final Task task : tasks) {
            System.out.println(index + ". " + task.getId() + ": " + task.getName());
            index++;
        }
    }

    public int listTaskByProjectId() {
        System.out.println("[LIST TASK BY PROJECT]");
        System.out.println("PLEASE, ENTER PROJECT ID:");
        final long projectId = Long.parseLong(scanner.nextLine());
        final List<Task> tasks = taskService.findAllByProjectId(projectId);
        viewTasks(tasks);
        System.out.println("[OK]");
        return 0;
    }

    public int addTaskToProjectByIds() {
        System.out.println("[ADD TASK TO PROJECT BY IDS]");
        System.out.println("PLEASE, ENTER PROJECT ID:");
        final long projectId = Long.parseLong(scanner.nextLine());
        System.out.println("PLEASE, ENTER TASK ID:");
        final long taskId = Long.parseLong(scanner.nextLine());
        projectTaskService.addTaskToProject(projectId, taskId);
        System.out.println("[OK]");
        return 0;
    }

    public int removeTaskToProjectByIds() {
        System.out.println("[REMOVE TASK FROM PROJECT BY IDS]");
        System.out.println("PLEASE, ENTER PROJECT ID:");
        final long projectId = Long.parseLong(scanner.nextLine());
        System.out.println("PLEASE, ENTER TASK ID:");
        final long taskId = Long.parseLong(scanner.nextLine());
        projectTaskService.removeTaskFromProject(projectId, taskId);
        System.out.println("[OK]");
        return 0;
    }

}
