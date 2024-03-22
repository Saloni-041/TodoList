package com.project.ToDoList.service;

import com.project.ToDoList.model.Task;

import java.util.List;

public interface TaskService {
    public Task createNewTask(Task task);
    public Task findByTask(String task);
    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
    public List<Task> findAll();
    public Task getById(Integer id);
    public String deleteTask(Integer id);
    public Task updateTask(Integer id,Task task);
}
