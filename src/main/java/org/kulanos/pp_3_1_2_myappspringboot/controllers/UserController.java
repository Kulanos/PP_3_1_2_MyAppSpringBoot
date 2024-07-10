package org.kulanos.pp_3_1_2_myappspringboot.controllers;
import org.kulanos.pp_3_1_2_myappspringboot.model.User;
import org.kulanos.pp_3_1_2_myappspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("userList", users);
        return "users";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "addPage";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("surname") String surname,
                          @RequestParam("age") int age,
                          @RequestParam("email") String email) {
        User user = new User(name, surname, age, email);
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editPage";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("surname") String surname,
                           @RequestParam("age") int age,
                           @RequestParam("email") String email) {
        User user = new User(name, surname, age, email);
        user.setId(id);
        userService.edit(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/users";
    }
}