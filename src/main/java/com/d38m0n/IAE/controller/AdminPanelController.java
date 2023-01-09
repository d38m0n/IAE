package com.d38m0n.IAE.controller;

import com.d38m0n.IAE.entity.RoleE;
import com.d38m0n.IAE.entity.UserE;
import com.d38m0n.IAE.service.RoleService;
import com.d38m0n.IAE.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminPanelController {
    private final UserService service;
    private final RoleService roleService;

    public AdminPanelController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }
    @RequestMapping("/add-roles")
    public void addRoles(){
        roleService.addRole(new RoleE("Admin"));
        roleService.addRole(new RoleE("User"));
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<UserE> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users-list";
//        Work temporary
    }

    @GetMapping("/add-user")
    public String addUser(Model model) {
        List<RoleE> listRoles = roleService.listRoles();
        model.addAttribute("user", new UserE());
        model.addAttribute("listRoles", listRoles);
        return "user";
//        Work temporary
    }

    @PostMapping("/users/save")
    public String saveUser(UserE user) {
        service.save(user);
        return "redirect:/users";
//        Work temporary
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") String id, Model model) {
        UserE user = service.get(id);
        List<RoleE> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user";
    }
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model) {
        service.delete(id);
        return  "redirect:/users";
    }
}