package com.task.backendtask.repository;

import com.task.backendtask.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemRepository extends JpaRepository<TodoItem, Long> {
}
