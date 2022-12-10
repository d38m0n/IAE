package com.d38m0n.IAE.controller;

import com.d38m0n.IAE.entity.RoleEntity;
import com.d38m0n.IAE.entity.UserEntity;
import com.d38m0n.IAE.service.RoleService;
import com.d38m0n.IAE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminPanelController {
    private final UserService service;
    private final RoleService roleService;

    public AdminPanelController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<UserEntity> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users-list";
//        Work temporary
    }

    @GetMapping("/add-user")
    public String addUser(Model model) {
        List<RoleEntity> listRoles = roleService.listRoles();
        model.addAttribute("user", new UserEntity());
        model.addAttribute("listRoles", listRoles);
        return "add-user";
//        Work temporary
    }

    @PostMapping("/users/save")
    public String saveUser(UserEntity user) {
        service.save(user);
        return "redirect:/users";
//        Work temporary
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") String id, Model model) {
        UserEntity user = service.get(id);
        List<RoleEntity> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "edit-user";
    }
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model) {
       service.delete(id);
        return  "redirect:/users";
    }
}
