package by.sadovnick.pp3_1_2.controller;

import by.sadovnick.pp3_1_2.model.User;
import by.sadovnick.pp3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable ("id") int id, Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "show_user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "new_user";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "edit_user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user){
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }
}
