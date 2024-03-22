package com.project.ToDoList.service;

import com.project.ToDoList.model.Task;
import com.project.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpel implements TaskService {
    @Autowired
    public TaskRepository taskRepository;
    @Override
    public Task createNewTask(Task task) {
        Task newTask=taskRepository.save(task);
        return newTask;
    }
//. Spring Data JPA provides a mechanism called query methods where you can declare method signatures that
// derive query criteria from the method name. In this case, the method findByTask takes a String parameter
// named task, and it's supposed to find a Task entity based on the value of the task field.
    @Override
    public Task findByTask(String task) {
        return taskRepository.findByTask(task);
    }

    @Override
    public List<Task> findByCompletedTrue() {
        return taskRepository.findByIsCompletedTrue();
    }

    @Override
    public List<Task> findByCompletedFalse() {
        return taskRepository.findByIsCompletedFalse();
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteTask(Integer id) {
         taskRepository.deleteById(id);
         return "Task Deleted successfully!";
    }

    @Override
    public Task updateTask(Integer id,Task task) {
        Task exisitingTask=taskRepository.findById(id).orElse(null);
        exisitingTask.setId(id);
        exisitingTask.setTask(task.getTask());
        exisitingTask.setComments(task.getComments());
        exisitingTask.setCompleted(task.isCompleted());
        return taskRepository.save(exisitingTask);
    }
}
