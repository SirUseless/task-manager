package com.asreboredo.taskmanager.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TaskService
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        this.taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Optional<Task> getTask(Long id) {
        return this.taskRepository.findById(id);
    }

    public void addTask(Task task) {
        this.taskRepository.save(task);
    }

    public void updateTask(Task task, Long id) {
        this.taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        this.taskRepository.delete(task);
    }
}