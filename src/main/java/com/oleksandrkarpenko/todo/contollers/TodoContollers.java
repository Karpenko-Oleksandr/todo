package com.oleksandrkarpenko.todo.contollers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoContollers {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("data", "test_data");
        return "index";
    }

}
