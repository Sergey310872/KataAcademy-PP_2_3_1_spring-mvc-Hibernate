package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.ServiceUser;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private ServiceUser serviceUser;

    @GetMapping(value = "/")
    public String listAllUser(ModelMap model) {
        model.addAttribute("messages", serviceUser.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") Optional<Long> id, ModelMap model) {
        serviceUser.deleteUser(id.get());
        return "redirect:/";
    }

    @GetMapping(value = "/update")
    public String updateUser(@RequestParam("id") Optional<Long> id, ModelMap model) {
        User user = serviceUser.getUserById(id.get());
        model.addAttribute("user", user);
        return "user-details";
    }

    @PostMapping(value = "/update")
    public String saveUser(@ModelAttribute("user") User user, ModelMap model) {
        serviceUser.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-details";
    }
}
