package web.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "new";

        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String editUser(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user,
                             @Valid BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "update";

        userService.updateUser(user);
        return  "redirect:/users";
    }

    @PostMapping("/delete")
    public String removeUser(@RequestParam("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }
}
