package com.example.practicespr.service.impl;

import com.example.practicespr.domain.User;
import com.example.practicespr.repository.UserRepository;
import com.example.practicespr.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long create(Map<String, Object> params) {
        String username = (String) params.get("username");
        User tempUser = userRepository.findByUsername(username);
        if(tempUser != null) {
            return (long) -200;
        }

        User user = new User();
        user.setUsername((String) params.get("username"));
        user.setPassword((String) params.get("password"));
        user.setName((String) params.get("name"));
        user.setNick((String) params.get("nick"));
        user.setPhone((String) params.get("phone"));

        userRepository.save(user);
        return user.getId();
    }

    @Override
    public void update(Map<String, Object> params) {
        Long id = Long.parseLong((String) params.get("id"));
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        if(params.get("password") != null) { user.setPassword((String) params.get("password")); }
        if(params.get("name") != null) { user.setName((String) params.get("name")); }
        if(params.get("nick") != null) { user.setNick((String) params.get("nick")); }
        if(params.get("phone") != null) { user.setPhone((String) params.get("phone")); }
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        userRepository.delete(user);
    }

    @Override
    public User detail(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}
