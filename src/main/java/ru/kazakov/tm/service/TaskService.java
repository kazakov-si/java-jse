package ru.kazakov.tm.service;

import ru.kazakov.tm.entity.Task;
import ru.kazakov.tm.repository.ProjectRepository;
import ru.kazakov.tm.repository.TaskRepository;

import java.util.Collections;
import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.create(name);
    }

    public Task create(String name, String description) {
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return taskRepository.create(name, description);
    }

    public void clear() {
        taskRepository.clear();
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task update(Long id, String name, String description) {
        if (id == null) return null;
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return taskRepository.update(id, name, description);
    }

    public Task findById(Long id) {
        if (id == null) return null;
        return taskRepository.findById(id);
    }

    public Task findByIndex(int index) {
        if (index < 0 || index > taskRepository.findAll().size() - 1) return null;
        return taskRepository.findByIndex(index);
    }

    public Task findByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.findByName(name);
    }

    public Task removeById(Long id) {
        if (id == null) return null;
        return taskRepository.removeById(id);
    }

    public Task removeByIndex(int index) {
        if (index < 0 || index > taskRepository.findAll().size() - 1) return null;
        return taskRepository.removeByIndex(index);
    }

    public Task removeByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.removeByName(name);
    }

    public Task findByProjectIdAndId(Long projectId, Long id) {
        if (projectId == null || id == null) return null;
        return taskRepository.findByProjectIdAndId(projectId, id);
    }

    public List<Task> findAllByProjectId(Long projectId) {
        if (projectId == null) return null;
        return taskRepository.findAddByProjectId(projectId);
    }
}
