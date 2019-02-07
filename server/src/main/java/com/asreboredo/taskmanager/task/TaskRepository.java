package com.asreboredo.taskmanager.task;

import org.springframework.data.repository.CrudRepository;

/**
 * TaskRepository
 */
public interface TaskRepository extends CrudRepository<Task, Long> {

}