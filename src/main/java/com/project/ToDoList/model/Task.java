package com.project.ToDoList.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String task;
    private boolean isCompleted;
    private String comments;

    public Task(String task, boolean isCompleted, String comments) {
        this.task = task;
        this.isCompleted = isCompleted;
        this.comments = comments;
    }
}
