package ru.komm.pp314.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.komm.pp314.model.User;
import ru.komm.pp314.service.RoleService;
import ru.komm.pp314.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showAdminPanel(Model model, Principal principal) {
        model.addAttribute("name", principal.getName());
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("userlist", userService.getAllUsers());
        model.addAttribute("allroles", roleService.getAllRoles());
        model.addAttribute("newuser", new User());
        return "admpanel";
    }

    @PostMapping("/addnewuser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/personaleditpage")
    public String saveEditedUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.editUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
