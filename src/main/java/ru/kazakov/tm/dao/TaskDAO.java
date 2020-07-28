package ru.kazakov.tm.dao;

import ru.kazakov.tm.entity.Project;
import ru.kazakov.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private List<Task> tasks = new ArrayList<>();

    public Task create(String name) {
        final Task task = new Task(name);
        tasks.add(task);
        return task;
    }

    public Task create(final String name, final String description) {
        final Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        tasks.add(task);
        return task;
    }

    public void clear() {
        tasks.clear();
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task update(final Long id, final String name, final String description) {
        final Task task = findById(id);
        if (task == null) return null;
        task.setId(id);
        task.setName(name);
        task.setDescription(description);
        return task;
    }

    public Task findById(final Long id) {
        if (id == null) return null;
        for (final Task task : tasks) {
            if (task.getId().equals(id)) return task;
        }
        return null;
    }

    public Task findByIndex(int index) {
        if (index < 0 || index > tasks.size() - 1) return null;
        return tasks.get(index);
    }

    public Task findByName(final String name) {
        if (name == null || name.isEmpty()) return null;
        for (final Task task : tasks) {
            if (task.getName().equals(name)) return task;
        }
        return null;
    }

    public Task removeById(final Long id) {
        final Task task = findById(id);
        if (task == null) return null;
        tasks.remove(task);
        return task;
    }

    public Task removeByIndex(final int index) {
        final Task task = findByIndex(index);
        if (task == null) return null;
        tasks.remove(task);
        return task;
    }

    public Task removeByName(final String name) {
        final Task task = findByName(name);
        if (task == null) return null;
        tasks.remove(task);
        return task;
    }

}
