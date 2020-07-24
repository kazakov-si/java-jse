package ru.kazakov.tm.dao;

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

    public void clear() {
        tasks.clear();
    }

    public List<Task> findAll() {
        return tasks;
    }

}
