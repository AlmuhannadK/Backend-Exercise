package com.task.backendtask.repository;

import com.task.backendtask.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

    List<TodoList> findByUserId(Long userId);
    Optional<TodoList> findTodoListByTitleIgnoreCaseAndUserId(String title, Long userId);
}
