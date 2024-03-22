package com.project.ToDoList.controller;

import com.project.ToDoList.model.Task;
import com.project.ToDoList.service.TaskServiceImpel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")  //v1 typically represents the version number of an API
public class TaskController {

    @Autowired
    private TaskServiceImpel taskServiceImpel;

    @GetMapping("/")
    public List<Task> findAll()
    {
        return taskServiceImpel.findAll();
    }

    @PostMapping("/")
    public Task createTask(@RequestBody Task task)
    {
        return taskServiceImpel.createNewTask(task);
    }

    @GetMapping("/find")
    public Task findByTask(@RequestParam ("task") String task)
    {
        return taskServiceImpel.findByTask(task);
    }

    @GetMapping("/completed")
    public List<Task> findByCompletedTrue()
    {
        return taskServiceImpel.findByCompletedTrue();
    }

    @GetMapping("/inComplete")
    public List<Task> findByCompletedFalse()
    {
        return taskServiceImpel.findByCompletedFalse();
    }

    @GetMapping("/find/{id}")
    public Task findById(@PathVariable("id") Integer id)
    {
        return taskServiceImpel.getById(id);
    }

    @DeleteMapping("/delete")
    public String deleteTask(@RequestParam("id")Integer id)
    {
        return taskServiceImpel.deleteTask(id);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable("id")Integer id,@RequestBody Task task)
    {
        return taskServiceImpel.updateTask(id,task);
    }
}
