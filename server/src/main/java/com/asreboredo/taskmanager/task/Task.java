package com.asreboredo.taskmanager.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Task
 * 
 * Entity representing a task
 */
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String title;
    private String description;
    private Boolean done;

    public Task() {
        super();
    }

    public Task(Long id, String title, String description) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isDone() {
        return this.done;
    }

    public Boolean getDone() {
        return this.done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", title='" + getTitle() + "'" + ", description='" + getDescription()
                + "'" + ", done='" + isDone() + "'" + "}";
    }

}