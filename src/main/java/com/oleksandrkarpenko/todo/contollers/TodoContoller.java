package com.oleksandrkarpenko.todo.contollers;


import com.oleksandrkarpenko.todo.model.TodoItem;
import com.oleksandrkarpenko.todo.repositories.TodoItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TodoContoller implements CommandLineRunner {

    private final TodoItemRepository todoItemRepository;

    public TodoContoller(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    public String index(Model model) {

        List<TodoItem> allTodos = todoItemRepository.findAll();
        model.addAttribute("allTodos", allTodos);
        model.addAttribute("newTodo", new TodoItem());

        return "index";
    }

    @PostMapping("/add")
    public String addTodoItem(@ModelAttribute TodoItem todoItem) {
        todoItemRepository.save(todoItem);

        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id) {
        todoItemRepository.deleteById(id);
        return "redirect:/";
    }

    @Override
    public void run(String... args) throws Exception {
        todoItemRepository.save(new TodoItem("Item 1"));
        todoItemRepository.save(new TodoItem("Item 2"));
    }
}
