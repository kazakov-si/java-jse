package ru.kazakov.tm.service;

import ru.kazakov.tm.entity.Project;
import ru.kazakov.tm.entity.Task;
import ru.kazakov.tm.repository.ProjectRepository;
import ru.kazakov.tm.repository.TaskRepository;

import java.util.Collections;
import java.util.List;

public class ProjectTaskService {

    private final ProjectRepository projectRepository;

    private final TaskRepository taskRepository;

    public ProjectTaskService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public List<Task> findAddByProjectId(Long projectId) {
        if (projectId == null) return Collections.emptyList();
        return taskRepository.findAddByProjectId(projectId);
    }
    public Task addTaskToProject(final Long projectId, final Long taskId) {
        final Project project = projectRepository.findById(projectId);
        if (project == null) return null;
        final Task task = taskRepository.findById(taskId);
        if (task == null) return null;
        task.setProjectId(projectId);
        return task;
    }

    public Task removeTaskFromProject(final Long projectId, final Long taskId) {
        final Task task = taskRepository.findByProjectIdAndId(projectId, taskId);
        if (task == null) return null;
        task.setProjectId(null);
        return task;
    }

}


