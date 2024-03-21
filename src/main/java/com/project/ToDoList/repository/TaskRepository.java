package com.project.ToDoList.repository;

import com.project.ToDoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    public Task findByTask(String task);
    public List<Task> findByIsCompletedTrue();
    public List<Task> findByIsCompletedFalse();
//    Spring Data JPA doesn't provide automatic query generation for update operations based on method names.
// To update an entity using Spring Data JPA, you typically fetch the entity first, modify its attributes, and then save it back to the database.(this approach we have used only)
//    However, if you want to perform a custom update operation, you can use the @Query annotation with a custom update query(it needed a lot of customization)
//    @Query("UPDATE Task t SET t.task = :newTask, t.isCompleted = :isCompleted, t.comments = :comments WHERE t.task = :task")
//    public Task updateTask(String task,String newTask,boolean isCompleted,String comments);
}
