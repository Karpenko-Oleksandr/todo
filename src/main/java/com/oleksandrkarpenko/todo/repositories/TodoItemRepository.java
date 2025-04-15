package com.oleksandrkarpenko.todo.repositories;

import com.oleksandrkarpenko.todo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
