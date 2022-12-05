package ru.zainetdinova.springbootcourse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zainetdinova.springbootcourse.model.Role;
import ru.zainetdinova.springbootcourse.model.User;
import ru.zainetdinova.springbootcourse.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller

public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/admin")
    public String showAllUsers(Model model, Principal principal){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("currentUser",userService.getUserByName(principal.getName()));
        model.addAttribute("allUsers", allUsers);
        return "all-users3";
    }

    @GetMapping("/admin/addNewUser")
    public String addNewUser(Model model){
        //User user = new User();
        model.addAttribute("user",new User());

        return "user-info";
    }
    @PostMapping("/admin/addNew")
    public String saveUser(@ModelAttribute("user") User user, @ModelAttribute("newRole") Role role){
        userService.saveNewUser(user, role.getRole());
        return "redirect:/admin";
    }
    @GetMapping("/admin/updateInfo/{id}")
    public String updateUser(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getUser(id));
        return "user-update";
    }


    @GetMapping("admin/get/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }


    @PostMapping ("/admin/updateUser")
    public String update(@ModelAttribute("myUserUpdate") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }
//    @RequestMapping(value="/admin/updateUser", method={RequestMethod.PUT,RequestMethod.GET})
//        public String update(User user) {
//        userService.updateUser(user);
//        return "redirect:/admin";
//}

    @RequestMapping("/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
    @GetMapping("/user")
    public String showUserInfo(Model model, Principal principal) {
        model.addAttribute("userInfo",userService.getUserByName(principal.getName()));
        return "user-show-info";
    }
    @GetMapping("/")
    public String showIndex(){
        return "index";
    }

}
