package com.asreboredo.taskmanager.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TaskController
 */
@CrossOrigin(maxAge = 3600)
@RestController
public class TaskController {

    /**
     * Base URL for the Task API endpoint
     */
    private static final String API_STRING = "/task";

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET, value = API_STRING)
    public List<Task> getAllTasks() {
        return this.taskService.getAllTasks();
    }

    @RequestMapping(method = RequestMethod.GET, value = API_STRING + "/{id}")
    public Optional<Task> getTask(@PathVariable Long id) {
        return this.taskService.getTask(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = API_STRING)
    public void addTask(@RequestBody Task task) {
        this.taskService.addTask(task);
    }

    @RequestMapping(method = RequestMethod.PUT, value = API_STRING + "/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable Long id) {
        this.taskService.updateTask(task, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = API_STRING + "/{id}")
    public void deleteTask(@PathVariable Long id) {
        Optional<Task> aux = this.taskService.getTask(id);
        if (aux.isPresent()) {
            this.taskService.deleteTask(aux.get());
        }
    }

}