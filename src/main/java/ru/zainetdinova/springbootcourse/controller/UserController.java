package ru.zainetdinova.springbootcourse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zainetdinova.springbootcourse.model.User;
import ru.zainetdinova.springbootcourse.service.UserService;

import java.util.List;

@Controller

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping ("/")
    public String showAllUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model){
        //User user = new User();
        model.addAttribute("user",new User());

        return "user-info";
    }
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }
    @GetMapping("/updateInfo/{id}")
    public String updateUser(Model model, @PathVariable("id") long id){
        model.addAttribute("user", userService.getUser(id));
        return "user-info";
    }
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
