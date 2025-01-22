package com.example.practicespr.controller.rest;

import com.example.practicespr.domain.User;
import com.example.practicespr.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this. userService = userService;
    }

    @PostMapping("")
    public Long create(@RequestBody Map<String, Object> params) {
        return userService.create(params);
    }

    @GetMapping("/list")
    public List<User> List() {
        return userService.list();
    }

    @GetMapping("")
    public User detail(Long id) {
        return userService.detail(id);
    }

    @PutMapping("")
    public int update(@RequestBody Map<String, Object> params) {
        userService.update(params);
        return 200;
    }

    @DeleteMapping("")
    public int delete(@RequestBody Long id) {
        userService.delete(id);
        return 200;
    }
}
